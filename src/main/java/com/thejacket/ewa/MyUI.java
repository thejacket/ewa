package com.thejacket.ewa;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.StyleSheet;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.*;
import com.opencsv.*;

import com.vaadin.ui.themes.ValoTheme;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Stream;

@Theme("mytheme2")
public class MyUI extends UI {

    private KidService service = KidService.getInstance();
    private Grid<Kid> grid = new Grid<>(Kid.class);
    private TextField filterText = new TextField();
    private KidForm form = new KidForm(this);

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        final VerticalLayout layout = new VerticalLayout();

        filterText.setPlaceholder("szukaj..");
        filterText.addValueChangeListener(e -> updateList());
        filterText.setValueChangeMode(ValueChangeMode.LAZY);

        Button addKidBtn = new Button("Dodaj");
        Button exportToCsvBtn = new Button("Eksportuj do .csv");

        addKidBtn.addClickListener(e -> {
            grid.asSingleSelect().clear();
            form.setKid(new Kid());
        });

        exportToCsvBtn.addClickListener(e -> {

            List<Kid> allKids = service.findAll();
            List<String[]> entries = new ArrayList<>();
            Field[] fields = Kid.class.getDeclaredFields();
            List<String> fieldNamesList = new ArrayList<>();

            for (Kid k : allKids) {
                List<String> singleKidStringList = new ArrayList<>();
               // Field[] fields = k.getClass().getDeclaredFields();
                for(Field f: fields){
                    f.setAccessible(true);
                    try {
                        Object value = f.get(k);
                        if(value == null){
                            continue;
                        }
                        singleKidStringList.add(value.toString());
                    } catch (IllegalAccessException e1) {
                        e1.printStackTrace();
                    }
                }

                for (Field f: fields){
                    String name = f.getName();
                    fieldNamesList.add(name);
                }
                entries.add(singleKidStringList.toArray(new String[singleKidStringList.size()]));
            }
            entries.add(fieldNamesList.toArray(new String[fieldNamesList.size()]));

            String fileName = "ewa.csv";

            try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
                writer.writeAll(entries);       // cast z arraylist<string> na string[]
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        CssLayout filtering = new CssLayout();
        filtering.addComponents(filterText);
        filtering.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

        form.setVisible(false);

        HorizontalLayout toolbar = new HorizontalLayout(filtering, addKidBtn, exportToCsvBtn);
        HorizontalLayout main = new HorizontalLayout(grid, form);
        form.setVisible(false);
        main.setSizeFull();
        grid.setSizeFull();
        main.setExpandRatio(grid, 1);

        layout.addComponents(toolbar, main);

        updateList();

        setContent(layout);

        grid.asSingleSelect().addValueChangeListener(e -> {
            if (e.getValue() == null) {
                form.setVisible(false);
            } else {
                form.setKid(e.getValue());
            }
        });
    }

    public void updateList() {

        List<Kid> kids = service.findAll(filterText.getValue());
        grid.setItems(kids);
        grid.setColumns("kidCode", "sex", "birthDate", "preStoryTimeSum", "preStoryTimeMean", "postStoryTimeSum", "postStoryTimeMean");
        grid.getColumn("kidCode").setCaption("Kod dziecka");
        grid.getColumn("sex").setCaption("Płeć");
        grid.getColumn("birthDate").setCaption("Data urodzenia");
        grid.getColumn("preStoryTimeSum").setCaption("Suma pre-test (s)");
        grid.getColumn("preStoryTimeMean").setCaption("średnia pre-test (s)");
        grid.getColumn("postStoryTimeSum").setCaption("Suma post-test (s)");
        grid.getColumn("postStoryTimeMean").setCaption("średnia post-test (s)");


    }
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @WebInitParam(name = "useFileMappedBuffer", value = "false")
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = true)
    public static class MyUIServlet extends VaadinServlet {

    }
}

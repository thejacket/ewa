package com.thejacket.ewa;

import com.vaadin.annotations.Theme;
import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;
import com.vaadin.data.converter.StringToFloatConverter;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.data.validator.DateRangeValidator;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.event.FieldEvents;
import com.vaadin.server.Page;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;

/**
 * Created by mariusz on 2017-06-21.
 */

        import com.vaadin.data.Binder;
        import com.vaadin.event.ShortcutAction.KeyCode;
        import com.vaadin.ui.Button;
        import com.vaadin.ui.DateField;
        import com.vaadin.ui.FormLayout;
        import com.vaadin.ui.HorizontalLayout;
        import com.vaadin.ui.NativeSelect;
        import com.vaadin.ui.TextField;
        import com.vaadin.ui.themes.ValoTheme;

import com.thejacket.ewa.QuestionnaireData.*;

@Theme("mytheme2")
public class KidForm extends FormLayout {

    private TextField kidCode = new TextField("Kod osoby badanej");
    private TextArea languageSpoken = new TextArea("W jakim języku rozmawiają Państwo <br/>w domu z dzieckiem?");
    private NativeSelect<QuestionnaireData.sex> sex = new NativeSelect<>("Płeć");
    private NativeSelect<wasSick> wasThereAnySickness = new NativeSelect<>("Czy dziecko chorowało na poważną chorobę?");
    private TextArea whichMonthOfPregnancy = new TextArea("W którym tygodniu ciąży dziecko zostało urodzone?");
    private CheckBox whichMonthOfPregnancyDontRemember = new CheckBox("Nie pamiętam");
    private TextArea isChildHealthyNow = new TextArea("Czy dziecko jest teraz zdrowe?");
    private TextArea wasThereAnyDisorder = new TextArea("Czy były jakieś zaburzenia okołoporodowe?");
    private TextArea programmingBackground = new TextArea("Wcześniejsze kontakty z programowaniem");
    private TextField ageOfMom = new TextField("Wiek matki");
    private NativeSelect<QuestionnaireData.education> momEducation = new NativeSelect<>("Wykształcenie matki");
    private TextField ageOfDad = new TextField("Wiek ojca");
    private NativeSelect<QuestionnaireData.education> dadEducation = new NativeSelect<>("Wykształcenie ojca");

    private DateField birthdate = new DateField("Data urodzenia");
    private Button save = new Button("Zapisz");
    private Button delete = new Button("Usuń");
    private Button save2 = new Button("Zapisz");
    private Notification notification = new Notification("");

    private KidService service = KidService.getInstance();
    private Kid kid;
    private MyUI myUI;
    private Binder<Kid> binder = new Binder<>(Kid.class);

    private Button firstpage = new Button("1");
    private Button secondpage = new Button("2");
    private Button thirdpage = new Button("3");

    private Button topfirstpage = new Button("1");
    private Button topsecondpage = new Button("2");
    private Button topthirdpage = new Button("3");

    private TextField preStoryNo1Order = new TextField("Kolejność obrazków w historyjce nr. 1");
    private TextField preStoryNo2Order = new TextField("Kolejność obrazków w historyjce nr. 2");
    private TextField preStoryNo3Order = new TextField("Kolejność obrazków w historyjce nr. 3");
    private TextField preStoryNo4Order = new TextField("Kolejność obrazków w historyjce nr. 4");
    private TextField preStoryNo5Order = new TextField("Kolejność obrazków w historyjce nr. 5");
    // dopisac description

    private TextField preStoryNo1Time = new TextField("Czas reakcji dla historii nr. 1");
    private TextField preStoryNo2Time = new TextField("Czas reakcji dla historii nr. 2");
    private TextField preStoryNo3Time = new TextField("Czas reakcji dla historii nr. 3");
    private TextField preStoryNo4Time = new TextField("Czas reakcji dla historii nr. 4");
    private TextField preStoryNo5Time = new TextField("Czas reakcji dla historii nr. 5");
    //dopisac description

    private TextField postStoryNo1Order = new TextField("Kolejność obrazków w historyjce nr. 1");
    private TextField postStoryNo2Order = new TextField("Kolejność obrazków w historyjce nr. 2");
    private TextField postStoryNo3Order = new TextField("Kolejność obrazków w historyjce nr. 3");
    private TextField postStoryNo4Order = new TextField("Kolejność obrazków w historyjce nr. 4");
    private TextField postStoryNo5Order = new TextField("Kolejność obrazków w historyjce nr. 5");
    // dopisac description

    private TextField postStoryNo1Time = new TextField("Czas reakcji dla historii nr. 1");
    private TextField postStoryNo2Time = new TextField("Czas reakcji dla historii nr. 2");
    private TextField postStoryNo3Time = new TextField("Czas reakcji dla historii nr. 3");
    private TextField postStoryNo4Time = new TextField("Czas reakcji dla historii nr. 4");
    private TextField postStoryNo5Time = new TextField("Czas reakcji dla historii nr. 5");

    public KidForm(MyUI myUI) {
        this.myUI = myUI;

        notification.setDelayMsec(3000);

        setSizeUndefined();
        HorizontalLayout buttons1 = new HorizontalLayout(save, delete);
        languageSpoken.setCaptionAsHtml(true);

        //Label htmlLabel = new Label("&nbsp;", ContentMode.HTML);
        //addComponent(htmlLabel);

        Label basicDataLabel = new Label("Dane podstawowe");
        Label preTestLabel = new Label("Pre test");
        Label postTestLabel = new Label("Post test");

        preTestLabel.addStyleName("mystyle2");
        postTestLabel.addStyleName("mystyle2");
        basicDataLabel.addStyleName("mystyle2");

        VerticalLayout basicDataComponents = new VerticalLayout();
        VerticalLayout preTestComponents = new VerticalLayout();
        VerticalLayout postTestComponents = new VerticalLayout();

        preTestComponents.setVisible(false);
        postTestComponents.setVisible(false);

        addComponents(buttons1, configureTopPageButtons());
        basicDataComponents.addComponents(basicDataLabel, kidCode, sex, birthdate, languageSpoken, whichMonthOfPregnancy, whichMonthOfPregnancyDontRemember, wasThereAnyDisorder, isChildHealthyNow, wasThereAnySickness, programmingBackground, ageOfMom, momEducation, ageOfDad, dadEducation);
        addComponents(preTestComponents, postTestComponents, basicDataComponents);

        basicDataComponents.setMargin(true);
        basicDataComponents.setSpacing(true);

        preTestComponents.addComponents(preTestLabel, preStoryNo1Order, preStoryNo1Time, preStoryNo2Order, preStoryNo2Time, preStoryNo3Order, preStoryNo3Time, preStoryNo4Order, preStoryNo4Time, preStoryNo5Order, preStoryNo5Time);
        postTestComponents.addComponents(postTestLabel, postStoryNo1Order, postStoryNo1Time, postStoryNo2Order, postStoryNo2Time, postStoryNo3Order, postStoryNo3Time, postStoryNo4Order, postStoryNo4Time, postStoryNo5Order, postStoryNo5Time);

        HorizontalLayout pageButtons = new HorizontalLayout();
        pageButtons.addComponents(firstpage,secondpage, thirdpage);
        addComponents(pageButtons, save2);

        pageButtons.setWidth("100%");


        sex.setItems(QuestionnaireData.sex.values());
        wasThereAnySickness.setItems(wasSick.values());
        momEducation.setItems(QuestionnaireData.education.values());
        dadEducation.setItems(QuestionnaireData.education.values());
        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        save2.setStyleName(ValoTheme.BUTTON_PRIMARY);
        save.setClickShortcut(KeyCode.ENTER);
        delete.setClickShortcut(KeyCode.DELETE);


        /////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////

        /////////////////////////////////////////////////////////////////////////

                // binds exactly named fields
        binder.forField (kidCode)
                //.asRequired("Pole nie może być puste")
                .asRequired("Pole nie może być puste")
                .bind (Kid:: getKidCode, Kid:: setKidCode);
        binder.forField (birthdate)
                .asRequired("Pole nie może być puste")
                .bind (Kid:: getBirthDate, Kid:: setBirthDate);
        binder.forField(preStoryNo1Time)
                .withNullRepresentation("")
                .withConverter ( new StringToFloatConverter( "Niepoprawne dane. Czy na pewno wpisano liczbę?" ) )
                .bind (Kid:: getPreStoryNo1Time, Kid:: setPreStoryNo1Time );
        binder.forField (preStoryNo2Time)
                .withNullRepresentation("")
                .withConverter ( new StringToFloatConverter( "Niepoprawne dane. Czy na pewno wpisano liczbę?" ) )
                .bind (Kid:: getPreStoryNo2Time, Kid:: setPreStoryNo2Time );
        binder.forField (preStoryNo3Time)
                .withNullRepresentation("")
                .withConverter ( new StringToFloatConverter( "Niepoprawne dane. Czy na pewno wpisano liczbę?" ) )
                .bind (Kid:: getPreStoryNo3Time, Kid:: setPreStoryNo3Time );
        binder.forField(preStoryNo4Time)
                .withNullRepresentation("")
                .withConverter ( new StringToFloatConverter( "Niepoprawne dane. Czy na pewno wpisano liczbę?" ) )
                .bind (Kid:: getPreStoryNo1Time, Kid:: setPreStoryNo4Time );
        binder.forField (preStoryNo5Time)
                .withNullRepresentation("")
                .withConverter ( new StringToFloatConverter( "Niepoprawne dane. Czy na pewno wpisano liczbę?" ) )
                .bind (Kid:: getPreStoryNo2Time, Kid:: setPreStoryNo5Time );
        binder.forField (postStoryNo1Time)
                .withNullRepresentation("")
                .withConverter ( new StringToFloatConverter( "Niepoprawne dane. Czy na pewno wpisano liczbę?" ) )
                .bind (Kid:: getPostStoryNo3Time, Kid:: setPostStoryNo1Time );
        binder.forField (postStoryNo2Time)
                .withNullRepresentation("")
                .withConverter ( new StringToFloatConverter( "Niepoprawne dane. Czy na pewno wpisano liczbę?" ) )
                .bind (Kid:: getPostStoryNo2Time, Kid:: setPostStoryNo2Time );
        binder.forField (postStoryNo3Time)
                .withNullRepresentation("")
                .withConverter ( new StringToFloatConverter( "Niepoprawne dane. Czy na pewno wpisano liczbę?" ) )
                .bind (Kid:: getPostStoryNo3Time, Kid:: setPostStoryNo3Time );
        binder.forField (postStoryNo4Time)
                .withNullRepresentation("")
                .withConverter ( new StringToFloatConverter( "Niepoprawne dane. Czy na pewno wpisano liczbę?" ) )
                .bind (Kid:: getPostStoryNo4Time, Kid:: setPostStoryNo4Time );
        binder.forField (postStoryNo5Time)
                .withNullRepresentation("")
                .withConverter ( new StringToFloatConverter( "Input must be Integer" ) )
                .bind (Kid:: getPostStoryNo5Time, Kid:: setPostStoryNo5Time );
        binder.bindInstanceFields(this);

        topfirstpage.addClickListener(e -> {
            basicDataComponents.setVisible(true);
            preTestComponents.setVisible(false);
            postTestComponents.setVisible(false);
            getUI().setScrollTop(0);
        });
        topsecondpage.addClickListener(e -> {
            basicDataComponents.setVisible(false);
            preTestComponents.setVisible(true);
            postTestComponents.setVisible(false);
            getUI().setScrollTop(0);
        });
        topthirdpage.addClickListener(e -> {
            basicDataComponents.setVisible(false);
            preTestComponents.setVisible(false);
            postTestComponents.setVisible(true);
            getUI().setScrollTop(0);
        });
        firstpage.addClickListener(e -> {
            basicDataComponents.setVisible(true);
            preTestComponents.setVisible(false);
            postTestComponents.setVisible(false);
            getUI().setScrollTop(0);
        });
        secondpage.addClickListener(e -> {
            basicDataComponents.setVisible(false);
            preTestComponents.setVisible(true);
            postTestComponents.setVisible(false);
            getUI().setScrollTop(0);
        });
        thirdpage.addClickListener(e -> {
            basicDataComponents.setVisible(false);
            preTestComponents.setVisible(false);
            postTestComponents.setVisible(true);
            getUI().setScrollTop(0);
        });


        whichMonthOfPregnancyDontRemember.addValueChangeListener(e -> whichMonthOfPregnancy.setRows(1));

        whichMonthOfPregnancy.addFocusListener(new FieldEvents.FocusListener() {
            @Override
            public void focus(FieldEvents.FocusEvent focusEvent) {
                whichMonthOfPregnancyDontRemember.setValue(false);
                whichMonthOfPregnancy.setRows(5);
            }
        });

        save.addClickListener(e -> {
            if(binder.writeBeanIfValid(kid)) {
                this.save();
            } else {
                notification.setCaption("Wypełnij wymagane pola ");
                notification.show(Page.getCurrent());
            }
        });
        delete.addClickListener(e -> this.delete());
        save2.addClickListener(e -> {
            if(binder.writeBeanIfValid(kid)) {
                this.save();
            } else {
                notification.setCaption("Wypełnij wymagane pola ");
                notification.show(Page.getCurrent());
            }
        });

    }

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////////////////

    public void setKid(Kid Kid) {
        this.kid = Kid;
        binder.setBean(Kid);

        // Show delete button for Kids already in the database
        delete.setVisible(Kid.isPersisted());
        setVisible(true);
        //firstName.selectAll();
    }

    private void delete() {
        notification.setCaption("Usunięto " + kid);
        notification.show(Page.getCurrent());
        service.delete(kid);
        myUI.updateList();
        setVisible(false);
    }

    private void save() {
        notification.setCaption("Zapisano " + kid);
        notification.show(Page.getCurrent());
        service.save(kid);
        kid.calculatePreStoryValues();
        kid.calculatePostStoryValues();
        myUI.updateList();
        setVisible(false);
    }

    private HorizontalLayout configureTopPageButtons(){
        HorizontalLayout topPageButtons = new HorizontalLayout();
        topPageButtons.setWidth("100%");

        topfirstpage.setSizeUndefined();
        topsecondpage.setSizeUndefined();
        topthirdpage.setSizeUndefined();
        topPageButtons.addComponent(topfirstpage);
        topPageButtons.setComponentAlignment(topfirstpage, Alignment.MIDDLE_CENTER);
        topPageButtons.addComponent(topsecondpage);
        topPageButtons.setComponentAlignment(topsecondpage, Alignment.MIDDLE_CENTER);
        topPageButtons.addComponent(topthirdpage);
        topPageButtons.setComponentAlignment(topthirdpage, Alignment.MIDDLE_CENTER);

        topfirstpage.setStyleName("mystyle8");
        topsecondpage.setStyleName("mystyle8");
        topthirdpage.setStyleName("mystyle8");

        firstpage.setStyleName("mystyle8");
        secondpage.setStyleName("mystyle8");
        thirdpage.setStyleName("mystyle8");
        return topPageButtons;
    }
}

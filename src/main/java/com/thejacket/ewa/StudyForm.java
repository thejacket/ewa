package com.thejacket.ewa;

import com.vaadin.data.Binder;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by mariusz on 2017-07-05.
 */
public class StudyForm extends VerticalLayout{

    private KidService service = KidService.getInstance();
    private Kid Kid;
    private Study study;
    private MyUI myUI;
    private Binder<Study> binder = new Binder<>(Study.class);
    private Grid<Study> studyGrid = new Grid<>();

    private Button firstpage = new Button("1");
    private Button secondpage = new Button("2");

    public StudyForm(MyUI myUI) {
        this.myUI = myUI;
    }
}

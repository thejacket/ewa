package com.thejacket.ewa;

/**
 * Created by mariusz on 2017-06-21.
 */

import com.vaadin.ui.TextField;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@SuppressWarnings("serial")
public class Kid implements Serializable, Cloneable {

    public Kid() {
        this.preStoryTimeSum = new Float(0);
        this.postStoryTimeSum = new Float(0);
    }

    private Long id;

    private String kidCode = "";

    private String firstName = "";

    private String lastName = "";

    private String schoolName = "";

    private QuestionnaireData.sex sex;

    private String ageOfMom;

    private QuestionnaireData.education momEducation;

    private QuestionnaireData.education dadEducation;

    private String ageOfDad;

    private String numberOfAttendances;

    private String languageSpoken;

    private String whichMonthOfPregnancy;

    private boolean whichMonthOfPregnancyDontRemember;

    private String isChildHealthyNow;

    private String group;

    private LocalDate birthDate;

    private QuestionnaireData.wasSick wasThereAnySickness;

    private String programmingBackground;

    private String email = "";


    public String getPreStoryNo1Order() {
        return preStoryNo1Order;
    }

    public void setPreStoryNo1Order(String preStoryNo1Order) {
        this.preStoryNo1Order = preStoryNo1Order;
    }

    public String getPreStoryNo2Order() {
        return preStoryNo2Order;
    }

    public void setPreStoryNo2Order(String preStoryNo2Order) {
        this.preStoryNo2Order = preStoryNo2Order;
    }

    public String getPreStoryNo3Order() {
        return preStoryNo3Order;
    }

    public void setPreStoryNo3Order(String preStoryNo3Order) {
        this.preStoryNo3Order = preStoryNo3Order;
    }

    public String getPreStoryNo4Order() {
        return preStoryNo4Order;
    }

    public void setPreStoryNo4Order(String preStoryNo4Order) {
        this.preStoryNo4Order = preStoryNo4Order;
    }

    public String getPreStoryNo5Order() {
        return preStoryNo5Order;
    }

    public void setPreStoryNo5Order(String preStoryNo5Order) {
        this.preStoryNo5Order = preStoryNo5Order;
    }

    public Float getPreStoryNo1Time() {
        return preStoryNo1Time;
    }

    public void setPreStoryNo1Time(Float preStoryNo1Time) {
        this.preStoryNo1Time = preStoryNo1Time;
    }

    public Float getPreStoryNo2Time() {
        return preStoryNo2Time;
    }

    public void setPreStoryNo2Time(Float preStoryNo2Time) {
        this.preStoryNo2Time = preStoryNo2Time;
    }

    public Float getPreStoryNo3Time() {
        return preStoryNo3Time;
    }

    public void setPreStoryNo3Time(Float preStoryNo3Time) {
        this.preStoryNo3Time = preStoryNo3Time;
    }

    public Float getPreStoryNo4Time() {
        return preStoryNo4Time;
    }

    public void setPreStoryNo4Time(Float preStoryNo4Time) {
        this.preStoryNo4Time = preStoryNo4Time;
    }

    public Float getPreStoryNo5Time() {
        return preStoryNo5Time;
    }

    public void setPreStoryNo5Time(Float preStoryNo5Time) {
        this.preStoryNo5Time = preStoryNo5Time;
    }

    public String getPostStoryNo1Order() {
        return postStoryNo1Order;
    }

    public void setPostStoryNo1Order(String postStoryNo1Order) {
        this.postStoryNo1Order = postStoryNo1Order;
    }

    public String getPostStoryNo2Order() {
        return postStoryNo2Order;
    }

    public void setPostStoryNo2Order(String postStoryNo2Order) {
        this.postStoryNo2Order = postStoryNo2Order;
    }

    public String getPostStoryNo3Order() {
        return postStoryNo3Order;
    }

    public void setPostStoryNo3Order(String postStoryNo3Order) {
        this.postStoryNo3Order = postStoryNo3Order;
    }

    public String getPostStoryNo4Order() {
        return postStoryNo4Order;
    }

    public void setPostStoryNo4Order(String postStoryNo4Order) {
        this.postStoryNo4Order = postStoryNo4Order;
    }

    public String getPostStoryNo5Order() {
        return postStoryNo5Order;
    }

    public void setPostStoryNo5Order(String postStoryNo5Order) {
        this.postStoryNo5Order = postStoryNo5Order;
    }

    public Float getPostStoryNo1Time() {
        return postStoryNo1Time;
    }

    public void setPostStoryNo1Time(Float postStoryNo1Time) {
        this.postStoryNo1Time = postStoryNo1Time;
    }

    public Float getPostStoryNo2Time() {
        return postStoryNo2Time;
    }

    public void setPostStoryNo2Time(Float postStoryNo2Time) {
        this.postStoryNo2Time = postStoryNo2Time;
    }

    public Float getPostStoryNo3Time() {
        return postStoryNo3Time;
    }

    public void setPostStoryNo3Time(Float postStoryNo3Time) {
        this.postStoryNo3Time = postStoryNo3Time;
    }

    public Float getPostStoryNo4Time() {
        return postStoryNo4Time;
    }

    public void setPostStoryNo4Time(Float postStoryNo4Time) {
        this.postStoryNo4Time = postStoryNo4Time;
    }

    public Float getPostStoryNo5Time() {
        return postStoryNo5Time;
    }

    public void setPostStoryNo5Time(Float postStoryNo5Time) {
        this.postStoryNo5Time = postStoryNo5Time;
    }

    public Float getPreStoryMeanTime() {
        return preStoryTimeMean;
    }

    public void setPreStoryMeanTime(Float preStoryMeanTime) {
        this.preStoryTimeMean = preStoryMeanTime;
    }

    public Float getPostStoryMeanTime() {
        return postStoryTimeMean;
    }

    public void setPostStoryMeanTime(Float postStoryMeanTime) {
        this.postStoryTimeMean = postStoryMeanTime;
    }

    private String preStoryNo1Order;
    private String preStoryNo2Order;
    private String preStoryNo3Order;
    private String preStoryNo4Order;
    private String preStoryNo5Order;

    private Float preStoryNo1Time = new Float(0);
    private Float preStoryNo2Time = new Float(0);
    private Float preStoryNo3Time = new Float(0);
    private Float preStoryNo4Time = new Float(0);
    private Float preStoryNo5Time = new Float(0);

    private String postStoryNo1Order;
    private String postStoryNo2Order;
    private String postStoryNo3Order;
    private String postStoryNo4Order;
    private String postStoryNo5Order;

    private Float postStoryNo1Time = new Float(0);
    private Float postStoryNo2Time = new Float(0);
    private Float postStoryNo3Time = new Float(0);
    private Float postStoryNo4Time = new Float(0);
    private Float postStoryNo5Time = new Float(0);

    private Float preStoryTimeMean;

    public Float getPreStoryTimeMean() {
        this.calculatePreStoryValues();
        return preStoryTimeMean;
    }

    public void setPreStoryTimeMean(Float preStoryTimeMean) {
        this.preStoryTimeMean = preStoryTimeMean;
    }

    public Float getPreStoryTimeSum() {
        this.calculatePreStoryValues();
        return preStoryTimeSum;
    }

    public void setPreStoryTimeSum(Float preStoryTimeSum) {
        this.preStoryTimeSum = preStoryTimeSum;
    }

    public Float getPostStoryTimeMean() {
        this.calculatePostStoryValues();
        return postStoryTimeMean;
    }

    public void setPostStoryTimeMean(Float postStoryTimeMean) {
        this.postStoryTimeMean = postStoryTimeMean;
    }

    public Float getPostStoryTimeSum() {
        this.calculatePostStoryValues();
        return postStoryTimeSum;
    }

    public void setPostStoryTimeSum(Float postStoryTimeSum) {
        this.postStoryTimeSum = postStoryTimeSum;
    }

    private Float preStoryTimeSum;
    private Float postStoryTimeMean;
    private Float postStoryTimeSum;

    public void calculatePreStoryValues() {
        this.preStoryTimeSum = preStoryNo1Time + preStoryNo2Time + preStoryNo3Time + preStoryNo4Time + preStoryNo5Time;
        this.preStoryTimeMean = (this.preStoryTimeSum / 5);
    }

    public void calculatePostStoryValues() {
        this.postStoryTimeSum = postStoryNo1Time + postStoryNo2Time + postStoryNo3Time + postStoryNo4Time + postStoryNo5Time;
        this.postStoryTimeMean = (this.postStoryTimeSum / 5);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public QuestionnaireData.wasSick getStatus() {
        return wasThereAnySickness;
    }

    public void setStatus(QuestionnaireData.wasSick status) {
        this.wasThereAnySickness = wasThereAnySickness;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public boolean isPersisted() {
        return id != null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this.id == null) {
            return false;
        }

        if (obj instanceof Kid && obj.getClass().equals(getClass())) {
            return this.id.equals(((Kid) obj).id);
        }

        return false;
    }

    @Override
    public Kid clone() throws CloneNotSupportedException {
        return (Kid) super.clone();
    }

    @Override
    public String toString() {
        return kidCode;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public QuestionnaireData.sex getSex() {
        return sex;
    }

    public void setSex(QuestionnaireData.sex sex) {
        this.sex = sex;
    }


    public String getNumberOfAttendances() {
        return numberOfAttendances;
    }

    public void setNumberOfAttendances(String numberOfAttendances) {
        this.numberOfAttendances = numberOfAttendances;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAgeOfMom() {
        return ageOfMom;
    }

    public void setAgeOfMom(String ageOfMom) {
        this.ageOfMom = ageOfMom;
    }

    public String getAgeOfDad() {
        return ageOfDad;
    }

    public void setAgeOfDad(String ageOfDad) {
        this.ageOfDad = ageOfDad;
    }

    public String getKidCode() {
        return kidCode;
    }

    public void setKidCode(String kidCode) {
        this.kidCode = kidCode;
    }

    public String getLanguageSpoken() {
        return languageSpoken;
    }

    public void setLanguageSpoken(String languageSpoken) {
        this.languageSpoken = languageSpoken;
    }

    public String getWhichMonthOfPregnancy() {
        return whichMonthOfPregnancy;
    }

    public void setWhichMonthOfPregnancy(String whichMonthOfPregnancy) {
        this.whichMonthOfPregnancy = whichMonthOfPregnancy;
    }

    public boolean isWhichMonthOfPregnancyDontRemember() {
        return whichMonthOfPregnancyDontRemember;
    }

    public void setWhichMonthOfPregnancyDontRemember(boolean whichMonthOfPregnancyDontRemember) {
        this.whichMonthOfPregnancyDontRemember = whichMonthOfPregnancyDontRemember;
    }

    public String getIsChildHealthyNow() {
        return isChildHealthyNow;
    }

    public void setIsChildHealthyNow(String isChildHealthyNow) {
        this.isChildHealthyNow = isChildHealthyNow;
    }

    public String getProgrammingBackground() {
        return programmingBackground;
    }

    public void setProgrammingBackground(String programmingBackground) {
        this.programmingBackground = programmingBackground;
    }

    public QuestionnaireData.education getDadEducation() {
        return dadEducation;
    }

    public void setDadEducation(QuestionnaireData.education dadEducation) {
        this.dadEducation = dadEducation;
    }

    public QuestionnaireData.education getMomEducation() {
        return momEducation;
    }

    public void setMomEducation(QuestionnaireData.education momEducation) {
        this.momEducation = momEducation;
    }


}

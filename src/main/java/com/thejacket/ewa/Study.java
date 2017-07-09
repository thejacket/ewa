package com.thejacket.ewa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mariusz on 2017-07-04.
 */
public class Study {
    private Integer id;
    private Date date;
    private ArrayList<Integer> reactionTime;
    private String picturesOrder;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Integer> getReactionTime() {
        return reactionTime;
    }

    public void setReactionTime(ArrayList<Integer> reactionTime) {
        this.reactionTime = reactionTime;
    }

    public String getPicturesOrder() {
        return picturesOrder;
    }

    public void setPicturesOrder(String picturesOrder) {
        this.picturesOrder = picturesOrder;
    }




}

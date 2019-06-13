package com.company;

import java.util.Calendar;

public class Task {
    private String target;
    private Calendar date;

    Task(String target){
        this.target = target;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
}

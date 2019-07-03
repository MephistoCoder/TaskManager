package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Task {
    private String target;
    private GregorianCalendar date;
    private String dateString;
    private int taskNumber;
    private static int amount = 0;
    Task(String target){
        this.target = target;
        this.date = new GregorianCalendar();
        amount++;
    }
    Task(){
        date = new GregorianCalendar();
        amount++;
        createTask();
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public String getDateString() {
        Date date = new Date();
        date = this.date.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY HH:mm");
        return sdf.format(date);
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public String getTarget() {
        return target;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    private void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }
    private static void breakAmount(){
        amount = 1;
    }
    public static void setNewTaskNumber(ArrayList <Task> tasks) {
        breakAmount();
        for (int i = 0; i < tasks.size(); i++, amount++)
            tasks.get(i).setTaskNumber(amount);
    }

    public void createTask (){
        Scanner input = new Scanner(System.in);
        boolean check = true;
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        taskNumber = amount;
        System.out.println("Введите описание задания, после нажмите Enter");
        target = input.nextLine();
        while (check) {
            System.out.println("Введите дату и время исполнения задания в формате dd.MM.yyyy HH:mm ");
            dateString = input.nextLine();
            try {
                date.setTime(inputDateFormat.parse(dateString));
                check = false;
            } catch (ParseException e) {
                System.out.println("Неправильнно введена дата");
                check = true;
            }
        }
        System.out.println("Задание успешно добавлено");
    }
}

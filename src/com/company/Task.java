package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        return date.toString();
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

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public static void setNewTaskNumber(Task [] tasks) {
        amount = 1;
        for (int i = 0; i < tasks.length; i++, amount++)
            tasks[i].setTaskNumber(amount);
    }

    public void createTask (){
        Scanner input = new Scanner(System.in);
        boolean check = true;
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        taskNumber = amount;
        System.out.println("Введите описание задания, после нажмите Enter");
        target = input.nextLine();
        while (check) {
            System.out.println("Введите дату исполнения задания в формате dd.MM.yyyy ");
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

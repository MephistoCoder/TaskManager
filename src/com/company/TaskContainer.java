package com.company;

import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;

public class TaskContainer {
    private HashMap <String, Task> container;
    File source;
    TaskContainer(File source){
        this.source = source;
        container = new HashMap<>();
    }
    public void readTasks() throws Exception{
        FileReader fileReader = new FileReader(source);
        Scanner input = new Scanner(fileReader);
        GregorianCalendar calendar = new GregorianCalendar();
        while (input.hasNext()){
            Task task = new Task(input.nextLine());
            calendar.set(Calendar.DAY_OF_MONTH,  input.nextInt());
            calendar.set(Calendar.MONTH,         input.nextInt());
            calendar.set(Calendar.YEAR,          input.nextInt());
            calendar.set(Calendar.HOUR,          input.nextInt());
            calendar.set(Calendar.MINUTE,        input.nextInt());
            calendar.set(Calendar.SECOND,        input.nextInt());
            task.setDate(calendar);
            container.put(task.getDateString(), task);
        }
    }
    public int size(){
        return container.size();
    }
    public void addTask(Task newTask){
        container.put(newTask.getDateString(), newTask);
    }
    public void getTasks () {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, d MMMM yyyy ");
        Calendar tmp;
        for (Task task: container.values()
             ) {
            int i = 1;
            tmp = task.getDate();
            System.out.println(i + ". " + task.getTarget() + ". Время : " + dateFormat.format(tmp.getTime()));
            i++;
        }
    }
    public void removeTask(){
        Scanner input = new Scanner(System.in);
        int number;
        HashMap <Boolean, Remove> map = new HashMap<>();
        map.put(true, new Remove() {
            @Override
            public void remove(Task task) {
                container.remove(task.getDateString());
            }
        });
        map.put(true, new Remove() {
            @Override
            public void remove(Task task) {
            }
        });
        System.out.println("Введите номер задания которое следует удалить");
        number = input.nextInt();
        for (Task task: container.values()
        ) {
            map.get(task.getTaskNumber() == number).remove(task);
        }
    }
}

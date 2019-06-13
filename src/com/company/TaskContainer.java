package com.company;

import java.io.File;
import java.io.FileReader;
import java.util.*;

public class TaskContainer {
    private HashMap <Date, Task> container;
    File source;
    TaskContainer(File source){
        this.source = source;
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
        }
    }
    public int size(){
        return container.size();
    }
}

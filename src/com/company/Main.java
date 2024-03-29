package com.company;

public class Main {

    public static void main(String[] args) {
        Check check = new Check();
        Starter starter = new Starter(check);
        starter.start();
        TaskContainer taskContainer = new TaskContainer(starter.getTargets());
        Working process = new Working(taskContainer);
        try {
            taskContainer.readTasks();
        }catch (Exception e){
        }
        process.start();
    }
}

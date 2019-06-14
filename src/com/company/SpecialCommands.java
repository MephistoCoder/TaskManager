package com.company;

import java.util.HashMap;

public class SpecialCommands {

    private HashMap <String, Command> commands ;
    SpecialCommands(TaskContainer taskContainer){
        commands = new HashMap<>();
        commands.put("/add", new Command() {
            @Override
            public void action(TaskContainer taskContainer) {
                taskContainer.addTask(new Task());
            }
        });
        commands.put("/delete", new Command() {
            @Override
            public void action(TaskContainer taskContainer) {
                taskContainer.removeTask();
            }
        });
        commands.put("/showAll", new Command() {
            @Override
            public void action(TaskContainer taskContainer) {
                taskContainer.getTasks();
            }
        });
        commands.put("/exit", new Command() {
            @Override
            public void action(TaskContainer taskContainer) {
                taskContainer.setStatus(false);
            }
        });
    }
    public void checkCommand(String key, TaskContainer taskContainer){
        commands.get(key).action(taskContainer);
    }
}

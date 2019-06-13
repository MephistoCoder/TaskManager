package com.company;

import java.util.HashMap;

public class SpecialCommands {
    HashMap <String, Command> commands;
    SpecialCommands(TaskContainer taskContainer){
        commands.put("/add", new Command() {
            @Override
            public void action(TaskContainer taskContainer) {
                taskContainer.addTask(new Task());
            }
        });
    }
}

package com.company;

import java.util.Scanner;

public class Working {
    private SpecialCommands specialCommands;
    private TaskContainer taskContainer;
    Working (TaskContainer taskContainer){
        specialCommands = new SpecialCommands(taskContainer);
        this.taskContainer = taskContainer;
    }
    public void start () {
        System.out.println("Для работы используйте следующие команды :");
        System.out.println(" /add     - создать задание\n" +
                           " /showAll - показать все задания\n" +
                           " /exit    - выйти с приложения\n" +
                           " /delete  - удалить задание");
        while (taskContainer.getStatus()) {
            System.out.println("Введите команду :");
            Scanner input = new Scanner(System.in);
            try {
                specialCommands.checkCommand(input.next(), this.taskContainer);
            } catch (NullPointerException exception) {
                System.out.println("Некорректный ввод команды");
            }
        }
    }
}

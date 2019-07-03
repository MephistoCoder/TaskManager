package com.company;

        import java.io.File;
        import java.io.FileReader;
        import java.io.FileWriter;
        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.*;
        import  java.io.IOException;

public class TaskContainer {
    private HashMap<String, Task> container;
    private boolean status;
    File source;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, d.MM.yyyy hh:mm");

    TaskContainer(File source) {
        System.out.println("Добро пожаловать в менеджер задач");
        this.status = true;
        this.source = source;
        container = new HashMap<>(0);
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void readTasks() throws Exception {
        FileReader fileReader = new FileReader(source);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Scanner input = new Scanner(fileReader);
        GregorianCalendar calendar = new GregorianCalendar();
        while (input.hasNext()) {
            Task task = new Task(input.nextLine());
            try {
                calendar.setTime(sdf.parse(input.nextLine()));
                task.setDate(calendar);
                container.put(task.getDateString(), task);
            }catch (ParseException e){
                System.out.println("Ошибка считывания даты с файла");
            }
        }
    }

    public void addTask(Task newTask) {
        container.put(newTask.getDateString(), newTask);
    }

    public void getTasks() {
        Calendar tmp;
        int i = 1;
        int checkSize = container.size();
        while (checkSize != 0){
            for (Task task : container.values()
            ) {
                tmp = task.getDate();
                System.out.println(i + ". " + task.getTarget() + ". Время : " + dateFormat.format(tmp.getTime()));
                ++i;
            }
            checkSize = 1;
            return;
        }
        System.out.println("Нет заданий");
    }
    public void writeTasks() {
        File file = new File("C:\\MyFiles\\TaskManager\\src\\com\\company\\TaskManager.txt");
        file.delete();
        file = new File("C:\\MyFiles\\TaskManager\\src\\com\\company\\TaskManager.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            for (Task task : container.values()
            ) {
                fileWriter.write(task.getTarget() + "\n" + task.getDateString());
                fileWriter.close();
            }
        }catch (IOException e) {
            System.out.println("Не существует такого файла как " +
                    "C:\\MyFiles\\TaskManager\\src\\com\\company\\TaskManager.txt");
        }
    }
    public void removeTask() {
        Scanner input = new Scanner(System.in);
        int number;
        int i = 0;
        ArrayList <Task> listValueContainer = new ArrayList(container.size());
        HashMap<Boolean, Remove> map = new HashMap<>();
        map.put(true, new Remove() {
            @Override
            public void remove(Task task) {
                int i = 0;
                listValueContainer.remove(task);
                container.remove(task.getDateString());
                for (Task aTask : container.values()
                ) {
                    listValueContainer.set(i, aTask);
                    i++;
                }
                Task.setNewTaskNumber(listValueContainer);
            }
        });
        map.put(false, new Remove() {
            @Override
            public void remove(Task task) {
                return;
            }
        });
        System.out.println("Введите номер задания которое следует удалить");
        number = input.nextInt();
        for (Task task : container.values()
        ) {
            listValueContainer.add(task);
            i++;
        }
        for ( i = 0; i < listValueContainer.size(); i++){
            map.get(listValueContainer.get(i).getTaskNumber() == number).remove(listValueContainer.get(i));
        }
        System.out.println("Задание успешно удалено");
    }
}
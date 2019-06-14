package com.company;

        import java.io.File;
        import java.io.FileReader;
        import java.text.SimpleDateFormat;
        import java.util.*;

public class TaskContainer {
    private HashMap<String, Task> container;
    private boolean status;
    File source;

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
        Scanner input = new Scanner(fileReader);
        GregorianCalendar calendar = new GregorianCalendar();
        while (input.hasNext()) {
            Task task = new Task(input.nextLine());
            calendar.set(Calendar.DAY_OF_MONTH, input.nextInt());
            calendar.set(Calendar.MONTH, input.nextInt());
            calendar.set(Calendar.YEAR, input.nextInt());
            calendar.set(Calendar.HOUR, input.nextInt());
            calendar.set(Calendar.MINUTE, input.nextInt());
            calendar.set(Calendar.SECOND, input.nextInt());
            task.setDate(calendar);
            container.put(task.getDateString(), task);
        }
    }

    public void addTask(Task newTask) {
        container.put(newTask.getDateString(), newTask);
    }

    public void getTasks() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, d MMMM yyyy ");
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

    public void removeTask() {
        Scanner input = new Scanner(System.in);
        int number;
        int i = 0;
        Task [] listValueContainer = new Task[container.size()];
        HashMap<Boolean, Remove> map = new HashMap<>();
        map.put(true, new Remove() {
            @Override
            public void remove(Task task) {
                int i = 0;
                container.remove(task.getDateString());
                for (Task aTask : container.values()
                ) {
                    listValueContainer[i] = aTask;
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
            listValueContainer[i] = task;
            i++;
        }
        for ( i = 0; i < listValueContainer.length; i++){
            map.get(listValueContainer[i].getTaskNumber() == number).remove(listValueContainer[i]);
        }
        System.out.println("Задание успешно удалено");
    }
}
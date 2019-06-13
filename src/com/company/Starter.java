package com.company;

import java.io.File;

public class Starter {

    private Check check;
    private File targets;

    public Starter(Check check) {
        this.check = check;
    }

    public void start ()  {
        File file = new File("C:\\MyFiles\\TaskManager\\src\\com\\company\\TaskManager.txt");
        try {
            this.targets = this.check.action.get(file.exists()).isExist(file);
        }catch (Exception e){
            System.out.println("Ошибка в Starter");
        }
     }

    public File getTargets() {
        return targets;
    }
}



package com.company;

import java.io.File;
import java.util.HashMap;

public class Check {

    protected HashMap<Boolean, Choice> action;

    Check() {
        this.action = new HashMap(2);
        action.put(true, new Choice() {
            @Override
            public File isExist(File file) {
                return file;
            }
        });
        action.put(false, new Choice() {
            @Override
            public File isExist(File file) throws Exception {
                    File newName = new File("C:\\MyFiles\\TaskManager\\src\\com\\company\\TaskManager.txt");
                    newName.createNewFile();
                    file.renameTo(newName);
                    return file;
            }
        });
    }

}
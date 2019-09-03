package com.company;

import java.util.HashMap;

public class CorrectDateInput {
    private  HashMap <Boolean, CheckDate> correctInput;
    CorrectDateInput(){
        this.correctInput = new HashMap<>();
        correctInput.put(true, new CheckDate() {
            @Override
            public void check (String inDate) {
                return;
            }
        });
        correctInput.put(false, new CheckDate() {
            @Override
            public void check(String inDate) throws TaskException {
                throw new TaskException("Введенная дата находится в прошлом, введите дату будущего");
            }
        });
    }

    public HashMap<Boolean, CheckDate> getCorrectInput() {
        return correctInput;
    }
}

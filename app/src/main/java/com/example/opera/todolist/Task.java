package com.example.opera.todolist;

public class Task {

    private boolean isChecked;
    public String task;

    public Task(String item){
        task = item;
        isChecked = false;
    }

    public boolean getChecked(){
        return isChecked;
    }

    public void setChecked(boolean checked){
        isChecked = checked;
    }
}

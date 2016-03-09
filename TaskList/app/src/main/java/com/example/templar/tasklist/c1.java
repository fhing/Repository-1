package com.example.templar.tasklist;

/**
 * Created by Templar on 09/03/2016.
 */
public class c1 {
    String name;
    int checked;
    c1(String name, int value)
    {
        this.name=name;
        this.checked=value;
    }
    public int getChecked(){
        return this.checked;
    }
    public void setChecked(int value){
        this.checked = value;
    }
    public String getName(){
        return this.name;
    }
    public void setChecked(String name){
        this.name = name;
    }
}

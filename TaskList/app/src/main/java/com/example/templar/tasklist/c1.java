package com.example.templar.tasklist;

/**
 * Created by Templar on 09/03/2016.
 */
public class c1 {
    String name;
    boolean checked;
    c1(String name, boolean value)
    {
        this.name=name;
        this.checked=value;
    }
    public boolean getChecked(){
        return this.checked;
    }
    public void setChecked(boolean value){
        this.checked = value;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
}

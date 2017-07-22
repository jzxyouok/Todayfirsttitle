package com.bwei.Bean;

/**
 * Created by 葛凯旋 on 2017/7/21.
 */
public class Downbean {
    private String  name;
    private   boolean  checkbox;

    public Downbean(boolean checkbox, String name) {
        this.checkbox = checkbox;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCheckbox() {
        return checkbox;
    }

    public void setCheckbox(boolean checkbox) {
        this.checkbox = checkbox;
    }
}

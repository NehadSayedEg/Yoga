package com.nehad.android.yoga.Model;

public class Exercise {
    private String image_id;
    private String name;

    //constructor

    public Exercise(String image_id, String name) {
        this.image_id = image_id;
        this.name = name;
    }

    //getters & setters

    public String getImage_id() {
        return image_id;
    }

    public String getName() {
        return name;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public void setName(String name) {
        this.name = name;
    }
}

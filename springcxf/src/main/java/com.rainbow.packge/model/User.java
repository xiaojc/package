package com.rainbow.packge.model;

import java.io.Serializable;

/**
 * 功能描述:
 * Created by Admin on 2016-07-20 23:20.
 */

public class User implements Serializable{

    private static final long serialVersionUID = -325658023995564313L;
    private String id;
    private String name;
    private String age;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

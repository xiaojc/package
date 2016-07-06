package com.rainbow.commons.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by xiaojc on 2016/7/6.
 * 功能:
 */
@XmlRootElement(name="receiver")
public class Receiver {

    private String man;

    private int age;

    public String getMan() {
        return man;
    }

    public void setMan(String man) {
        this.man = man;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Receiver(String man, int age) {
        this.man = man;
        this.age = age;
    }

    public Receiver() {
    }
}

package com.rainbow.commons.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 功能描述: 发送邮件的实体类
 * Created by Admin on 2016-07-05 22:01.
 */
@XmlRootElement(name="email")
public class Email implements Serializable {
    private static final long serialVersionUID = 9864472132884997L;


    private Receiver receiver;//接收器
    private String title;//标题
    private String content;//正文

    @XmlElement(name="receiver")
    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Email(){}

    public Email(Receiver receiver, String title, String content) {
        this.receiver = receiver;
        this.title = title;
        this.content = content;
    }
}

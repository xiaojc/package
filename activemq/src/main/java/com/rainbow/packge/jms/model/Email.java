package com.rainbow.packge.jms.model;

import java.io.Serializable;

/**
 * 功能描述: 发送邮件的实体类
 * Created by Admin on 2016-07-05 22:01.
 */
public class Email implements Serializable {
    private static final long serialVersionUID = 9864472132884997L;

    private String receiver;//接收器
    private String title;//标题
    private String content;//正文

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
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

    @Override
    public String toString() {
        return "Email{" +
                "receiver='" + receiver + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Email(String receiver, String title, String content) {
        this.receiver = receiver;
        this.title = title;
        this.content = content;
    }
}

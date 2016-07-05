package com.rainbow.packge.jms.listener;

import com.rainbow.packge.jms.model.Email;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

/**
 * 功能描述:
 * Created by Admin on 2016-07-05 23:13.
 */
public class ConsumerListener {

    public void receiveMessage(String message) {
        System.out.println("ConsumerListener通过receiveMessage接收到一个纯文本消息，消息内容是：" + message);
    }

    public void receiveMessage(Email email) {
        System.out.println("接收到一个包含Email的ObjectMessage。");
        System.out.println(email);
    }

    public void receiveMessage(ObjectMessage message) throws JMSException {
        System.out.println(message.getObject());
    }

}

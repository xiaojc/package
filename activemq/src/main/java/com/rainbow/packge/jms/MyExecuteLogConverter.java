package com.rainbow.packge.jms;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by xiaojc on 2016/7/5.
 * 功能:消息转换器
 * fromMessage是用来把一个JMS Message转换成对应的Java对象，
 * 而toMessage方法是用来把一个Java对象转换成对应的JMS Message
 */
public class MyExecuteLogConverter implements MessageConverter {

    public Message toMessage(Object o, Session session) throws JMSException, MessageConversionException {
        return null;
    }

    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        return null;
    }
}

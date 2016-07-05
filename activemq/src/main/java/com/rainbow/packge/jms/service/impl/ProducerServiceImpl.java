package com.rainbow.packge.jms.service.impl;

import com.rainbow.packge.jms.service.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * 功能描述:
 * Created by Admin on 2016-07-04 23:11.
 */
@Service
@Slf4j
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * 发送消息
     * @param destination
     * @param message
     */
    public void sendMessage(Destination destination, final String message) {
        log.info("---------------生产者发送消息-----------------");
        log.info("---------------生产者发了一个消息：{}", message);

        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }

    /**
     * 使用MessageConverter
     * @param destination
     * @param obj
     */
    public void sendMessage(Destination destination, Object obj) {
        jmsTemplate.convertAndSend(destination, obj);
    }
}

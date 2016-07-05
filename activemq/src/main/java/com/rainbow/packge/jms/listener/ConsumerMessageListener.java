package com.rainbow.packge.jms.listener;

import com.rainbow.packge.jms.model.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.*;

/**
 * 功能描述:activeMQ jms 监听实现类
 * Created by Admin on 2016-07-04 23:17.
 */
@Slf4j
public class ConsumerMessageListener implements MessageListener {

    @Autowired
    private MessageConverter messageConverter;

    public void onMessage(Message message) {
        /*//这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换
        TextMessage textMsg = (TextMessage) message;
        System.out.println("接收到一个纯文本消息。");
        try {
            System.out.println("消息内容是：" + textMsg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }*/

        log.info("接收到一个ObjectMessage，包含Email对象。");
        System.out.println(message);
       /* if (message instanceof ObjectMessage) {
            ObjectMessage objMessage = (ObjectMessage) message;
            try {
                *//*Object obj = objMessage.getObject();
                Email email = (Email) obj;*//*
//                Email email = (Email) messageConverter.fromMessage(objMessage);
                log.info("接收到一个ObjectMessage，包含Email对象。");
                System.out.println(message);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }*/
    }

}

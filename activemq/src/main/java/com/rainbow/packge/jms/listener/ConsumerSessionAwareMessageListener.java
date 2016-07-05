package com.rainbow.packge.jms.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.*;

/**
 * Created by xiaojc on 2016/7/5.
 * 功能: spring jms 提供的消息监听器
 */
public class ConsumerSessionAwareMessageListener implements SessionAwareMessageListener<TextMessage>  {

    private Destination destination;


    /**
     *
     * @param message 接收消息的message
     * @param session 发送回复的session
     * @throws JMSException
     */
    public void onMessage(TextMessage message, Session session) throws JMSException {

        System.out.println("收到一条消息");
        System.out.println("消息内容是：" + message.getText());
        MessageProducer producer = session.createProducer(destination);
        Message textMessage = session.createTextMessage("测试ConsumerSessionAwareMessageListener。。。");
        producer.send(textMessage);
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}

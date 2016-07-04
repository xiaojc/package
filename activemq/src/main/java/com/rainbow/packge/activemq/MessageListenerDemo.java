package com.rainbow.packge.activemq;

import javax.jms.*;

/**
 * Created by xiaojc on 2016/7/4.
 * 功能:
 */
public class MessageListenerDemo implements MessageListener {

    public void onMessage(Message message) {

        TextMessage message1 = (TextMessage)message;
        try {
            System.out.println("收到消息" + message1.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

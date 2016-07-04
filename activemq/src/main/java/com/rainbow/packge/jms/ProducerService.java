package com.rainbow.packge.jms;

import javax.jms.Destination;

/**
 * 功能描述: 消息生成者发送消息接口类
 * Created by Admin on 2016-07-04 23:13.
 */
public interface ProducerService {

    public void sendMessage(Destination destination, String message);
}

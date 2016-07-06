package com.rainbow.packge.jms;

import com.rainbow.packge.jms.model.Email;
import com.rainbow.packge.jms.service.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;

/**
 * 功能描述:jms消息接收测试类
 * Created by Admin on 2016-07-04 23:22.
 */

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/application-context.xml")
public class ProducerConsumerTest {

    @Autowired
    private ProducerService producerService;
    @Autowired
    @Qualifier("queueDestination")
    private Destination destination;

/*    @Autowired
    @Qualifier("sessionAwareQueue")
    private Destination destination;*/

    @Test
    public void testSend() {
       /* for (int i=0; i<2; i++) {
            producerService.sendMessage(destination, "你好，生产者！这是消息：" + (i+1));
        }*/

//        producerService.sendMessage(destination, "生产者产生一条信息.");
        Email email = new Email("xjc_sun@163.com", "调休申请", "20160901请求一天");
        producerService.sendMessage(destination, email);
    }


    @Test
    public void testObjectMessage() {
        log.info("开始发生消息：");
        Email email = new Email("zhangsan@xxx.com", "主题", "内容");
        producerService.sendMessage(destination, email);

    }
}

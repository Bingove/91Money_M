package com.qfedu.uicontroller.mq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

/**
 * @Author Bingove
 * @Date 2018/8/4 0004 上午 11:51
 * p2p 点对点 消息提供者
 */
public class MqHelp {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private ActiveMQQueue queue;

    //创建消息并发送消息
    public void sendMsg(String msg){
        jmsTemplate.send(queue,(session) -> {
            return session.createTextMessage(msg);
        });
    }
}

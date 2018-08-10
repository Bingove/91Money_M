package com.qfedu.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.xml.bind.SchemaOutputResolver;

/**
 * @Author Bingove
 * @Date 2018/8/4 0004 上午 8:51
 * 订阅者
 */
public class ActionMQSub {
    public static void main(String[] args) throws Exception {
        //网络客户端口
        String url = "tcp://118.31.44.95:61616";
        //创建工厂
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(url);
        //设置全局序列化
        factory.setTrustAllPackages(true);
        //创建连接对象
        Connection connection = factory.createConnection();
        //设置是否开启事物
        connection.start();
        //创建会话 ，设置不开启事物
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建主题
        Topic study = session.createTopic("study");
        //窗帘消费者 订阅者
        MessageConsumer consumer = session.createConsumer(study);
        //接收消息
        consumer.setMessageListener((message) -> {
            try {
                if (message instanceof TextMessage) {
                    System.out.println("文本消息--->" + ((TextMessage) message).getText());
                } else if(message instanceof ObjectMessage) {
                    System.out.println("对象消息-->" + ((ObjectMessage) message).getObject());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }
}

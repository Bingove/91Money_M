package com.qfedu.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;


import javax.jms.*;

/**
 * @Author Bingove
 * @Date 2018/8/4 0004 上午 8:52
 * 发布者
 */
public class ActionMQPub {
    public static void main(String[] args) throws Exception{
        String url = "tcp://118.31.44.95:61616";
        //创建工厂
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(url);
        //设置可以接受序列化说明
        factory.setTrustAllPackages(true);
        //创建连接对象
        Connection connection = factory.createConnection();
        //开启连接
        connection.start();
        //创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建主题
        Topic topic = session.createTopic("study");
        //创建消息提供作者
        MessageProducer producer = session.createProducer(topic);
        //创建内容
       // TextMessage message = session.createTextMessage("It's impossible");
        ObjectMessage message = session.createObjectMessage(new Person(100, "wangwu", "man"));
        //发布
        producer.send(message);
        session.close();
        connection.close();
    }
}

package com.qfedu.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Author Bingove
 * @Date 2018/8/3 0003 上午 9:32
 * p2p
 * 发送方
 */
public class ActiveMQSend_Main {
    public static void main(String[] args) throws Exception {
        String url = "tcp://118.31.44.95:61616";
        //1创建工厂
        ConnectionFactory factory = new ActiveMQConnectionFactory(url);
        ((ActiveMQConnectionFactory) factory).setTrustAllPackages(true);
        //2创建连接
        Connection connection = factory.createConnection();
        //3 开启连接
        connection.start();
        //4 创建会话(false 不开启事物)
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5 创建队列
        Queue bingove = session.createQueue("Bingove");
        //6创建消息提供者
        MessageProducer producer = session.createProducer(bingove);

        //7创建文本消息
       // TextMessage message = session.createTextMessage("今天你学会了什么了呢？");
        ObjectMessage message = session.createObjectMessage(new Person(188, "张伟", "女"));
        //8发送消息
        producer.send(message);
        //9关闭销毁
        session.close();
        connection.close();
    }
}

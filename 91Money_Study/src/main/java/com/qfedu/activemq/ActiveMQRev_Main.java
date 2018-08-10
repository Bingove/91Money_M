package com.qfedu.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


/**
 * @Author Bingove
 * @Date 2018/8/3 0003 上午 9:32
 * 接收端 p2p
 */
public class ActiveMQRev_Main {
    public static void main(String[] args) throws Exception {
        String url = "tcp://118.31.44.95:61616";
        //String url = "tcp://10.8.155.34:61616";
        ConnectionFactory factory = new ActiveMQConnectionFactory(url);
        ((ActiveMQConnectionFactory) factory).setTrustAllPackages(true);
        Connection connection = factory.createConnection();
        connection.start();
        //4 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5 创建队列
        Queue bingove = session.createQueue("Bingove");
        //6创建消息消费者
        MessageConsumer consumer = session.createConsumer(bingove);
        consumer.setMessageListener((message) -> {
            try {
                if (message instanceof TextMessage) {
                    System.out.println("文本消息--->>" + ((TextMessage) message).getText());
                } else if (message instanceof ObjectMessage) {
                    System.out.println("对象消息--->>" + ((ObjectMessage) message).getObject());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

   /*       consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {

            }
        });*/

        //7接收消息
        //TextMessage receive = (TextMessage)consumer.receive();
/*        ObjectMessage receive = (ObjectMessage) consumer.receive();
        System.out.println(receive.getObject());
        //8关闭销毁

        session.close();
        connection.close();*/
    }

}


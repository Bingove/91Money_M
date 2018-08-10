package com.qfedu.controller;

import org.springframework.jms.connection.SingleConnectionFactory;

/**
 * @Author Bingove
 * @Date 2018/8/9 0009 下午 20:46
 */
public class Singleton {
    private static Singleton singleton;
    //私有化的构造方法
    private Singleton() {}
    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        String st1 = "a";
        String st2 = "a";
        System.out.println(st1==st2);
      // Singleton singleton = new Singleton();
       // Singleton singleton1 = new Singleton();
        System.out.println(singleton);
    }

}
class Test {
    public static void main(String[] args) {
       // Singleton singleton = new Singleton();
    }
}

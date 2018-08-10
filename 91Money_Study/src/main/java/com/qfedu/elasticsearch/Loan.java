package com.qfedu.elasticsearch;

/**
 * @Author Bingove
 * @Date 2018/8/8 0008 下午 18:14
 */
public class Loan {
    private int id;
    private int money;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public Loan(int id, int money, String title) {
        this.id = id;
        this.money = money;
        this.title = title;
    }

    public Loan() {
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", money=" + money +
                ", title='" + title + '\'' +
                '}';
    }
}

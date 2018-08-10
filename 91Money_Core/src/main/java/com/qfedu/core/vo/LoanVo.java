package com.qfedu.core.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author Bingove
 * @Date 2018/8/10 0010 上午 9:53
 */
public class LoanVo {
    private int id;
    private int type;
    private String typename;
    private int rate;
    private int monthes;
    private int minmoney;
    private int money;
    private int completemoney;//已经完成的金额
    private int investpeople;//投资人数
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date authdate;//审核通过日期 --起始日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date enddate;//结束日期 --结束日期
    private int days;//投标天数
    private int totlemoney;//可用余额
    private String flagname;//投标类型   可投、结束
    private int flag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
        switch (type) {
            case 1:
                typename = "信用标";
                break;
            case 2:
                typename = "债券标";
                break;
            case 3:
                typename = "抵押标";
                break;
        }
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getMonthes() {
        return monthes;
    }

    public void setMonthes(int monthes) {
        this.monthes = monthes;
    }

    public int getMinmoney() {
        return minmoney;
    }

    public void setMinmoney(int minmoney) {
        this.minmoney = minmoney;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getCompletemoney() {
        return completemoney;
    }

    public void setCompletemoney(int completemoney) {
        this.completemoney = completemoney;
    }

    public int getInvestpeople() {
        return investpeople;
    }

    public void setInvestpeople(int investpeople) {
        this.investpeople = investpeople;
    }

    public Date getAuthdate() {
        return authdate;
    }

    public void setAuthdate(Date authdate) {
        this.authdate = authdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(authdate);
        calendar.add(Calendar.DAY_OF_MONTH, days); //当前时间加上  期限 也就是天数
        enddate = calendar.getTime();
    }

    public int getTotlemoney() {
        return totlemoney;
    }

    public void setTotlemoney(int totlemoney) {
        this.totlemoney = totlemoney;
    }

    public String getFlagname() {
        return flagname;
    }

    public void setFlagname(String flagname) {
        this.flagname = flagname;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
        switch (flag) {
            case 1:
                flagname = "未审核";
                break;
            case 2:
                flagname = "审核";
                break;
            case 3:
                flagname = "未审核";
                break;
        }
    }
}

package com.qfedu.domain.user;

import java.io.Serializable;

/**
 * @Author Bingove
 * @Date 2018/7/24 0024 下午 17:40
 */
public class User implements Serializable {
    private int id;
    private String username;
    private String phone;
    private String password;
    private int uid;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

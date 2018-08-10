package com.qfedu.pojo;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Author Bingove
 * @Date 2018/8/9 0009 上午 9:31
 */
@Document(indexName = "91moneynewsd",type = "news")
public class NewsES {
    private int id;
    private String title;

    public NewsES(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public NewsES(int id) {
        this.id = id;
    }

    public NewsES() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

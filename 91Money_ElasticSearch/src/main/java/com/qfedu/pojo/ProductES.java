package com.qfedu.pojo;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Author Bingove
 * @Date 2018/8/20 0020 下午 14:54
 */
@Document(indexName = "product", type = "product")
public class ProductES {
    private int id;
    private String type;

    public ProductES(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public ProductES() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

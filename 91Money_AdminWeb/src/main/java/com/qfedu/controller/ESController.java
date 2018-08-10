package com.qfedu.controller;

import com.alibaba.fastjson.JSON;
import com.qfedu.core.clientutils.ClientUtils;
import com.qfedu.core.vo.R;
import com.qfedu.domain.news.News;
import com.qfedu.service.news.NewsService;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Bingove
 * @Date 2018/8/9 0009 下午 21:45
 */
@Controller
public class ESController {
    @Autowired
    private NewsService service;

    @RequestMapping("sys/es/{page}")
    public String index(@PathVariable String page) {
        return "sys/es/" + page;
    }

    //HttpClient Apache 的网络请求工具
    @RequestMapping("newsindexadd")
    @ResponseBody
    public R save() throws Exception {
        List<News> list = service.queryAll(0);
        String json = JSON.toJSONString(list);
        String url = "http://localhost:8089/newsessave.do";
        String json1 = ClientUtils.getClient(json,url);
        if (json1 != null) {
            return JSON.parseObject(json1, R.class);
        } else {
            return R.setError("异常");
        }
        /*//创建请求对象
        HttpPost post = new HttpPost("http://localhost:8089/newsessave.do");
        List<NameValuePair> pairs = new ArrayList<>();
        pairs.add(new BasicNameValuePair("json", json));


        //设置请求参数
        post.setEntity(new UrlEncodedFormEntity(pairs, "UTF-8"));
        //创建客户端
        CloseableHttpClient client = HttpClientBuilder.create().build();
        CloseableHttpResponse response = client.execute(post);
        if (response.getStatusLine().getStatusCode() == 200) {
            String json1 = EntityUtils.toString(response.getEntity(), "UTF-8");
           return JSON.parseObject(json1, R.class);

        } else {
            return R.setError("异常");
        }*/
    }

}

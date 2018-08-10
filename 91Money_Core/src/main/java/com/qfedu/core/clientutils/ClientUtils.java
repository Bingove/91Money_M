package com.qfedu.core.clientutils;

import com.alibaba.fastjson.JSON;
import com.qfedu.core.vo.R;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Bingove
 * @Date 2018/8/9 0009 下午 22:10
 */
public class ClientUtils {
    public static String getClient(String json, String url) throws Exception {
        // List<News> list = service.queryAll(0);
        //  String json = JSON.toJSONString(list);
        //创建请求对象
        HttpPost post = new HttpPost(url);
        List<NameValuePair> pairs = new ArrayList<>();
        pairs.add(new BasicNameValuePair("json", json));


        //设置请求参数
        post.setEntity(new UrlEncodedFormEntity(pairs, "UTF-8"));
        //创建客户端
        CloseableHttpClient client = HttpClientBuilder.create().build();
        CloseableHttpResponse response = client.execute(post);
        if (response.getStatusLine().getStatusCode() == 200) {
            String json1 = EntityUtils.toString(response.getEntity(), "UTF-8");
            return json1;

        } else {
            return null;
        }
    }

}

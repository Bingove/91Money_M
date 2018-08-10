package com.qfedu.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.util.List;

/**
 * @Author Bingove
 * @Date 2018/8/8 0008 上午 9:34
 */
public class ES_Main1 {
    private static String host = "39.104.168.246";
    private static int port = 9300;

    public static void main(String[] args) throws Exception {
        //connect();
        crud();
    }

    //连接 ES服务器
    public static void connect() throws Exception {
        //构建设置信息,需要指定集群的名称
        Settings settings = Settings.builder().put("cluster.name", "es01").build();
        //创建客户端对象
        TransportClient client = new PreBuiltTransportClient(settings).addTransportAddress(
                new InetSocketTransportAddress(InetAddress.getByName(host), port)
        );
        //获得所有的节点
        List<DiscoveryNode> nodes = client.connectedNodes();

        for (DiscoveryNode no : nodes
                ) {
            System.out.println(no.getHostName() + "----" + no.getName());
        }
        //关闭
        client.close();
    }

    //索引的CRUD
    private static void crud() throws Exception {
        //构建设置信息,需要指定集群的名称
        Settings settings = Settings.builder().put("cluster.name", "es01").build();
        //创建客户端对象
        TransportClient client = new PreBuiltTransportClient(settings).addTransportAddress(
                new InetSocketTransportAddress(InetAddress.getByName(host), port)
        );
        //新建索引
        //JSONObject object = new JSONObject();
        // object.put("title","学习 学习");
        // object.put("money","30000");
        Loan loan = new Loan(1004, 6688, "天天q上");
        //将对象转为字符串
        JSONObject object = JSONObject.parseObject(JSON.toJSONString(loan));
        /*IndexResponse response = client.prepareIndex("cdj", "loan", "1002").
               setSource(object, XContentType.JSON).get();
        System.out.println("添加数据"+response.getIndex());*/

        //查询索引
       // GetResponse getFields = client.prepareGet("cdj", "loan", "1002").get();
      //  System.out.println("查询索引---->" + getFields.getSourceAsString());
        //修改索引
        // UpdateResponse response = client.prepareUpdate("cdj", "loan", "1002").setDoc(object, XContentType.JSON).get();
        // System.out.println("修改---->" + response.status().toString());
        //删除索引
        //DeleteResponse deleteResponse = client.prepareDelete("loans", "loan", "1001").get();
        // System.out.println(deleteResponse.status().toString());
        //关闭
        client.close();
    }
}

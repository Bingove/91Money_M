package com.qfedu.test;


import com.qfedu.domain.admin.SysUser;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static freemarker.template.Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS;

/**
 * @Author Bingove
 * @Date 2018/8/1 0001 下午 14:31
 */
public class FM_Main1 {
    public static void main(String[] args) throws Exception {
        //1创建配置对象
        Configuration configuration = new Configuration(DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        //2设置模板目录
        configuration.setDirectoryForTemplateLoading(new File("91Money_AdminWeb/src/main/resources/tem"));
        //3加载模板文件
        Template template = configuration.getTemplate("all.ftl","utf-8");
        //4写入数据
        HashMap<String, Object> params = new HashMap<>();
        //String
        params.put("msg","张三");
        //对象
        SysUser sysUser = new SysUser();
        sysUser.setEmail("bingove@163.com");
        sysUser.setMobile("1378249124");
        sysUser.setUsername("Bingove");
        params.put("sysuser",sysUser);
        //集合
        List<String> list = new ArrayList<>();
        for(int i=65;i < 73; i++) {
            list.add("BINGOVE ONLY YOU"+ i);
        }
        params.put("list",list);
        //5保存
        FileWriter writer=new FileWriter("all.html");
        template.process(params,writer);
        System.out.println("OK");
    }
}

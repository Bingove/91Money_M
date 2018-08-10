package com.qfedu.spider;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Bingove
 * @Date 2018/7/31 0031 下午 14:51
 */
public class WebMagic_Main {
    public static void main(String[] args) {
        //addUrl("")---网址
        Spider.create(new MySpider()).addUrl("http://www.huanqiu.com/").
                addPipeline(new PositionDetailPipeline()).
                thread(10).start();
    }
}

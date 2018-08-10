package com.qfedu.spider;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;

/**
 * @Author Bingove
 * @Date 2018/7/31 0031 下午 14:51
 */
public class MySpider implements PageProcessor {
    @Override
    public void process(Page page) {
       // System.out.println(page.getUrl());
        //System.out.println(page.getHtml());
        //page.putField("链接",page.getHtml().xpath("a[@se_prerender_url='complete']/@href").all());
        page.putField("链接",page.getHtml().xpath("a[@target='_blank']/@href").all());
        page.putField("标题",page.getHtml().xpath("a[@target='_blank']/text()").all());
        System.out.println(page.getHtml().xpath("a[@target='_blank']/@href").toString());
    }

    @Override
    public Site getSite() {
        return Site.me().setRetryTimes(10).setSleepTime(100);

    }
}

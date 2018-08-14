package com.qfedu.controller;

import com.alibaba.fastjson.JSON;
import com.qfedu.core.vo.R;
import com.qfedu.domain.news.News;
import com.qfedu.pojo.NewsES;
import com.qfedu.service.NewsESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Bingove
 * @Date 2018/8/9 0009 上午 9:37
 */
@RestController
public class NewsESController {
    @Autowired
    private NewsESService service;

    //json 数据就是从前端获得的，在这里由后台admin查询获得提供
    @PostMapping("newsessave.do")
    public R save(String json) {
        List<News> list = JSON.parseArray(json,News.class);
        List<NewsES> newsES = new ArrayList<>(list.size());
        for (News n: list) {
            NewsES obj = new NewsES();
            obj.setId(n.getId());
            obj.setTitle(n.getTitle());
            newsES.add(obj);
        }
        return service.saveBatch(newsES);
    }
    //模糊查找
    @GetMapping("newesquery.do")
    public List<NewsES> queryByTitle(String title) {
        return service.queryByTittle(title);
    }
}

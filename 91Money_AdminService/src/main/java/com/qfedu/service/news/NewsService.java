package com.qfedu.service.news;

import com.qfedu.core.vo.R;
import com.qfedu.domain.news.News;

import java.util.List;

/**
 * @Author Bingove
 * @Date 2018/8/1 0001 下午 19:12
 */
public interface NewsService {
    //查询
    List<News> queryAll(int flag);
    //新增 读取出来则 flag =1
    R save(News news);
}

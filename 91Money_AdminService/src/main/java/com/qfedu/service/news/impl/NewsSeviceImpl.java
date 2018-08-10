package com.qfedu.service.news.impl;

import com.qfedu.core.utils.ExecuteUtil;
import com.qfedu.core.vo.R;
import com.qfedu.domain.news.News;
import com.qfedu.mapper.news.NewsMapper;
import com.qfedu.service.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Bingove
 * @Date 2018/8/1 0001 下午 19:20
 */
@Service
public class NewsSeviceImpl implements NewsService {
    @Autowired
    private NewsMapper mapper;
    @Override
    public List<News> queryAll(int flag) {
        return mapper.selectAll(flag);
    }

    @Override
    public R save(News news) {
        return ExecuteUtil.getR(mapper.insert(news),"新增");
    }
}

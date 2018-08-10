package com.qfedu.repository;

import com.qfedu.pojo.NewsES;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Author Bingove
 * @Date 2018/8/9 0009 上午 9:33
 */
public interface NewsESRepository extends ElasticsearchRepository <NewsES,Integer>{
    List<NewsES> findByTitleLike(String title);

}

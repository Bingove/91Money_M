package com.qfedu.service;

import com.qfedu.core.vo.R;
import com.qfedu.pojo.NewsES;

import java.util.List;

/**
 * @Author Bingove
 * @Date 2018/8/9 0009 上午 9:35
 */
public interface NewsESService {
    //添加
    R save(NewsES newsES);
    R saveBatch(List<NewsES> list);
    //查询 模糊查询
    List<NewsES> queryByTittle(String title);

    //删除
    R del(List<Integer> ids);
    R del(int id);
}

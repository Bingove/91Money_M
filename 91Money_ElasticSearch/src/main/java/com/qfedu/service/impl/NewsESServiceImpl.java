package com.qfedu.service.impl;

import com.qfedu.core.vo.R;
import com.qfedu.pojo.NewsES;
import com.qfedu.repository.NewsESRepository;
import com.qfedu.service.NewsESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Bingove
 * @Date 2018/8/9 0009 上午 9:36
 */
@Service
public class NewsESServiceImpl implements NewsESService {
    @Autowired
    private NewsESRepository repository;

    @Override
    public R save(NewsES newsES) {
        if (repository.save(newsES) != null) {
            return R.setOk("success");
        } else {
            return R.setError("失败");
        }
    }

    @Override
    public R saveBatch(List<NewsES> list) {
        //list集合实现了迭代器
        if (repository.saveAll(list) != null) {
            return R.setOk("批量更新索引成功");
        } else {
            return R.setOk("批量更新索引失败");
        }

    }

    @Override
    public List<NewsES> queryByTittle(String title) {
        return repository.findByTitleLike(title);
    }

    @Override
    public R del(List<Integer> ids) {
        List<NewsES> newsES = new ArrayList<>();
        for (Integer id : ids) {
            newsES.add(new NewsES(id));
        }
        repository.deleteAll(newsES);
        return R.setOk("删除成功");
    }

    @Override
    public R del(int id) {
        repository.deleteById(id);
        return R.setOk("删除成功");
    }
}

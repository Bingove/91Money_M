package com.qfedu.controller;

import com.qfedu.core.vo.R;
import com.qfedu.domain.user.UserDetail;
import com.qfedu.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Bingove
 * @Date 2018/7/27 0027 下午 16:49
 */
@RestController
public class UserDetailController {
    @Autowired
    private UserDetailService service;
    //新增
    @PostMapping("/userdetail.do")
    public R save(UserDetail userDetail) {
        return service.save(userDetail);
    }

    //查询单个
    @GetMapping("")
    public UserDetail queryByN(String name) {
        return service.queryByN(name);
    }

    //查询全部
    @GetMapping("/userdetailquery.do")
    public List<UserDetail> queryAll() {
        return service.quertyAll();
    }

}

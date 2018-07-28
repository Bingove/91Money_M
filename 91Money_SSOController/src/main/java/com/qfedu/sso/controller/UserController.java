package com.qfedu.sso.controller;

import com.qfedu.core.utils.CookieUtil;
import com.qfedu.core.vo.R;
import com.qfedu.domain.user.User;
import com.qfedu.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author Bingove
 * @Date 2018/7/24 0024 下午 18:08
 */
@RestController    //返回的都是Json 类型的数据
public class UserController {
    @Autowired
    private UserService service;

    //检测用户名是否存在
    @GetMapping("/usercheckname.do")
    public R checkName(String username) {

        return service.checkName(username);
    }
    //保存，注册使用
    @PostMapping("/userregister.do")    // @RequestBody 解析json数据 @ResponseBody 生成json数据
    public R save(User user) {
        return service.save(user);
    }

    //查询所有的用户，进行分页查询
    @GetMapping("/userquery.do")
    public List<User> queryPageAll() {
        return service.queryPageAll();
    }

    //单点登录
    @PostMapping("/userlogin.do")
    public R userLogin(String name, String password, HttpServletResponse response, HttpSession session) {
        //return service.ssoLogin(name,password,response,session);
        System.out.println(name + "------------" + password + "sss-----------");
        R r = service.ssoLogin(name,password);
        if(r.getCode() == 0) {
            //设置Cookie 将tk 设置进去 -1 代表存在内存中
            CookieUtil.setCK("userauth",r.getMsg(),-1,response);
        }
        return r;
    }
    //检测是否已经登录
    @GetMapping("/usercheck.do")
    public R userCheck(HttpServletRequest request, HttpServletResponse response) {
        String token = CookieUtil.getCk("userauth",request);
        R r = service.ssoCheck(token);
        if(r.getCode() != 0) {
            //表名已经失效
            //不存在，就删除Cooken ，重新登录
            CookieUtil.delCK("userauth", response);
        }
        //return service.ssoCheck(token,response);
        return r;
    }

    //退出
    @GetMapping("/userout.do")
    public R userout(HttpServletRequest request,HttpServletResponse response) {
        String token = CookieUtil.getCk("userauth",request);
        //return service.userOut(token,response);
        R r = service.userOut(token);
        if(r.getCode() == 0) {
            CookieUtil.setCK("userauth","",0,response);
        }
        return r;
    }
}

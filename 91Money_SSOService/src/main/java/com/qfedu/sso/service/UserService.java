package com.qfedu.sso.service;

import com.qfedu.core.vo.R;
import com.qfedu.domain.user.User;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author Bingove
 * @Date 2018/7/24 0024 下午 17:55
 */
public interface UserService {
    //校验用户名
    R checkName(String username);
    //保存 新增
    R save(User user);
    //查询所有，分页
   // List<User> queryPageAll(int page,int count);
    List<User> queryPageAll();

    //登录查询---一般的登录
    User queryByName(String name);
    //检测是否登录
    R ssoCheck(String token);
    //仅仅登录使用
    R ssoLogin(String name, String password);
    //注销
    R userOut(String token);
}

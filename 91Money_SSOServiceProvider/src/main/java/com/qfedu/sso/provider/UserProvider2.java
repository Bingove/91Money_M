package com.qfedu.sso.provider;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.qfedu.core.redis.JedisUtil;
import com.qfedu.core.utils.CookieUtil;
import com.qfedu.core.utils.ExecuteUtil;
import com.qfedu.core.utils.IdGenerator;
import com.qfedu.core.vo.R;
import com.qfedu.domain.user.User;
import com.qfedu.mapper.user.UserMapper;
import com.qfedu.sso.service.UserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Author Bingove
 * @Date 2018/7/24 0024 下午 18:02
 */
@Service
public class UserProvider2 implements UserService2 {
    @Autowired
    private UserMapper mapper;
    @Autowired
    private IdGenerator idGenerator;
    @Autowired
    private JedisUtil jedisUtil;
    @Override
    public R save(User user) {
        return ExecuteUtil.getR(mapper.insert(user),"新增数据");
    }

    @Override
    public List<User> queryPageAll() {
        return mapper.queryPage(0,100);
    }

    @Override
    public User queryByName(String name) {
        return mapper.queryBy(name);
    }

    @Override
    public R ssoCheck(String token, HttpServletResponse response) {

        String json = jedisUtil.getStr("usertoken" + token);
        //判断是否存在 value
        if(!StringUtils.isEmpty(json)) {
            //成功
            jedisUtil.expire("usertoken"+token,TimeUnit.MINUTES,30);
            return new R(0,"登录成功",(User)JSON.parseObject(json,User.class));
        } else {
            //表名已经失效
            //不存在，就删除Cooken ，重新登录
            CookieUtil.delCK("userauth", response);
            return R.setError("令牌失效，需要重新登录");
        }
       /* if(jedisUtil.isKey("usertoken"+token)){
            //存在就刷新时间
            jedisUtil.expire("usertoken:"+token,TimeUnit.MINUTES,30);
            return new R(0,"存在",JSON.parseObject(jedisUtil.getStr("usertoken"+token),User.class));
        }else{
            //不存在，就删除Cooken ，重新登录
            CookieUtil.delCK("userauth",response);
            return R.setError("不存在");

        }*/
    }

    @Override
    public R ssoLogin(String name, String password,
                      HttpServletResponse response,HttpSession session) {
        System.out.println(name + "--------------->" + password);
        User user = mapper.queryBy(name);
        if(user != null) {
            //存在user
            if(Objects.equals(password,user.getPassword())) {
                //登录成功---
                //token 生成 唯一
               String  token = idGenerator.nextId() + "";
                //将token以及user存到redis
                jedisUtil.addStr("usertoken"+token,JSON.toJSONString(user));
                //设置redis 存储 key 的 有效期
                jedisUtil.expire("usertoken"+token,TimeUnit.MINUTES,30);

                //设置Cookie 将tk 设置进去 -1 代表存在内存中
                CookieUtil.setCK("userauth",token,-1,response);
                //把user 记录session
                session.setAttribute("user",user);
                //成功
                return new R(0,"登录成功",user);
            } else {
                //密码错误
                return R.setError("密码错误");
            }
        } else {
            //用户名不存在
            return R.setError("用户名不存在");
        }
    }

    @Override
    public R ssoLogin(String token, String name, String password,
                      HttpServletResponse response, HttpSession session) {
        if(token.length() == 0) {
            //第一次登录
            User user = mapper.queryBy(name);
            if(user != null) {
                //存在user
                if(Objects.equals(password,user.getPassword())) {
                    //登录成功---
                    //token 生成 唯一
                    token = idGenerator.nextId() + "";
                    //将token以及user存到redis
                    jedisUtil.addStr("token"+token,JSON.toJSONString(user));
                    //设置redis 存储 key 的 有效期
                    jedisUtil.expire("usertoken"+token,TimeUnit.MINUTES,30);

                    //设置Cookie 将tk 设置进去 -1 代表存在内存中
                    CookieUtil.setCK("userauth",token,-1,response);
                    //把user 记录session
                    session.setAttribute("user",user);
                    //成功
                    return new R(0,"登录成功",user);
                } else {
                    //密码错误
                    return R.setError("密码错误");
                }
            } else {
                //用户名不存在
                return R.setError("用户名不存在");
            }

        } else {
            //存在token 进行判断
            //得到对应key的值 以及和value
            String json = jedisUtil.getStr("usertoken" + token);
            //判断是否存在 value
            if(!StringUtils.isEmpty(json)) {
                //成功
                return new R(0,"登录成功",JSON.parseObject(json,User.class));
            } else {
                //表名已经失效
                return R.setError("令牌失效，需要重新登录");
            }
        }

    }

    @Override
    public R userOut(String token, HttpServletResponse response) {
        //移除Redis
        jedisUtil.delKey("usertoken:"+token);
        //移除Cookie
        CookieUtil.setCK("userauth","",0,response);

       // CookieUtil.delCK("userauth",response);
        return R.setOk("注销成功");
    }

}

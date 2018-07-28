package com.qfedu.mapper.user;

import com.qfedu.domain.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author Bingove
 * @Date 2018/7/24 0024 下午 17:44
 */
public interface UserMapper {
    //是否存在
    @Select("select id,username,password,phone,uid from t_user where username=#{username}")
    User queryByN(String username);
    //新增
    @Insert("insert into t_user(username,password,phone,uid) values(#{username},#{password},#{phone},#{uid})")
    int insert(User user);
    //查询
    @Select("select id,username,password,phone,uid from t_user limit #{index},#{count}")
    @ResultType(User.class)
    List<User> queryAll(@Param("index")int index, @Param("count")int count);
    //查询用户总数量
    @Select("select count(1) from t_user")
    long queryCount();
    //登录查询
    @Select("select id,username,password,phone,uid from t_user where username=#{name} or phone=#{name}")
    User queryByName(String name);
}

package com.qfedu.mapper.user;

import com.qfedu.domain.user.UserDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDetailMapper {

    @Insert("insert into t_userdetail (uid, realname, \n" +
            "      sex, idNumber, birthDate, \n" +
            "      createtime, flag, address, \n" +
            "      idimage1, idimage2)\n" +
            "    values (#{uid,jdbcType=INTEGER}, #{realname,jdbcType=VARCHAR}, \n" +
            "      #{sex,jdbcType=VARCHAR}, #{idnumber,jdbcType=VARCHAR}, #{birthdate,jdbcType=DATE}, \n" +
            "      #{createtime,jdbcType=TIMESTAMP}, #{flag,jdbcType=INTEGER}, #{address,jdbcType=LONGVARCHAR}, \n" +
            "      #{idimage1,jdbcType=LONGVARCHAR}, #{idimage2,jdbcType=LONGVARCHAR})")
    int insert(UserDetail userDetail);
    @Delete("delete from t_usedetail where uid=#{uid}")
    int deleteByPrimaryKey(Integer uid);

    @Update("update t_userdetail\n" +
            "    set realname = #{realname,jdbcType=VARCHAR},\n" +
            "      sex = #{sex,jdbcType=VARCHAR},\n" +
            "      idNumber = #{idnumber,jdbcType=VARCHAR},\n" +
            "      birthDate = #{birthdate,jdbcType=DATE},\n" +
            "      createtime = #{createtime,jdbcType=TIMESTAMP},\n" +
            "      flag = #{flag,jdbcType=INTEGER}\n" +
            "    where uid = #{uid,jdbcType=INTEGER}}")
    int updateByPrimaryKey(UserDetail userDetail);

    @Select("select * from t_userdetail where username=#{name}")
    @ResultType(UserDetail.class)
    UserDetail selectByN(String name);

    //查找全部
    @Select("select * from t_userdetail")
    @ResultType(UserDetail.class)
    List<UserDetail> selectAll();
}
package com.qfedu.mapper.admin;

import com.qfedu.domain.admin.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *@Author Bingove
 *@Date Created in 2018/7/29 23:41
 */
public interface SysUserMapper {

    // 根据userId 删除用户
    int deleteByPrimaryKey(Long userId);
    // 新增
    int insert(SysUser record);
    //动态新增
    int insertSelective(SysUser record);
    // 根据UserId查找
    SysUser selectByPrimaryKey(Long userId);
    // 动态更新
    int updateByPrimaryKeySelective(SysUser record);
    //全部更新
    int updateByPrimaryKey(SysUser record);

    /**
     * 根据用户名，查询系统用户
     */
    SysUser queryByUserName(String username);

    //查询所有的用户
    @Select("select * from sys_user where status=0 order by user_id desc limit #{index},#{count}")
    @ResultType(SysUser.class)
    List<SysUser> selectByPage(@Param("index")int index, @Param("count")int count);
    //数量
    @Select("select COUNT(*) from sys_user where status=0")
    @ResultType(Long.class)
    Long selectCount();
    //批量删除
    int deleteBatch(Long[] uids);
    //查询密码
    @Select("select password from sys_user where user_id=#{uid}")
    @ResultType(String.class)
    String selectPassword(long uid);
}

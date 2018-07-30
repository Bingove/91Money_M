package com.qfedu.mapper.admin;

import com.qfedu.domain.admin.SysRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *@Author Bingove
 *@Date Created in 2018/7/29 23:40
 */
public interface SysRoleMapper {

    int deleteByPrimaryKey(Long roleId);
    int insert(SysRole record);
    SysRole selectByPrimaryKey(Long roleId);

    @Select("select * from sys_role order by role_id desc limit #{index},#{count}")
    @ResultType(SysRole.class)
    List<SysRole> queryByPage(@Param("index") int index, @Param("count") int count);

    @Select("select COUNT(*) from sys_role")
    @ResultType(Long.class)
    Long queryCount();

    @Select("select * from sys_role")
    @ResultType(SysRole.class)
    List<SysRole> queryAll();

    //根据userId 查找对应的角色
    @Select("select role_name from sys_role r left join sys_user_role ur on ur.role_id=r.id where ur.user_id=#{userId}")
    @ResultType(String.class)
    List<String> selectRoleNameList(Long userId);

    //批量删除
    int deleteBatch(Long[] roleIds);
}

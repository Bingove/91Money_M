package com.qfedu.mapper.user;

import com.qfedu.domain.user.LoginLog;

public interface LoginLogMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(LoginLog record);

    int insertSelective(LoginLog record);


    LoginLog selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(LoginLog record);

    int updateByPrimaryKeyWithBLOBs(LoginLog record);

    int updateByPrimaryKey(LoginLog record);
}
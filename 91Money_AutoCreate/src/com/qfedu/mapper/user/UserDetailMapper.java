package com.qfedu.mapper.user;

import com.qfedu.domain.user.UserDetail;
import com.qfedu.domain.user.UserDetailExample;
import com.qfedu.domain.user.UserDetailWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDetailMapper {
    long countByExample(UserDetailExample example);

    int deleteByExample(UserDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserDetailWithBLOBs record);

    int insertSelective(UserDetailWithBLOBs record);

    List<UserDetailWithBLOBs> selectByExampleWithBLOBs(UserDetailExample example);

    List<UserDetail> selectByExample(UserDetailExample example);

    UserDetailWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserDetailWithBLOBs record, @Param("example") UserDetailExample example);

    int updateByExampleWithBLOBs(@Param("record") UserDetailWithBLOBs record, @Param("example") UserDetailExample example);

    int updateByExample(@Param("record") UserDetail record, @Param("example") UserDetailExample example);

    int updateByPrimaryKeySelective(UserDetailWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UserDetailWithBLOBs record);

    int updateByPrimaryKey(UserDetail record);
}
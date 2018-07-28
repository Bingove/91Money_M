package com.qfedu.mapper.user;

import com.qfedu.domain.user.OpLog;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpLogMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(OpLog record);

    int insertSelective(OpLog record);


    OpLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OpLog record);

    int updateByPrimaryKeyWithBLOBs(OpLog record);

    int updateByPrimaryKey(OpLog record);
}
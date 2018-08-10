package com.qfedu.mapper.loan;

import com.qfedu.core.vo.LoanVo;
import com.qfedu.domain.loan.Loan;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LoanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Loan record);

    Loan selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Loan record);

    @Select("select * from t_loan")
    @ResultType(Loan.class)
    List<Loan> queryAll();
    @Select("select * from t_loan")
    @ResultType(LoanVo.class)
    LoanVo selectById(int id);

}
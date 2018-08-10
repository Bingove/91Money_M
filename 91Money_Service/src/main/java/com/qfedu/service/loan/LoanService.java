package com.qfedu.service.loan;

import com.qfedu.core.vo.LoanVo;
import com.qfedu.core.vo.R;
import com.qfedu.domain.loan.Loan;

import java.util.List;

/**
 * @Author Bingove
 * @Date 2018/8/4 0004 上午 11:03
 */
public interface LoanService {
    //添加借款
    R save(Loan loan);
    //查询全部
    List<Loan> queryAll();

    LoanVo queryById(int id);
}

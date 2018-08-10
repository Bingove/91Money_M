package com.qfedu.service.loan;

import com.qfedu.core.vo.R;
import com.qfedu.domain.loan.LoanLog;

/**
 * @Author Bingove
 * @Date 2018/8/4 0004 上午 11:04
 */
public interface LoanLogService {
    //添加借款日志
    R save(LoanLog loanLog);
}

package com.qfedu.provider.loan;

import com.qfedu.core.utils.ExecuteUtil;
import com.qfedu.core.vo.R;
import com.qfedu.domain.loan.LoanLog;
import com.qfedu.mapper.loan.LoanLogMapper;
import com.qfedu.service.loan.LoanLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Bingove
 * @Date 2018/8/4 0004 上午 11:09
 */
@Service
public class LoanLogServiceImpl implements LoanLogService {
    @Autowired
    private LoanLogMapper mapper;
    @Override
    public R save(LoanLog loanLog) {
        return ExecuteUtil.getR(mapper.insert(loanLog),"新增借款日志");
    }
}

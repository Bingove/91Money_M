package com.qfedu.provider.loan;

import com.qfedu.core.utils.ExecuteUtil;
import com.qfedu.core.vo.LoanVo;
import com.qfedu.core.vo.R;
import com.qfedu.domain.loan.Loan;
import com.qfedu.mapper.loan.LoanLogMapper;
import com.qfedu.mapper.loan.LoanMapper;
import com.qfedu.service.loan.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Bingove
 * @Date 2018/8/4 0004 上午 11:05
 */
@Service
public class LoanServiceImpl implements LoanService {
   @Autowired
   private LoanMapper mapper;

    @Override
    public R save(Loan loan) {
        //loan.setMoney(loan.getMoney()*100);
        //数据库存储的金钱为分  页面显示的为元
        loan.setMoney(loan.getMoney()*100);
        loan.setMinmoney(loan.getMinmoney()*100);
        loan.setRate(loan.getRate()/100);
        return ExecuteUtil.getR(mapper.insert(loan),"添加借款");

    }

    @Override
    public List<Loan> queryAll() {
        return mapper.queryAll();
    }

    @Override
    public LoanVo queryById(int id) {
        return mapper.selectById(id);
    }
}

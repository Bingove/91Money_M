package com.qfedu.sso.provider;

import com.qfedu.core.vo.R;
import com.qfedu.domain.user.UserDetail;
import com.qfedu.mapper.user.UserDetailMapper;
import com.qfedu.sso.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Bingove
 * @Date 2018/7/27 0027 下午 16:43
 */
@Service
public class UserDetailProvider implements UserDetailService {
    @Autowired
    private UserDetailMapper mapper;
    @Override
    public R save(UserDetail userDetail) {
        if(mapper.insert(userDetail) > 0) {
            return R.setOk("新增成功");
        } else {
            return R.setError("新增失败");
        }

    }

    @Override
    public R deleteByUid(int uid) {
        return null;
    }

    @Override
    public R updateByUid(int uid) {
        return null;
    }

    @Override
    public UserDetail queryByN(String name) {
        return mapper.selectByN(name);
    }

    @Override
    public List<UserDetail> quertyAll() {
        return mapper.selectAll();
    }
}

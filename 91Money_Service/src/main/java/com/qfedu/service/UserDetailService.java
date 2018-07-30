package com.qfedu.service;

import com.qfedu.core.vo.R;
import com.qfedu.domain.user.UserDetail;

import java.util.List;

/**
 * @Author Bingove
 * @Date 2018/7/27 0027 下午 16:32
 */
public interface UserDetailService {
    R save(UserDetail userDetail);
    R deleteByUid(int uid);
    R updateByUid(int uid);
    UserDetail queryByN(String name);
    List<UserDetail> quertyAll();
}

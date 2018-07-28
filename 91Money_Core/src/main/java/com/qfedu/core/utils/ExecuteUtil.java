package com.qfedu.core.utils;

import com.qfedu.core.vo.R;

/**
 * @Author Bingove
 * @Date 2018/7/24 0024 下午 18:03
 */
public class ExecuteUtil {
    public static R getR(int num, String msg) {
        if(num > 0) {
            return R.setOk(msg + "成功");
        } else {
            return R.setError(msg + "失败");
        }
    }
}

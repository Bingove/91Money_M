package com.qfedu.uicontroller.pay;

import com.qfedu.core.pay.PayCommonUtil;
import com.qfedu.core.pay.ZxingUtil;
import com.qfedu.core.redis.JedisUtil;
import com.qfedu.core.vo.R;
import com.qfedu.domain.user.User;
import com.qfedu.uicontroller.login.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author Bingove
 * @Date 2018/8/10 0010 下午 15:18
 */
@RestController
public class WinXinPayController {
    @Autowired
    private JedisUtil jedisUtil;

    // oid price body 详细信息
    @RequestMapping("wxpaypre.do")
    public R pre(HttpServletRequest request, String oid, String price, String body) throws Exception {
        User user = Login.getU(jedisUtil, request);

        String url = PayCommonUtil.weixin_pay(price, body, oid);
        jedisUtil.addStr(user.getId() + "", url, TimeUnit.HOURS, 2);
        return R.setOk("支付信息成功");
    }

    @RequestMapping("wxpayimage.do")
    public void payImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = Login.getU(jedisUtil, request);
        String url = jedisUtil.getStr(user.getId() + "");
        BufferedImage image;
        if (url != null && url.length() > 0) {
            image = ZxingUtil.createImage(url, 200, 200);

        } else {
            image = ZxingUtil.createImage("支付失败，请重新发起", 200, 200);

        }
        // String url = "";
        ImageIO.write(image, "JPEG", response.getOutputStream());
    }
}

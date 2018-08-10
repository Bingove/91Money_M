package com.qfedu.uicontroller.oss;

import com.qfedu.core.utils.FileUtils;
import com.qfedu.core.utils.OSSUtil;
import com.qfedu.core.vo.R;
import com.qfedu.domain.oss.OSSPo;
import com.qfedu.service.user.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *@Author Bingove
 *@Date Created in 2018-8-2
 */
@RestController
public class OssController {
    @Autowired
    private OSSUtil ossUtil;
    @Autowired
    private UserDetailService service;
    //文件上传
    @PostMapping("/fileup.do")
    public R fileup(@RequestParam("bingove") CommonsMultipartFile file){
        System.out.println(file.getOriginalFilename());
        String fn=FileUtils.createFileName(file.getOriginalFilename());
        System.out.println(fn);
        String url=ossUtil.fileUp(fn,file.getBytes());
        OSSPo po=new OSSPo();
        po.setObjname(fn);
        po.setOurl(url);
        po.setPeriod(-1L);
        service.save(po);
        return new R(0,url,null);
    }


}

package com.qfedu.uicontroller.oss;

import com.qfedu.core.utils.FileUtils;
import com.qfedu.core.utils.OSSUtil;
import com.qfedu.core.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * @Author Bingove
 * @Date 2018/7/28 0028 下午 14:46
 */
@RestController
public class OssController {
    @Autowired
    private OSSUtil ossUtil;
    //文件上传
    @PostMapping("/fileup.do")
    public R ileup(CommonsMultipartFile file){
        String fn=FileUtils.createFileName(file.getOriginalFilename());
        String url=ossUtil.fileUp(fn,file.getBytes());
        return new R(0,fn+"@"+url,null);
    }

}

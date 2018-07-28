package com.qfedu.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;

import java.io.*;

/**
 * @Author Bingove
 * @Date 2018/7/27 0027 下午 21:47
 */
public class OSS_Main {
    private static String endpoint = "oss-cn-beijing.aliyuncs.com";
    private static String accessKeyId = "LTAIfPDYzpbNLxA9";
    private static String accessKeySecret = "QZVDJCYT3mVgQjGQXJfMd304ZZ5XX5";

    private static String bucketName = "bingove";
    public static void main(String[] args) throws IOException {
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传字符串。
/*
        String content = "Hello OSS";
        ossClient.putObject(bucketName, "<yourObjectName>", new ByteArrayInputStream(content.getBytes()));
*/

        // 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
/*        ossClient.putObject(bucketName,
                "image1", new File("91Money_Study/katong.jpg"));*/
        System.out.println(new File("91Money_Study/katong.jpg").getAbsolutePath());
        File file=new File("91Money_Study/katong.jpg");
        FileInputStream fis=new FileInputStream(file);
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        byte[] data=new byte[1024];
        int len=0;
        while ((len=fis.read(data))!=-1){
            baos.write(data,0,len);
        }

       PutObjectResult result=ossClient.putObject(bucketName, file.getName(), new ByteArrayInputStream(baos.toByteArray()));
        ossClient.shutdown();
    }
}

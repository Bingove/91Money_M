package com.qfedu.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author Bingove
 * @Date 2018/7/31 0031 上午 11:37
 */
public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("study study study " + System.currentTimeMillis()/1000);
        //System.currentTimeMillis() 以秒为单位
    }
}

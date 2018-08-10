package com.qfedu.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Author Bingove
 * @Date 2018/7/31 0031 上午 10:20
 */
public class Quartz_Main1 {
    public static void main(String[] args) throws Exception {
        //1、创建调度器
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        //2、创建触发条件  什么时候 时间 repeatSecondlyForever(3) 表示间隔3秒--
        Trigger trigger =
                TriggerBuilder.newTrigger().
                        withIdentity("mytrigger","triggergroup1").
                        startNow().
                        withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(3).withRepeatCount(5)).
                        build();
        //3、创建作业   干什么
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("job","myjobgroup1").build();
        //4、设置调度器的触发条件以及作业
        scheduler.scheduleJob(jobDetail,trigger);
        //5、启动作业
        scheduler.start();//启动
//        scheduler.pauseJob();//暂停
//        scheduler.resumeJob();//继续
//        scheduler.shutdown();//关闭

    }
}

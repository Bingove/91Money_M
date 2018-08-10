package com.qfedu.quartz;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Author Bingove
 * @Date 2018/7/31 0031 上午 11:48
 */
public class Quartz_Schedule {
    public static void main(String[] args) throws Exception {
        //calendar();
        corn();
    }
//间隔时间
    public static void time() throws Exception{
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

    //时  分  秒
    public static void calendar() throws Exception {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("calendar1","calendergroup").
                startNow().withSchedule(CalendarIntervalScheduleBuilder.calendarIntervalSchedule().withIntervalInSeconds(2)).build();
        //3、创建作业   干什么
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("job","myjobgroup1").build();
        //4、设置调度器的触发条件以及作业
        scheduler.scheduleJob(jobDetail,trigger);
        //5、启动作业
        scheduler.start();//启动
    }

    /*cron  秒  分   时  日   月   周  年
    *      0/3  *   *   *   *    ？   ？   3秒执行一次
    *      45/3 5  12   *   *    ?    每一天的 12点 5分 45 秒 开始  ， 每隔3秒执行一次
    *      0    15  6    *   *   ？
    *
    *
    *
    * */

    public static void corn() throws Exception{
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("calendar1","calendergroup").
                startNow().withSchedule(CronScheduleBuilder.cronSchedule("45/3 5 12 * * ?")).build();
        //3、创建作业   干什么
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("job","myjobgroup1").build();
        //4、设置调度器的触发条件以及作业
        scheduler.scheduleJob(jobDetail,trigger);
        //5、启动作业
        scheduler.start();//启动
    }
}

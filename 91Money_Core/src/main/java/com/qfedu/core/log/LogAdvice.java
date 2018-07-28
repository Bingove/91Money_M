package com.qfedu.core.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Bingove
 * @Date 2018/7/27 0027 下午 21:28
 */
public class LogAdvice {
    Logger logger=LoggerFactory.getLogger(LogAdvice.class);

    public Object writeLog(ProceedingJoinPoint joinPoint) {
        Object obj= null;
        try {
            obj = joinPoint.proceed();
            logger.info(joinPoint.getSignature().getName()+" 执行成功");
        } catch (Throwable throwable) {
            logger.error(joinPoint.getSignature().getName()+" 执行失败："+throwable.getMessage());
            throwable.printStackTrace();
        }
        return obj;
    }
}

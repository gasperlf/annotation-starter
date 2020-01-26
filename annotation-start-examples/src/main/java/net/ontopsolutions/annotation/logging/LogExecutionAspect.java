package net.ontopsolutions.annotation.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
@Slf4j
public class LogExecutionAspect {

    public LogExecutionAspect() {
        log.info("Creating timing logging aspect");
    }

    @Around("execution(@net.ontopsolutions.annotation.logging.LogExecutionTime * *(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();
        log.info("{} executed in {} ms", joinPoint.getSignature().getName(), stopWatch.getTotalTimeMillis());
        return result;
    }
}

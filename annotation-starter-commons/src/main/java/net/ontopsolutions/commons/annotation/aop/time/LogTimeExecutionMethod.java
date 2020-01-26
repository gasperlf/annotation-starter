package net.ontopsolutions.commons.annotation.aop.time;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LogTimeExecutionMethod {

    private static final Logger log = LoggerFactory.getLogger(LogTimeExecutionMethod.class);

    @Around("@annotation(LogTimeExecution)")
    public Object logTimeExecution(ProceedingJoinPoint joinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();
        log.info("Execution of {} time elapse {} ms",
                String.format("%s.%s", joinPoint.getSignature().getDeclaringType(), joinPoint.getSignature().getName()),
                stopWatch.getTotalTimeMillis());
        return result;
    }
}

package com.cg.springbootmvcemployeelab.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Gagandeep
 * @date 14-04-2020
 * @time 16:00
 */

@Component
@Aspect
public class Logger {

    @Pointcut("execution(* com.cg.springbootmvcemployeelab.*.*.*(..)))")
    public void everyWhere() {
    }

    @Before("everyWhere()")
    public void logBefore(JoinPoint point) {
        System.out.println("@Before method: " + point.getSignature().toShortString());
        System.out.println("Arguments: ");
        Object[] objects = point.getArgs();
        for (Object object : objects) {
            System.out.println("->" + object);
        }
    }

    @AfterReturning(pointcut = "everyWhere()", returning = "result")
    public void logAfter(JoinPoint point, Object result) {
        System.out.println("@AfterReturning method: " + point.getSignature().toShortString());
        System.out.println("Returning Value: " + result);
    }
}

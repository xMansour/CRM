package com.mansour.crm.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.mansour.crm.controllers.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution(* com.mansour.crm.services.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("execution(* com.mansour.crm.dao.*.*(..))")
    private void forDAOPackage() {
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow() {
    }

    @Before("forAppFlow()")
    public void beforeAppFlowAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("========> in @Before: calling method: " + method);
        Object[] args = joinPoint.getArgs();
        for (Object obj : args) {
            logger.info("========> argument: " + obj);
        }
    }


    public void afterAppFlowAdvice() {

    }


}

package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Proc;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.data.relational.core.sql.Join;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect {
    @Before("execution(* *..*.*UserService.*(..))")
    public void startLog(JoinPoint jp) {
        log.info("Start method " + jp.getSignature());
    }

    @After("execution(* *..*.*UserService.*(..))")
    public void endLog(JoinPoint jp) {
        log.info("End method " + jp.getSignature());
    }

    //    @Around("bean(*Controller)")
    //    @Around("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    @Around("@within(org.springframework.web.bind.annotation.RestController)")
    public Object startLog(ProceedingJoinPoint jp) throws Throwable {
        log.info("Method start: " + jp.getSignature());
        try {
            Object result = jp.proceed();
            log.info("Method end: " + jp.getSignature());
            return result;
        } catch (Exception e) {
            log.error("Method abend: " + jp.getSignature());
            throw e;
        }
    }

}

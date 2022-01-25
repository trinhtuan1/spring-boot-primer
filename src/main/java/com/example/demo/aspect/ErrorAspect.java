package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ErrorAspect {
    @AfterThrowing(value = "execution(* *..*.*(..)) && " +
            "(bean(*Service) || bean(*Controller) || bean(*Respository))", throwing = "ex")
    private void throwingNull(DataAccessException ex) {
        log.error("Data Access Exception has occurred");
    }
}

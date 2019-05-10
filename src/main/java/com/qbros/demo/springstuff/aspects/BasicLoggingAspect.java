package com.qbros.demo.springstuff.aspects;

import com.qbros.demo.springstuff.Utils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
@Component
@Aspect
public class BasicLoggingAspect {

    @Pointcut("execution(protected * com.qbros.demo.controller.http.MyExceptionHandler.*(..))")
    public void exceptionHandlerMethod() {
    }

    @Before("exceptionHandlerMethod()")
    public void logException(JoinPoint joinPoint) {
        System.out.println("*********exception" + joinPoint.getArgs()[0] + "happened at: " + Utils.getServerTime());
    }

    @AfterThrowing("exceptionHandlerMethod()")
    public void logWTF() {
        System.out.println("Exception in exception handling! WTF :(((");
    }


    //----------------------------

}




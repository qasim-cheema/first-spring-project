package com.example.demo.servises;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

@Configuration
@Aspect
public class AspectConfig {
    static Logger logger= LogManager.getLogger(AspectConfig.class);
    @Autowired(required = false)
    private HttpServletRequest request;
   /* @After(value = "execution(* com.example.demo.controlers.TeacherController.*(..)) )")
    public void beforeAdvice(JoinPoint joinPoint) {

      logger.info("Info ---------"+joinPoint);
    }*/
    @After(value = "execution(* com.example.demo.controlers.*.*(..)) )")
    public void beforeAdvicePackege(JoinPoint joinPoint) {
        logger.info("Method Signature__"+joinPoint.getSignature());
        logger.info("URL of source__"+request.getRequestURI());
    }
}

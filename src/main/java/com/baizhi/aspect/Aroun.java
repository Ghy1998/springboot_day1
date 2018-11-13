package com.baizhi.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect //表面该类为切面类
@Configuration //将该通知交给工厂管理
public class Aroun {

    //切入点
    @Pointcut("@annotation(Log)")
    public void pointCut() {

    }

    //新的配置形式,直接在方法参数中声明对应的对象进行注入
    @Around(value = "pointCut()")
    public Object AroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }

    //通知
    //有spring的工厂根据类型做自动的注入
    /*@After(value ="pointCut()")
    public void beforeAdvice(JoinPoint joinPoint){
        //参数列表
        Object[] args = joinPoint.getArgs();
        //目标方法所在的对象
        Object target = joinPoint.getTarget();
        //代理对象  cglib
        Object aThis = joinPoint.getThis();
        //方法对象
        Signature signature = joinPoint.getSignature();
        System.out.println("this is before advice invoke");
    }*/
}

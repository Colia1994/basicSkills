package org.kly.basicSkills.aop.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author konglingyao
 * @Date 2018/9/17
 */
@Order(1)
@Aspect
@Component
public class DealInterceptor {

    @Pointcut("execution(* org.kly.basicSkills.AopService.*(..))")
    public void pointcut1() {

    }

    /**
     * 前置通知：在方法执行前执行的代码
     *
     * @param joinPoint 切入点
     */
    @Before(value = "pointcut1()")
    public void beforeExecute(JoinPoint joinPoint) {

        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + "切面，准备执行");
    }

    /**
     * 后置通知：在方法执行后执行的代码(无论该方法是否发生异常),注意后置通知拿不到执行的结果
     *
     * @param joinPoint 切入点
     */
    @After(value = "pointcut1()")
    public void afterExecute(JoinPoint joinPoint) {

        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + "切面，结束执行");
    }

    /**
     * 后置返回通知：在方法正常执行后执行的代码,可以获取到方法的返回值
     *
     * @param joinPoint 切入点
     */
    @AfterReturning(value = "pointcut1()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + "切面，正常结束执行，方法返回值：" + result);
    }

    /**
     * 后置异常通知：在方法抛出异常之后执行,可以访问到异常信息,且可以指定出现特定异常信息时执行代码
     *
     * @param joinPoint 切入点
     */
    @AfterThrowing(value = "pointcut1()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {

        System.out.println(this.getClass().getSimpleName() + " afterThrowing execute, exception:" + exception);
    }

    /**
     * 环绕通知, 围绕着方法执行
     */
    @Around(value = "pointcut1()")
    public Object around(ProceedingJoinPoint joinPoint) {

        String methodName = joinPoint.getSignature().getName();
        System.out.println(this.getClass().getSimpleName() + " around execute  " + methodName + "start");

        Object result = null;
        try {
            //执行目标方法
            result = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return result;
    }

}

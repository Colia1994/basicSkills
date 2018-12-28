package org.kly.basicSkills.aop.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.kly.basicSkills.aop.annotation.Validate;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author konglingyao
 * @Date 2018/12/17
 */
@Order(2)
@Aspect
@Component
public class AopValidate {

    @Around(value = "@annotation(validate)")
    public Object validate(ProceedingJoinPoint joinPoint, Validate validate) throws Throwable {
        Signature signature = joinPoint.getSignature();

        System.out.println(validate.value()+"--------" + signature.getName());
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
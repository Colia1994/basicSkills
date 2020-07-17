package org.kly.javaCode.others.tableCommit.validation;

import org.springframework.validation.Errors;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 自定义校验- 校验处理器接口
 *
 * @author kongly
 * @date 2017-07-03 10:00:00
 */
public interface CustomerValidatorRule {

    /**
     * 判断是否支持该注解
     *
     * @param annotation
     * @return
     */
    boolean support(Annotation annotation);

    /**
     * 校验处理
     *
     * @param annotation
     * @param field
     * @param errors
     */
    void valid(Annotation annotation, Object object, Field field, Errors errors) throws Exception;

}

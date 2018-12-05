package org.kly.basicSkills.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 自动扫描实现
 * @author kongly
 * @date 2017-07-03 10:00:00
 */
@Component
public class CustomerValidatorFactory implements Validator {
    @Autowired
    private CustomerValidatorConfig customerValidatorConfig;


    public boolean supports(Class<?> clazz) {
        return true;
    }


    public void validate(Object target, Errors errors) {
        Assert.notNull(target);
        Assert.notNull(errors);
        List<Field> fileds = getFields(target.getClass());
        for (Field field : fileds) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().getAnnotation(CustomerValidator.class) != null) {
                    try {
                        CustomerValidatorRule customerValidatorRule = customerValidatorConfig.findRule(annotation);
                        if (customerValidatorRule != null) {
                            customerValidatorRule.valid(annotation, target, field, errors);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    /**
     * 获取class的fields。
     *
     * @param clazz bean所在的class
     */
    private List<Field> getFields(Class<?> clazz) {
        // 声明Field数组
        List<Field> fields = new ArrayList<Field>();
        // 如果class类型不为空
        while (clazz != null) {
            // 添加属性到属性数组
            Collections.addAll(fields, clazz.getDeclaredFields());
            clazz = clazz.getSuperclass();
        }
        return fields;
    }
}

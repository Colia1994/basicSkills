package org.kly.basicSkills.Validation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 自定义校验-testvo
 * @author kongly
 * @date 2017-07-03 10:00:00
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface CustomerRule {


}

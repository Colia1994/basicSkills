package org.kly.javaCode.others.tableCommit.validation;

import java.lang.annotation.*;

/**
 * 自定义校验-testvo
 * Documented用于描述其它类型的annotation应该被作为被标注的程序成员的公共API
 * Retention定义了该Annotation被保留的时间长短
 * Target说明了Annotation所修饰的对象范围
 * Inherited 元注解是一个标记注解,注解作用于类可以被继承
 *
 * @author kongly
 * @date 2017-07-03 10:00:00
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@CustomerValidator
public @interface DateString {
    String pattern() default "yyyy-MM-dd HH:mm:ss";

    String errorCode() default "must date";

    String message() default "must be date pattern";
}

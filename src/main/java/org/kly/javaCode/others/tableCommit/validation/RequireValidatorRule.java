package org.kly.javaCode.others.tableCommit.validation;

import java.lang.annotation.Annotation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义校验-testvo
 *
 * @author kongly
 * @date 2017-07-03 10:00:00
 */
@CustomerRule
public class RequireValidatorRule extends AbstractCustomerValidatorRule {

    @Override
    public boolean support(Annotation annotation) {
        return annotation instanceof DateString;
    }

    @Override
    public void validProperty(Annotation annotation, Object property, PostHandler postHandler) {
        DateString ds = (DateString) annotation;
        if (parse(ds.pattern(), (String) property) == null) {
            postHandler.postHanle(ds.errorCode(), ds.message());
        }
    }

    private Date parse(String pattern, String property) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(property);
        } catch (ParseException e) {
            //do noting
        }
        return null;
    }
}

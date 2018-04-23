package org.kly.basicSkills.validation;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 自动扫描实现
 * @author kongly
 * @date 2017-07-03 10:00:00
 */
public class CustomerValidatorConfig implements ApplicationContextAware {

    private Map<Annotation, CustomerValidatorRule> rules	= new ConcurrentHashMap<Annotation, CustomerValidatorRule>();
    private Map<String, Object>	customerValidationRules = null;
    /**
     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        customerValidationRules = applicationContext
                .getBeansWithAnnotation(CustomerRule.class);
        System.out.println(customerValidationRules);
    }
    private CustomerValidatorRule findFormMap(Annotation annotation) {
        for (Map.Entry<String, Object> entry : customerValidationRules.entrySet()) {
            if (entry.getValue() != null
                    && ((CustomerValidatorRule) entry.getValue()).support(annotation)) {
                return (CustomerValidatorRule) entry.getValue();
            }
        }
        return null;
    }
    CustomerValidatorRule findRule(Annotation annotation) {
        CustomerValidatorRule customerValidatorRule = null;
        if (!rules.containsKey(annotation)) {
            CustomerValidatorRule cvr = findFormMap(annotation);
            if (cvr != null) {
                rules.put(annotation, cvr);
            }
            customerValidatorRule = cvr;
        }
        customerValidatorRule = rules.get(annotation);
        return customerValidatorRule;
    }
}

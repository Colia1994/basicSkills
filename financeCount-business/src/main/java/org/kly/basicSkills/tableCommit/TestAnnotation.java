package org.kly.basicSkills.tableCommit;


import org.kly.basicSkills.tableCommit.Validation.CustomerValidatorFactory;
import org.springframework.validation.BindException;

/**
 * 自定义校验-testvo
 * @author kongly
 * @date 2017-07-03 10:00:00
 */
public class TestAnnotation {

//    @Autowired
//    private CustomerValidatorFactory customerValidatorFactory;

    private void helloTest() {
        WaybillVo waybillVo = new WaybillVo();
        waybillVo.setWaybillNo("11");
        waybillVo.setWaybillId("112");
        BindException errors = new BindException(waybillVo, "target");
        System.out.println(errors.getFieldErrors());
        CustomerValidatorFactory customerValidatorFactory = new CustomerValidatorFactory();
        customerValidatorFactory.validate(waybillVo, errors);
        System.out.println(errors.getFieldErrors());
    }


    public static void main(String[] args) {
        TestAnnotation testAnnotation = new TestAnnotation();
        testAnnotation.helloTest();
    }

}

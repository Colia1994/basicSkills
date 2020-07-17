package org.kly.javaCode.springCode.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author konglingyao
 * @Date 2018/9/6
 */
@Service
public class TestAop {


    @Autowired
    private AopService aopService;

    public AopService getAopService() {
        return aopService;
    }

    public void setAopService(AopService aopService) {
        this.aopService = aopService;
    }

    public void printString() {
        System.out.println("*****controller进入，准备执行");
        aopService.complateAop();
        System.out.println("*****controller结束，结束执行");
    }
}

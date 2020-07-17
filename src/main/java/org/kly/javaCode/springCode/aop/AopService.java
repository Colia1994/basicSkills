package org.kly.javaCode.springCode.aop;

import org.springframework.stereotype.Service;

/**
 * @Author konglingyao
 * @Date 2018/9/6
 */
@Service("aopService")
public interface AopService {

    boolean complateAop();

    void del(String string);

}

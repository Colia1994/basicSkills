package org.kly.javaCode.test;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.*;

/**
 * @Author konglingyao
 * @Date 2021/2/7
 */
@Configuration
@EnableAsync
public class AsyncConfiguration {


    @Bean("defaultExecutor")
    public Executor doSomethingExecutor() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("executor-process-%d").build();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2,
                60L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(10000), threadFactory);
        // 缓冲队列满了之后的拒绝策略：由调用线程处理（一般是主线程）
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        return executor;
    }

}

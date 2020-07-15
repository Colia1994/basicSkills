package org.kly.javaCode.concurrent.BrockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 阻塞队列
 *
 * @author colia
 * @date 2018/12/25 23:18
 */
public class MyBlockingQueue {


    /**
     * 对队列的四种操作 异常 空 阻塞直到返回 阻塞直到时间到达最大
     * Insert	add(e)	offer(e)	put(e)	offer(e, time, unit)
     * Remove	remove()	poll()	take()	poll(time, unit)
     * Examine	element()	peek()	not applicable	not applicable
     */
    private final ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

    private void doSome() {
        blockingQueue.offer(1);
        int i = blockingQueue.peek();
    }



}
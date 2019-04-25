package com.zhongjinlang.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: zhongjinlang
 * @date: Created in 2019/4/25 2:32
 * @description:
 */
@Slf4j
public class CyclicBarrierExample1 {

    private static CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++){
            final int threadNum = i;
            Thread.sleep(1000);
            exec.execute(() -> {
                try {
                    rece(threadNum);
                }catch (Exception e){
                    log.error("exception", e);
                }
            });
        }
    }

    private static void rece(int threadNum) throws Exception {
        Thread.sleep(1000);
        log.info("{} 准备好了", threadNum);
        barrier.await();
        log.info("{} 线程往下执行了", threadNum);
    }
}

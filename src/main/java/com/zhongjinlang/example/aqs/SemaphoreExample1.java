package com.zhongjinlang.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author: zhongjinlang
 * @date: Created in 2019/4/25 1:37
 * @description:
 */
@Slf4j
public class SemaphoreExample1 {
    // 给定测试的线程数
    private final static int threadCount = 20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        // 给定允许的并发数
        final Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            // 从线程池中开启线程
            exec.execute(() -> {
                try {
                    // 调用方法
                    // 对并发控制的代码前后要包裹semaphore相关函数
                    semaphore.acquire(3); // 获得许可
                    test(threadNum);
                    semaphore.release(1); // 释放许可
                } catch (Exception e) {
                    log.error("exception", e);
                }
            });
        }
        log.info("完成");
        // 关闭资源
        exec.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        log.info("{}", threadNum);
        Thread.sleep(1000);
    }
}

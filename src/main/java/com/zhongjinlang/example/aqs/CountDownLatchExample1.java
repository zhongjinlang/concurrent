package com.zhongjinlang.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: zhongjinlang
 * @date: Created in 2019/4/25 1:37
 * @description:
 */
@Slf4j
public class CountDownLatchExample1 {

    // 给定测试的线程数
    private final static int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            // 从线程池中开启线程
            exec.execute(() -> {
                try {
                    // 调用方法
                    test(threadNum);
                } catch (Exception e) {
                    log.error("exception", e);
                } finally {
                    // -1
                    countDownLatch.countDown();
                }
            });
        }
        // 线程等待
        countDownLatch.await();
        log.info("完成");
        // 关闭资源
        exec.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        log.info("{}", threadNum);
        Thread.sleep(100);
    }
}

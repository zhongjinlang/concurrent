package com.zhongjinlang.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author: zhongjinlang
 * @date: Created in 2019/4/25 18:07
 * @description:
 */

@Slf4j
public class FutureExample {

    static class MyCallable implements Callable<String>{
        @Override
        public String call() throws Exception {
            log.info("do something in callable");
            Thread.sleep(5000);
            return "Done";
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 获取线程结果
        ExecutorService exec= Executors.newCachedThreadPool();
        // 提交任务 获取结果
        Future<String> future = exec.submit(new MyCallable());
        log.info("do something in main");
        Thread.sleep(1000);

        // 阻塞
        String result = future.get();
        log.info("result: {}", result);

    }
}

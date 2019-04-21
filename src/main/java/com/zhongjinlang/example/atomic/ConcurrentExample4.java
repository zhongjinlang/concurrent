package com.zhongjinlang.example.atomic;

import com.zhongjinlang.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author ：zhongjinlang
 * @date ：Created in 2019/4/21 18:42
 * @description：使用atomic-原子性测试
 */

@Slf4j
@ThreadSafe
public class ConcurrentExample4 {

    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        // 当为0的时候赋值2...以此类推
        count.compareAndSet(0,2); // 2
        count.compareAndSet(0,1); // no
        count.compareAndSet(1,3); // no
        count.compareAndSet(2,4); // 4
        count.compareAndSet(3,5); // no

        log.info("count:{}", count.get() ); // 输出4

    }
}

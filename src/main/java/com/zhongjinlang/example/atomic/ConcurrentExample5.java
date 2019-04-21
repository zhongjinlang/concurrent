package com.zhongjinlang.example.atomic;

import com.zhongjinlang.annotation.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ：zhongjinlang
 * @date ：Created in 2019/4/21 18:42
 * @description：使用atomic-原子性测试
 */

@Slf4j
@ThreadSafe
public class ConcurrentExample5 {

    // T: 要更新的类字节码。fieleName: 类中的字段名称(volatile修饰且非static)
    // 原子性更新某个类的指定字段的值
    private static AtomicIntegerFieldUpdater<ConcurrentExample5> updater =
            AtomicIntegerFieldUpdater.newUpdater(ConcurrentExample5.class, "count");
    @Getter
    public volatile int count = 100;
    private static ConcurrentExample5 example5 = new ConcurrentExample5();

    public static void main(String[] args) {
        // 如果该类的字段为100那么将其更新为120
        if (updater.compareAndSet(example5, 100, 120)){
            log.info("更新成功【第一次】 {}", example5.getCount()); // info
        }

        if (updater.compareAndSet(example5, 100, 120)){
            log.info("更新成功【第二次】 {}", example5.getCount());
        }else {
            log.info("更新失败【第二次】{}", example5.getCount() ); // info
        }
    }
}

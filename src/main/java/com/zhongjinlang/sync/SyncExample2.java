package com.zhongjinlang.sync;

import com.zhongjinlang.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：zhongjinlang
 * @date ：Created in 2019/4/21 23:17
 * @description：使用synchronization-修饰代码块
 */
@Slf4j
@NotThreadSafe
public class SyncExample2 {

    // 修饰一个类
    public static void test1(){
        synchronized (SyncExample2.class){
            for(int i = 0; i < 10; i++){
                log.info("test1 - {}", i);
            }
        }
    }

    // 修饰一个静态方法：作用于这个类的所有对象
    public static synchronized void test2(){
        for(int i = 0; i < 10; i++){
            log.info("test2 - {}", i);
        }
    }

    public static void main(String[] args) {
        SyncExample2 example1 = new SyncExample2();
        // TODO 再声明一个对象
        SyncExample2 example2 = new SyncExample2();
        // 线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 开启两个线程执行方法【一个对象:example1】
        executorService.execute(() -> example1.test1());
        executorService.execute(() -> example2.test1()); // TODO 不同的对象进行调用
    }
}

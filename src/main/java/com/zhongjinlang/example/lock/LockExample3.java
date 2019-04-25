package com.zhongjinlang.example.lock;

import com.zhongjinlang.annotation.ThreadSafe;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ：zhongjinlang
 * @date ：Created in 2019/4/21 18:42
 * @description：使用synchronization实现线程安全
 */

@Slf4j
@ThreadSafe
public class LockExample3 {
    private final Map<String, Data> map = new TreeMap<>();

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    // 定义读锁和写锁
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    // 对外提供线程安全的接口
    public Data get(String key) {
        readLock.lock(); // 读锁
        try {
            return map.get(key);
        } finally {
            readLock.unlock(); // 解锁
        }
    }

    public Set<String> getAllKeys() {
        readLock.lock(); // 读锁
        try {
            return map.keySet();
        } finally {
            readLock.unlock(); // 解锁
        }
    }

    public Data put(String key, Data value) {
        writeLock.lock(); // 写锁
        try {
            return map.put(key, value);
        } finally {
            readLock.unlock(); // 解锁
        }
    }

    class Data {

    }
}

package com.zhongjinlang.single;

/**
 * @author ：zhongjinlang
 * @date ：Created in 2019/4/22 12:47
 * @description：单例模式
 */

import com.zhongjinlang.annotation.NotThreadSafe;
import com.zhongjinlang.annotation.ThreadSafe;

/**
 * 懒汉模式：单例实例在第一次使用时创建
 *
 * synchronization修饰类，双重检测机制
 */
@ThreadSafe
public class SingleExample4 {

    private SingleExample4(){}

    // 单例对象
    // 如果不加：会导致线程不安全 因为JVM和CPU发生指令重排:
    private volatile static SingleExample4 instance = null;

    // 静态工厂方法

    public static SingleExample4 getInstance(){
        if (instance == null) { // 双从检测机制
            synchronized (SingleExample4.class){ // 同步锁
                if (instance == null){
                    instance = new SingleExample4();
                }
            }
        }
        return instance;
    }
}

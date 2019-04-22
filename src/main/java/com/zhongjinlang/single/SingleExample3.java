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
 * 单线程环境下安全，但是多线程环境不安全
 * 使用synchronization修饰方法
 */
@ThreadSafe
public class SingleExample3 {

    private SingleExample3(){}

    // 单例对象
    private static SingleExample3 instance = null;

    // 静态工厂方法
    public static synchronized SingleExample3 getInstance(){
        if (instance == null){
            instance = new SingleExample3();
        }
        return instance;
    }
}

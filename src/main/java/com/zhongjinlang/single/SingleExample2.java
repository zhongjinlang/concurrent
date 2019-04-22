package com.zhongjinlang.single;

/**
 * @author ：zhongjinlang
 * @date ：Created in 2019/4/22 12:47
 * @description：单例模式
 */

import com.zhongjinlang.annotation.NotThreadSafe;
import com.zhongjinlang.annotation.ThreadSafe;

/**
 * 饿汗模式：单例实例在类加载时就进行创建
 *
 */
@ThreadSafe
public class SingleExample2 {

    private SingleExample2(){}

    // 单例对象
    private static SingleExample2 instance = new SingleExample2();

    // 静态工厂方法
    public static SingleExample2 getInstance(){
        return instance;
    }
}

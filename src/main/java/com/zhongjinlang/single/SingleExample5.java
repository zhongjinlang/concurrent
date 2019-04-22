package com.zhongjinlang.single;

/**
 * @author ：zhongjinlang
 * @date ：Created in 2019/4/22 12:47
 * @description：枚举发布安全对象
 */

import com.zhongjinlang.annotation.Recommend;
import com.zhongjinlang.annotation.ThreadSafe;


@ThreadSafe
@Recommend
public class SingleExample5 {

    private SingleExample5(){}

    // 返回枚举声明的对象
    public static SingleExample5 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private SingleExample5 single;

        // 给私有变量创建对象
        // JVM保证这个方法只会被调用一次
        Singleton() {
            single = new SingleExample5();
        }

        // 返回私有变量
        public SingleExample5 getInstance(){
            return single;
        }
    }
}
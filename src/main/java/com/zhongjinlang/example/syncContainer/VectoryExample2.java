package com.zhongjinlang.example.syncContainer;

import com.zhongjinlang.annotation.NotThreadSafe;

import java.util.List;
import java.util.Vector;

/**
 * @author ：zhongjinlang
 * @date ：Created in 2019/4/23 2:02
 * @description：
 */

// 同步容器也有线程不安全的情况
@NotThreadSafe
public class VectoryExample2 {
    private static Vector<Integer> list = new Vector<>();

    public static void main(String[] args) {

        while (true){
            // 向集合中存10个值
            for (int i = 0; i < 10; i++){
                list.add(i);
            }

            /**
             * vector虽然能保证同一时刻只有一个线程能访问他，但是不排除如下情况
             * 1. 当t2线程执行到i < list.size()时，t1线程也可能执行了i < list.size()，它正好将当前i元素移出掉了
             * 2. 这个时候get方法就获取不了所删除的元素了，因此抛出数组越界异常
             */
            // 开启两个线程
            Thread t1 = new Thread(() -> {
                for (int i = 0; i < list.size(); i++){
                    list.remove(i); // 删除(synchronization)
                }
            });
            Thread t2 = new Thread(() -> {
                for (int i = 0; i < list.size(); i++){
                    list.get(i); // 获取(synchronization)
                }
            });

            // 启动两个线程
            t1.start();
            t2.start();
        }

    }
}

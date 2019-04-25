package com.zhongjinlang.example.syncContainer;

import com.google.common.collect.Lists;
import com.zhongjinlang.annotation.NotThreadSafe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * @author ：zhongjinlang
 * @date ：Created in 2019/4/23 2:02
 * @description：
 */


@NotThreadSafe
public class VectoryExample3 {
    
    // 三个方法：遍历集合对指定元素删除
    // ConcurrentModificationException

    // 如果使用了foreach和iterator循环集合时，尽量不要在操作过程中做remove等相关的更新操作
    // 如果需要删除，提前做好标记，在循环结束之后再去执行删除操作

    private static void test1(Vector<Integer> v1){
        for (Integer data : v1) {
            if (data.equals(3)){
                v1.remove(data);
            }
        }
    }

    //ConcurrentModificationException
    private static void test2(Vector<Integer> v1){
        Iterator<Integer> iterator = v1.iterator();
        while (iterator.hasNext()){
            Integer data = iterator.next();
            if (data.equals(3)){
                //v1.remove(data);
                iterator.remove();
            }
        }
    }

    // ok
    private static void test3(Vector<Integer> v1){
        for (int i = 0; i < v1.size(); i++){
            if (v1.get(i).equals(3)){
                v1.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);

        //test1(vector);
        test2(vector);
        //test3(vector);
    }
}

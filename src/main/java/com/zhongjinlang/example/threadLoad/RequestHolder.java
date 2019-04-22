package com.zhongjinlang.example.threadLoad;

import java.util.zip.Inflater;

/**
 * @author ：zhongjinlang
 * @date ：Created in 2019/4/22 18:34
 * @description：
 */
public class RequestHolder {
    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    // 在线程中绑定一个值
    public static void add(Long id){
        requestHolder.set(id);
    }

    // 取出线程中的值
    public static Long getId(){
        // 取出线程中的值
        return requestHolder.get();
    }

    // 移出线程中的值【否则内存溢出】
    public static void remove(){
        requestHolder.remove();
    }
}

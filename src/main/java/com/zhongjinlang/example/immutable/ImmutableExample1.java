package com.zhongjinlang.example.immutable;
import com.google.common.collect.Maps;
import com.zhongjinlang.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;
import java.util.Map;

/**
 * @author ：zhongjinlang
 * @date ：Created in 2019/4/22 17:52
 * @description：不可变对象
 */
@Slf4j
@NotThreadSafe
public class ImmutableExample1 {
    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
        // 基础数据类型不可修改
        //a = 2;
        //b = "3";

        // 不可改变引用
        //map = Maps.newLinkedHashMap();

        // 没有安全发布可使用，它是线程不安全的
        map.put(1,3);
        log.info("{}", map.get(1));
    }
}

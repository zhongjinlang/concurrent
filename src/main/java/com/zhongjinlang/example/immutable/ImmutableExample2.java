package com.zhongjinlang.example.immutable;

import com.google.common.collect.Maps;
import com.zhongjinlang.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * @author ：zhongjinlang
 * @date ：Created in 2019/4/22 17:52
 * @description：collections包
 */
@Slf4j
@NotThreadSafe
public class ImmutableExample2 {
    private static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        // 处理后的map不可被修改
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map.put(1,3);
        log.info("{}", map.get(1)); // 不可操作
    }
}

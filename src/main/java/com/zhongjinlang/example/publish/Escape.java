package com.zhongjinlang.example.publish;

import com.zhongjinlang.annotation.NotRecommend;
import com.zhongjinlang.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ：zhongjinlang
 * @date ：Created in 2019/4/22 12:36
 * @description：
 */

@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCanBeEscape = 0;

    public Escape() {
        new innerClass();
    }

    private class innerClass{
        // 对象没有被正确构造之前就发布对象，可能会不安全
        public innerClass() {
            log.info("{}", Escape.this.thisCanBeEscape); // 启动了另一个对象引用
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}

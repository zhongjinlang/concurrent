package com.zhongjinlang.example.publish;
import com.zhongjinlang.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;

/**
 * @author ：zhongjinlang
 * @date ：Created in 2019/4/22 1:45
 * @description：不安全的发布对象
 */
@Slf4j
@NotThreadSafe
public class UnsafePublish {

    private String[] status = {"a", "b", "c"};

    public String[] getStatus() {
        return status;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStatus())); // abc

        unsafePublish.getStatus()[0] = "z";
        log.info("{}", Arrays.toString(unsafePublish.getStatus())); // zbc
    }
}

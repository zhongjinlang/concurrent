package com.zhongjinlang.example.threadLoad;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：zhongjinlang
 * @date ：Created in 2019/4/22 18:54
 * @description：
 */
@RestController
@RequestMapping("/threadLoad")
public class ThreadLoadController {

    @RequestMapping("/test")
    public Long test(){
        return RequestHolder.getId();
    }
}

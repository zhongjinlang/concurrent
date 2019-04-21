package com.zhongjinlang.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：zhongjinlang
 * @date ：Created in 2019/4/21 2:12
 * @description：
 */
@RestController
@Slf4j
public class TestController {

    @RequestMapping("/test.do")
    public String test(){
        return "test";
    }
}

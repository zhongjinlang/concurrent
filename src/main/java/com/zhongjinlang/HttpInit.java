package com.zhongjinlang;

import com.zhongjinlang.example.threadLoad.RequestHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：zhongjinlang
 * @date ：Created in 2019/4/22 18:47
 * @description：
 */
@Slf4j
public class HttpInit extends HandlerInterceptorAdapter {

    //接口处理之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("处理之前");
        return true;
    }

    // 节后处理之后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        RequestHolder.remove();
        log.info("处理之后");
        return;
    }
}

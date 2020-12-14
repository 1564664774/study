package com.zqh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuangqinghui
 * @version 1.0
 * @date 2020/12/12 17:29
 */
@RestController
public class TestController {
    @RequestMapping("/test")
    public String test() {
        return "nihoa";
    }
}

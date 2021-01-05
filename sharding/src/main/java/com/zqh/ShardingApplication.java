package com.zqh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhuangqinghui
 * @version 1.0
 * @date 2020/12/29 13:46
 */
@SpringBootApplication
@MapperScan("com.zqh.mapper")
public class ShardingApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShardingApplication.class, args);
    }
}

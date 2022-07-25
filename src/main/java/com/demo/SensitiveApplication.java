package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wanghl
 * @date 2022/7/25
 */
@SpringBootApplication
@MapperScan(value = "com.demo.dao")
public class SensitiveApplication {
    public static void main(String[] args) {
        SpringApplication.run(SensitiveApplication.class,args);
    }
}

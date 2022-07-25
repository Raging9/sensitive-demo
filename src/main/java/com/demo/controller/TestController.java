package com.demo.controller;

import com.demo.domain.User;
import com.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wanghl
 * @date 2022/7/25
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private UserService userService;

    @GetMapping("/user")
    public List<User> getUser(){
        List<User> list = userService.list();
        return list;
    }
}

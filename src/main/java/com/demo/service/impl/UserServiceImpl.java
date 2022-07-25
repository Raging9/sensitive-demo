package com.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.dao.UserMapper;
import com.demo.domain.User;
import com.demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author wanghl
 * @date 2022/7/25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}

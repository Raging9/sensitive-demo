package com.demo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.demo.dao.UserMapper;
import com.demo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.List;

/**
 * @author wanghl
 * @date 2022/7/25
 */
@SpringBootTest(classes = SensitiveApplication.class)
@RunWith(SpringRunner.class)
public class SensitiveApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void test(){
        User user = new User();
        user.setName("张三");
        user.setPhone("15178907415");
        userMapper.insert(user);
    }

    @Test
    public void query(){
        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<>();
        qw.eq(User::getName, "张三").eq(User::getPhone, "15178907415");
        List<User> users = userMapper.selectList(qw);
        System.out.printf(users.toString());
    }

}

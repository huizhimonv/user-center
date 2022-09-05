package com.yupi.usercenter.service;
import java.util.Date;

import com.yupi.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/*
用户服务测试

 */
@SpringBootTest
class UserServiceTest {


    @Resource
    private  UserService userService;

    @Test
    public void testAddUser(){

        User user = new User();

        user.setUsername("huizhimonv");
        user.setUserAccount("123");
        user.setAvataUrl("https://636f-codenav-8grj8px727565176-1256524210.tcb.qcloud.la/img/logo.png");
        user.setGender(0);
        user.setUserPassword("xxx");
        user.setPhone("123");
        user.setEmail("456");

        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);

    }


    @Test
    void userRegister() {
        String userAccount = "yupoi";
        String userPassword = "";
        String checkPassword = "123456";
        String planetCode = "1";
        long result = userService.userRegister(userAccount, userPassword, checkPassword,planetCode);
        Assertions.assertEquals(-1,result);
        userAccount = "yu";
        result = userService.userRegister(userAccount, userPassword, checkPassword,planetCode);
        Assertions.assertEquals(-1,result);
        userAccount = "yupoi";
        userPassword = "123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword,planetCode);
        Assertions.assertEquals(-1,result);
        userAccount = "yu pi";
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword,planetCode);
        Assertions.assertEquals(-1,result);
        checkPassword = "123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword,planetCode);
        Assertions.assertEquals(-1,result);

//        userAccount = "huizhimonv";
//        checkPassword = "12345678";
//        result = userService.userRegister(userAccount, userPassword, checkPassword,planetCode);
//        Assertions.assertEquals(-1,result);

        userAccount = "yupi";
        result = userService.userRegister(userAccount, userPassword, checkPassword,planetCode);
        Assertions.assertEquals(-1,result);

    }
}
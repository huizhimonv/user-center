package com.jcjc.usercenter.service;

import com.jcjc.usercenter.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
* @author 神原秋人
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2022-03-14 17:00:03
*/
public interface UserService extends IService<User> {




    /**
     *
     * 用户注册
     * @param userAccount
     * @param userPassword
     * @param checkPassword
     * @return
     */
    long userRegister(String userAccount,String userPassword,String checkPassword,String planetCode);

    /**
     *
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @param request
     * @return 返回脱敏信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);



    /**
     * 用户脱敏
     * @param originUser
     * @return
     */
    User getSafetyUser(User originUser);

    /**
     * 用户注销
     * @param request
     * @return
     */
    int userLogout(HttpServletRequest request);
}

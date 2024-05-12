package com.example.service;

import cn.dev33.satoken.util.SaResult;

/**
 * @author shanhai1024
 * 登录接口
 */
public interface UserLogin {


    //    根据用户名密码实现登录
    public SaResult userLogin(String phoneNumber, String password,String device,String smsCode);

}

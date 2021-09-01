package com.starter.login.service.impl;

import com.starter.login.service.LoginService;
import org.springframework.stereotype.Service;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public void login() {
        System.out.println("======登录成功======");
    }
}

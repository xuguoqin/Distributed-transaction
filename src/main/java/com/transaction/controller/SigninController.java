package com.transaction.controller;

import com.transaction.pojo.signin.Signin;
import com.transaction.service.IntegralService;
import com.transaction.service.SigninService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signin")
public class SigninController {

    @Autowired
    private SigninService signinService;

    @Autowired
    private IntegralService integralService;

    @RequestMapping("/dosignin")
    public String dosignin() {
        // 1.模拟用户签到的操作
        Signin signin = new Signin(null, 0000071234L);
        signinService.signin(signin);
        return "签到成功";
    }
}

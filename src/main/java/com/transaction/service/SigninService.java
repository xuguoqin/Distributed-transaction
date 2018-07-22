package com.transaction.service;

import com.transaction.pojo.signin.Signin;

public interface SigninService {

    void save(Signin signin);

    boolean signin(Signin signin);
}

package com.transaction.enums;

import lombok.Getter;

@Getter
public enum EventType {

    USER_SIGNIN(1, "user_signin"),
    ADD_INTEGRAL(2, "add_integral");

    private Integer code;
    private String msg;

    private EventType(Integer code, String msg) {
        this.code  = code;
        this.msg = msg;
    }
}

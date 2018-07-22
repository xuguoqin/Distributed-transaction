package com.transaction.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.transaction.commons.Constant;
import com.transaction.enums.EventType;
import com.transaction.mapper.signin.SigninEventpublishMapper;
import com.transaction.mapper.signin.SigninMapper;
import com.transaction.pojo.signin.Signin;
import com.transaction.pojo.signin.SigninEventpublish;
import com.transaction.service.SigninService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional(transactionManager = "signinTransactionManager")
public class SigninServiceImpl implements SigninService {

    @Autowired
    private SigninMapper signinMapper;

    @Autowired
    private SigninEventpublishMapper signinEventpublishMapper;

    @Override
    public void save(Signin signin) {
        signinMapper.insert(signin);
    }

    @Override
    public boolean signin(Signin signin) {
        // 1.用户签到
        signinMapper.insert(signin);
        // 2.本数据库记录事件
        SigninEventpublish signinEventpublish = new SigninEventpublish();
        signinEventpublish.setCreateTime(new Date());
        signinEventpublish.setStatus(Constant.NEW);
        signinEventpublish.setEventType(EventType.USER_SIGNIN.getMsg());
        // 3.设置事件内容
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", signin.getUserId());
        String eventJsonString = JSONObject.toJSONString(map);
        signinEventpublish.setPayload(eventJsonString);
        // 4.插入到事件表中
        signinEventpublishMapper.insert(signinEventpublish);
        return true;
    }
}

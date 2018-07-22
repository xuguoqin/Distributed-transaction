package com.transaction.listener;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.transaction.commons.Constant;
import com.transaction.enums.EventType;
import com.transaction.mapper.integral.IntegralEventpublishMapper;
import com.transaction.pojo.integral.IntegralEventpublish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * 监听消息队列发送的事件
 */
@Component
public class MessageListener {

    @Autowired
    private IntegralEventpublishMapper eventpublishMapper;

    /**
     * 用户签到的事件
     */
    @JmsListener(destination = "user_signin")
    public void receiveQueue(String text) {
        Map<String, Object> payload = (Map) JSON.parse(text);
        // 1.确定是用户签到的事件
        if (payload != null) {
            // 2.在积分数据库中添加一条事件记录，类型为增加积分
            IntegralEventpublish integralEventpublish = new IntegralEventpublish();
            integralEventpublish.setCreateTime(new Date());
            integralEventpublish.setStatus(Constant.NEW);
            // 3.设置新的事件，类型为增加积分
            integralEventpublish.setEventType(EventType.ADD_INTEGRAL.getMsg());
            integralEventpublish.setPayload(JSONObject.toJSONString(payload));
            // 4.更新该事件到数据库中
            eventpublishMapper.insert(integralEventpublish);
        }
    }
}

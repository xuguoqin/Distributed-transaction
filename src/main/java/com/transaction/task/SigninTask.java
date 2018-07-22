package com.transaction.task;

import com.transaction.commons.Constant;
import com.transaction.enums.EventType;
import com.transaction.mapper.signin.SigninEventpublishMapper;
import com.transaction.pojo.signin.SigninEventpublish;
import com.transaction.pojo.signin.SigninEventpublishExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class SigninTask {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private SigninEventpublishMapper signinEventpublishMapper;

    private final String destinationName = "user_signin";

    @Scheduled(cron = "0 */1 * * * ?")
    @Transactional(transactionManager = "signinTransactionManager")
    public void task() {

        // 1.通过数据库查询出状态为NEW, 类型为签到的事件
        SigninEventpublishExample eventpublishExample = new SigninEventpublishExample();
        SigninEventpublishExample.Criteria criteria = eventpublishExample.createCriteria();
        criteria.andStatusEqualTo(Constant.NEW);
        criteria.andEventTypeEqualTo(EventType.USER_SIGNIN.getMsg());
        List<SigninEventpublish> list = signinEventpublishMapper.selectByExample(eventpublishExample);
        // 2.这里需要事件列表不为null才进行后续的操作
        if (!CollectionUtils.isEmpty(list)) {
            System.out.println("有数据");
            // 3.发送事件到消息队列
            for (SigninEventpublish signinEventpublish : list) {
                jmsMessagingTemplate.convertAndSend(destinationName, signinEventpublish.getPayload());
            }
            // 4.把数据修改为PUSHLISH状态
            signinEventpublishMapper.updateStatusWithList(Constant.PUBLISH, list);
        }
    }
}

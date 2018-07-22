package com.transaction.task;

import com.alibaba.fastjson.JSON;
import com.transaction.commons.Constant;
import com.transaction.enums.EventType;
import com.transaction.mapper.integral.IntegralEventpublishMapper;
import com.transaction.mapper.integral.IntegralMapper;
import com.transaction.pojo.integral.Integral;
import com.transaction.pojo.integral.IntegralEventpublish;
import com.transaction.pojo.integral.IntegralEventpublishExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class IntegralTask {

    @Autowired
    private IntegralEventpublishMapper integralEventpublishMapper;

    @Autowired
    private IntegralMapper integralMapper;

    @Scheduled(cron = "0 */1 * * * ?")
    @Transactional(transactionManager = "integralTransactionManager")
    public void task() {

        // 1.查询出本地状态为NEW, 类型为增加积分的事件
        IntegralEventpublishExample eventpublishExample = new IntegralEventpublishExample();
        IntegralEventpublishExample.Criteria criteria = eventpublishExample.createCriteria();
        criteria.andEventTypeEqualTo(EventType.ADD_INTEGRAL.getMsg());
        criteria.andStatusEqualTo(Constant.NEW);
        List<IntegralEventpublish> list = integralEventpublishMapper.selectByExample(eventpublishExample);
        if (!CollectionUtils.isEmpty(list)) {
            System.out.println("有数据2");
            List<Integral> integralList = new ArrayList<>();
            for (IntegralEventpublish integralEventpublish : list) {
                // 2.得到用户id
                Map<String, Object> map = (Map) JSON.parse(integralEventpublish.getPayload());
                Integral integral = new Integral(null, 10, Long.parseLong(map.get("user_id").toString()));
                integralList.add(integral);
            }
            // 3.批量插入
            integralMapper.insertWithList(integralList);
            // 4.批量更新
            integralEventpublishMapper.updateStatusWithList(Constant.PUBLISH, list);
        }

    }
}

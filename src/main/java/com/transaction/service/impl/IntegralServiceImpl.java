package com.transaction.service.impl;

import com.transaction.mapper.integral.IntegralMapper;
import com.transaction.pojo.integral.Integral;
import com.transaction.service.IntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(transactionManager = "integralTransactionManager")
public class IntegralServiceImpl implements IntegralService {

    @Autowired
    private IntegralMapper integralMapper;

    @Override
    public void save(Integral integral) {
        integralMapper.insert(integral);
    }
}

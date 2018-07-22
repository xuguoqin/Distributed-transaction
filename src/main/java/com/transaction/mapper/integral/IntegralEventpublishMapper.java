package com.transaction.mapper.integral;

import com.transaction.pojo.integral.IntegralEventpublish;
import com.transaction.pojo.integral.IntegralEventpublishExample;
import java.util.List;

import com.transaction.pojo.signin.SigninEventpublish;
import org.apache.ibatis.annotations.Param;

public interface IntegralEventpublishMapper {
    int countByExample(IntegralEventpublishExample example);

    int deleteByExample(IntegralEventpublishExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IntegralEventpublish record);

    int insertSelective(IntegralEventpublish record);

    List<IntegralEventpublish> selectByExample(IntegralEventpublishExample example);

    IntegralEventpublish selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IntegralEventpublish record, @Param("example") IntegralEventpublishExample example);

    int updateByExample(@Param("record") IntegralEventpublish record, @Param("example") IntegralEventpublishExample example);

    int updateByPrimaryKeySelective(IntegralEventpublish record);

    int updateByPrimaryKey(IntegralEventpublish record);

    int updateStatusWithList(@Param("status") Boolean status, @Param("list") List<IntegralEventpublish> list);
}
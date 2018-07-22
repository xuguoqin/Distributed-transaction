package com.transaction.mapper.signin;

import com.transaction.pojo.signin.SigninEventpublish;
import com.transaction.pojo.signin.SigninEventpublishExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SigninEventpublishMapper {
    int countByExample(SigninEventpublishExample example);

    int deleteByExample(SigninEventpublishExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SigninEventpublish record);

    int insertSelective(SigninEventpublish record);

    List<SigninEventpublish> selectByExample(SigninEventpublishExample example);

    SigninEventpublish selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SigninEventpublish record, @Param("example") SigninEventpublishExample example);

    int updateByExample(@Param("record") SigninEventpublish record, @Param("example") SigninEventpublishExample example);

    int updateByPrimaryKeySelective(SigninEventpublish record);

    int updateByPrimaryKey(SigninEventpublish record);

    int updateStatusWithList(@Param("status") Boolean status, @Param("list") List<SigninEventpublish> list);
}
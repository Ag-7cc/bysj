package com.vic.bysj.core.mall.dal.mapper;

import com.vic.bysj.core.mall.dal.model.UserModel;
import com.vic.bysj.core.mall.dal.model.UserModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserModelMapper {
    int countByExample(UserModelExample example);

    int deleteByExample(UserModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserModel record);

    int insertSelective(UserModel record);

    List<UserModel> selectByExample(UserModelExample example);

    UserModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserModel record, @Param("example") UserModelExample example);

    int updateByExample(@Param("record") UserModel record, @Param("example") UserModelExample example);

    int updateByPrimaryKeySelective(UserModel record);

    int updateByPrimaryKey(UserModel record);
}
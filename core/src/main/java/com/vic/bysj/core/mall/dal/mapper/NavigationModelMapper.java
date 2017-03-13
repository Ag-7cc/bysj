package com.vic.bysj.core.mall.dal.mapper;

import com.vic.bysj.core.mall.dal.model.NavigationModel;
import com.vic.bysj.core.mall.dal.model.NavigationModelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NavigationModelMapper {
    int countByExample(NavigationModelExample example);

    int deleteByExample(NavigationModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NavigationModel record);

    int insertSelective(NavigationModel record);

    List<NavigationModel> selectByExample(NavigationModelExample example);

    NavigationModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NavigationModel record, @Param("example") NavigationModelExample example);

    int updateByExample(@Param("record") NavigationModel record, @Param("example") NavigationModelExample example);

    int updateByPrimaryKeySelective(NavigationModel record);

    int updateByPrimaryKey(NavigationModel record);
}
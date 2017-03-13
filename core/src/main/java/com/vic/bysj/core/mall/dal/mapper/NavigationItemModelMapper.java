package com.vic.bysj.core.mall.dal.mapper;

import com.vic.bysj.core.mall.dal.model.NavigationItemModel;
import com.vic.bysj.core.mall.dal.model.NavigationItemModelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NavigationItemModelMapper {
    int countByExample(NavigationItemModelExample example);

    int deleteByExample(NavigationItemModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NavigationItemModel record);

    int insertSelective(NavigationItemModel record);

    List<NavigationItemModel> selectByExample(NavigationItemModelExample example);

    NavigationItemModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NavigationItemModel record, @Param("example") NavigationItemModelExample example);

    int updateByExample(@Param("record") NavigationItemModel record, @Param("example") NavigationItemModelExample example);

    int updateByPrimaryKeySelective(NavigationItemModel record);

    int updateByPrimaryKey(NavigationItemModel record);
}
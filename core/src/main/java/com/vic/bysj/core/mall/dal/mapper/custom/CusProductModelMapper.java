package com.vic.bysj.core.mall.dal.mapper.custom;

import com.vic.bysj.core.mall.dal.model.ProductModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CusProductModelMapper {
    List<ProductModel> selectByNavIdAndItemId(@Param("navId") Long navId, @Param("itemId") Long itemId);
}
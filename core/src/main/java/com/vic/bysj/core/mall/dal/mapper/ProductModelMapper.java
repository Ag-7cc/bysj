package com.vic.bysj.core.mall.dal.mapper;

import com.vic.bysj.core.mall.dal.model.ProductModel;
import com.vic.bysj.core.mall.dal.model.ProductModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductModelMapper {
    int countByExample(ProductModelExample example);

    int deleteByExample(ProductModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductModel record);

    int insertSelective(ProductModel record);

    List<ProductModel> selectByExample(ProductModelExample example);

    ProductModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductModel record, @Param("example") ProductModelExample example);

    int updateByExample(@Param("record") ProductModel record, @Param("example") ProductModelExample example);

    int updateByPrimaryKeySelective(ProductModel record);

    int updateByPrimaryKey(ProductModel record);
}
package com.vic.bysj.core.mall.dal.mapper;

import com.vic.bysj.core.mall.dal.model.ProductItemModel;
import com.vic.bysj.core.mall.dal.model.ProductItemModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductItemModelMapper {
    int countByExample(ProductItemModelExample example);

    int deleteByExample(ProductItemModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductItemModel record);

    int insertSelective(ProductItemModel record);

    List<ProductItemModel> selectByExample(ProductItemModelExample example);

    ProductItemModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductItemModel record, @Param("example") ProductItemModelExample example);

    int updateByExample(@Param("record") ProductItemModel record, @Param("example") ProductItemModelExample example);

    int updateByPrimaryKeySelective(ProductItemModel record);

    int updateByPrimaryKey(ProductItemModel record);
}
package com.vic.bysj.mall.dao;

import com.vic.bysj.core.mall.dal.bean.Page;
import com.vic.bysj.core.mall.dal.bean.Product;
import com.vic.bysj.core.mall.dal.mapper.ProductItemModelMapper;
import com.vic.bysj.core.mall.dal.mapper.ProductModelMapper;
import com.vic.bysj.core.mall.dal.mapper.custom.CusProductModelMapper;
import com.vic.bysj.core.mall.dal.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 产品dao
 * Created by vic
 * Create time : 2017/2/5 下午2:16
 */
@Repository
public class ProductDao {

    @Autowired
    private ProductModelMapper productModelMapper;
    @Autowired
    private ProductItemModelMapper productItemModelMapper;
    @Autowired
    private CusProductModelMapper cusProductModelMapper;

    public List<ProductModel> findByPage(Page<Product> page) {
        LinkedHashMap<String, Object> filter = page.getFilter();

        List<ProductModel> productModels = cusProductModelMapper.selectByNavIdAndItemId((Long) filter.get("navId"), (Long) filter.get("itemId"));
        return productModels;

        /*ProductModelExample example = new ProductModelExample();

        ProductModelExample.Criteria criteria = example.or();

        LinkedHashMap<String, Object> filter = page.getFilter();

        ProductItemModelExample itemModelExample = new ProductItemModelExample();
        ProductItemModelExample.Criteria itemCriteria = itemModelExample.createCriteria();

        if(filter.containsKey("navId")){
            itemCriteria.andNavIdEqualTo((Long)filter.get("navId"));
        }
        if(filter.containsKey("itemId")){
            itemCriteria.andItemIdEqualTo((Long)filter.get("itemId"));
        }
        itemModelExample.or(itemCriteria);
        List<ProductItemModel> productItemModels = productItemModelMapper.selectByExample(itemModelExample);



        example.setOrderByClause("create_time desc");
        return productModelMapper.selectByExample(example);*/
    }
}

package com.vic.bysj.mall.service;

import com.vic.bysj.core.mall.dal.bean.Page;
import com.vic.bysj.core.mall.dal.bean.Product;
import com.vic.bysj.core.mall.dal.model.ProductModel;
import com.vic.bysj.mall.dao.ProductDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 产品service
 * Created by vic
 * Create time : 2017/2/5 下午2:15
 */
@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    /**
     * 分页查询
     * @return
     */
    public List<Product> findByPage(Page<Product> page) {
        List<ProductModel> modelList = productDao.findByPage(page);

        List<Product> productList = modelList.stream().map(model -> {
            Product product = new Product();
            BeanUtils.copyProperties(model, product);
            return product;
        }).collect(Collectors.toList());

        return productList;
    }
}

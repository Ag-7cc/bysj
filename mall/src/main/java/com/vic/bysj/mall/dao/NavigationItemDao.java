package com.vic.bysj.mall.dao;

import com.google.common.collect.Lists;
import com.vic.bysj.core.mall.dal.bean.NavigationItem;
import com.vic.bysj.core.mall.dal.mapper.NavigationItemModelMapper;
import com.vic.bysj.core.mall.dal.model.NavigationItemModel;
import com.vic.bysj.core.mall.dal.model.NavigationItemModelExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 导航类目
 * Created by vic
 * Create time : 2017/1/31 下午8:44
 */
@Repository
public class NavigationItemDao {
    @Autowired
    private NavigationItemModelMapper navigationItemModelMapper;

    /**
     * 根据导航编号获取类目列表
     *
     * @param navId
     * @return
     */
    public List<NavigationItem> findByNavId(Long navId) {
        if (null == navId) return Lists.newArrayList();
        NavigationItemModelExample example = new NavigationItemModelExample();
        example.or().andNavIdEqualTo(navId).andStatusEqualTo(1);
        List<NavigationItemModel> modelList = navigationItemModelMapper.selectByExample(example);

        List<NavigationItem> itemList = modelList.stream().map(model -> {
            NavigationItem navigationItem = new NavigationItem();
            BeanUtils.copyProperties(model,navigationItem);
            return navigationItem;
        }).collect(Collectors.toList());

        return itemList;
    }
}

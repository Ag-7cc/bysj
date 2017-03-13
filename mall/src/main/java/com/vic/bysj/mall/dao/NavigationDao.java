package com.vic.bysj.mall.dao;

import com.vic.bysj.core.mall.dal.bean.Navigation;
import com.vic.bysj.core.mall.dal.mapper.NavigationModelMapper;
import com.vic.bysj.core.mall.dal.model.NavigationModel;
import com.vic.bysj.core.mall.dal.model.NavigationModelExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 导航dao
 * Created by vic
 * Create time : 2017/1/31 下午7:40
 */
@Repository
public class NavigationDao {
    @Autowired
    private NavigationModelMapper navigationModelMapper;

    /**
     * 查询所有导航按权重排序
     *
     * @return
     */
    public List<Navigation> findAll() {
        NavigationModelExample example = new NavigationModelExample();
        example.or().andStatusEqualTo(1);
        example.setOrderByClause("weight");
        List<NavigationModel> modelList = navigationModelMapper.selectByExample(example);

        List<Navigation> navigationList = modelList.stream().map((model) -> {
            Navigation navigation = new Navigation();
            BeanUtils.copyProperties(model, navigation);
            return navigation;
        }).collect(Collectors.toList());

        return navigationList;
    }
}

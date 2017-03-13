package com.vic.bysj.mall.service;

import com.vic.bysj.core.mall.dal.bean.Navigation;
import com.vic.bysj.core.mall.dal.bean.NavigationItem;
import com.vic.bysj.mall.dao.NavigationDao;
import com.vic.bysj.mall.dao.NavigationItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 导航service
 * Created by vic
 * Create time : 2017/1/31 下午7:39
 */
@Service
public class NavigationService {
    @Autowired
    private NavigationDao navigationDao;
    @Autowired
    private NavigationItemDao navigationItemDao;

    /**
     * 查询所有按权重排序
     * 最多查询出10条
     *
     * @return
     */
    public List<Navigation> findNavigationList() {
        List<Navigation> navigationList = navigationDao.findAll();

        /*// 填充item列表
        List<Navigation> list = navigationList.stream().map(navigation -> {
            navigation.setItemList(navigationItemDao.findByNavId(navigation.getId()));
            return navigation;
        }).collect(Collectors.toList());*/

        return navigationList;
    }

    /**
     * 根据导航编号获取类目列表
     *
     * @param navId
     * @return
     */
    public List<NavigationItem> findItemListByNavId(Long navId) {
        return navigationItemDao.findByNavId(navId);
    }
}

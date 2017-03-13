package com.vic.bysj.core.mall.dal.bean;

import java.util.List;

public class Navigation {
    private Long id;

    private String name;

    private Long weight;

    private Integer status;

    private Long createTime;

    /* 自定义字段 begin */
    private List<NavigationItem> itemList;
    /* 自定义字段 end */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public List<NavigationItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<NavigationItem> itemList) {
        this.itemList = itemList;
    }
}
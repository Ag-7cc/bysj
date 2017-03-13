package com.vic.bysj.mall.dao;

import com.vic.bysj.core.mall.dal.mapper.UserModelMapper;
import com.vic.bysj.core.mall.dal.model.UserModel;
import com.vic.bysj.core.mall.dal.model.UserModelExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vic
 * Create time : 2017/1/23 下午9:15
 */
@Repository
public class UserDao {
    @Autowired
    private UserModelMapper userModelMapper;

    public void insert(){
        UserModel userModel = new UserModel();
        userModel.setUserName("vic");
        userModel.setPassword("123456");
        userModel.setMobile("15821244303");
        userModel.setEmail("390002333@qq.com");
        userModel.setSex(1);
        userModel.setCreateTime(System.currentTimeMillis());
        userModelMapper.insert(userModel);
        System.out.println("~~~~~~~~insert finish~~~~~~~");
    }

    public List<UserModel> find(){
       return userModelMapper.selectByExample(new UserModelExample());
    }

}

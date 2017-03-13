package com.vic.bysj.mall.base;

import java.util.Properties;

/**
 * 应用程序上下文，读取app.properties资源信息
 * Created by vic
 * Create time : 2017/1/23 下午6:48
 */
public class AppContext {

    private static AppContext instance;

    private Properties properties;

    public AppContext(Properties properties) {
        if(null == instance){
            instance = this;
            this.properties = properties;
        }
    }

    /**
     * 根据key获取值
     * @param key
     * @return
     */
    public static String getProperty(String key){
        if(null == instance.properties){
            return null;
        }
        return instance.properties.getProperty(key);
    }
}

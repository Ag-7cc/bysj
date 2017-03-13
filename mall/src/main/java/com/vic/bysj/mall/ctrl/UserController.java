package com.vic.bysj.mall.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by vic
 * Create time : 2017/1/25 下午5:37
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public String login() {
        return "index";
    }


    /**
     * 注册页面
     *
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public String register() {
        return "/register";
    }
}

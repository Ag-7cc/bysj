package com.vic.bysj.mall.ctrl;

import com.vic.bysj.core.mall.dal.bean.Navigation;
import com.vic.bysj.core.mall.dal.bean.NavigationItem;
import com.vic.bysj.core.mall.dal.bean.Page;
import com.vic.bysj.core.mall.dal.bean.Product;
import com.vic.bysj.mall.service.NavigationService;
import com.vic.bysj.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by vic
 * Create time : 2017/1/31 下午8:41
 */
@Controller
@RequestMapping("/navigation")
public class NavigationController {
    @Autowired
    private NavigationService navigationService;
    @Autowired
    private ProductService productService;

    @RequestMapping("/findByNavIdAndItemId")
    public String findByNavIdAndItemId(Page<Product> page, Model model) {
        // 导航列表
        List<Navigation> navigationList = navigationService.findNavigationList();

        LinkedHashMap<String, Object> filter = page.getFilter();
        if (filter.containsKey("navId") && filter.containsKey("itemId")) {
            Long navId = (Long) filter.get("navId");
            Long itemId = (Long) filter.get("itemId");
            // 类目列表
            List<NavigationItem> itemList = navigationService.findItemListByNavId(navId);
            // 产品列表
            List<Product> productList = productService.findByPage(page);

            model.addAttribute("navigationList", navigationList);
            model.addAttribute("itemList", itemList);
            model.addAttribute("productList", productList);
            model.addAttribute("navId", navId);
            model.addAttribute("itemId", itemId);
        }
        return "index";
    }
}

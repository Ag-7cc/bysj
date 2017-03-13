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
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 首页
 * Created by vic
 * Create time : 2017/1/25 下午4:27
 */
@Controller
public class IndexController extends BaseController {

    @Autowired
    private NavigationService navigationService;
    @Autowired
    private ProductService productService;

    @RequestMapping("/index")
    public String index(Model model) {
        List<Navigation> navigationList = navigationService.findNavigationList();
        model.addAttribute("navigationList", navigationList);
        if(!CollectionUtils.isEmpty(navigationList)){
            Long navId = navigationList.get(0).getId();
            List<NavigationItem> itemList = navigationService.findItemListByNavId(navId);

            if(!CollectionUtils.isEmpty(itemList)){
                Page<Product> page = new Page();
                LinkedHashMap<String, Object> filter = new LinkedHashMap<>();
                filter.put("navId",navId);
                filter.put("itemId",itemList.get(0).getId());
                page.setFilter(filter);
                List<Product> productList = productService.findByPage(page);
                model.addAttribute("productList",productList);
            }
            model.addAttribute("navId", navId);
            model.addAttribute("itemList",itemList);
        }
        return "index";
    }

}

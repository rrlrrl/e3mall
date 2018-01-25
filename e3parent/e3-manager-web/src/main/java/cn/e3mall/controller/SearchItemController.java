package cn.e3mall.controller;

import cn.e3mall.common.utils.E3Result;
import cn.e3mall.search.service.SearchItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lenovo on 2018/1/24.
 */
@Controller
public class SearchItemController {

    @Autowired
    private SearchItemService searchItemService;

    @RequestMapping("/index/item/import")
    @ResponseBody
    public E3Result importItemList(){
        E3Result e3Result = searchItemService.importAllItem();
        return  e3Result;
    }
}

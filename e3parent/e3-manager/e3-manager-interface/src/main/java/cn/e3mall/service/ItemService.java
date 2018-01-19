package cn.e3mall.service;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbItem;

/**
 * Created by lenovo on 2018/1/10.
 */

public interface ItemService {
    TbItem getItemById(long id);
    EasyUIDataGridResult getItemList(int page,int rows);

    E3Result addItem(TbItem item, String desc);

}

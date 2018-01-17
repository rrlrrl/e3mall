package cn.e3mall.service;

import cn.e3mall.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Created by lenovo on 2018/1/16.
 */
public interface ItemCatService {
    List<EasyUITreeNode> getItemCatList(long parentId);
}

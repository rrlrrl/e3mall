package cn.e3mall.content.service;

import cn.e3mall.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Created by lenovo on 2018/1/19.
 */
public interface ContentCategoryService {

    List<EasyUITreeNode> getContentCatList(long parentId);
}

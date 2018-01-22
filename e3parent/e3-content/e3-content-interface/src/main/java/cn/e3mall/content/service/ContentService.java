package cn.e3mall.content.service;

import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbContent;

import java.util.List;

/**
 * Created by lenovo on 2018/1/22.
 */
public interface ContentService {

    E3Result addContent(TbContent tbContent);

    List<TbContent> getContentListByCid(long cid);
}

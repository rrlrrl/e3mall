package cn.e3mall.content.service.impl;

import cn.e3mall.common.utils.E3Result;
import cn.e3mall.content.service.ContentService;
import cn.e3mall.mapper.TbContentMapper;
import cn.e3mall.pojo.TbContent;
import cn.e3mall.pojo.TbContentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2018/1/22.
 */
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private TbContentMapper contentMapper;

    @Override
    public E3Result addContent(TbContent content) {
        //补全属性
        content.setCreated(new Date());
        content.setUpdated(new Date());
        //插入数据
        contentMapper.insert(content);
        return E3Result.ok();
    }

    @Override
    public List<TbContent> getContentListByCid(long cid) {
        //根据分类id查询内容列表
        //设置查询条件
        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(cid);
        //执行查询
        List<TbContent> list = contentMapper.selectByExample(example);
        return list;

    }

}

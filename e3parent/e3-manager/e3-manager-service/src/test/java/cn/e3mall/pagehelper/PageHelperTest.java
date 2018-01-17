package cn.e3mall.pagehelper;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by lenovo on 2018/1/16.
 */
public class PageHelperTest {

    @Test
    public void testPageHelper() throws Exception {
        //初始化spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        //获得Mapper的代理对象
        TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
        //设置分页信息
        PageHelper.startPage(1, 10);
        //执行查询
        TbItemExample example = new TbItemExample();
        List<TbItem> list = itemMapper.selectByExample(example);
        //取分页信息
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo.getTotal());
        System.out.println(pageInfo.getPages());
        System.out.println(pageInfo.getPageNum());
        System.out.println(pageInfo.getPageSize());


    }

}

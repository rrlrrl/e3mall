package cn.e3mall.solrj;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/1/24.
 */
public class TestSolrJ {
    @Test
    public void addDocument() throws Exception {
        // 1、把solrJ的jar包添加到工程。
        // 2、创建一个SolrServer对象。创建一个和sorl服务的连接。HttpSolrServer。
        //如果不带Collection默认连接Collection1
        SolrServer solrServer = new HttpSolrServer("http://10.71.201.24:8080/solr");
        // 3、创建一个文档对象。SolrInputDocument。
        SolrInputDocument document = new SolrInputDocument();
        // 4、向文档对象中添加域。必须有一个id域。而且文档中使用的域必须在schema.xml中定义。
        document.addField("id", "test001");
        document.addField("item_title", "测试商品");
        // 5、把文档添加到索引库
        solrServer.add(document);
        // 6、Commit。
        solrServer.commit();
    }

    @Test
    public void deleteDocument() throws Exception {
        SolrServer solrServer = new HttpSolrServer("http://10.71.201.24:8080/solr");
        solrServer.deleteByQuery("id:test001");
        solrServer.commit();
    }

    //使用solrJ实现查询
    @Test
    public void queryDocument() throws Exception {
        //创建一个SolrServer对象
        SolrServer solrServer = new HttpSolrServer("http://10.71.201.24:8080/solr");
        //创建一个查询对象，可以参考solr的后台的查询功能设置条件
        SolrQuery query = new SolrQuery();
        //设置查询条件
//		query.setQuery("阿尔卡特");
        query.set("q","阿尔卡特");
        //设置分页条件
        query.setStart(1);
        query.setRows(2);
        //开启高亮
        query.setHighlight(true);
        query.addHighlightField("item_title");
        query.setHighlightSimplePre("<em>");
        query.setHighlightSimplePost("</em>");
        //设置默认搜索域
        query.set("df", "item_title");
        //执行查询，得到一个QueryResponse对象。
        QueryResponse queryResponse = solrServer.query(query);
        //取查询结果总记录数
        SolrDocumentList solrDocumentList = queryResponse.getResults();
        System.out.println("查询结果总记录数：" + solrDocumentList.getNumFound());
        //取查询结果
        Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
        for (SolrDocument solrDocument : solrDocumentList) {
            System.out.println(solrDocument.get("id"));
            //取高亮后的结果
            List<String> list = highlighting.get(solrDocument.get("id")).get("item_title");
            String title= "";
            if (list != null && list.size() > 0) {
                //取高亮后的结果
                title = list.get(0);
            } else {
                title = (String) solrDocument.get("item_title");
            }
            System.out.println(title);
            System.out.println(solrDocument.get("item_sell_point"));
            System.out.println(solrDocument.get("item_price"));
            System.out.println(solrDocument.get("item_image"));
            System.out.println(solrDocument.get("item_category_name"));
        }

    }



}

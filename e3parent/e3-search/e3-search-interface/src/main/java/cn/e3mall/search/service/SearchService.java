package cn.e3mall.search.service;

import cn.e3mall.common.pojo.SearchResult;

/**
 * Created by lenovo on 2018/1/25.
 */
public interface SearchService {

    SearchResult search(String keyWord, int page, int rows) throws Exception;
}

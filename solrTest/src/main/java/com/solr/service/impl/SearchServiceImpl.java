package com.solr.service.impl;

import com.solr.dao.SearchDao;
import com.solr.service.SearchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/2/1 0001.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SearchServiceImpl implements SearchService{

    @Resource
    private SearchDao searchDao;

    public String getStory(int Id) {
        return searchDao.getStory(Id);
    }
}

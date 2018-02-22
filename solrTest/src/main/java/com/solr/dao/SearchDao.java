package com.solr.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/2/1 0001.
 */
@Repository
public interface SearchDao {
    String getStory(int Id);
}

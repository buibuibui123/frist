package com.solr.utils;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2018/2/2 0002.
 */
public class DeleteIndex {
    HttpSolrClient client = new HttpSolrClient(EnumUtil.serverUrl);

    //删除某一个
    public int deleteOne(String id) throws IOException, SolrServerException {
        if (client.deleteById(id)==null){
            return 0;
        }else {
            return 1;
        }
    }

    //删除多个
    public int deleteMore(List<String> ids) throws IOException, SolrServerException {
        if (client.deleteById(ids)==null){
            return 0;
        }else {
            return 1;
        }
    }

    //条件删除
    public int deleteByCondition(String condition,String msg) throws IOException, SolrServerException {
        if (client.deleteByQuery(condition+":"+msg)==null){
            return 0;
        }else {
            return 1;
        }
    }

    //删除全部
    public int deleteAll() throws IOException, SolrServerException {
        if (client.deleteByQuery("*:*")==null){
            return 0;
        }else {
            return 1;
        }
    }

}

package com.solr.utils;

import com.solr.model.Moive;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/2/1 0001.
 */
public class Search {

    public Map<String, Object> selectSearch(String Keywords, String selectType, int page) throws IOException, SolrServerException {
        List<Moive> list= new ArrayList<Moive>();
        HashMap<String, Object> hm = new HashMap<String, Object>();
        Moive moive = new Moive();
        HttpSolrClient client = new HttpSolrClient(EnumUtil.serverUrl);
        SolrQuery query = new SolrQuery();
        query.set("q",Keywords);
        query.setStart(10*(page-1));
        query.setRows(10);
        query.set("df",selectType);
        //======高亮设置===
        //开启高亮
        query.setHighlight(true);
        //高亮域
        query.addHighlightField(selectType);
        //前缀
        query.setHighlightSimplePre("<span style='color:red'>");
        //后缀
        query.setHighlightSimplePost("</span>");
        QueryResponse queryResponse = client.query(query);
        SolrDocumentList results =  queryResponse.getResults();
        long numFound = results.getNumFound();
        System.out.println("总查询出:" + numFound + "条记录");
        Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();

        list = moive.add(results);
//        for (SolrDocument solrDocument : results) {
//            System.out.println("电影id:" + solrDocument.get("id"));
//            System.out.println("电影名称 :" + solrDocument.get("mv_title"));
//            System.out.println("电影评分 :" + solrDocument.get("mv_race"));
//            System.out.println("电影分类:" + solrDocument.get("mv_type"));
//            System.out.println("电影描述:" + solrDocument.get("mv_story"));
//            System.out.println("电影地址:" + solrDocument.get("mv_url"));
//
//            //输出高亮信息
//            List<String>list1 = highlighting.get(solrDocument.get("id")).get(selectType);
//            //Map<String, List<String>> map = highlighting.get(solrDocument.get("id"));
//            //List<String> list = map.get("mv_title");
//            if(list1 != null && list1.size() > 0){
//                System.out.println(list1.get(0));
//            }
//        }
        //client.close();
        hm.put("list",list);
        return hm;
    }

}

package com.solr.controller;

import com.alibaba.fastjson.JSONObject;
import com.solr.model.Moive;
import com.solr.service.SearchService;
import com.solr.utils.EnumUtil;
import com.solr.utils.JosnUtil;
import com.solr.utils.Search;
import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/2/1 0001.
 */

@Controller
@RequestMapping("/search")
public class SearchController {
    private Logger log = Logger.getLogger(SearchController.class);
    @Resource
    private SearchService searchService;



    @RequestMapping("/typeSearch")
    @ResponseBody
    public JSONObject typeSearch(String Keywords,Integer page,int type) throws IOException, SolrServerException {
        if (page == null || page < 0) {
            page = 1;
        }
        Search search = new Search();
        HashMap<String, Object> result = new HashMap<String,Object>();

        Map<String, Object> list = null;
        if (type==0){
            list = search.selectSearch(Keywords, EnumUtil.title,page);
        }else if (type == 1){
            list = search.selectSearch(Keywords, EnumUtil.type,page);
        }else if (type == 2){
            list = search.selectSearch(Keywords, EnumUtil.story,page);
        }else if (type == 3){
            list = search.selectSearch(Keywords, EnumUtil.all,page);
        }else {
            log.info("查询类型出错");
            return JosnUtil.constructResponse(0,"查询类型出错",null);
        }
        result.put("list",list);
        return JosnUtil.constructResponse(1,"查询成功",result);

    }
    @RequestMapping("/storySearch")
    @ResponseBody
    public JSONObject storySearch(int id){
        try {
            log.info("查询内容");
            String story = searchService.getStory(id);
            if (story==null){
                return JosnUtil.constructResponse(0,"查询无果",null);
            }else {
                return JosnUtil.constructResponse(1,"查询成功",story);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("数据库系统错误"+e);
            return JosnUtil.constructResponse(0,"数据库系统错误",null);
        }
    }

}

package com.solr.model;

import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/2 0002.
 */
public class Moive {
    private String id;
    private String title;
    private String race;
    private String type;
    private String story;
    private String url;

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List add(SolrDocumentList results){
        Moive moive = null;
        List<Moive> list = new ArrayList<Moive>();
        for (SolrDocument solrDocument : results) {
            moive = new Moive();
           moive.setId((String) solrDocument.get("id"));
           moive.setTitle((String) solrDocument.get("mv_title"));
           moive.setRace((String) solrDocument.get("mv_race"));
           moive.setType((String)solrDocument.get("mv_type"));
           moive.setStory((String)solrDocument.get("mv_story"));
           moive.setUrl((String)solrDocument.get("mv_url"));
                list.add(moive);
            System.out.println(list.get(0).getUrl());
        }
        return list;
    }
}

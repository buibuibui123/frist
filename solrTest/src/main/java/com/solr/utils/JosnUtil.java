package com.solr.utils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2018/2/1 0001.
 */
public class JosnUtil {
    private static Logger log = LoggerFactory.getLogger(JosnUtil.class);

    public static JSONObject constructResponse(int code, String msg, Object data){
        JSONObject jo = new JSONObject();
        jo.put("code",code);
        jo.put("msg",msg);
        jo.put("data",data);
        return jo;
    }
}

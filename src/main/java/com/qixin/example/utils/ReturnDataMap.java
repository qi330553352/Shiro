package com.qixin.example.utils;

import java.util.HashMap;

/**
 * 文    件     名： ReturnDataMap
 * 包           名： com.qixin.example.utils
 * 创  建   时  间： 2018/1/18 23:04
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
public class ReturnDataMap extends HashMap<String,Object> {

    public ReturnDataMap(){
        this.put("success",true);
        this.put("msg","");
    }

    public ReturnDataMap(boolean success,String msg){
        this.put("success",success);
        this.put("msg",msg);
    }

    /**
     * 初始化自定义 HashMap 对象
     * @param success 返回结果
     * @param msg 返回消息
     * @param key 参数名称
     * @param value 参数值
     * @author qixin
     */
    public ReturnDataMap(boolean success,String msg,String key,boolean value){
        this.put("success",success);
        this.put("msg",msg);
        this.put(key,value);
    }
}

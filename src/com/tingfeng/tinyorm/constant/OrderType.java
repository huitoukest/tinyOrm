package com.tingfeng.tinyorm.constant;
/**
 * 排序的关键字
 * OrderType
 * @author wanggang-1
 * @version 1.0
 *
 */
public enum OrderType {
    NULL(""),ASC("asc"),DESC("desc");
    private String value="";
    
    private OrderType(String va){
        this.value=va;
    }
    
    public String getJoinTypeString(){
        return this.value;
    }
}

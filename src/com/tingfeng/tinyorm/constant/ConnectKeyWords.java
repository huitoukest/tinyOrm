package com.tingfeng.tinyorm.constant;
/**
 * sql中的连接关键字
 * ConnectKeyWords
 * @version 1.0
 *
 */
public enum ConnectKeyWords {
    NULL("",100),SELECT("select",1),FROM("from",2),
    JOIN("join",3),ON("on",4),GROUPBY("group by",5),
    HAVING("having",6),WHERE("where",7),ORDERBY("order by",8),
    LIMIT("limit",9),OFFSET("offset",10)
    ;
    /**
     * 名称
     */
    private String value="";
    /**
     * 顺序,默认100表示顺序最低
     */
    private int orderValue=100;
    
    private ConnectKeyWords(String va,int orderValue){
        this.value=va;
        this.orderValue=orderValue;
    }
    
    public String getConnectKeyWords(){
        return this.value;
    }
    public int getOrderValue(){
        return this.orderValue;
    }
}

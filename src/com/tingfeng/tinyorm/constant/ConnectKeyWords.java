package com.tingfeng.tinyorm.constant;

public enum ConnectKeyWords {
    NULL(""),SELECT("select"),FROM("from"),JOIN("join"),WHERE("where"),
    GROUPBY("group by"),ORDERBY("order by"),LIMIT("limit")
    ;
    private String value="";
    
    private ConnectKeyWords(String va){
        this.value=va;
    }
    
    public String getConnectKeyWords(){
        return this.value;
    }
}

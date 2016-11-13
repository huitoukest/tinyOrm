package com.tingfeng.tinyorm.sql;

import com.tingfeng.tinyorm.constant.ConnectKeyWords;

import java.io.Serializable;
import com.tingfeng.tinyorm.constant.ConnectType;
import java.util.ArrayList;
import java.util.List;

public abstract class ASqlString<T> implements Serializable,ISqlString<T>{
    /**
     *默认序列号
     */
    private static final long serialVersionUID = 1L;
    
    protected List<T> sqlList=null;
    
    protected List<Object> paramsList=null;
    
    protected List<ConnectType> connectTypes=null;   
    
    public ASqlString(){
        
    }   
    /**
     *初始化方法 
     */
    public void init() {
        if(this.sqlList==null)
        {
            this.sqlList=new ArrayList<T>(5);
        }
        if(paramsList==null){
            this.paramsList=new ArrayList<Object>(5);
        }
        if(connectTypes==null){
            this.connectTypes=new ArrayList<ConnectType>(3);
        }
    }
    /**
     * 返回默认的连接类型
     * @return
     */
    public abstract ConnectType getDefaultConnectType();
    /**
     * 返回当前的链接关键字
     * @return
     */
    public abstract ConnectKeyWords getConnectKeyWords();
    
    /**
     * 加入相关sql
     * @param sqlString 
     * @param connectType 和之前sql/条件的连接类型,默认为NULL连接类型
     * @param param 参数的值,默认为无参数
     * @return
     */
    public ASqlString<T> add(T sqlString,ConnectType connectType,Object param){
        this.init();
        this.sqlList.add(sqlString);
        if(connectType==null)
        {
            connectType=getDefaultConnectType();
        }
        this.connectTypes.add(connectType);
        if(param!=null){
            this.paramsList.add(param);
        }
        return this;
    }
    
    public ASqlString<T> add(T sqlString,ConnectType connectType){
        return this.add(sqlString,connectType,null);
    }
    public ASqlString<T> add(T sqlString,Object param){
        return this.add(sqlString,null,param);
    }

    public ASqlString<T> add(T sqlString){
        return this.add(sqlString,null,null);
    }
      
     /**
     * 
     * @param SqlString
     * @param sb 在StringBuilder后附加连接和条件,默认会忽略离连接关键字(如where)最近的第一个条件的ConnectType
     * @return
     */
    public String getSqlString(StringBuilder sb){
        List<T> sList=this.getSqlList();
        StringBuilder sBuilder=null;
        if(sList==null||sList.isEmpty()){
            return "";
        }
        if(sb==null){
           sBuilder=new StringBuilder();
        }else{
            sBuilder=sb;
        }
        for(int i=0;i<sList.size();i++){
            if(i==0)
            {   sBuilder.append(" ");
                sBuilder.append(this.getConnectKeyWords().getConnectKeyWords());
                sBuilder.append(" ");
            }
            if(i>0)
            {    
                 sBuilder.append(this.getConnectTypes().get(i).getJoinTypeString());
                 sBuilder.append(" ");
            }
                 sBuilder.append(sList.get(i));
            if(i==sList.size()){
               
            }
        }
        return sBuilder.toString();
    }
    /**
     * 返回SqlString
     * @return
     */
    public String getSqlString(){
        return  this.getSqlString(null);
    }



    public List<T> getSqlList() {
        return sqlList;
    }
    public void setSqlList(List<T> sqlList) {
        this.sqlList = sqlList;
    }
    public List<Object> getParamsList() {
        return paramsList;
    }

    public void setParamsList(List<Object> paramsList) {
        this.paramsList = paramsList;
    }

    public List<ConnectType> getConnectTypes() {
        return connectTypes;
    }

    public void setConnectTypes(List<ConnectType> connectTypes) {
        this.connectTypes = connectTypes;
    }
    
}

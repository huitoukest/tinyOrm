package com.tingfeng.tinyorm.sql;

import java.io.Serializable;

import com.tingfeng.tinyorm.constant.ConnectType;
import java.util.ArrayList;
import java.util.List;

public abstract class ASqlString implements Serializable{
    /**
     *默认序列号
     */
    private static final long serialVersionUID = 1L;
    
    protected List<String> sqlList=null;
    
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
            this.sqlList=new ArrayList<String>(5);
        }
        if(paramsList==null){
            this.paramsList=new ArrayList<Object>(5);
        }
        if(connectTypes==null){
            this.connectTypes=new ArrayList<ConnectType>();
        }
    }
    /**
     * 返回默认的连接类型
     * @return
     */
    public abstract ConnectType getDefaultConnectType();
    
    /**
     * 加入相关sql
     * @param sqlString 
     * @param connectType 和之前sql/条件的连接类型,默认为NULL连接类型
     * @param param 参数的值,默认为无参数
     * @return
     */
    public ASqlString add(String sqlString,ConnectType connectType,Object param){
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
    
    public void add(String sqlString,ConnectType connectType){
        this.add(sqlString,connectType,null);
    }
    
    public void add(String sqlString,Object param){
        this.add(sqlString,null,param);
    }
    
    public void add(String sqlString){
        this.add(sqlString,null,null);
    }
      
     /**
     * 
     * @param whereString
     * @param sb 在StringBuilder后附加where条件
     * @return
     */
    public String getSqlString(StringBuilder sb){
        List<String> whereList=this;
        StringBuilder sBuilder=null;
        if(whereList==null||whereList.isEmpty()){
            return "";
        }
        if(sb==null){
           sBuilder=new StringBuilder();
        }else{
            sBuilder=sb;
        }
        for(int i=0;i<whereList.size();i++){
            if(i==0)
            sBuilder.append(" where ");
             if(i>0)
                 sBuilder.append(" and ");
            sBuilder.append(whereList.get(i));
            if(i==whereList.size()){
                sBuilder.append(" ");
            }
        }
        return sBuilder.toString();
    }
    /**
     * 返回每一个where条件;
     * @param whereString
     * @return
     */
    public String getSqlString(){
        return  this.getSqlString(null);
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

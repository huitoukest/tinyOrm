package com.tingfeng.tinyorm.sql.impl;

import java.util.ArrayList;
import java.util.List;

import util.tingfeng.java.base.common.utils.LogUtils;

public class TableSql {
	
	private Class<?> cls=null;
	private String alies="";
	private String tableName=null;
	private  JoinCondition joinCondition=null;
	private List<Object> params=null;
	
	public TableSql(Class<?> cls,String alies){
		this.cls=cls;
		this.tableName=cls.getSimpleName();
		this.alies=alies;
		this.params=new ArrayList<Object>();
	}
	public TableSql(String table,String alies){		
		this.tableName=table;
		this.alies=alies;
		this.params=new ArrayList<Object>();
	}

	public Class<?> getCls() {
		return cls;
	}
	public void setCls(Class<?> cls) {
		this.cls = cls;
	}
	public String getAlies() {
		return alies;
	}
	public void setAlies(String alies) {
		this.alies = alies;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public JoinCondition getJoinCondition() {
		return joinCondition;
	}
	public void setJoinCondition(JoinCondition joinCondition) {
		this.joinCondition = joinCondition;
	}
    public List<Object> getParams() {
        try{
            if(this.joinCondition!=null){
                params.addAll(this.joinCondition.getJoinTable().getParams());
                params.addAll(this.joinCondition.getParamsList());
            }           
        }catch (Exception e) {
            LogUtils.error(getClass(),e);
        }
        return params;
    }
    public void setParams(List<Object> params) {
        this.params = params;
    }	
    
    public String getSqlString(){
        StringBuilder sBuilder=new StringBuilder();
            sBuilder.append(this.getTableName());
            sBuilder.append(" AS ");
            sBuilder.append(this.getAlies());
            if(null!=this.getJoinCondition()){
                JoinCondition jCondition=this.getJoinCondition();
                sBuilder.append(" ");     
                sBuilder.append(jCondition.getJoinType());
                sBuilder.append(" JOIN ");  
                /*sBuilder.append(jCondition.getJoinTable().getTableName());
                sBuilder.append(" ");
                sBuilder.append(jCondition.getJoinTable().getAlies());*/
                String joinSql=jCondition.getSqlString();
                sBuilder.append(joinSql);
            }
        return sBuilder.toString();
    }
}

package com.tingfeng.tinyorm.sql.impl;

import java.util.ArrayList;
import java.util.List;

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
        return params;
    }
    public void setParams(List<Object> params) {
        this.params = params;
    }	
}

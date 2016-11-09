package com.tingfeng.tinyorm.sql.impl;

public class TableSql {
	
	public static TableSql getDbTableByQuery(QuerySql querySql){
		
		return new TableSql("("+querySql.getQueryString()+")","");
	}
	public static TableSql getDbTableByQuery(QuerySql querySql,String aliesName){
		
		return new TableSql("("+querySql.getQueryString()+")",aliesName);
	}
	
	private Class<?> cls=null;
	private String alies="";
	private String tableName=null;
	private  JoinCondition joinCondition=null;
	
	public TableSql(Class<?> cls,String alies){
		this.cls=cls;
		this.tableName=cls.getSimpleName();
		this.alies=alies;
	}
	public TableSql(String table,String alies){		
		this.tableName=table;
		this.alies=alies;
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
	
	
}

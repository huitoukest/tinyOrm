package com.tingfeng.tinyorm.sql.impl;

public class DbTable {
	
	public static DbTable getDbTableByQuery(Query query){
		
		return new DbTable("("+query.getQueryString()+")","");
	}
	public static DbTable getDbTableByQuery(Query query,String aliesName){
		
		return new DbTable("("+query.getQueryString()+")",aliesName);
	}
	
	private Class<?> cls=null;
	private String alies="";
	private String tableName=null;
	private  JoinCondition joinCondition=null;
	
	public DbTable(Class<?> cls,String alies){
		this.cls=cls;
		this.tableName=cls.getSimpleName();
		this.alies=alies;
	}
	public DbTable(String table,String alies){		
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

package com.tingfeng.tinyorm.sql.impl;

import com.tingfeng.tinyorm.constant.JoinType;

import java.util.ArrayList;
import java.util.List;

public class JoinCondition extends ArrayList<String> {
	private DbTable joinTable=null;
	private JoinType joinType=null;
	
	public List<Object> paramsList=new ArrayList<Object>();
	
	public JoinCondition(DbTable table,JoinType joinType){
		this.joinTable=table;
		this.joinType=joinType;
	}
	
	public void add(String whereString,Object params){
		this.add(whereString);
		this.paramsList.add(params);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 /**
     * 
     * @param whereString
     * @param sb 鍦⊿tringBuilder鍚庨檮鍔爓here鏉′欢
     * @return
     */
	public String getWhereString(StringBuilder sb){
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
			sBuilder.append(" on ");
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
	 * 杩斿洖姣忎竴涓獁here鏉′欢;
	 * @param whereString
	 * @return
	 */
	public String getWhereString(){
		return 	this.getWhereString(null);
	}
	public List<Object> getParamsList() {
		return paramsList;
	}
	public void setParamsList(List<Object> paramsList) {
		this.paramsList = paramsList;
	}	
	
	public DbTable getJoinTable() {
		return joinTable;
	}
	public void setJoinTable(DbTable joinTable) {
		this.joinTable = joinTable;
	}
	public JoinType getJoinType() {
		return joinType;
	}
	public void setJoinType(JoinType joinType) {
		this.joinType = joinType;
	}
}

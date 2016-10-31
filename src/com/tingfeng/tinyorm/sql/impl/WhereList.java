package com.tingfeng.tinyorm.sql.impl;

import com.tingfeng.tinyorm.constant.ConnectType;

import java.util.ArrayList;
import java.util.List;

public class WhereList extends ArrayList<String> {
	
	public List<Object> paramsList=new ArrayList<Object>();
	private List<ConnectType> connectTypes=new ArrayList<ConnectType>();
	
	public boolean add(String whereString){
		this.add(whereString);
		this.connectTypes.add(ConnectType.AND);
		return true;
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
     * @param sb 在StringBuilder后附加where条件
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
	public String getWhereString(){
		return 	this.getWhereString(null);
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

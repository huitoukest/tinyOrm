package com.tingfeng.tinyorm.sql.impl;

import java.util.ArrayList;
import java.util.List;

public class GroupByList extends ArrayList<String> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public String getGroupString(StringBuilder sb){
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
			sBuilder.append(" group by ");
			 if(i>0)
				 sBuilder.append(" , ");
			sBuilder.append(whereList.get(i));
			if(i==whereList.size()){
				sBuilder.append(" ");
			}
		}
		return sBuilder.toString();
	}

	public String getGroupString(){
		return 	this.getGroupString(null);
	}
	
}

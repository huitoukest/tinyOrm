package com.tingfeng.tinyorm.sql.impl;

import java.util.ArrayList;
import java.util.List;

public class DbTables extends ArrayList<DbTable>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getDbTablesString(StringBuilder sb){
		List<DbTable> whereList=this;
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
			 if(i>0)
				 sBuilder.append(" , ");
			
			sBuilder.append(whereList.get(i).getTableName());
			sBuilder.append(" AS ");
			sBuilder.append(whereList.get(i).getAlies());
			
			if(i==whereList.size()){
				sBuilder.append(" ");
			}
		}
		return sBuilder.toString();
	}

	public String getDbTablesString(){
		return 	this.getDbTablesString(null);
	}
}

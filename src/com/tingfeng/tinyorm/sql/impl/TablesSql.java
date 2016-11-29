package com.tingfeng.tinyorm.sql.impl;

import com.tingfeng.tinyorm.constant.ConnectKeyWords;
import com.tingfeng.tinyorm.constant.ConnectType;

import com.tingfeng.tinyorm.sql.ASqlString;
import java.util.ArrayList;
import java.util.List;

public class TablesSql extends ASqlString<TableSql>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
    public String getSqlString(StringBuilder sb) {
	    List<TableSql> whereList=this.getSqlList();
        StringBuilder sBuilder=null;
        if(whereList==null||whereList.isEmpty()){
            return "";
        }
        if(sb==null){
           sBuilder=new StringBuilder();
        }else{
            sBuilder=sb;
        }
        if(!whereList.isEmpty()){
            sBuilder.append(" ");
            sBuilder.append(this.getConnectKeyWords());
            sBuilder.append(" ");
        }
        for(int i=0;i<whereList.size();i++){
            TableSql tableSql=whereList.get(i);
             if(i>0)
                 {
                     sBuilder.append(" , ");             
                 }
            sBuilder.append(tableSql.getSqlString());
            if(i==whereList.size()){
                sBuilder.append(" ");
            }
        }
        return sBuilder.toString();
    }

	
	
    @Override
    public List<Object> getParamsList() {
        if(this.paramsList!=null){
            this.paramsList.clear();
        }else{
            this.paramsList=new ArrayList<Object>();
        }
        List<TableSql> whereList=this.getSqlList();
        for(TableSql tab:whereList){
            this.paramsList.addAll(tab.getParams());
        }
        return this.paramsList;
    }



    @Override
    public String getSqlString() {
        return  this.getSqlString(null);
    }

    @Override
    public ConnectType getDefaultConnectType() {
        return ConnectType.COMMA;
    }

    @Override
    public ConnectKeyWords getConnectKeyWords() {
        return ConnectKeyWords.FROM;
    }
}

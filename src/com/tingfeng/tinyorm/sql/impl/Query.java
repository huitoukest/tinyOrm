package com.tingfeng.tinyorm.sql.impl;

import java.util.List;

public class Query {
	private StringBuilder sb=new StringBuilder(500);
    
	private DbTables tables=null;
    private ColumList colums=null;
	private WhereList whereList=null;
	private OrderByList orderByList=null;
	private GroupByList groupByList=null;
	
	public void setFromTables(DbTables tables){
		   this.tables=tables;
	}
	/**
	 * @param colums
	 */
	public void setColums(ColumList colums){
		this.colums=colums;
	}
	
	
	
		
	public List<DbTable> getTables() {
		return tables;
	}
	public void setTables(DbTables tables) {
		this.tables = tables;
	}
	public WhereList getWhereList() {
		return whereList;
	}
	public void setWhereList(WhereList whereList) {
		this.whereList = whereList;
	}
	public ColumList getColums() {
		return colums;
	}
	
	
	
	public OrderByList getOrderByList() {
		return orderByList;
	}
	public void setOrderByList(OrderByList orderByList) {
		this.orderByList = orderByList;
	}
	public GroupByList getGroupByList() {
		return groupByList;
	}
	public void setGroupByList(GroupByList groupByList) {
		this.groupByList = groupByList;
	}
	
	public String getQueryString() {
		sb.setLength(0);
		sb.append("select ");
		colums.getColumString(sb);
		sb.append(" from ");
		tables.getDbTablesString(sb);
		if(null!=whereList)
			{
				whereList.getWhereString(sb);
			}
		if(null!=orderByList)
			{
				orderByList.getOrderString(sb);
			}
		if(null!=groupByList){
				groupByList.getGroupString(sb);
		}
		
		return sb.toString();
	}	
	
	public void printFormateString(){
		sb.setLength(0);
		sb.append("select ");
		sb.append("\n");
		colums.getColumString(sb);
		sb.append("\n");
		sb.append(" from ");
		sb.append("\n");
		tables.getDbTablesString(sb);
		sb.append("\n");
		if(null!=whereList)
			{
				whereList.getWhereString(sb);
				sb.append("\n");
			}
		if(null!=orderByList)
			{
				orderByList.getOrderString(sb);
				sb.append("\n");
			}
		if(null!=groupByList){
				groupByList.getGroupString(sb);
				sb.append("\n");
		}
		
		System.out.println(sb.toString());
		System.out.println("params:");
		if(null!=whereList){
			for(int i=0;i<whereList.getParamsList().size();i++){
				if(i>0)
					System.out.print(",");
				Object object=whereList.getParamsList().get(i);
				System.out.print(object.toString());
			}
			System.out.println();
		}
	}
}

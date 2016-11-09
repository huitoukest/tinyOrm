package com.tingfeng.tinyorm.sql.impl;

import com.tingfeng.tinyorm.sql.ISqlString;
import java.util.ArrayList;
import java.util.List;

public class QuerySql {
	private StringBuilder sb=new StringBuilder(500);
    
	private ColumSql colums=null;
	private TablesSql tables=null;
	private GroupBySql groupBySql=null;
	private HavingSql havingSql=null;
	private WhereSql whereSql=null;
	private OrderBySql orderBySql=null;	
	private LimitSql limitSql=null;
	
	public void setFromTables(TablesSql tables){
		   this.tables=tables;
	}
	/**
	 * @param colums
	 */
	public void setColums(ColumSql colums){
		this.colums=colums;
	}
		
	public StringBuilder getSb() {
        return sb;
    }
    public void setSb(StringBuilder sb) {
        this.sb = sb;
    }
    public GroupBySql getGroupBySql() {
        return groupBySql;
    }
    public void setGroupBySql(GroupBySql groupBySql) {
        this.groupBySql = groupBySql;
    }
    public HavingSql getHavingSql() {
        return havingSql;
    }
    public void setHavingSql(HavingSql havingSql) {
        this.havingSql = havingSql;
    }
    public WhereSql getWhereSql() {
        return whereSql;
    }
    public void setWhereSql(WhereSql whereSql) {
        this.whereSql = whereSql;
    }
    public OrderBySql getOrderBySql() {
        return orderBySql;
    }
    public void setOrderBySql(OrderBySql orderBySql) {
        this.orderBySql = orderBySql;
    }
    public LimitSql getLimitSql() {
        return limitSql;
    }
    public void setLimitSql(LimitSql limitSql) {
        this.limitSql = limitSql;
    }
    public TablesSql getTables() {
		return tables;
	}
	public void setTables(TablesSql tables) {
		this.tables = tables;
	}
	public WhereSql getWhereList() {
		return whereSql;
	}
	public void setWhereList(WhereSql whereSql) {
		this.whereSql = whereSql;
	}
	public ColumSql getColums() {
		return colums;
	}
	
	public OrderBySql getOrderByList() {
		return orderBySql;
	}
	public void setOrderByList(OrderBySql orderBySql) {
		this.orderBySql = orderBySql;
	}
	public GroupBySql getGroupByList() {
		return groupBySql;
	}
	public void setGroupByList(GroupBySql groupBySql) {
		this.groupBySql = groupBySql;
	}
	/**
	 * 返回有顺序的ISqlString的List
	 * @return
	 */
	public List<ISqlString<?>> getSqlList(){
	    List<ISqlString<?>> sqlList=new ArrayList<ISqlString<?>>();
	    this.addNotNullISqlString(sqlList,colums);
	    this.addNotNullISqlString(sqlList,tables);
	    this.addNotNullISqlString(sqlList,groupBySql);
	    this.addNotNullISqlString(sqlList,havingSql);
	    this.addNotNullISqlString(sqlList,whereSql);
	    this.addNotNullISqlString(sqlList,orderBySql);
	    this.addNotNullISqlString(sqlList,limitSql);
	    return sqlList;
	}
	/**
	 * 将sqlString为非空的加入sqlList中
	 * @param sqlList
	 * @param sqlString
	 */
	protected void addNotNullISqlString(List<ISqlString<?>> sqlList,ISqlString<?> sqlString){
	    if(null!=sqlString){
	        sqlList.add(sqlString);
	    }
	}
	
	public String getQueryString() {
		sb.setLength(0);
		List<ISqlString<?>> sqlList=this.getSqlList();
		for(int i=0;i<sqlList.size();i++)
		{
		    ISqlString<?> sqlString=sqlList.get(i);
		    sb.append(sqlString.getSqlString(sb));
		}
		return sb.toString();
	}
	
	public void printFormateString(){
        List<ISqlString<?>> sqlList=this.getSqlList();
        for(int i=0;i<sqlList.size();i++)
        {
            ISqlString<?> sqlString=sqlList.get(i);
            System.out.print(sqlString.getSqlString()+"\t");
            this.printParams(sqlString);
            System.out.println();
           
        }	  
	}
	
	/**
	 * 参数打印
	 */
	protected void printParams(ISqlString<?> sqlString){
	    System.out.print("params:");
        if(null!=sqlString){
            for(int i=0;i<sqlString.getParamsList().size();i++){
                if(i>0)
                    System.out.print(",");
                Object object=sqlString.getParamsList().get(i);
                System.out.print(object.toString());
            }
        }
	}
}

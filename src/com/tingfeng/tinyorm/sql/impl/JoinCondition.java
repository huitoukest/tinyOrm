package com.tingfeng.tinyorm.sql.impl;

import com.tingfeng.tinyorm.constant.ConnectKeyWords;
import com.tingfeng.tinyorm.constant.ConnectType;
import com.tingfeng.tinyorm.sql.ASqlString;
import com.tingfeng.tinyorm.constant.JoinType;

public class JoinCondition extends ASqlString<String>{
    private static final long serialVersionUID = 1L;
	private TableSql joinTable=null;
	private JoinType joinType=null;
		
	public JoinCondition(TableSql table,JoinType joinType){
		this.joinTable=table;
		this.joinType=joinType;
	}
	@Override
	public ConnectType getDefaultConnectType() {
        return ConnectType.AND;
    }

    @Override
    public ConnectKeyWords getConnectKeyWords() {
        return ConnectKeyWords.ON;
    }
    public TableSql getJoinTable() {
        return joinTable;
    }
    public void setJoinTable(TableSql joinTable) {
        this.joinTable = joinTable;
    }
    public JoinType getJoinType() {
        return joinType;
    }
    public void setJoinType(JoinType joinType) {
        this.joinType = joinType;
    }
    
    
}

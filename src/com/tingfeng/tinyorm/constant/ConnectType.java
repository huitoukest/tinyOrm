package com.tingfeng.tinyorm.constant;
/**
 * sql中条件连接的关键字
 * ConnectKeyWords
 * @version 1.0
 *
 */
public enum ConnectType {
	AND("and"),OR("or"),NOT("not"),NULL(""),COMMA(",");
	private String value="and";
	
	private ConnectType(String va){
		this.value=va;
	}
	
	public String getJoinTypeString(){
		return this.value;
	}
}

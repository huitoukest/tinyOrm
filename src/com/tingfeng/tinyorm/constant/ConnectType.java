package com.tingfeng.tinyorm.constant;

public enum ConnectType {
	AND("and"),OR("or"),NOT("not"),NULL("");
	private String value="and";
	
	private ConnectType(String va){
		this.value=va;
	}
	
	public String getJoinTypeString(){
		return this.value;
	}
}

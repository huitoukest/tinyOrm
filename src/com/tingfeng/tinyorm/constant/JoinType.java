package com.tingfeng.tinyorm.constant;

public enum JoinType {
	INNER(" inner "),OUTTER(" full outter "),LEFT(" left "),RIGHT(" right ");
	private String value="inner";
	
	private JoinType(String va){
		this.value=va;
	}
	
	public String getJoinTypeString(){
		return this.value;
	}
}

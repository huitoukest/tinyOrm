package com.tingfeng.tinyorm.constant;

/**
 * sql中的join连接类型关键字
 * ConnectKeyWords
 * @version 1.0
 *
 */
public enum JoinType {
	INNER(" inner "),OUTTER(" full outter "),LEFT(" left "),RIGHT(" right ");
	private String value="inner";
	private final static String JOIN=" join";
	private JoinType(String va){
		this.value=va;
	}
	
	public String getJoinTypeString(){
		return this.value;
	}
	public String getJoinString(){
	    return JOIN+this.value;
	}
}

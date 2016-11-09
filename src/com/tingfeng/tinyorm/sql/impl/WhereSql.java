package com.tingfeng.tinyorm.sql.impl;

import com.tingfeng.tinyorm.constant.ConnectKeyWords;

import com.tingfeng.tinyorm.sql.ASqlString;
import com.tingfeng.tinyorm.constant.ConnectType;

public class WhereSql extends ASqlString<String>{
    private static final long serialVersionUID = 1L;

    @Override
    public ConnectType getDefaultConnectType() {
        return ConnectType.AND;
    }

    @Override
    public ConnectKeyWords getConnectKeyWords() {
        return ConnectKeyWords.WHERE;
    }
	
}

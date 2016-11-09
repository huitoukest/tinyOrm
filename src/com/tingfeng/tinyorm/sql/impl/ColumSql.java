package com.tingfeng.tinyorm.sql.impl;

import com.tingfeng.tinyorm.constant.ConnectKeyWords;
import com.tingfeng.tinyorm.constant.ConnectType;
import com.tingfeng.tinyorm.sql.ASqlString;

public class ColumSql extends ASqlString<String>{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public ConnectType getDefaultConnectType() {
       return ConnectType.COMMA;
    }

    @Override
    public ConnectKeyWords getConnectKeyWords() {
        return ConnectKeyWords.SELECT;
    }
	
}

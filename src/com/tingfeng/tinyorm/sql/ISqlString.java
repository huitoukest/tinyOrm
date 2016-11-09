package com.tingfeng.tinyorm.sql;

import com.tingfeng.tinyorm.constant.ConnectKeyWords;
import com.tingfeng.tinyorm.constant.ConnectType;
import java.util.List;

/**
 * 定义sqlString链接具有的基本方法
 * ISqlString
 * @author wanggang-1
 * @version 1.0
 *
 */
public interface ISqlString<T> {
    
    /**
     * 返回默认的连接类型
     * @return
     */
    public ConnectType getDefaultConnectType();
    /**
     * 返回当前的链接关键字
     * @return
     */
    public ConnectKeyWords getConnectKeyWords();
    
    
    /**
     * 加入sql对象和参数
     * @param sqlObj
     * @param param
     * @return
     */
    public ISqlString<T> add(T sqlObj,Object param);
    /**
     * 加入sql对象,默认没有参数
     * @param sqlObj
     * @return
     */
    public ISqlString<T> add(T sqlObj);
    /**
     * 获取提交的参数
     * @return
     */
    public List<Object> getParamsList();
     /**
     * 
     * @param sb 在StringBuilder后附加sql条件
     * @return
     */
    public String getSqlString(StringBuilder sb);
    /**
     * 返回处理后的sql语句
     * @return
     */
    public String getSqlString();
}

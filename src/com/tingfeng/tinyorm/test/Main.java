package com.tingfeng.tinyorm.test;

import com.tingfeng.tinyorm.constant.JoinType;

import com.tingfeng.tinyorm.sql.impl.ColumSql;
import com.tingfeng.tinyorm.sql.impl.TableSql;
import com.tingfeng.tinyorm.sql.impl.TablesSql;
import com.tingfeng.tinyorm.sql.impl.JoinCondition;
import com.tingfeng.tinyorm.sql.impl.OrderBySql;
import com.tingfeng.tinyorm.sql.impl.QuerySql;
import com.tingfeng.tinyorm.sql.impl.WhereSql;
import com.tingfeng.tinyorm.test.bean.Book;
import com.tingfeng.tinyorm.test.bean.User;
import java.math.BigDecimal;
//import util.tingfeng.java.base.database.common.SqlFormatUtils;

public class Main { 
    public static void main(String[] args){ 
        testQuery();
    }
  public static void testQuery(){
      QuerySql querySql=new QuerySql();
      querySql.setColums(null);
                  
      TablesSql tables=new TablesSql();
      TableSql ta=new TableSql(User.class,"user");
      TableSql tb=new TableSql(Book.class,"book");
      JoinCondition joinCondition=new JoinCondition(tb, JoinType.RIGHT);
                    joinCondition.add("user.userName!=?","张大叔");
                    joinCondition.add("user.userName!=?","王大叔");
      ta.setJoinCondition(joinCondition);
      tables.add(ta);
              
      ColumSql colums=new ColumSql();
      colums.add("user.userName");
      colums.add("book.bookName");
      colums.add("book.author");
      
      
      WhereSql whereSql=new WhereSql();
                whereSql.add("user.userName=book.author");
                whereSql.add("user.userName=?","王大叔");
      OrderBySql orderBySql=new OrderBySql();
                orderBySql.add("user.userName");
     
     querySql.setColums(colums);    
     querySql.setTables(tables);
     querySql.setWhereList(whereSql);
     querySql.setOrderByList(orderBySql);
     
      QuerySql queryB=new QuerySql();
               TableSql tableb=querySql.toTableSql(" ta");
               TablesSql tablebs=new TablesSql();
               tablebs.add(tableb);
               ColumSql columSql=new ColumSql();
               columSql.add("ta.userName");
       queryB.setTables(tablebs);
       queryB.setColums(columSql);
       
      System.out.println(queryB.getQueryString());
      System.out.println();
      //System.out.println(new SqlFormatUtils().format(queryB.getQueryString()));
      //SqlFormatUtils.printFormatSql(queryB.getQueryString());
      queryB.printAllParams();
  }
    public static void test01(){
        Double d=12546351234165.12569874d;
        System.out.println(d);
        BigDecimal b=new BigDecimal(d.toString());
        System.out.println(b);
    }
}

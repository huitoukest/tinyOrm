package com.tingfeng.tinyorm.test;

import com.tingfeng.tinyorm.sql.impl.ColumList;
import com.tingfeng.tinyorm.sql.impl.DbTable;
import com.tingfeng.tinyorm.sql.impl.DbTables;
import com.tingfeng.tinyorm.sql.impl.JoinCondition;
import com.tingfeng.tinyorm.sql.impl.OrderByList;
import com.tingfeng.tinyorm.sql.impl.Query;
import com.tingfeng.tinyorm.sql.impl.WhereList;

import com.tingfeng.tinyorm.test.bean.Book;
import com.tingfeng.tinyorm.test.bean.User;
import java.math.BigDecimal;

public class Main {	
	public static void main(String[] args){
	    //test01();	
	    testQuery();
	}
  public static void testQuery(){
      Query query=new Query();
      query.setColums(null);
                  
      DbTables tables=new DbTables();
      DbTable ta=new DbTable(User.class,"user");
      DbTable tb=new DbTable(Book.class,"book");
      JoinCondition joinCondition=new JoinCondition(tb, JoinType.right);
      				joinCondition.add("user.userName!=?","李大�?");
      				joinCondition.add("user.userName!=?","李大�?");
      ta.setJoinCondition(joinCondition);
      tables.add(ta);
              
      ColumList colums=new ColumList();
      colums.add("user.userName");
      colums.add("book.bookName");
      colums.add("book.author");
      
      
      WhereList whereList=new WhereList();
                whereList.add("user.userName=book.author");
                whereList.add("user.userName=?","王大�?");
      OrderByList orderByList=new OrderByList();
      			orderByList.add("user.userName");
     
     query.setColums(colums); 	
     query.setFromTables(tables);
     query.setWhereList(whereList);
     query.setOrderByList(orderByList);
     
      
      
      System.out.println(query.getQueryString());
      System.out.println();
      query.printFormateString();
  }
	public static void test01(){
	    Double d=12546351234165.12569874d;
	    System.out.println(d);
	    BigDecimal b=new BigDecimal(d.toString());
	    System.out.println(b);
	}
}

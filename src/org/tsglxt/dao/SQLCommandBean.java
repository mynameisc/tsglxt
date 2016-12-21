package org.tsglxt.dao;
import java.util.*;
import java.sql.*;
import javax.servlet.jsp.jstl.sql.*;

import org.apache.taglibs.standard.lang.jstl.ValueSuffix;
import org.omg.CORBA.PRIVATE_MEMBER;

 
public class SQLCommandBean {
	private Connection conn;
	private String sqlValue;
	private List values;
	public void setConn(Connection conn) {
		this.conn = conn;
	}//设置连接类
	public void setSqlValue(String sqlValue) {
		this.sqlValue = sqlValue;
	}//设置sql语句
	public void setValues(List values) {
		this.values = values;
	}//设置sql语句参数
//执行查询语句	
	public Result executeQuery() throws SQLException {
		Result result=null;
		ResultSet rs=null; 
		PreparedStatement ps=null;
		Statement st=null;
		try{
			if(values!=null&&values.size()>0)
			{
				ps=conn.prepareStatement(sqlValue);//写入sql语句
				setValues(ps,values);
				rs=ps.executeQuery();
			}else {
				st=conn.createStatement();
				rs=st.executeQuery(sqlValue);//执行语句
			}
				result=ResultSupport.toResult(rs);
			
		}finally
		{
			if(rs!=null){rs.close();}
			if(st!=null){st.close();}
			if(ps!=null){ps.close();}
		}

		return result;
		
	}
//执行update语句	
	public int executeUpdate() throws SQLException
	{
		int noOfRows=0;
		ResultSet rs=null;
		PreparedStatement ps=null;
		Statement st=null;
		try{
			if(values!=null&&values.size()>0)
			{
				ps=conn.prepareStatement(sqlValue);
				setValues(ps,values);
				noOfRows=ps.executeUpdate();
			}else
			{
				st=conn.createStatement();
				noOfRows=st.executeUpdate(sqlValue);
			}
			
		}finally
		{
			if(rs!=null){rs.close();}
			if(st!=null){st.close();}
			if(ps!=null){ps.close();}
		}
		return noOfRows;
	}
	private Void setValues(PreparedStatement ps,List values) throws SQLException
	{
		for (int i = 0; i < values.size(); i++) {
			Object v=values.get(i);
			ps.setObject(i+1, v);
		}
		return null;
		
	}
}

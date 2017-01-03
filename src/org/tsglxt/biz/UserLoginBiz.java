package org.tsglxt.biz;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.jstl.sql.Result;

import org.tsglxt.common.ConnectionManager;
import org.tsglxt.dao.SQLCommandBean;
import org.tsglxt.javebean.Admin;
import org.tsglxt.javebean.Borrower;

public class UserLoginBiz {
	public boolean verify(Borrower borrower)
	{
		boolean valid=false;
		String sql="select id_user,br_password FROM borrower WHERE id_user=? and br_password=?";
		List<String> values=new ArrayList<String>();
		values.add(borrower.getId_user());
		values.add(borrower.getPassword());
		try
		{
			SQLCommandBean sqlCommandBean=new SQLCommandBean();
			sqlCommandBean.setConn(ConnectionManager.getConnection());
			sqlCommandBean.setSqlValue(sql);
			sqlCommandBean.setValues(values);
			Result result=sqlCommandBean.executeQuery();
			if(result!=null&&result.getRowCount()>0)
			{
				
				valid=true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return valid;
		
	}
}

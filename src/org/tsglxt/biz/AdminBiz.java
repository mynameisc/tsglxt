package org.tsglxt.biz;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.jstl.sql.Result;

import org.tsglxt.common.ConnectionManager;
import org.tsglxt.dao.SQLCommandBean;
import org.tsglxt.javebean.Admin;

public class AdminBiz {
	public boolean verify(Admin admin)
	{
		boolean valid=false;
		String sql="select id_admin,pass_word FROM admin WHERE id_admin=? and pass_word=?";
		List<String> values=new ArrayList<String>();
		values.add(admin.getId_admin());
		values.add(admin.getPass_word());
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

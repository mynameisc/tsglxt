package org.tsglxt.biz;

import java.util.ArrayList;
import java.util.List;

import org.tsglxt.common.ConnectionManager;
import org.tsglxt.dao.SQLCommandBean;
import org.tsglxt.javebean.Borrower;

public class AdminUserAddBiz {
	public int  userAdd(Borrower borrower)
	{
		int i=0;
		String sql="insert into borrower(id_user,br_name,br_sex,br_academy,br_password,br_createtime)"
				+ " values(?,?,?,?,?,?);";
		List<String> values=new ArrayList<String>();
		values.add(borrower.getId_user());
		values.add(borrower.getBr_name());
		values.add(borrower.getBr_sex());
		values.add(borrower.getAcademy());
		values.add(borrower.getPassword());
		values.add(borrower.getBr_createtime().toString());
		try {
			SQLCommandBean sqlCommandBean=new SQLCommandBean();
			sqlCommandBean.setConn(ConnectionManager.getConnection());
			sqlCommandBean.setSqlValue(sql);
			sqlCommandBean.setValues(values);
			i=sqlCommandBean.executeUpdate();
			return i;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}
}

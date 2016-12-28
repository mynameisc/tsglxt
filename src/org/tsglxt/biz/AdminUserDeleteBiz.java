package org.tsglxt.biz;

import java.util.ArrayList;
import java.util.List;

import org.tsglxt.common.ConnectionManager;
import org.tsglxt.dao.SQLCommandBean;
import org.tsglxt.javebean.Borrower;

public class AdminUserDeleteBiz {
	public  int userDelete(Borrower borrower){

		int i=0;
		String sql="delete from borrower where id_rfid=?";
		List<String> values=new ArrayList<String>();
		values.add(borrower.getId_rfid());
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

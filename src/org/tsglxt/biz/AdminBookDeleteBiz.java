package org.tsglxt.biz;

import java.util.ArrayList;
import java.util.List;

import org.tsglxt.common.ConnectionManager;
import org.tsglxt.dao.SQLCommandBean;
import org.tsglxt.javebean.Bk_info;

public class AdminBookDeleteBiz {
	public int BookDelete(Bk_info bk_info){
		int i=0;
		String sql="delete from bk_info where bk_rfid=?";
		List<String> values=new ArrayList<String>();
		values.add(bk_info.getBk_rfid());
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

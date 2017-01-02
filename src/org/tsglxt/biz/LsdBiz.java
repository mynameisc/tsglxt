package org.tsglxt.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;

import org.tsglxt.common.ConnectionManager;
import org.tsglxt.dao.SQLCommandBean;
import org.tsglxt.javebean.Lsd;

public class LsdBiz {
	public int addLsdmessage(Lsd lsd){
		int i=0;

			
			String sql="insert into lsd(book_rfid,book_fromid,book_time)"
					+ " values(?,?,?);";
			List<String> values=new ArrayList<String>();
			values.add(lsd.getBook_rfid());
			values.add(lsd.getBooK_fromid());
			values.add(lsd.getBook_time());
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

package org.tsglxt.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;

import org.tsglxt.common.ConnectionManager;
import org.tsglxt.dao.SQLCommandBean;
import org.tsglxt.javebean.Lsd;
import org.tsglxt.javebean.LsdUserInfo;

public class LsdUserinfoBiz {
	public int addLsdmessage(LsdUserInfo lsdUserInfo){
		int i=0;

			
			String sql="insert into lsduserinfo(User_rfid,User_from,User_time)"
					+ " values(?,?,?);";
			List<String> values=new ArrayList<String>();
			values.add(lsdUserInfo.getUser_Rfid());
			values.add(lsdUserInfo.getUser_From());
			values.add(lsdUserInfo.getUser_Time());
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

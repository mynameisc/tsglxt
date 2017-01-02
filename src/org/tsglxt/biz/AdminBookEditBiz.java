package org.tsglxt.biz;

import java.util.ArrayList;
import java.util.List;

import org.tsglxt.common.ConnectionManager;
import org.tsglxt.dao.SQLCommandBean;
import org.tsglxt.javebean.Bk_info;
import org.tsglxt.javebean.Borrower;

public class AdminBookEditBiz {
	public int  BookEdit(Bk_info bk_info)
	{
		int i=0;
		String sql="update bk_info SET bk_name=?,bk_author=?,bk_publish=?,bk_price=?,bk_address=?,bk_amount=?,bk_re_amount=? where bk_rfid=?";
		List<String> values=new ArrayList<String>();
		values.add(bk_info.getBk_name());
		values.add(bk_info.getBk_author());
		values.add(bk_info.getBk_publish());
		values.add(bk_info.getBk_price());
		values.add(bk_info.getBk_address());
		values.add(bk_info.getBk_amount());
		values.add(bk_info.getBk_re_amount());
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

package org.tsglxt.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;

import org.tsglxt.common.ConnectionManager;
import org.tsglxt.dao.SQLCommandBean;
import org.tsglxt.javebean.Bk_info;
import org.tsglxt.javebean.Lsd;

public class AdminbookAddBiz {
	public List<Lsd> get_bookrfid() {

		List<String> values=new ArrayList<String>();
		List<Lsd>  lsd_info=new ArrayList<Lsd>();
		String sql="select book_rfid,book_fromid,book_time from lsd;";
		try
		{
			SQLCommandBean sqlCommandBean=new SQLCommandBean();
			sqlCommandBean.setConn(ConnectionManager.getConnection());
			sqlCommandBean.setSqlValue(sql);
			sqlCommandBean.setValues(values);
			Result result=sqlCommandBean.executeQuery();
			if(result!=null&&result.getRowCount()>0)
			{
		        for(int i=0;i<result.getRowCount();i++){  
		            Map row = result.getRows()[i]; 
		            Lsd lsd=new Lsd();
		            lsd.setBook_rfid((String)row.get("book_rfid"));
		            lsd.setBooK_fromid((String)row.get("book_fromid"));
		            lsd.setBook_time((String)row.get("book_time"));
		            lsd_info.add(lsd);
		        }
		        try {
		            String sql2="DELETE FROM lsd WHERE book_rfid ='"+lsd_info.get(0).getBook_rfid()+"'";
			        sqlCommandBean.setSqlValue(sql2);
			        sqlCommandBean.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
				}
		       
		   
		        
		        return lsd_info;
			}
			
		}
		catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
					e.printStackTrace();
				}
		return lsd_info;
	
		
	}
	public int bookAdd(Bk_info bk_info) {

		int i=0;
		String sql="insert into bk_info(bk_rfid,bk_name,bk_author,bk_publish,bk_price,bk_address,bk_amount,bk_re_amount)"
				+ " values(?,?,?,?,?,?,?,?);";
		List<String> values=new ArrayList<String>();
		values.add(bk_info.getBk_rfid());
		values.add(bk_info.getBk_name());
		values.add(bk_info.getBk_author());
		values.add(bk_info.getBk_publish());
		values.add(bk_info.getBk_price());
		values.add(bk_info.getBk_address());
		values.add(bk_info.getBk_amount());
		values.add(bk_info.getBk_re_amount());
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

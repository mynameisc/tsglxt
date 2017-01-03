package org.tsglxt.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;

import org.tsglxt.common.ConnectionManager;
import org.tsglxt.dao.SQLCommandBean;
import org.tsglxt.javebean.Bk_info;
import org.tsglxt.javebean.Borrower;
import org.tsglxt.javebean.Lsd;

public class UserReadBookBiz {
	public List<Lsd> getBookRfid(String bookMachineid) {
		List<String> values=new ArrayList<String>();
		List<Lsd>  bookrfid_result=new ArrayList<Lsd>();;
		String sql="select book_rfid from lsd where book_fromid=?;";
		values.add(bookMachineid);
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
		            bookrfid_result.add(lsd);
		        }
		        return bookrfid_result;
			}
			
		}
		catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
					e.printStackTrace();
				}
		return bookrfid_result;
	}
	
	
	public List<Bk_info> getBookInfo(String bookrfid) {
		List<String> values=new ArrayList<String>();
		List<Bk_info>  bookinfo_result=new ArrayList<Bk_info>();;
		String sql="select bk_rfid,bk_name,bk_author,bk_publish,bk_address,bk_amount,bk_re_amount from bk_info where bk_rfid=?;";
		values.add(bookrfid);
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
		            Bk_info bk_info=new Bk_info();
		            bk_info.setBk_rfid((String)row.get("bk_rfid"));
		            bk_info.setBk_name((String)row.get("bk_name"));
		            bk_info.setBk_author((String)row.get("bk_author"));
		            bk_info.setBk_publish((String)row.get("bk_publish"));
		            bk_info.setBk_address((String)row.get("bk_address"));
		            bk_info.setBk_amount((String)row.get("bk_amount"));
		            bk_info.setBk_re_amount((String)row.get("bk_re_amount"));
		            bookinfo_result.add(bk_info);
		        }
		        return bookinfo_result;
			}
			
		}
		catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
					e.printStackTrace();
				}
		return bookinfo_result;
	}
}

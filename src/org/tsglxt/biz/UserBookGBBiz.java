package org.tsglxt.biz;


import java.beans.VetoableChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;

import org.tsglxt.common.ConnectionManager;
import org.tsglxt.dao.SQLCommandBean;
import org.tsglxt.javebean.Bk_info;
import org.tsglxt.javebean.Borrow_info;
import org.tsglxt.javebean.Lsd;
import org.tsglxt.seversocket.receive;

public class UserBookGBBiz {
	//根据机器编号 得到book的rfid
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
	
	//更具rfid号得到书名
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
	
	//得到图书的信息
	public List<Borrow_info> getGB_info(String user_id,String book_name)
	{
		List<String> values=new ArrayList<String>();
		List<Borrow_info>  borrowInfo_result=new ArrayList<Borrow_info>();;
		String sql="select id_user,bo_name,bk_name,bo_borrow_time,bo_sgb_time from borrow_info where id_user=? and bk_name=? and bo_gb_time is null;";
		values.add(user_id);
		values.add(book_name);
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
		            Borrow_info borrow_info=new Borrow_info();
		            borrow_info.setId_user((String)row.get("id_user"));
		            borrow_info.setBo_name((String)row.get("bo_name"));
		            borrow_info.setBk_name((String)row.get("bk_name"));
		            borrow_info.setBo_borrow_time((String)row.get("bo_borrow_time"));
		            borrow_info.getBo_sgb_time();
		            borrowInfo_result.add(borrow_info);
		        }
		        return borrowInfo_result;
			}
			
		}
		catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
					e.printStackTrace();
				}
		return borrowInfo_result;
	
	}
	
	
	public int setGBbookTime(Borrow_info borrow_info)
	{
		int i=0;
		String sql="update borrow_info set bo_gb_time=? where id_user=? and bk_name=?";
		List<String> values=new ArrayList<String>();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		String time=simpleDateFormat.format(date);
		values.add(time);
		values.add(borrow_info.getId_user());
		values.add(borrow_info.getBk_name());
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
	
	public boolean add_Reamount(String bk_name)
	{

		List<String> values=new ArrayList<String>();
		List<String> values2=new ArrayList<String>();
		List<Borrow_info>  borrowInfo_result=new ArrayList<Borrow_info>();;
		String sql="select bk_re_amount from bk_info where bk_name=?;";
		String sql2="update bk_info set bk_re_amount=? where bk_name=?;";
		values.add(bk_name);
		try
		{
			SQLCommandBean sqlCommandBean=new SQLCommandBean();
			sqlCommandBean.setConn(ConnectionManager.getConnection());
			sqlCommandBean.setSqlValue(sql);
			sqlCommandBean.setValues(values);
			Result result=sqlCommandBean.executeQuery();

			if(result!=null&&result.getRowCount()>0)
			{
				Map row=result.getRows()[0];
				String reamount=(String)row.get("bk_re_amount");
				int i=Integer.parseInt(reamount);
				i=i+1;
				String newreamount=String.valueOf(i);
				values2.add(newreamount);
				values2.add(bk_name);
				sqlCommandBean.setSqlValue(sql2);
				sqlCommandBean.setValues(values2);
				sqlCommandBean.executeUpdate();//
				return true;
			}
			
		}
		catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
					e.printStackTrace();
		}
	
	
		
		return false;
		}
	
	
	public boolean clearLSD(String bookfromid)
	{

		int i=0;
		String sql="Delete from lsd where book_fromid=?;";
		List<String> values = new ArrayList<String>();
		values.add(bookfromid);
		try {
			SQLCommandBean sqlCommandBean=new SQLCommandBean();
			sqlCommandBean.setConn(ConnectionManager.getConnection());
			sqlCommandBean.setSqlValue(sql);
			sqlCommandBean.setValues(values);
			i=sqlCommandBean.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		return false;
	}
	
}

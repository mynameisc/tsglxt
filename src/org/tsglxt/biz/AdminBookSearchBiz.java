package org.tsglxt.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;

import org.tsglxt.common.ConnectionManager;
import org.tsglxt.dao.SQLCommandBean;
import org.tsglxt.javebean.Bk_info;
import org.tsglxt.javebean.Borrow_info;

public class AdminBookSearchBiz {
	public List<Bk_info> bookname_search(String bookname) {
		List<String> values=new ArrayList<String>();
		List<Bk_info>  book_result=new ArrayList<Bk_info>();;
		String sql="select bk_rfid,bk_name,bk_author,bk_publish,bk_price,bk_address,bk_amount,bk_re_amount from bk_info where bk_name=?;";
		values.add(bookname);
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
		            bk_info.setBk_price((String)row.get("bk_price"));
		            bk_info.setBk_address((String)row.get("bk_address"));      
		            bk_info.setBk_amount((String)row.get("bk_amount"));	
		            bk_info.setBk_re_amount((String)row.get("bk_re_amount"));
		            book_result.add(bk_info);
		        }
		        return book_result;
			}
			
		}
		catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
					e.printStackTrace();
				}
		return book_result;
	}
	
	
	public List<Bk_info> author_search(String author) {
		List<String> values=new ArrayList<String>();
		List<Bk_info>  book_result=new ArrayList<Bk_info>();;
		String sql="select bk_rfid,bk_name,bk_author,bk_publish,bk_price,bk_address,bk_amount,bk_re_amount from bk_info where bk_author=?;";
		values.add(author);
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
		            bk_info.setBk_price((String)row.get("bk_price"));
		            bk_info.setBk_address((String)row.get("bk_address"));      
		            bk_info.setBk_amount((String)row.get("bk_amount"));	
		            bk_info.setBk_re_amount((String)row.get("bk_re_amount"));
		            book_result.add(bk_info);
		        }
		        return book_result;
			}
			
		}
		catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
					e.printStackTrace();
				}
		return book_result;
	}
	
	
	public List<Bk_info> publish_search(String publish) {
		List<String> values=new ArrayList<String>();
		List<Bk_info>  book_result=new ArrayList<Bk_info>();;
		String sql="select bk_rfid,bk_name,bk_author,bk_publish,bk_price,bk_address,bk_amount,bk_re_amount from bk_info where bk_publish=?;";
		values.add(publish);
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
		            bk_info.setBk_price((String)row.get("bk_price"));
		            bk_info.setBk_address((String)row.get("bk_address"));      
		            bk_info.setBk_amount((String)row.get("bk_amount"));	
		            bk_info.setBk_re_amount((String)row.get("bk_re_amount"));
		            book_result.add(bk_info);
		        }
		        return book_result;
			}
			
		}
		catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
					e.printStackTrace();
				}
		return book_result;
	}

}

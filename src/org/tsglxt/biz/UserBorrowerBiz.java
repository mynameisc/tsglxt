package org.tsglxt.biz;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;

import org.tsglxt.common.ConnectionManager;
import org.tsglxt.dao.SQLCommandBean;
import org.tsglxt.javebean.Borrow_info;
import org.tsglxt.javebean.Borrower;

public class UserBorrowerBiz {
	public int addBorrowInfo(Borrow_info borrow_info) throws ParseException{
		int i=0;
		String sql="insert into borrow_info(id_user,bo_name,bk_name,bo_borrow_time,bo_sgb_time)"
				+ " values(?,?,?,?,?);";
		List<String> values=new ArrayList<String>();
//		values.add(borrow_info.getId_rfid());
		values.add(borrow_info.getId_user());
		values.add(borrow_info.getBo_name());
		values.add(borrow_info.getBk_name());
		values.add(borrow_info.getBo_borrow_time());
		values.add(borrow_info.getBo_sgb_time());
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
	public String getBoname(String user_id)
	{

		
		
		List<String> values=new ArrayList<String>();
		List<Borrower>  user_result=new ArrayList<Borrower>();;
		String sql="select br_name from borrower where id_user=?;";
		values.add(user_id);
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
		            Borrower borrower=new Borrower();
		            borrower.setBr_name((String)row.get("br_name"));
		            user_result.add(borrower);
		        }
		        return user_result.get(0).getBr_name();
			}
			
		}
		catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
					e.printStackTrace();
				}
		return user_result.get(0).getBr_name();
	
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
	
	public boolean minus_Reamount(String bk_name)
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
				i=i-1;
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
	
}

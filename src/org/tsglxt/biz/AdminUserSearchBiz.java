package org.tsglxt.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;

import org.tsglxt.common.ConnectionManager;
import org.tsglxt.dao.SQLCommandBean;
import org.tsglxt.javebean.Borrower;

public class AdminUserSearchBiz {
	public List<Borrower> search_name(String name)
	{
		
		
		List<String> values=new ArrayList<String>();
		List<Borrower>  user_result=new ArrayList<Borrower>();;
		String sql="select id_rfid,id_user,br_name,br_sex,br_academy,br_createtime from borrower where br_name=?;";
		values.add(name);
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
		            borrower.setId_rfid((String)row.get("id_rfid"));
		            borrower.setId_user((String)row.get("id_user"));
		            borrower.setBr_name((String)row.get("br_name"));
		            borrower.setBr_sex((String)row.get("br_sex"));
		            borrower.setAcademy((String)row.get("br_Academy"));
		            borrower.setBr_createtime((String)row.get("br_createtime"));
		            user_result.add(borrower);
		        }
		        return user_result;
			}
			
		}
		catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
					e.printStackTrace();
				}
		return user_result;
	}
	
	
	public List<Borrower> search_id(String id)
	{
		
		
		List<String> values=new ArrayList<String>();
		List<Borrower>  user_result=new ArrayList<Borrower>();;
		String sql="select id_rfid,id_user,br_name,br_sex,br_academy,br_createtime from borrower where id_user=?;";
		values.add(id);
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
		            borrower.setId_rfid((String)row.get("id_rfid"));
		            borrower.setId_user((String)row.get("id_user"));
		            borrower.setBr_name((String)row.get("br_name"));
		            borrower.setBr_sex((String)row.get("br_sex"));
		            borrower.setAcademy((String)row.get("br_Academy"));
		            borrower.setBr_createtime((String)row.get("br_createtime"));
		            user_result.add(borrower);
		        }
		        return user_result;
			}
			
		}
		catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
					e.printStackTrace();
				}
		return user_result;
	}
	
	public List<Borrower> search_create(String time)
	{
		
		
		List<String> values=new ArrayList<String>();
		List<Borrower>  user_result=new ArrayList<Borrower>();;
		String sql="select id_rfid,id_user,br_name,br_sex,br_academy,br_createtime from borrower where br_createtime=?;";
		values.add(time);
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
		            borrower.setId_rfid((String)row.get("id_rfid"));
		            borrower.setId_user((String)row.get("id_user"));
		            borrower.setBr_name((String)row.get("br_name"));
		            borrower.setBr_sex((String)row.get("br_sex"));
		            borrower.setAcademy((String)row.get("br_Academy"));
		            borrower.setBr_createtime((String)row.get("br_createtime"));
		            user_result.add(borrower);
		        }
		        return user_result;
			}
			
		}
		catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
					e.printStackTrace();
				}
		return user_result;
	}
}

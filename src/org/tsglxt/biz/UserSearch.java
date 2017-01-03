package org.tsglxt.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;

import org.tsglxt.common.ConnectionManager;
import org.tsglxt.dao.SQLCommandBean;
import org.tsglxt.javebean.Borrow_info;
import org.tsglxt.javebean.Borrower;

public class UserSearch {
	public List<Borrow_info> getBorrow_info(String user_id)
	{
		

		
		
		List<String> values=new ArrayList<String>();
		List<Borrow_info>  borrowInfo_result=new ArrayList<Borrow_info>();;
		String sql="select id_user,bo_name,bk_name,bo_borrow_time,bo_sgb_time,bo_gb_time,bo_ex_day from borrowe_info where id_user=?;";
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
		            Borrow_info borrow_info=new Borrow_info();
		            borrow_info.setId_user((String)row.get("id_user"));
		            borrow_info.setBo_name((String)row.get("bo_name"));
		            borrow_info.setBk_name((String)row.get("bk_name"));
		            borrow_info.setBo_borrow_time((String)row.get("bo_borrow_time"));
		            borrow_info.setBo_gb_time((String)row.get("bo_gb_time"));
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
	
}

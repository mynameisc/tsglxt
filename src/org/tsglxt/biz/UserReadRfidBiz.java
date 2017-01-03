package org.tsglxt.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;

import org.tsglxt.common.ConnectionManager;
import org.tsglxt.dao.SQLCommandBean;
import org.tsglxt.javebean.Borrower;
import org.tsglxt.javebean.Lsd;
import org.tsglxt.javebean.LsdUserInfo;

public class UserReadRfidBiz {
	public List<LsdUserInfo> readRfid()
	{


		List<String> values=new ArrayList<String>();
		List<LsdUserInfo>  lsdUserInfos=new ArrayList<LsdUserInfo>();
		String sql="select user_rfid,user_from,user_time from lsdUserInfo;";
		try
		{
			SQLCommandBean sqlCommandBean=new SQLCommandBean();
			sqlCommandBean.setConn(ConnectionManager.getConnection());
			sqlCommandBean.setSqlValue(sql);
			//sqlCommandBean.setValues(values);
			Result result=sqlCommandBean.executeQuery();
			if(result!=null&&result.getRowCount()>0)
			{
		        for(int i=0;i<result.getRowCount();i++){  
		            Map row = result.getRows()[i]; 
		            LsdUserInfo lsdUserInfo=new LsdUserInfo();
		            lsdUserInfo.setUser_Rfid((String)row.get("User_rfid"));
		            lsdUserInfo.setUser_From((String)row.get("User_from"));
		            lsdUserInfo.setUser_Time((String)row.get("User_time"));
		            lsdUserInfos.add(lsdUserInfo);
		        }
		        try {
		            String sql2="DELETE FROM lsdUserInfo WHERE User_rfid ='"+lsdUserInfos.get(0).getUser_Rfid()+"'";
			        sqlCommandBean.setSqlValue(sql2);
			        sqlCommandBean.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
				}
		       
		   
		        
		        return lsdUserInfos;
			}
			
		}
		catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
					e.printStackTrace();
				}
		return lsdUserInfos;
	}
	
	public List<Borrower> getUserId(String user_rfid)
	{


		List<String> values=new ArrayList<String>();
		List<Borrower>  borrowers=new ArrayList<Borrower>();
		String sql="select id_user from borrower where id_rfid=?;";
		values.add(user_rfid);
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
		            borrower.setId_user((String)row.get("id_user"));
		            borrowers.add(borrower);
		        }
		       	        
		        return borrowers;
			}
			
		}
		catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
					e.printStackTrace();
				}
		return borrowers;
		
	}

}

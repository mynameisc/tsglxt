package org.tsglxt.javebean;
import com.mysql.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class Borrow_info {
	private String id_rfid;
	private String id_user;
	private String bo_name;
	private Date bo_borrow_time;//借阅时间
	private Date bo_sgb_time;//应该归还时间
	private Date bo_gb_time;//实际归还世时间
	private String bo_ex_day;//超期时间
	public String getId_rfid() {
		return id_rfid;
	}
	public void setId_rfid(String id_rfid) {
		this.id_rfid = id_rfid;
	}
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public String getBo_name() {
		return bo_name;
	}
	public void setBo_name(String bo_name) {
		this.bo_name = bo_name;
	}
	public Date getBo_borrow_time() {
		return bo_borrow_time;
	}
	public void setBo_borrow_time(Date bo_borrow_time) {
		this.bo_borrow_time = bo_borrow_time;
	}
	public Date getBo_gb_time() {
		return bo_gb_time;
	}
	public void setBo_gb_time(Date bo_gb_time) {
		this.bo_gb_time = bo_gb_time;
	}
	public Date getBo_sgb_time() throws ParseException {

		Calendar cal = Calendar.getInstance();
		cal.setTime(bo_borrow_time);
		cal.add(Calendar.DATE, 30);
	    bo_borrow_time=cal.getTime();
		return bo_sgb_time;
	}
	public String getBo_ex_day() {
		try {
			int time=daysBetween(bo_borrow_time,bo_gb_time);
			bo_ex_day=String.valueOf(time);
			return bo_ex_day;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bo_ex_day;
	}

	
    public static int daysBetween(Date smdate,Date bdate) throws ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));           
    } 

}

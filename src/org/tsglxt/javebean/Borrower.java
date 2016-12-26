package org.tsglxt.javebean;

import java.util.Date;

public class Borrower {
	private String id_rfid;
	private String id_user;
	private String br_name;
	private String br_sex;
	private String academy;
	private String password;
	private String br_createtime;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
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
	public String getBr_name() {
		return br_name;
	}
	public void setBr_name(String br_name) {
		this.br_name = br_name;
	}
	public String getBr_sex() {
		return br_sex;
	}
	public void setBr_sex(String br_sex) {
		this.br_sex = br_sex;
	}
	public String getAcademy() {
		return academy;
	}
	public void setAcademy(String academy) {
		this.academy = academy;
	}
	public String getBr_createtime() {
		return br_createtime;
	}
	public void setBr_createtime(String br_createtime) {
		this.br_createtime = br_createtime;
	}


}

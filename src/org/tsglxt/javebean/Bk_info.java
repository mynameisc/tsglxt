package org.tsglxt.javebean;
/********
 * 
 * @author cqs
 *创建bk_info的javaben
 */
public class Bk_info {
//	public int id;
	private String bk_rfid;
	private String bk_name;
	private String bk_author;
	private String bk_publish;
	private String bk_price;
	private String bk_address;
	private String bk_amount;
	private String bk_re_amount;
	
	public void setBk_re_amount(String bk_re_amount) {
		this.bk_re_amount = bk_re_amount;
	}

	public String getBk_rfid() {
		return bk_rfid;
	}

	public void setBk_rfid(String bk_rfid) {
		this.bk_rfid = bk_rfid;
	}

	public String getBk_name() {
		return bk_name;
	}

	public void setBk_name(String bk_name) {
		this.bk_name = bk_name;
	}

	public String getBk_author() {
		return bk_author;
	}

	public void setBk_author(String bk_author) {
		this.bk_author = bk_author;
	}

	public String getBk_publish() {
		return bk_publish;
	}

	public void setBk_publish(String bk_publish) {
		this.bk_publish = bk_publish;
	}

	public String getBk_price() {
		return bk_price;
	}

	public void setBk_price(String bk_price) {
		this.bk_price = bk_price;
	}

	public String getBk_address() {
		return bk_address;
	}

	public void setBk_address(String bk_address) {
		this.bk_address = bk_address;
	}

	public String getBk_amount() {
		return bk_amount;
	}

	public void setBk_amount(String bk_amount) {
		this.bk_amount = bk_amount;
	}

	public String getBk_re_amount() {
		return bk_re_amount;
	}

	public Bk_info(String bk_rfid,String bk_name,String bk_author,String bk_publish,String bk_price,
			String bk_address,String bk_amount)
	{	
				this.bk_rfid=bk_rfid;
				this.bk_name=bk_name;
				this.bk_author=bk_author;
				this.bk_publish=bk_publish;
				this.bk_price=bk_price;
				this.bk_address=bk_address;
				this.bk_amount=bk_amount;
				this.bk_re_amount=bk_amount;
				
				
	}

	public Bk_info() {
		// TODO Auto-generated constructor stub
	}
}

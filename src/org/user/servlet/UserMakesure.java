package org.user.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.RepaintManager;
import javax.xml.crypto.Data;

import org.tsglxt.biz.UserBorrowerBiz;
import org.tsglxt.biz.UserReadBookBiz;
import org.tsglxt.biz.UserReadRfidBiz;
import org.tsglxt.javebean.Bk_info;
import org.tsglxt.javebean.Borrow_info;
import org.tsglxt.javebean.Borrower;
import org.tsglxt.javebean.Lsd;

/**
 * Servlet implementation class UserMakesure
 */
@WebServlet("/UserMakesure")
public class UserMakesure extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserMakesure() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession=request.getSession();
		String bookMachineid=(String) httpSession.getAttribute("bookMachineid");
		String userid=(String) httpSession.getAttribute("userName");
		List<Lsd> lsd_rfid=new ArrayList<Lsd>();
		List<Bk_info> bk_infos=new ArrayList<Bk_info>();
		
		Borrow_info borrow_info=new Borrow_info();
		UserReadBookBiz userReadBookBiz=new UserReadBookBiz();
		UserBorrowerBiz userBorrowerBiz=new UserBorrowerBiz();
		lsd_rfid=userReadBookBiz.getBookRfid(bookMachineid);//得到图书的rfid；
		Iterator iterator;
		iterator=lsd_rfid.iterator();//遍历图书的rfid
		int i=0;
		while(iterator.hasNext())
		{
			Lsd lsd=lsd_rfid.get(i);
			i++;
			System.out.println("借阅图书的rfid"+lsd.getBook_rfid());
			Bk_info bk_info=new Bk_info();
			bk_info= userReadBookBiz.getBookInfo(lsd.getBook_rfid()).get(0);//根据图书的rfid得到图书信息
			String bo_name=userBorrowerBiz.getBoname(userid);//根据用户id得到用户名	

			borrow_info.setId_user(userid);
			borrow_info.setBo_name(bo_name);
			borrow_info.setBk_name(bk_info.getBk_name());//得到图书名
			
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
			Date date=new Date();
			String bo_borrow_time=simpleDateFormat.format(date);
			borrow_info.setBo_borrow_time(bo_borrow_time);
			borrow_info.getBo_sgb_time();//设置应该归还的时间
			try {
				userBorrowerBiz.addBorrowInfo(borrow_info);//添加借阅信息
				userBorrowerBiz.minus_Reamount(borrow_info.getBk_name());//减少剩余数量
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bk_infos.add(bk_info);
			iterator.next();
		}
		userBorrowerBiz.clearLSD(bookMachineid);
		request.setAttribute("bk_infos", bk_infos);
		//request.getRequestDispatcher("success_test.jsp").forward(request,response);;
		request.setAttribute("message","<script type='text/javascript' >alert('借阅成功');</script>");
		request.getRequestDispatcher("User_index.jsp").forward(request, response);
	}

}

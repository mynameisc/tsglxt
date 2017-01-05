package org.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tsglxt.biz.UserReadRfidBiz;
import org.tsglxt.javebean.Borrower;
import org.tsglxt.javebean.Lsd;
import org.tsglxt.javebean.LsdUserInfo;

/**
 * Servlet implementation class UserReadRfid
 */
@WebServlet("/UserReadRfid")
public class UserReadRfid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserReadRfid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserReadRfidBiz userReadRfidBiz = new UserReadRfidBiz();
		List<LsdUserInfo> list=new ArrayList<LsdUserInfo>();
		List<Borrower> borrower=new ArrayList<Borrower>();
		list = userReadRfidBiz.readRfid();
		Iterator iterator;
		iterator=list.iterator();
		while(iterator.hasNext())
		{
			LsdUserInfo lsdUserInfo=list.get(0);
			System.out.println("用户id"+lsdUserInfo.getUser_Rfid());
			System.out.println("机器号"+lsdUserInfo.getUser_From());

			iterator.next();
		}
		
		borrower=userReadRfidBiz.getUserId(list.get(0).getUser_Rfid());//根据rfid卡号得到id；
		userReadRfidBiz.clearlsdUser(list.get(0).getUser_Rfid());//根据rfid卡号删除lsduserinfo
		request.setAttribute("userRFID",list.get(0).getUser_Rfid());
		request.setAttribute("userID", borrower.get(0).getId_user());
		request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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
import javax.servlet.http.HttpSession;

import org.tsglxt.biz.UserReadBookBiz;
import org.tsglxt.javebean.Bk_info;
import org.tsglxt.javebean.Borrower;
import org.tsglxt.javebean.Lsd;

/**
 * Servlet implementation class UserReadBook
 */
@WebServlet("/UserReadBook")
public class UserReadBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserReadBook() {
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
		String userName=(String) httpSession.getAttribute("userName");
		List<Lsd> lsd_rfid=new ArrayList<Lsd>();
		List<Bk_info> bk_infos=new ArrayList<Bk_info>();
		UserReadBookBiz userReadBookBiz=new UserReadBookBiz();
		lsd_rfid=userReadBookBiz.getBookRfid(bookMachineid);//图书的rfid号
		Iterator iterator;
		iterator=lsd_rfid.iterator();
		int i=0;
		while(iterator.hasNext())
		{
			Lsd lsd=lsd_rfid.get(i);
			i++;
			System.out.println("需要借阅图书的rfid"+lsd.getBook_rfid());
			Bk_info bk_info=new Bk_info();
			bk_info= userReadBookBiz.getBookInfo(lsd.getBook_rfid()).get(0);
			bk_infos.add(bk_info);
			iterator.next();
		}
		request.setAttribute("bk_infos", bk_infos);//显示到页面前端的信息。
		request.getRequestDispatcher("Userbookinfo.jsp").forward(request, response);
		//doGet(request, response);
	}

}

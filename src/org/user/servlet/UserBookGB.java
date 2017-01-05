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

import org.tsglxt.biz.UserBookGBBiz;
import org.tsglxt.biz.UserReadBookBiz;
import org.tsglxt.biz.UserReadRfidBiz;
import org.tsglxt.javebean.Bk_info;
import org.tsglxt.javebean.Borrow_info;
import org.tsglxt.javebean.Borrower;
import org.tsglxt.javebean.Lsd;
import org.tsglxt.javebean.LsdUserInfo;

/**
 * Servlet implementation class UserBookGB
 */
@WebServlet("/UserBookGB")
public class UserBookGB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserBookGB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession=request.getSession();
		String bookMachineid=(String) httpSession.getAttribute("bookMachineid");
		String userid=(String) httpSession.getAttribute("userName");
		List<Lsd> lsd_rfid=new ArrayList<Lsd>();
		List<Bk_info> bk_infos=new ArrayList<Bk_info>();
		UserBookGBBiz userBookGBBiz=new UserBookGBBiz();
		lsd_rfid=userBookGBBiz.getBookRfid(bookMachineid);
		Iterator iterator;
		iterator=lsd_rfid.iterator();		
		int i=0;
		while(iterator.hasNext())
		{
			Lsd lsd=lsd_rfid.get(i);
			i++;
			System.out.println(lsd.getBook_rfid());
			Bk_info bk_info=new Bk_info();
			bk_info= userBookGBBiz.getBookInfo(lsd.getBook_rfid()).get(0);
			bk_infos.add(bk_info);//得到书名
			iterator.next();
		}
		
		
		iterator=bk_infos.iterator();
		i=0;
		List<Borrow_info> GBborrow_infos=new ArrayList<Borrow_info>();
		while (iterator.hasNext()) {
			
			Borrow_info borrow_info=new Borrow_info();
			String book_name=bk_infos.get(i).getBk_name();
			i++;
			borrow_info=(userBookGBBiz.getGB_info(userid, book_name)).get(0);
			GBborrow_infos.add(borrow_info);//得到书名信息
			iterator.next();
		}
		
		httpSession.setAttribute("GBborrow_infos", GBborrow_infos);
		request.getRequestDispatcher("UserGBShow.jsp").forward(request, response);
		//doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}

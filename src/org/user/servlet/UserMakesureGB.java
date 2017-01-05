package org.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.tsglxt.biz.UserBookGBBiz;
import org.tsglxt.javebean.Borrow_info;

/**
 * Servlet implementation class UserMakesureGB
 */
@WebServlet("/UserMakesureGB")
public class UserMakesureGB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserMakesureGB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession=request.getSession();
		String book_fromid=(String) httpSession.getAttribute("bookMachineid");
		Borrow_info borrow_info=new Borrow_info();
		UserBookGBBiz userBookGBBiz=new UserBookGBBiz();
		List<Borrow_info> GBborrow_infos=new ArrayList<Borrow_info>();
		GBborrow_infos = (List<Borrow_info>) httpSession.getAttribute("GBborrow_infos");
		Iterator iterator;
		iterator=GBborrow_infos.iterator();
		int i=0;
		while (iterator.hasNext()) {
			borrow_info=GBborrow_infos.get(i);
			i++;
			userBookGBBiz.setGBbookTime(borrow_info);//设置归还时间
			userBookGBBiz.add_Reamount(borrow_info.getBk_name());//重置剩余数量；
			userBookGBBiz.clearLSD(book_fromid);//清除临时表
			iterator.next();
		}
		request.setAttribute("message","<script type='text/javascript' >alert('归还成功');</script>");
		request.getRequestDispatcher("user_index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package org.admin.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tsglxt.biz.AdminBookSearchBiz;
import org.tsglxt.biz.AdminUserSearchBiz;
import org.tsglxt.javebean.Bk_info;
import org.tsglxt.javebean.Borrower;

/**
 * Servlet implementation class AdminUserSearch
 */
@WebServlet("/AdminBookSearch")
public class AdminBookSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBookSearch() {
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
		request.setCharacterEncoding("UTF-8");
		AdminBookSearchBiz adminBookSearchBiz =new AdminBookSearchBiz();
		List<Bk_info> list=new ArrayList<Bk_info>();
		if(request.getParameter("bookname_search")!=null)
		{
		//	System.out.println(request.getParameter("name_search"));
			String bookname=request.getParameter("bookname");
			list=adminBookSearchBiz.bookname_search(bookname);
//			Iterator iterator;
//			iterator=list.iterator();
//			while(iterator.hasNext())
//			{
//				Borrower borrower=list.get(0);
//				System.out.println(borrower.getId_rfid());
//				iterator.next();
//				
//			}
			//System.out.println(list.get(0));
			request.setAttribute("book_search_result",list);  
			request.getRequestDispatcher("AdminBookSearchresult.jsp").forward(request,response);  
		}
		if (request.getParameter("author_search")!=null) {
		//	System.out.println(request.getParameter("name_search"));
			String author=request.getParameter("author");
			list=adminBookSearchBiz.author_search(author);
//			Iterator iterator;
//			iterator=list.iterator();
//			while(iterator.hasNext())
//			{
//				Borrower borrower=list.get(0);
//				System.out.println(borrower.getId_rfid());
//				iterator.next();
//				
//			}
			//System.out.println(list.get(0));
			request.setAttribute("book_search_result",list);  
			request.getRequestDispatcher("AdminBookSearchresult.jsp").forward(request,response);  
		}
		if(request.getParameter("publish_search")!=null)
		{

			//	System.out.println(request.getParameter("name_search"));
				String publish=request.getParameter("publish");
				list=adminBookSearchBiz.publish_search(publish);
//				Iterator iterator;
//				iterator=list.iterator();
//				while(iterator.hasNext())
//				{
//					Borrower borrower=list.get(0);
//					System.out.println(borrower.getId_rfid());
//					iterator.next();
//					
//				}
				//System.out.println(list.get(0));
				request.setAttribute("book_search_result",list);  
				request.getRequestDispatcher("AdminBookSearchresult.jsp").forward(request,response);  
			
		}
	}

}

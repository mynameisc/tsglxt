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

import org.tsglxt.biz.AdminUserSearchBiz;
import org.tsglxt.javebean.Borrower;

/**
 * Servlet implementation class AdminUserSearch
 */
@WebServlet("/AdminUserSearch")
public class AdminUserSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserSearch() {
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
		AdminUserSearchBiz adminUserSearchBiz=new AdminUserSearchBiz();
		List<Borrower> list=new ArrayList<Borrower>();
		if(request.getParameter("name_search")!=null)
		{
		//	System.out.println(request.getParameter("name_search"));
			String name=request.getParameter("name");
			list=adminUserSearchBiz.search_name(name);
			Iterator iterator;
			iterator=list.iterator();
			while(iterator.hasNext())
			{
				Borrower borrower=list.get(0);
				System.out.println(borrower.getId_rfid());
				iterator.next();
				
			}
			//System.out.println(list.get(0));
			request.setAttribute("name_search_result",list);  
			request.getRequestDispatcher("AdminUserSearchresult.jsp").forward(request,response);  
		}
		if (request.getParameter("id_search")!=null) {
		//	System.out.println(request.getParameter("name_search"));
			String id=request.getParameter("id");
			list=adminUserSearchBiz.search_id(id);
			Iterator iterator;
			iterator=list.iterator();
			while(iterator.hasNext())
			{
				Borrower borrower=list.get(0);
				System.out.println(borrower.getId_rfid());
				iterator.next();
				
			}
			//System.out.println(list.get(0));
			request.setAttribute("name_search_result",list);  
			request.getRequestDispatcher("AdminUserSearchresult.jsp").forward(request,response);  
		}
		if(request.getParameter("time_search")!=null)
		{

			//	System.out.println(request.getParameter("name_search"));
				String time=request.getParameter("time");
				list=adminUserSearchBiz.search_create(time);
				Iterator iterator;
				iterator=list.iterator();
				while(iterator.hasNext())
				{
					Borrower borrower=list.get(0);
					System.out.println(borrower.getId_rfid());
					iterator.next();
					
				}
				//System.out.println(list.get(0));
				request.setAttribute("name_search_result",list);  
				request.getRequestDispatcher("AdminUserSearchresult.jsp").forward(request,response);  
			
		}
	}

}

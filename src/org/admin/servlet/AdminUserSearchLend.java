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

import org.tsglxt.biz.AdminLendSearchBiz;
import org.tsglxt.biz.AdminUserSearchBiz;
import org.tsglxt.javebean.Borrow_info;
import org.tsglxt.javebean.Borrower;

/**
 * Servlet implementation class AdminUserSearchLend
 */
@WebServlet("/AdminUserSearchLend")
public class AdminUserSearchLend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserSearchLend() {
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
		AdminLendSearchBiz adminLendSearchBiz=new AdminLendSearchBiz();
		List<Borrow_info> list=new ArrayList<Borrow_info>();
		if(request.getParameter("bo_name_search")!=null)
		{
			String bo_name=request.getParameter("bo_name");
			list=adminLendSearchBiz.bo_name_search(bo_name);
			Iterator iterator;
			iterator=list.iterator();
			while(iterator.hasNext())
			{
				Borrow_info borrow_info=list.get(0);
				//System.out.println(borrow_info.getId_rfid());
				iterator.next();
				
			}
			//System.out.println(list.get(0));
			request.setAttribute("name_search_result",list);  
			request.getRequestDispatcher("AdminLendSearchresult.jsp").forward(request,response);			
		}
		if(request.getParameter("bo_id_search")!=null)
		{
			String user_id=request.getParameter("user_id");
			list=adminLendSearchBiz.bo_id_search(user_id);
			Iterator iterator;
			iterator=list.iterator();
			while(iterator.hasNext())
			{
				Borrow_info borrow_info=list.get(0);
			//	System.out.println(borrow_info.getId_rfid());
				iterator.next();
				
			}
			//System.out.println(list.get(0));
			request.setAttribute("name_search_result",list);  
			request.getRequestDispatcher("AdminLendSearchresult.jsp").forward(request,response);
		}
		if(request.getParameter("bo_lendtime_search")!=null)
		{
			String time=request.getParameter("time");
			list=adminLendSearchBiz.bo_lend_search(time);
			Iterator iterator;
			iterator=list.iterator();
			while(iterator.hasNext())
			{
				Borrow_info borrow_info=list.get(0);
		//		System.out.println(borrow_info.getId_rfid());
				iterator.next();
				
			}
			//System.out.println(list.get(0));
			request.setAttribute("name_search_result",list);  
			request.getRequestDispatcher("AdminLendSearchresult.jsp").forward(request,response);
		}
		doGet(request, response);
	}

}

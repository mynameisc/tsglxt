package org.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.tsglxt.biz.UserSearchBiz;
import org.tsglxt.javebean.Borrow_info;

/**
 * Servlet implementation class UserSearch
 */
@WebServlet("/UserSearch")
public class UserSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Borrow_info> borrow_infos=new ArrayList<Borrow_info>();
		UserSearchBiz userSearchBiz=new UserSearchBiz();
		HttpSession httpSession= request.getSession();
		String user_id=(String)httpSession.getAttribute("userName");
		borrow_infos=userSearchBiz.getBorrow_info(user_id);
		request.setAttribute("borrow_infos", borrow_infos);
		request.getRequestDispatcher("UserBorrowinfoRestult.jsp").forward(request, response);
	//	doGet(request, response);
	}

}

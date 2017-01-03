package org.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.tsglxt.biz.UserLoginBiz;
import org.tsglxt.javebean.Borrower;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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
		boolean b;
		String username=request.getParameter("username");
		String bookMachineid=request.getParameter("bookMachineid");
		String password=request.getParameter("password");
		Borrower borrower=new Borrower();
		UserLoginBiz userLoginBiz=new UserLoginBiz();
		borrower.setId_user(username);
		borrower.setPassword(password);
		b=userLoginBiz.verify(borrower);
		if(b)
		{
			HttpSession session = request.getSession(); 
			session.setAttribute("bookMachineid", bookMachineid);
			session.setAttribute("userName", username);
			session.setAttribute("userPassword", password);
			request.getRequestDispatcher("user_index.jsp").forward(request, response);
		}else
		{
			request.getRequestDispatcher("success_test.jsp").forward(request, response);
		}
		//doGet(request, response);
	}

}

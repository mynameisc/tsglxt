package org.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableInterceptor.SUCCESSFUL;
import org.tsglxt.biz.AdminBiz;
import org.tsglxt.javebean.Admin;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin.do")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Admin admin=new Admin();
		AdminBiz adminBiz=new AdminBiz();
		admin.setId_admin(username);
		admin.setPass_word(password);
		if (adminBiz.verify(admin)) {
			request.getRequestDispatcher("success_test.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("AdminLogin.jsp").forward(request, response);
		}
	}

}

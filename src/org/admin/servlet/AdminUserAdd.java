package org.admin.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import org.tsglxt.biz.AdminUserAddBiz;
import org.tsglxt.javebean.*;
/**
 * Servlet implementation class AdminUserAdd
 */
@WebServlet("/AdminUserAdd")
public class AdminUserAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Borrower borrower=new Borrower();
		request.setCharacterEncoding("UTF-8");
		borrower.setId_user(request.getParameter("id_user"));
		borrower.setBr_name(request.getParameter("name"));
		borrower.setBr_sex(request.getParameter("sex"));
		borrower.setAcademy(request.getParameter("academy"));
		String password=request.getParameter("password");
		String repassword=request.getParameter("re_password");
		if(password.equals(repassword))
		{
			borrower.setPassword(password);
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = new Date();
	        String tp = sd.format(date);
			borrower.setBr_createtime(tp);
			AdminUserAddBiz adminUserAddBiz=new AdminUserAddBiz();
			int i=adminUserAddBiz.userAdd(borrower);
			if(i!=0)
				request.getRequestDispatcher("success_test.jsp").forward(request, response);
			else
			{
				request.getRequestDispatcher("AdminUserAdd.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("error_info", "请确认两次密码输入是否一致");
			request.getRequestDispatcher("AdminUserAdd.jsp").forward(request, response);
		}
	}

}

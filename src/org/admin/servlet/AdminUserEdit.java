package org.admin.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tsglxt.biz.AdminUserEditBiz;
import org.tsglxt.biz.UserReadRfidBiz;
import org.tsglxt.javebean.Borrower;

/**
 * Servlet implementation class AdminUserEdit
 */
@WebServlet("/AdminUserEdit")
public class AdminUserEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserEdit() {
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
		// TODO Auto-generated method stub
		Borrower borrower=new Borrower();
		request.setCharacterEncoding("UTF-8");
		borrower.setId_rfid(request.getParameter("id_rfid"));
		borrower.setId_user(request.getParameter("id_user"));
		borrower.setBr_name(request.getParameter("name"));
		borrower.setBr_sex(request.getParameter("sex"));
		borrower.setAcademy(request.getParameter("academy"));
		String password=request.getParameter("password");
		String repassword=request.getParameter("re_password");
		if(password.equals(repassword))
		{
			borrower.setPassword(password);

			AdminUserEditBiz adminUserEditBiz=new AdminUserEditBiz();
			int i=adminUserEditBiz.userEdit(borrower);
			if(i!=0)
			{
				request.setAttribute("editmessage","<script type='text/javascript' >alert('用户修改成功');</script>");
				request.getRequestDispatcher("Admin_index.jsp").forward(request, response);
		}
			else
			{
				request.setAttribute("error_info", "未修改成功");
				request.getRequestDispatcher("Adminuseredit.jsp").forward(request, response);
			}
		}
		else
		{
			String url="Adminuseredit.jsp?id_rfid="+request.getParameter("id_rfid");
			request.setAttribute("error_info", "请确认两次密码输入是否一致");
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
	

}

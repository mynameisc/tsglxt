package org.admin.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tsglxt.biz.AdminBookEditBiz;
import org.tsglxt.biz.AdminUserEditBiz;
import org.tsglxt.javebean.Bk_info;
import org.tsglxt.javebean.Borrower;

/**
 * Servlet implementation class AdminUserEdit
 */
@WebServlet("/AdminBookEdit")
public class AdminBookEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBookEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		Bk_info bk_info=new Bk_info();
		request.setCharacterEncoding("UTF-8");
		bk_info.setBk_rfid(request.getParameter("bk_rfid"));
		bk_info.setBk_name(request.getParameter("bk_name"));
		bk_info.setBk_author(request.getParameter("bk_author"));
		bk_info.setBk_publish(request.getParameter("bk_publish"));
		bk_info.setBk_price(request.getParameter("bk_price"));
		bk_info.setBk_address(request.getParameter("bk_address"));
		bk_info.setBk_amount(request.getParameter("bk_amount"));
		bk_info.setBk_re_amount(request.getParameter("bk_re_amount"));
		AdminBookEditBiz adminBookEditBiz=new AdminBookEditBiz();
		int i=adminBookEditBiz.BookEdit(bk_info);
		if(i!=0)
		{
			request.setAttribute("editmessage","<script type='text/javascript' >alert('修改成功！');</script>");
			request.getRequestDispatcher("Admin_index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		doGet(request,response);
			
	}
	

}

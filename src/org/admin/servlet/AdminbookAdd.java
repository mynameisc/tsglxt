package org.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tsglxt.biz.AdminbookAddBiz;
import org.tsglxt.javebean.Bk_info;

/**
 * Servlet implementation class AdminbookAdd
 */
@WebServlet("/AdminbookAdd")
public class AdminbookAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminbookAdd() {
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
		String bk_rfid=request.getParameter("id_rfid");
		String bk_name=request.getParameter("bk_name");
		String bk_author=request.getParameter("bk_author");
		String bk_publish=request.getParameter("bk_publish");
		String bk_price=request.getParameter("bk_price");
		String bk_address=request.getParameter("bk_address");
		String bk_amount=request.getParameter("bk_amount");
		Bk_info bk_info=new Bk_info(bk_rfid,bk_name, bk_author, bk_publish, bk_price, bk_address, bk_amount);
		
		AdminbookAddBiz adminbookAddBiz=new AdminbookAddBiz();
		int i=adminbookAddBiz.bookAdd(bk_info);
		if(i!=0)
		{
			request.setAttribute("addmessage","<script type='text/javascript' >alert('添加成功');</script>");
			request.getRequestDispatcher("Admin_index.jsp").forward(request, response);
		}
		doGet(request, response);
	}

}

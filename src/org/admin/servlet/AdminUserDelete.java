package org.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.tsglxt.biz.AdminUserDeleteBiz;
import org.tsglxt.javebean.Borrower;

/**
 * Servlet implementation class AdminUserDelete
 */
@WebServlet("/AdminUserDelete")
public class AdminUserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id_rfid=request.getParameter("id_rfid");
		Borrower borrower=new Borrower();
		borrower.setId_rfid(id_rfid);
		AdminUserDeleteBiz adminUserDelete=new AdminUserDeleteBiz();
		adminUserDelete.userDelete(borrower);
		request.setAttribute("deletemessage","<script type='text/javascript' >alert('删除成功');</script>");
		//JOptionPane.showMessageDialog(null, "删除成功");
		request.getRequestDispatcher("AdminUserSearch.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}

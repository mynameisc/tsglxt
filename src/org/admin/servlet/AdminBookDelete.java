package org.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tsglxt.biz.AdminBookDeleteBiz;
import org.tsglxt.biz.AdminUserDeleteBiz;
import org.tsglxt.javebean.Bk_info;
import org.tsglxt.javebean.Borrower;

import com.mysql.jdbc.RowData;

/**
 * Servlet implementation class AdminBookDelete
 */
@WebServlet("/AdminBookDelete")
public class AdminBookDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBookDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		
		String bk_rfid=request.getParameter("bk_rfid");
		Bk_info bk_info=new Bk_info();
		bk_info.setBk_rfid(bk_rfid);
		AdminBookDeleteBiz adminBookDelete=new AdminBookDeleteBiz();
		adminBookDelete.BookDelete(bk_info);
		request.setAttribute("deletemessage","<script type='text/javascript' >alert('删除成功!');</script>");
		//JOptionPane.showMessageDialog(null, "删除成功");
		request.getRequestDispatcher("Admin_index.jsp").forward(request, response);
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

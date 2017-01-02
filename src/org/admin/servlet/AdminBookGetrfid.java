package org.admin.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tsglxt.biz.AdminbookAddBiz;
import org.tsglxt.javebean.Borrower;
import org.tsglxt.javebean.Lsd;

/**
 * Servlet implementation class AdminBookGetrfid
 */
@WebServlet("/AdminBookGetrfid")
public class AdminBookGetrfid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBookGetrfid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// TODO Auto-generated method stub
		AdminbookAddBiz adminbookAddBiz=new AdminbookAddBiz();
		List<Lsd> list= adminbookAddBiz.get_bookrfid();
		Iterator iterator;
		iterator=list.iterator();
		while(iterator.hasNext())
		{
			Lsd lsd=list.get(0);
			System.out.println(lsd.getBook_rfid());
			System.out.println(lsd.getBooK_fromid());

			iterator.next();
		}
		request.setAttribute("bookrfid",list.get(0).getBook_rfid());
		request.setAttribute("book_fromid",list.get(0).getBooK_fromid());
		request.getRequestDispatcher("AdminbookAdd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	//	doGet(request, response);
	}

}

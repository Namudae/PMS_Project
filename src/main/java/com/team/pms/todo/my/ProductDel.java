package com.team.pms.todo.my;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/todo/my/productdel.do")
public class ProductDel extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//ProductDel.java
		
		String seq = req.getParameter("seq");
		
		req.setAttribute("seq", seq);
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/todo/my/productdel.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String prseq = req.getParameter("prseq");
		
		
		TodoDAO dao = new TodoDAO();
		
		int result = 0;
		
		result = dao.prfiledel(prseq);
		result = dao.prdel(prseq);
		
		
		
		if(result >=1) {
			resp.sendRedirect("/pms/todo/my/productlist.do");
		} else {
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
		}	
		
	}
}

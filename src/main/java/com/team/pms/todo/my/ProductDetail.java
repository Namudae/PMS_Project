package com.team.pms.todo.my;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/todo/my/productdetail.do")
public class ProductDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String emseq = (String) session.getAttribute("employeeSeq");
		
		String seq = req.getParameter("seq");
		
		TodoDAO dao = new TodoDAO();
		
		ProductDTO dto =  dao.get(seq,emseq); 
		
		
		req.setAttribute("dto", dto);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/todo/my/productdetail.jsp");
		dispatcher.forward(req, resp);
	}
}

package com.team.pms.todo.team;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/todo/team/teamproductdetail.do")
public class TeamProductDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String productseq = req.getParameter("seq");
		
		TeamProductDAO dao = new TeamProductDAO();
		
		TeamProductDTO dto =  dao.get(productseq); 
		
		req.setAttribute("dto", dto);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/todo/team/teamproductdetail.jsp");

		dispatcher.forward(req, resp);
	}
}

package com.team.pms.issue;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.pms.employee.repository.EmployeeDAO;
import com.team.pms.employee.repository.EmployeeDTO;

@WebServlet("/issue/issuedetail.do")
public class IssueDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//IssueDetail.java
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();

		String employeeSeq = (String) session.getAttribute("employeeSeq");
		
		
		String seq = req.getParameter("issueseq");

		
		IssueDAO dao = new IssueDAO();
		List<IssueDTO> list = dao.get(seq);
		req.setAttribute("list", list);

		
		
		EmployeeDAO daot = new EmployeeDAO();
		EmployeeDTO dto = daot.myInfo(employeeSeq);
		
		req.setAttribute("name", dto.getName());
		req.setAttribute("position", dto.getPosition());
		req.setAttribute("teamname", dto.getTeamName());
		
		/*
		 * List<IssueDTO> list = dao.issuelistdetail();
		 * 
		 * req.setAttribute("list", list);
		 */
	

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/issue/issuedetail.jsp");
		dispatcher.forward(req, resp);
	}

	
	
}

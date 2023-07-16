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

@WebServlet("/issue/issueadd.do")
public class IssueAdd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//IssueAdd.java
		
		HttpSession session = req.getSession();

		String employeeSeq = (String) session.getAttribute("employeeSeq");
		
		
		IssueDAO dao = new IssueDAO();
		
		List<IssueDTO> list = dao.projectlist();

		req.setAttribute("list", list);
		//////////////////////////////////////////////
		EmployeeDAO daot = new EmployeeDAO();
		EmployeeDTO dto = daot.myInfo(employeeSeq);
		
		req.setAttribute("name", dto.getName());
		req.setAttribute("position", dto.getPosition());
		req.setAttribute("teamname", dto.getTeamName());
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/issue/issueadd.jsp");
		dispatcher.forward(req, resp);
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		String employeeSeq = (String) session.getAttribute("employeeSeq");
		
		String title = req.getParameter("title");
		String deadline = req.getParameter("deadline");
		String issuetype = req.getParameter("issuetype");
		String projectseq = req.getParameter("project");
		String issuecontent = req.getParameter("issuecontent");
		
		IssueDAO dao = new IssueDAO();
		
		IssueDTO dto = new IssueDTO();
		dto.setTitle(title);
		dto.setDeadline(deadline);
		dto.setIssuetype(issuetype);
		dto.setProjectseq(projectseq);
		dto.setIssuecontent(issuecontent);
		dto.setEmployeeseq(employeeSeq);
		
		int result = dao.addlist(dto);
		
		if(result == 1) {
			
			resp.sendRedirect("/pms/issue/issuelist.do");
			
		} else {
			PrintWriter writer = resp.getWriter();
			
//			단순하게 html출력 해야될땐 script태그만 사용해도 된다!
			
			writer.write("<script>alert('failed');history.back();</script>");
			writer.close();
			
		}
	}
}



























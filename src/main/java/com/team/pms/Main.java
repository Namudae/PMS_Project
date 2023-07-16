package com.team.pms;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.pms.center.wbs.WbsDAO;
import com.team.pms.center.wbs.WbsDTO;
import com.team.pms.employee.repository.EmployeeDAO;
import com.team.pms.employee.repository.EmployeeDTO;
import com.team.pms.issue.IssueDAO;
import com.team.pms.sign.repository.SignListDAO;
import com.team.pms.todo.my.TodoDAO;
import com.team.pms.todo.my.TodoDTO;

@WebServlet("/main.do")
public class Main extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Main.java
		HttpSession session = req.getSession();

		String employeeSeq = (String) session.getAttribute("employeeSeq");
		
		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO dto = dao.myInfo(employeeSeq);
		
		req.setAttribute("name", dto.getName());
		req.setAttribute("position", dto.getPosition());
		req.setAttribute("teamname", dto.getTeamName());
		
		//도넛
		WbsDAO daoChart = new WbsDAO();
	      List<WbsDTO> listChart = daoChart.getChart(employeeSeq);
	      req.setAttribute("listChart", listChart);
		
		
		//새로 넣음
		SignListDAO daos = new SignListDAO();
		String signwait = daos.signwait();
		
		System.out.println(signwait);
		
		req.setAttribute("signwait", signwait);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main.jsp");
		
		
		//Issue
		IssueDAO daot = new IssueDAO();
	    String issuecount = daot.issuecount();
	    req.setAttribute("issuecount", issuecount);
	    
	    
	  //동현 추가
	      TodoDAO tododao = new TodoDAO();
	      PjDTO pjdto = new PjDTO();
	      List<TodoDTO> joblist = tododao.joblist(employeeSeq);
	      String jobcnt = tododao.todocnt(employeeSeq);
	      String wbscnt = tododao.wbscnt(employeeSeq);
	      
	      pjdto = tododao.listpj();
	      
	      req.setAttribute("joblist", joblist);
	      req.setAttribute("jobcnt", jobcnt);
	      req.setAttribute("pjdto", pjdto);
	      req.setAttribute("wbscnt", wbscnt);
	      //여기까지
		

		dispatcher.forward(req, resp);
	}
}

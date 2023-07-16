package com.team.pms.todo.team;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.team.pms.employee.repository.EmployeeDAO;
import com.team.pms.employee.repository.EmployeeDTO;

@WebServlet("/todo/team/wbsadd.do")
public class WbsAdd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// WbsAdd.java
		HttpSession session = req.getSession();
		String employeeseq = (String) session.getAttribute("employeeSeq");
		String lv = (String) session.getAttribute("lv");
		
	      
	      String employeeSeq = (String) session.getAttribute("employeeSeq");
	         
	         EmployeeDAO daot = new EmployeeDAO();
	         EmployeeDTO dto = daot.myInfo(employeeSeq);
	         req.setAttribute("name", dto.getName());
	         req.setAttribute("position", dto.getPosition());
	         req.setAttribute("teamname", dto.getTeamName());
		// PM이라면
		if (lv.equals("2")) {
			ProgressDAO dao = new ProgressDAO();
			int teamMaxRow = dao.teamMaxRow(employeeseq);
			int n = 1;
			
			ArrayList<ProgressDTO> list = dao.getWbs(employeeseq, n);
			ArrayList<ProgressDTO> teamList = dao.getTeam(employeeseq);

			req.setAttribute("list", list);
			req.setAttribute("teamList", teamList);
			req.setAttribute("teamMaxRow", teamMaxRow);

			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/todo/team/wbsadd.jsp");
			dispatcher.forward(req, resp);
		} else {
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed'); history.back();</script>");
			writer.close();
		}
	}

	//ajax 처리할 post
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String wbsname = req.getParameter("wbsname");
		String seq = req.getParameter("seq");
		String start = req.getParameter("start");
		String end = req.getParameter("end");
		
		ProgressDTO dto = new ProgressDTO();
		
		dto.setWbsname(wbsname);
		dto.setEmployeeseq(seq);
		dto.setStartdate(start);
		dto.setEnddate(end);
		
		ProgressDAO dao = new ProgressDAO();
		
		int result = dao.insertWbs(dto);
		
		HttpSession session = req.getSession();
		
		String employeeseq =(String)session.getAttribute("employeeSeq");
		
		int newWbsSeq = dao.getNewWbsSeq(employeeseq);
		
		if(result == 1) {
			
			
			JSONObject obj = new JSONObject();
			
			obj.put("result", result);
			obj.put("newseq", newWbsSeq);
			
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			
			PrintWriter writer = resp.getWriter();
			writer.print(obj);
			writer.close();
			
		} else {
			PrintWriter writer = resp.getWriter();

			writer.print("<script>alert('failed');</script>");
			writer.close();
		}
	}
}

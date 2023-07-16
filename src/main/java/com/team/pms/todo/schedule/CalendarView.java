package com.team.pms.todo.schedule;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.pms.employee.repository.EmployeeDAO;
import com.team.pms.employee.repository.EmployeeDTO;

@WebServlet("/todo/schedule/calendarview.do")
public class CalendarView extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		String employeeSeq = (String) session.getAttribute("employeeSeq");

		EmployeeDAO daot = new EmployeeDAO();
		EmployeeDTO dto = daot.myInfo(employeeSeq);
		req.setAttribute("name", dto.getName());
		req.setAttribute("position", dto.getPosition());
		req.setAttribute("teamname", dto.getTeamName());

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/todo/schedule/calendarview.jsp");

		dispatcher.forward(req, resp);
	}
}
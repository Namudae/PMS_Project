package com.team.pms.todo.schedule;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/todo/schedule/calendaredit.do")
public class CalendarEdit extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String input = req.getParameter("input");
		String calendarSeq = req.getParameter("seq");
		HttpSession session = req.getSession();
		
		String seq = (String)session.getAttribute("employeeSeq");
		
		CalendarDAO dao = new CalendarDAO();
		
		int result = dao.edit(input, seq, calendarSeq);
		
		if(result == 1) {
			System.out.println("성공~");
		}
	}
}


package com.team.pms.todo.schedule;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

@WebServlet("/todo/schedule/calendaradd.do")
public class CalendarAdd extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String input = req.getParameter("input");
		int year = Integer.parseInt(req.getParameter("year"));
		int month = Integer.parseInt(req.getParameter("month"));
		int day = Integer.parseInt(req.getParameter("day"));
		
		
		
		HttpSession session = req.getSession();

		String seq = (String) session.getAttribute("employeeSeq");

		Calendar now = Calendar.getInstance();

		String date = String.format("%d-%02d-%02d", year, month + 1, day);

		CalendarDAO dao = new CalendarDAO();

		// 클라이언트 딴에서 미리 선별하고 들어온거라, 딱히 제어가 필요없음.
		dao.calendarAdd(input, seq, date);

		JSONObject obj = new JSONObject();
		CalendarDTO dto = new CalendarDTO();
		dto = dao.getNewLog(seq);

		obj.put("seq", seq);
		obj.put("startdate", dto.getStartDate());
		obj.put("content", dto.getContent());
		obj.put("calendarseq", dto.getCalendarseq());

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");

		PrintWriter writer = resp.getWriter();
		writer.print(obj);
		writer.close();

	}
}

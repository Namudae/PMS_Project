package com.team.pms.todo.schedule;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/todo/schedule/calendarajax.do")
public class CalendarAjax extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// CalendarAjax.java
		CalendarDAO dao = new CalendarDAO();
		HttpSession session = req.getSession();

		int year = Integer.parseInt(req.getParameter("year"));
		int month = Integer.parseInt(req.getParameter("month"));

		Calendar now = Calendar.getInstance();

		
		now.set(year, month, 1);
		// month가 6월이면 5를반환하기때문에, 실제 쿼리문에 떤질떄는 6월을 줘야하니까 + 1
		String seq = (String) (session.getAttribute("employeeSeq"));

		String startDate = String.format("%d-%02d-01", now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1);
		// 해당 달만 가져오기 위해 해야함 ㅇㅇ

		now.set(year, month + 1, 0);
		int endDay = now.get(Calendar.DATE);
		
		String endDate = String.format("%d-%02d-%02d", now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1, endDay);

		// startdate보단 크거나같고 endDate보단 작아야함
		ArrayList<CalendarDTO> list = dao.getThisMonth(startDate, endDate, seq);

		JSONArray arr = new JSONArray();

		for (CalendarDTO dto : list) {

			JSONObject obj = new JSONObject();

			obj.put("calendarseq", dto.getCalendarseq());
			obj.put("content", dto.getContent());
			obj.put("employeeseq", dto.getEmployeeSeq());
			obj.put("startdate", dto.getStartDate());
			obj.put("enddate", dto.getEndDate());

			arr.add(obj);

		}

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");

		PrintWriter writer = resp.getWriter();
		writer.print(arr);
		writer.close();

//		for(CalendarDTO c : list) {
//			System.out.println(c.getStartDate());
//			System.out.println(c.getContent());
//		}

	}
}

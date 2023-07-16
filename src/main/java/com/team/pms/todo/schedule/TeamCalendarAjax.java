package com.team.pms.todo.schedule;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/todo/schedule/teamcalendarajax.do")
public class TeamCalendarAjax extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int year = Integer.parseInt(req.getParameter("year"));
		int month = Integer.parseInt(req.getParameter("month")) + 1;
		String seq = req.getParameter("employeeseq");
		
		String startDate = String.format("%d-%02d-01", year, month);

		// 해당 달만 가져오기 위해 해야함 ㅇㅇ
		month += 1;
		String endDate = String.format("%d-%02d-01", year, month);
		
		CalendarDAO dao = new CalendarDAO();
		
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
		
	}
}


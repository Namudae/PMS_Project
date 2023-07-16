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

@WebServlet("/todo/schedule/holidayajax.do")
public class HolidayAjax extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CalendarDAO dao = new CalendarDAO();
		Calendar now = Calendar.getInstance();
		int year = Integer.parseInt(req.getParameter("year"));
		int month = Integer.parseInt(req.getParameter("month"));		

		now.set(year, month, 1);
		String startDate = String.format("%d-%02d-01", now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1);
		// 해당 달만 가져오기 위해 해야함 ㅇㅇ

		now.set(year, month + 1, 0);
		int endDay = now.get(Calendar.DATE);
		
		String endDate = String.format("%d-%02d-%02d", now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1, endDay);

		ArrayList<CalendarDTO> list = dao.getHoliday(startDate, endDate);
		
		JSONArray arr = new JSONArray();
	      
	      for (CalendarDTO dto : list) {
	         
	         JSONObject obj = new JSONObject();
	         
	         obj.put("name",dto.getName());
	         obj.put("holidaydate",dto.getHolidayDate());
	         
	         arr.add(obj);
	      }
	      
	      resp.setCharacterEncoding("UTF-8");
	      resp.setContentType("application/json");
	      
	      PrintWriter writer = resp.getWriter();
	      writer.print(arr);
	      writer.close();
		
		
	}
}

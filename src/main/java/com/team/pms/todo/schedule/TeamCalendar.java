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

import com.team.pms.employee.repository.EmployeeDAO;
import com.team.pms.employee.repository.EmployeeDTO;

@WebServlet("/todo/schedule/teamcalendar.do")
public class TeamCalendar extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		String seq = (String) session.getAttribute("employeeSeq");
		
		EmployeeDAO dao = new EmployeeDAO();

		ArrayList<EmployeeDTO> list = dao.myTeam(seq);
		
		JSONArray arr = new JSONArray();
		
		for (EmployeeDTO dto : list) {
			JSONObject obj = new JSONObject();

			// 사실 이렇게 많이 필요없는데 걍 일단 가져와봤음
			obj.put("employeeseq", dto.getEmployeeSeq());
			obj.put("address", dto.getAddress());
			obj.put("birth", dto.getBirth());
			obj.put("email", dto.getEmail());
			obj.put("lv", dto.getLv());
			obj.put("name", dto.getName());
			obj.put("joinedate", dto.getJoinDate());
			obj.put("tel", dto.getTel());

			arr.add(obj);
		}

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");

		PrintWriter writer = resp.getWriter();
		writer.print(arr);
		writer.close();

	}
}

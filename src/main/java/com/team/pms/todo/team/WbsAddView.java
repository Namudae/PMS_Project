package com.team.pms.todo.team;

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

@WebServlet("/todo/team/wbsaddview.do")
public class WbsAddView extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int trLen = Integer.parseInt(req.getParameter("trLen"));
		
		
		HttpSession session = req.getSession();
		String employeeseq = (String) session.getAttribute("employeeSeq");
		
		ProgressDAO dao = new ProgressDAO();
		
		ArrayList<ProgressDTO> list = dao.getWbs(employeeseq, trLen + 1);
		
		JSONArray arr = new JSONArray();
		
		for (ProgressDTO dto : list) {
			JSONObject obj = new JSONObject();
			
			obj.put("startdate", dto.getStartdate());
			obj.put("enddate", dto.getEnddate());
			obj.put("name", dto.getName());
			obj.put("position", dto.getPosition());
			obj.put("wbsname", dto.getWbsname());
			obj.put("wbsseq", dto.getWbsseq());
			obj.put("rownum", dto.getRownum());
			
			arr.add(obj);
		}
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");

		PrintWriter writer = resp.getWriter();
		writer.print(arr);
		writer.close();
	}
}

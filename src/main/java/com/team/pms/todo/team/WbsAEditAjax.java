package com.team.pms.todo.team;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/todo/team/wbseditajax.do")
public class WbsAEditAjax extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String wbsseq = req.getParameter("wbsseq");
		String end = req.getParameter("end");
		String start = req.getParameter("start");
		String employeeseq = req.getParameter("employeeseq");
		String wbsname = req.getParameter("wbsname");

		ProgressDAO dao = new ProgressDAO();
		ProgressDTO dto = new ProgressDTO();
		
		dto.setWbsseq(wbsseq);
		dto.setWbsname(wbsname);
		dto.setStartdate(start);
		dto.setEnddate(end);
		dto.setEmployeeseq(employeeseq);
		
		int result = dao.updateWbs(dto);
		
		
		if(result == 1) {
			JSONObject obj = new JSONObject();
			obj.put("result", result);
			
			
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");
			
			PrintWriter writer = resp.getWriter();
			
			writer.print(obj);
			writer.close();
			
			System.out.println("성공");
			
		}else {
			
		}
		
	}
}

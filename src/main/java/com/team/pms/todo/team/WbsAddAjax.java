package com.team.pms.todo.team;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/todo/team/wbsaddajax.do")
public class WbsAddAjax extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String seq = req.getParameter("seq");
		ProgressDAO dao = new ProgressDAO();
		
		String position = dao.getPosition(seq);
		
		JSONObject obj = new JSONObject();
		
		obj.put("position", position);
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");

		PrintWriter writer = resp.getWriter();
		writer.print(obj);
		writer.close();
		
	}
}

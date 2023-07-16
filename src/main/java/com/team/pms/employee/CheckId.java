package com.team.pms.employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.team.pms.employee.repository.RegisterDAO;

@WebServlet("/employee/checkid.do")
public class CheckId extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		System.out.println(id);
		RegisterDAO dao = new RegisterDAO();
		String result = dao.checkId(id);
		
		JSONObject obj = new JSONObject();
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		obj.put("result", result);
		
		PrintWriter writer = resp.getWriter();
		writer.print(obj);
		writer.close();
		
		
	}
}

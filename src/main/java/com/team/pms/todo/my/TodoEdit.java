package com.team.pms.todo.my;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/todo/my/todoedit.do")
public class TodoEdit extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String seq = req.getParameter("seq");
		String per = req.getParameter("per");
		
		
		TodoDAO dao = new TodoDAO();
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("seq", seq);
		map.put("per", per);
		
		
		int result = dao.updatepercent(map);
		
		
		PrintWriter writer = resp.getWriter();
		
		if (result == 1) {
				JSONObject obj = new JSONObject();
				
				resp.setContentType("application/json");
				
				obj.put("result", result);
				writer.print(obj);
				
	        } else {
	           
	           writer.write("<script>alert('failed'); history.back();</script>");
	           writer.close();
	        }
		
		
		
	}
	
}

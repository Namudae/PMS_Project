package com.team.pms.center.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.team.pms.center.project.repository.ProjectDAO;
import com.team.pms.employee.repository.EmployeeDTO;

//가상 주소 매핑 방법
@WebServlet("/center/project/projectteamlist.do")

public class ProjectTeamList extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		String teamSeq = req.getParameter("seq");
		
		ProjectDAO dao = new ProjectDAO();
		
		List<EmployeeDTO> list = dao.getList(teamSeq);
		
		
		JSONArray arr = new JSONArray();
		for(EmployeeDTO dto : list) {
			JSONObject obj = new JSONObject();
			
			obj.put("name", dto.getName());
			obj.put("lv" ,dto.getLv());
			obj.put("employeeseq", dto.getEmployeeSeq());
			
			arr.add(obj);
		}
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		writer.print(arr);
		writer.close();
	
	}
	

}

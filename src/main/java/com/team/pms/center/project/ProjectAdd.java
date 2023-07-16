package com.team.pms.center.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.pms.center.project.repository.ProjectDAO;
import com.team.pms.center.project.repository.ProjectDTO;
import com.team.pms.employee.repository.EmployeeDTO;

//가상 주소 매핑 방법
@WebServlet("/center/project/projectadd.do")

public class ProjectAdd extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ProjectDAO dao = new ProjectDAO();
		
		
		List<EmployeeDTO> teamList = dao.teamList();
		List<ProjectDTO> projectList = dao.list();
		ArrayList<String> projectType = dao.getProjectType();
		ArrayList<String> rndType = dao.getRndType();
		
		
		req.setAttribute("teamList", teamList);
		req.setAttribute("projectList", projectList);
		req.setAttribute("projectType", projectType);
		req.setAttribute("rndType", rndType);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/center/project/projectadd.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			
			String projectName = req.getParameter("projectName");
			String startDate = req.getParameter("startdate");
			String endDate = req.getParameter("enddate");
			String teamName = req.getParameter("team");
			String projectType= req.getParameter("projectType");
			String rndType = req.getParameter("projectRnd");
			String budget = req.getParameter("budget");
			String content = req.getParameter("content");
			String pmName = req.getParameter("pm");
			String pa = req.getParameter("pa");
		
			String[] paSeq = pa.split(",");
		
			
			
			ProjectDAO dao = new ProjectDAO();
			ProjectDTO dto = new ProjectDTO();
			
			dto.setName(projectName);
			dto.setStartDate(startDate);
			dto.setEndDate(endDate);
			dto.setTeamName(teamName);
			dto.setProjectType(projectType);
			dto.setRndType(rndType);
			dto.setBudget(budget);
			dto.setContent(content);
			dto.setPmName(pmName);
			dto.setAddEmployee(paSeq);
			
			
		

			// 다른 페이지로 이동
		
			
			
		
			int addProject = dao.addProject(dto);
		
			dao.addEmployee(dto);
			
			if (addProject == 1) {
				

				resp.sendRedirect("/pms/center/project/projectlist.do");
				
			} else {
				PrintWriter writer = resp.getWriter();
				
				writer.print("<script>alert('양식에 맞춰 다시 입력해주세요.'); history.back();</script>");
				writer.close();
			}
			
			
			
			
			
			
			
			
			
		
		
		
		
	
	}
}

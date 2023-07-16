package com.team.pms.center.project;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.pms.center.project.repository.CostDTO;
import com.team.pms.center.project.repository.ProjectDAO;
import com.team.pms.center.project.repository.ProjectDTO;

//가상 주소 매핑 방법
@WebServlet("/center/project/projectedit.do")

public class ProjectEdit extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String seq = req.getParameter("projectSeq");
		
		ProjectDAO dao = new ProjectDAO();
		

		ProjectDTO dto = dao.projectList(seq);
		List<ProjectDTO> employeeList = dao.elist(seq);
		
	
		List<CostDTO> costList = dao.costList(seq);
		
		
		req.setAttribute("employeeList", employeeList);
		req.setAttribute("costList", costList);
		req.setAttribute("dto", dto);
		
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/center/project/projectedit.jsp");
		dispatcher.forward(req, resp);

	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		
		String projectName = req.getParameter("name");
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		String rndType = req.getParameter("rndType");
		String projectType = req.getParameter("projectType");
		String budget = req.getParameter("budget");
		String content = req.getParameter("content");
		String projectSeq = req.getParameter("projectSeq");
		budget = budget.replaceAll(",", "");
		
		ProjectDTO dto = new ProjectDTO();
		
		dto.setName(projectName);
		dto.setStartDate(startDate);
		dto.setEndDate(endDate);
		dto.setRndType(rndType);
		dto.setProjectType(projectType);
		dto.setBudget(budget);
		dto.setContent(content);
		dto.setProjectSeq(projectSeq);
		
		System.out.println(dto);
		
		System.out.println(dto.getProjectSeq());
		System.out.println(dto.getName());
		System.out.println(dto.getStartDate());
		System.out.println(dto.getEndDate());
		System.out.println(dto.getBudget());
		System.out.println(dto.getContent());
		System.out.println(dto.getProjectType());
		System.out.println(dto.getRndType());
		
		
		ProjectDAO dao = new ProjectDAO();
		
		
		dao.editDetailProject(dto);
		

		resp.setCharacterEncoding("UTF-8");
		
		String temp =  dto.getProjectSeq();
		
		resp.sendRedirect("/pms/center/project/projectdetail.do?projectSeq=" + temp);
		
		
	
	
	}
	
	
	
	
}

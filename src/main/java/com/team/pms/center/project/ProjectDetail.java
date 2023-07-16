package com.team.pms.center.project;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.team.pms.employee.repository.EmployeeDTO;

//가상 주소 매핑 방법
@WebServlet("/center/project/projectdetail.do")

public class ProjectDetail extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//ProjectDetail.java 
		
		String seq = req.getParameter("projectSeq");
		
		ProjectDAO dao = new ProjectDAO();
		

		ProjectDTO dto = dao.projectList(seq);
		List<ProjectDTO> employeeList = dao.elist(seq);
		
	
		List<CostDTO> costList = dao.costList(seq);
		
		
		req.setAttribute("employeeList", employeeList);
		req.setAttribute("costList", costList);
		req.setAttribute("dto", dto);
	
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/center/project/projectdetail.jsp");
		dispatcher.forward(req, resp);

	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			

		
		
		String item = req.getParameter("item");
		String money = req.getParameter("money");
		String costDate = req.getParameter("costDate");
		String signDate = req.getParameter("signDate");
		String projectSeq = req.getParameter("seq");
		
	

		CostDTO dto = new CostDTO();
		
		dto.setProjectSeq(projectSeq);
		dto.setItems(item);
		dto.setMoney(money);
		dto.setCostDate(costDate);
		dto.setSignDate(signDate);
		
		
		ProjectDAO dao = new ProjectDAO();
		
		dto = dao.addCost(dto);
		
		String cseq = dao.getCseq();
		
		PrintWriter writer = resp.getWriter();
		writer.print(cseq);
		writer.close();
		
		
		
		
		
	
	}
	
	
}

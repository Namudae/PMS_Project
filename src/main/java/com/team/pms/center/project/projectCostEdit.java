package com.team.pms.center.project;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.pms.center.project.repository.CostDTO;
import com.team.pms.center.project.repository.ProjectDAO;

//가상 주소 매핑 방법
@WebServlet("/center/project/projectcostedit.do")

public class projectCostEdit extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		

		String item = req.getParameter("item");
		String money = req.getParameter("money");
		String costDate = req.getParameter("costDate");
		String signDate = req.getParameter("signDate");
		String projectSeq = req.getParameter("seq");
		String costSeq = req.getParameter("costSeq");
		
		
		CostDTO dto = new CostDTO();
		
		dto.setProjectSeq(projectSeq);
		dto.setItems(item);
		dto.setMoney(money);
		dto.setCostDate(costDate);
		dto.setSignDate(signDate);
		dto.setCostSeq(costSeq);
		
		
		ProjectDAO dao = new ProjectDAO();
		
		dto = dao.updateCost(dto);
	
		
	
	}
	
}


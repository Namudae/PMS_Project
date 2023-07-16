package com.team.pms.center.project;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.pms.center.project.repository.ProjectDAO;

//가상 주소 매핑 방법
@WebServlet("/center/project/projectcostdel.do")
public class projectCostDel extends HttpServlet {

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String cseq = req.getParameter("cseq");
		
		System.out.println(cseq);
		
		ProjectDAO dao = new ProjectDAO();
		
		dao.delCost(cseq);
		
		

	
	}
	
	

}


package com.team.pms.center.version;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/center/version/versiondetail.do")
public class VersionDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//VersionDetail.java
		HttpSession session = req.getSession();
		 String employeeseq = (String)session.getAttribute("employeeseq");
		 
		 String versionseq = req.getParameter("versionseq");
		 
		//합치면
		 String projectseq = req.getParameter("projectseq");
		 
//		String projectseq = "1";

		 
		 VersionDAO dao = new VersionDAO();
		 VersionDTO dto = dao.getversion(versionseq,projectseq);
		 
		 
		 
		 req.setAttribute("dto", dto);
		 System.out.println(dto);
		 

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/center/version/versiondetail.jsp");
		dispatcher.forward(req, resp);
	}

}


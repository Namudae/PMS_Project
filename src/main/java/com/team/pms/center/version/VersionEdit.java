package com.team.pms.center.version;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/center/version/versionedit.do")
public class VersionEdit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//VersionEdit.java
		HttpSession session = req.getSession();
		 String employeeseq = (String)session.getAttribute("employeeseq");
		 
		 //String projectseq = "1";
		 
		 String versionseq = req.getParameter("versionseq");
		 String projectseq = req.getParameter("projectseq");
		 
		 VersionDAO dao = new VersionDAO();
		 VersionDTO dto = dao.getversion(versionseq, projectseq);
		 
		 req.setAttribute("dto", dto);
		 System.out.println(dto);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/center/version/versionedit.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String versionseq = req.getParameter("versionseq");
		String version = req.getParameter("version");
		String content = req.getParameter("content");
		String versiondate = req.getParameter("versiondate");
		String filename = req.getParameter("filename");
		String projectseq = req.getParameter("projectseq");
		
		VersionDAO dao = new VersionDAO();
		VersionDTO dto = new VersionDTO();
		dto.setVersionseq(versionseq);
		dto.setVersion(version);
		dto.setContent(content);
		dto.setVersiondate(versiondate);
		dto.setFilename(filename);
		
		int result = dao.versionedit(dto);
		
		System.out.println(dto);
		
		if (result == 1) {
			resp.sendRedirect("/pms/center/version/versionlist.do?pjseq="+ projectseq);
		} else {
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
		}
		
	}

}

package com.team.pms.center.version;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/center/version/versiondel.do")
public class VersionDel extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//VersionDel.java
		
		String versionseq = req.getParameter("versionseq");
		String projectseq = req.getParameter("projectseq");
		
		req.setAttribute("versionseq", versionseq);
		req.setAttribute("projectseq", projectseq);
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/center/version/versiondel.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String versionseq = req.getParameter("versionseq");
		String projectseq = req.getParameter("projectseq");
		System.out.println(projectseq);
		
		VersionDAO dao = new VersionDAO();
		
		int result = 0;
		
		result = dao.delversion(versionseq);
		
		if (result == 1) {
			resp.sendRedirect("/pms/center/version/versionlist.do?pjseq="+projectseq);
		} else {
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
		}
		
	}

}

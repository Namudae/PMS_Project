package com.team.pms.center.version;

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

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/center/version/versionadd.do")
public class VersionAdd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//VersionAdd.java
		HttpSession session = req.getSession();
		 String employeeseq = (String)session.getAttribute("employeeseq");
		 
//		 String projectseq = "1";
		 String projectseq = req.getParameter("projectseq");
		 System.out.println("sdfs" + projectseq);
		 
		 VersionDAO dao = new VersionDAO();
		 VersionDTO dto = dao.getversionproname(projectseq);
			/* String lv = dao.getlv(employeeseq); */
		 
		 System.out.println("dtodtodto" + dto);
	//	 System.out.println("프로젝트명" + dto);
		 req.setAttribute("dto", dto);
			/* req.setAttribute("lv", lv); */
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/center/version/versionadd.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		HttpSession session = req.getSession();
		
		req.setCharacterEncoding("UTF-8");
		
		//String projectseq = "1";
//		String projectseq = req.getParameter("projectseq");
		
		VersionDAO dao = new VersionDAO();
		
		System.out.println(req.getRealPath("/versionfiles"));
		//C:\class\code\server\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\PmsProject\versionfiles
		
	      
	      try {
	          MultipartRequest multi = new MultipartRequest(
	                               req,
	                               req.getRealPath("/versionfiles"),
	                               1024 * 1024 * 100,
	                               "UTF-8",
	                               new DefaultFileRenamePolicy()
	                               );
	      
		
		
		
		String version = multi.getParameter("version");
		String content = multi.getParameter("content");
		String versiondate = multi.getParameter("versiondate");
		String filename = multi.getFilesystemName("filename");
		String projectseq = multi.getParameter("projectseq");
		
		
		VersionDTO dto = new VersionDTO();
		
		dto.setVersion(version);
		dto.setContent(content);
		dto.setVersiondate(versiondate);
		dto.setFilename(filename);
		dto.setProjectseq(projectseq);
		
		
		
		int result = dao.addversion(dto);
		
		System.out.println(dto);
		
		if (result == 1) {
			resp.sendRedirect("/pms/center/version/versionlist.do?pjseq=" +projectseq);
		} else {
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
		} 
		
	    }catch (Exception e) {
	         e.printStackTrace();
	    }
		
		
	}
	
}


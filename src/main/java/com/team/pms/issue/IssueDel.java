package com.team.pms.issue;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/issue/issuedel.do")
public class IssueDel extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//IssueDel.java
		
		req.setCharacterEncoding("UTF-8");
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/issue/issuedel.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		 String seq = req.getParameter("issueseq");
		 
		 
		
		 
		 IssueDAO dao = new IssueDAO();
		
		 IssueDTO dto = new IssueDTO();
		
		 dto.setIssueseq(seq);
		
		 
		 
		 
		 int result = dao.delissue(dto);
		 
		 if(result == 1) {
				
				resp.sendRedirect("/pms/issue/issuelist.do");
				
			} else {
				PrintWriter writer = resp.getWriter();
				
//				단순하게 html출력 해야될땐 script태그만 사용해도 된다!
				
				writer.write("<script>alert('failed');history.back();</script>");
				writer.close();
				
			}
	}
}

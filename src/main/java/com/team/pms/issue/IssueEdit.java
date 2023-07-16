package com.team.pms.issue;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/issue/issueedit.do")
public class IssueEdit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//IssueEdit.java
		String seq = req.getParameter("issueseq");
		
		
		IssueDAO dao = new IssueDAO();
		
		List<IssueDTO> list = dao.projectlistEdit(seq);

		req.setAttribute("list", list);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/issue/issueedit.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String status = req.getParameter("status");
		 String seq = req.getParameter("issueseq");
		 String txt = req.getParameter("issuecontent");
		 
		 System.out.println(status);
		 System.out.println(seq);
		 
		 IssueDAO dao = new IssueDAO();
		
		 IssueDTO dto = new IssueDTO();
		 dto.setStatus(status);
		 dto.setIssueseq(seq);
		 dto.setIssuecontent(txt);
		 
		 
		 
		 int result = dao.editissue(dto);
		 
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

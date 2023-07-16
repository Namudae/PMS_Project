package com.team.pms.center.issue;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/center/issue/cissueview.do")
public class CIssueView extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//CIssueView.java
		
		HttpSession session = req.getSession();
		 String employeeseq = (String)session.getAttribute("employeeseq");
		 
		 String issueseq = req.getParameter("issueseq");
		 String projectseq = req.getParameter("projectseq");
		 
		 
		 CIssueDAO dao = new CIssueDAO();
		 CIssueDTO dto = dao.getissue(issueseq,projectseq);
		 
//		 String issuecontent = dto.getIssuecontent();
		 
//		//HTML 태그 이스케이프
//			issuecontent = issuecontent.replace("<", "&lt;")
//				         	 .replace(">", "&gt;");
//			
//			//글 내용 개행 문자 처리
//			issuecontent = issuecontent.replace("\r\n", "<br>");
//			
//			dto.setIssuecontent(issuecontent);
			
			req.setAttribute("dto", dto);
			req.setAttribute("projectseq", projectseq);
			System.out.println(dto);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/center/issue/cissueview.jsp");
		dispatcher.forward(req, resp);
	}

}


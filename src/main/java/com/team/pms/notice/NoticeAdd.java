package com.team.pms.notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.pms.notice.repository.NoticeDAO;
import com.team.pms.notice.repository.NoticeDTO;


@WebServlet("/notice/noticeAdd.do")
public class NoticeAdd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//NoticeAdd.java
		HttpSession session = req.getSession();

		
		String employeeSeq = (String) session.getAttribute("employeeSeq");
		NoticeDAO dao = new NoticeDAO();
		
		List<NoticeDTO> list = dao.teamlist();
		
		req.setAttribute("list", list);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/notice/add.jsp");
		dispatcher.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//NoticeAddOk.java
		
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		String employeeSeq = (String) session.getAttribute("employeeSeq");
		
		String title = req.getParameter("title");
		String noticetype = req.getParameter("noticetype");
		String content = req.getParameter("content");
		
		NoticeDAO dao = new NoticeDAO();
		
		NoticeDTO dto = new NoticeDTO();
		dto.setTitle(title);
		dto.setNoticetype(noticetype);
		dto.setContent(content);
		dto.setEmployeeseq(employeeSeq);
		
		int result = dao.addlist(dto);
		
		System.out.println(result);
		if(result ==1 ) {
			resp.sendRedirect("/pms/notice/noticelist.do");
		} else {
			PrintWriter writer = resp.getWriter();
			
			writer.write("<script>alert('failed');history.back(</script>");
			writer.close();
		}
		 
		
		
		
		
	}
	
	
	
}
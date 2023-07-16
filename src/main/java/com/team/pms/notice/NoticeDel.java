package com.team.pms.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.pms.notice.repository.NoticeDAO;
import com.team.pms.notice.repository.NoticeDTO;

@WebServlet("/notice/noticedel.do")
public class NoticeDel extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//NoticeDel.java

		req.setCharacterEncoding("UTF-8");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/notice/noticedel.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String seq = req.getParameter("noticeseq");
		
		NoticeDAO dao = new NoticeDAO();
		
		NoticeDTO dto = new NoticeDTO();
		
		dto.setNoticeseq(seq);
		
		int result = dao.delnotice(dto);
		
		if(result == 1) {
			
			resp.sendRedirect("/pms/notice/noticelist.do");
	
		} else {
			PrintWriter writer = resp.getWriter();
			
			writer.write("<script>alert('failed');history.back();</script>");
			writer.close();
		}
		
	}
}

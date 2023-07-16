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

import com.team.pms.notice.repository.NoticeDAO;
import com.team.pms.notice.repository.NoticeDTO;

@WebServlet("/notice/noticeedit.do")
public class NoticeEdit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//NoticeEdit.java
		String seq = req.getParameter("noticeseq");
		
		NoticeDAO dao = new NoticeDAO();
		
		List<NoticeDTO> list = dao.noticelistEdit(seq);
		
		req.setAttribute("list", list);
		
		req.setAttribute("noticeseq", seq);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/notice/edit.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
//		String title = req.getParameter("title");
//		String noticetype = req.getParameter("noticetype");
		String content = req.getParameter("content");
		String seq = req.getParameter("noticeseq");
		
		System.out.println("noticeseq: " + seq);
		
		NoticeDAO dao = new NoticeDAO();
		
		NoticeDTO dto = new NoticeDTO();
//		dto.setTitle(title);
//		dto.setNoticetype(noticetype);
		dto.setContent(content);
		dto.setNoticeseq(seq);
		
		System.out.println(seq);
		
		int result = dao.editnotice(dto);
		
		if(result == 1) {
			
			resp.sendRedirect("/pms/notice/noticelist.do");
		
		} else {
			
			PrintWriter writer = resp.getWriter();
			writer.write("<script>alert('failed');history.back();</script>");
			writer.close();
		}
	}
}

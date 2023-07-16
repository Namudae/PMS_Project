package com.team.pms.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.pms.employee.repository.EmployeeDAO;
import com.team.pms.employee.repository.EmployeeDTO;
import com.team.pms.employee.repository.RegisterDAO;
import com.team.pms.employee.repository.RegisterDTO;
import com.team.pms.notice.repository.NoticeDAO;
import com.team.pms.notice.repository.NoticeDTO;

@WebServlet("/notice/noticedetail.do")
public class NoticeDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//NoticeDetail.java
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		
		String employeeSeq = (String) session.getAttribute("employeeSeq");

		String seq = req.getParameter("noticeseq");
		
		
		NoticeDAO dao = new NoticeDAO();
		List<NoticeDTO> list = dao.get(seq);
		req.setAttribute("list", list);
		
		EmployeeDAO daot = new EmployeeDAO();
		EmployeeDTO dto = daot.myInfo(employeeSeq);
		
		req.setAttribute("name", dto.getName());
	      req.setAttribute("position", dto.getPosition());
	      req.setAttribute("teamname", dto.getTeamName());
		
		req.setAttribute("dto", dto);
		req.setAttribute("seq", seq);
//		
//		List<NoticeDTO> list = dao.noticelistdetail();
//		
//		req.setAttribute("list", list);
//		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/notice/noticedetail.jsp");
		dispatcher.forward(req, resp);
	}
	

}

package com.team.pms.sign;

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

import com.team.pms.employee.repository.EmployeeDAO;
import com.team.pms.employee.repository.EmployeeDTO;
import com.team.pms.sign.repository.SignListDAO;
import com.team.pms.sign.repository.SignListDTO;

@WebServlet("/sign/signok.do")
public class SignOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//SignOk.java
		
		//액션, seq 받아와서
		String action = req.getParameter("action");
		String signseq = req.getParameter("signseq");
		
		//넘김
		req.setAttribute("action", action);
		req.setAttribute("signseq", signseq);
		
		
		HttpSession session = req.getSession();
		
		String employeeSeq = (String) session.getAttribute("employeeSeq");
	      
	      EmployeeDAO daot = new EmployeeDAO();
	      EmployeeDTO dto = daot.myInfo(employeeSeq);
	      req.setAttribute("name", dto.getName());
	      req.setAttribute("position", dto.getPosition());
	      req.setAttribute("teamname", dto.getTeamName());

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/sign/signok.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String action = req.getParameter("action");
		if (action.equals("approve")) {
		    // 승인 처리 로직 수행
			String seq = req.getParameter("signseq");
			
			System.out.println(seq);
			
			SignListDAO dao = new SignListDAO();
			
			SignListDTO dto = new SignListDTO();

			dto.setSignseq(seq);
			
			int result = dao.signokedit(dto);
			
			if (result >= 1) {
				resp.sendRedirect("/pms/sign/signlist.do");
			} else {
				PrintWriter writer = resp.getWriter();
				writer.print("<script>alert('failed');history.back();</script>");
				writer.close();
			}	
			
		} else if (action.equals("reject")) {
		    // 거절 처리 로직 수행

			String seq = req.getParameter("signseq");
			
			System.out.println(seq);
			
			SignListDAO dao = new SignListDAO();
			
			SignListDTO dto = new SignListDTO();

			dto.setSignseq(seq);
			
			int result = dao.signnoedit(dto);
			
			if (result >= 1) {
				resp.sendRedirect("/pms/sign/signlist.do");
			} else {
				PrintWriter writer = resp.getWriter();
				writer.print("<script>alert('failed');history.back();</script>");
				writer.close();
			}	
			
		} else {
		    // 다른 경우 처리 또는 오류 메시지 표시
		}
		
		
		
	}

}

package com.team.pms.employee;

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
import com.team.pms.employee.repository.RegisterDAO;
import com.team.pms.employee.repository.RegisterDTO;
import com.team.pms.notice.repository.NoticeDAO;
import com.team.pms.notice.repository.NoticeDTO;

@WebServlet("/employee/mypage.do")
public class Mypage extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Mypage.java

		HttpSession session = req.getSession();
		
		String employeeSeq = (String)session.getAttribute("employeeSeq");
		
		RegisterDAO daom = new RegisterDAO();
		RegisterDTO dto = daom.userdetail(employeeSeq);
		
		
		
		req.setAttribute("employeeSeq", employeeSeq);
		req.setAttribute("dto", dto);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/employee/mypage.jsp");
		dispatcher.forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
//		String name = req.getParameter("name");
		String newPw = req.getParameter("newPw");
		String newPw2 = req.getParameter("newPw2");
		
		HttpSession session = req.getSession();
		
		String employeeSeq = (String)session.getAttribute("employeeSeq");
	
		
		RegisterDAO dao = new RegisterDAO();
		
		RegisterDTO dto = new RegisterDTO();
		
		int result = dao.PwEdit(newPw, newPw2, employeeSeq);
		
		System.out.println(result);

		
		if(result == 1) {
			
			resp.sendRedirect("/pms/main.do");
		
		} else {
			
			PrintWriter writer = resp.getWriter();
			writer.write("<script>alert('failed');history.back();</script>");
			writer.close();
		}
		
		
	}
}
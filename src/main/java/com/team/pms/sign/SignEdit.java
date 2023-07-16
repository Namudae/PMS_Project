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


@WebServlet("/sign/signedit.do")
public class SignEdit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//SignEdit.java
		//Edit.java
		//1. 데이터 가져오기(글번호)
		//2. DB 작업 > select
		//3. 결과 > JSP 호출하기
//		if (Auth.check(req, resp)) {
//			return;
//		}
		
		req.setCharacterEncoding("UTF-8");
	      
		String seq = req.getParameter("signseq");
      
		SignListDAO dao = new SignListDAO();
		List<SignListDTO> list = dao.get(seq);
		req.setAttribute("list", list);
		
		
		
		
		HttpSession session = req.getSession();
		
		String employeeSeq = (String) session.getAttribute("employeeSeq");
	      
	      EmployeeDAO daot = new EmployeeDAO();
	      EmployeeDTO dto = daot.myInfo(employeeSeq);
	      req.setAttribute("name", dto.getName());
	      req.setAttribute("position", dto.getPosition());
	      req.setAttribute("teamname", dto.getTeamName());

		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/sign/signedit.jsp");
		dispatcher.forward(req, resp);
	}
	
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//EditOk.java
		//1. 데이터 가져오기(수정할 값)
		//2. DB 작업 > update
		//3. 결과
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String seq = req.getParameter("signseq");
		
		System.out.println(seq);
		
		SignListDAO dao = new SignListDAO();
		
		SignListDTO dto = new SignListDTO();
		dto.setTitle(title);
		dto.setContent(content);
		dto.setSignseq(seq);
		
		int result = dao.edit(dto);
		
		if (result == 1) {
			resp.sendRedirect("/pms/sign/signlist.do");
		} else {
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
		}		
		
	}

}

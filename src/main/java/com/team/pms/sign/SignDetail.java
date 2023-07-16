package com.team.pms.sign;

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
import com.team.pms.sign.repository.SignListDAO;
import com.team.pms.sign.repository.SignListDTO;

@WebServlet("/sign/signdetail.do")
public class SignDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//SignDetail.java
		
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
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/sign/signdetail.jsp");
		dispatcher.forward(req, resp);
	}

}

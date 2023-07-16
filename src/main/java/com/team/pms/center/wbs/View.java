package com.team.pms.center.wbs;

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

@WebServlet("/center/wbs/view.do")
public class View extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
	   String pjseq = req.getParameter("pjseq");
      //View.java
      WbsDAO dao = new WbsDAO();
      
      List<WbsDTO> list = dao.getwbslist(pjseq);
      
      System.out.println(list);
      
      
      req.setAttribute("list", list);
      
      

		HttpSession session = req.getSession();
		
		String employeeSeq = (String) session.getAttribute("employeeSeq");

		EmployeeDAO daov = new EmployeeDAO();
		EmployeeDTO dto = daov.myInfo(employeeSeq);
		
		req.setAttribute("name", dto.getName());
		req.setAttribute("position", dto.getPosition());
		req.setAttribute("teamname", dto.getTeamName());
      
      
      
      RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/center/wbs/view.jsp");
      dispatcher.forward(req, resp);
   }

}

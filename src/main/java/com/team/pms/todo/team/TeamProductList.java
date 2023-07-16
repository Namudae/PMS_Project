package com.team.pms.todo.team;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.pms.center.product.CProductDAO;
import com.team.pms.center.product.CProductDTO;
import com.team.pms.employee.repository.EmployeeDAO;
import com.team.pms.employee.repository.EmployeeDTO;

@WebServlet("/todo/team/teamproductlist.do")
public class TeamProductList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//TeamProductList.java
		CProductDAO dao = new CProductDAO();
		
		HttpSession session = req.getSession();
		String employeeseq = (String) session.getAttribute("employeeSeq");		
		ArrayList<CProductDTO> list = dao.getTeamProduct(employeeseq);
				
		EmployeeDAO daot = new EmployeeDAO();
		EmployeeDTO dto = daot.myInfo(employeeseq);
		req.setAttribute("name", dto.getName());
		
		req.setAttribute("position", dto.getPosition());
		req.setAttribute("teamname", dto.getTeamName());
		req.setAttribute("list", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/todo/team/teamproductlist.jsp");

		dispatcher.forward(req, resp);
	}
}


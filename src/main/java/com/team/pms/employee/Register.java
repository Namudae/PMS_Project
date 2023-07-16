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

import com.team.pms.employee.repository.EmployeeDTO;
import com.team.pms.employee.repository.RegisterDAO;
import com.team.pms.employee.repository.RegisterDTO;

@WebServlet("/employee/register.do")
public class Register extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Register.java

		HttpSession session = req.getSession();

		
		String employeeSeq = (String) session.getAttribute("employeeSeq");
		
		RegisterDAO dao = new RegisterDAO();
		
		List<RegisterDTO> teamlist = dao.teamlist();
		
		req.setAttribute("teamlist", teamlist);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/employee/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
try {
			
			/*
			 * name birth tel joindate position lv email address id , pw1 pw2
			MultipartRequest multi = new MultipartRequest(
						
										req,
										req.getRealPath("/asset/images/man_03.png"),
										1024 * 1024 * 10,
										"UTF-8",
										new DefaultFileRenamePolicy()
					
									);
			
			System.out.println(req.getRealPath("/asset/images/man_03.png"));
			
			*/
			
			req.setCharacterEncoding("UTF-8");
	
			String name = req.getParameter("name");
			String birth = req.getParameter("birth");
			String tel = req.getParameter("tel");
			String joindate = req.getParameter("joindate");
			String position = req.getParameter("position");
			String lv = req.getParameter("lv");
			String email = req.getParameter("email");
			String address = req.getParameter("address");
			String id = req.getParameter("id");
			String pw1 = req.getParameter("newPw");
			String pw2 = req.getParameter("newPw2");
			String temaseq = req.getParameter("team");
			
			RegisterDTO dto = new RegisterDTO();
			
			dto.setName(name);
			dto.setBirth(birth);
			dto.setTel(tel);
			dto.setJoindate(joindate);
			dto.setEmail(email);
			dto.setPs(position);
			dto.setId(id);
			dto.setLv(lv);
			dto.setPw(pw1);
			dto.setAddress(address);
			dto.setTeamseq(temaseq);
			
			RegisterDAO dao = new RegisterDAO();
			
			int result = dao.EmployeeAdd(dto);
			
			int result2 = dao.RegisterAdd(dto);
			
			if (result == 1 && result2 ==1) {
				resp.sendRedirect("/pms/main.do");
			} else {
				PrintWriter writer = resp.getWriter();
				writer.print("<script>history.back();</script>");
				writer.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
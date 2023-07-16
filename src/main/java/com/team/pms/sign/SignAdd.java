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

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team.pms.employee.repository.EmployeeDAO;
import com.team.pms.employee.repository.EmployeeDTO;
import com.team.pms.sign.repository.SignListDAO;
import com.team.pms.sign.repository.SignListDTO;

@WebServlet("/sign/signadd.do")
public class SignAdd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//SignAdd.java
		
		HttpSession session = req.getSession();
		
		String employeeSeq = (String) session.getAttribute("employeeSeq");
		
		EmployeeDAO daot = new EmployeeDAO();
		EmployeeDTO dto = daot.myInfo(employeeSeq);
		req.setAttribute("name", dto.getName());
		req.setAttribute("position", dto.getPosition());
		req.setAttribute("teamname", dto.getTeamName());
		
		
		SignListDAO dao = new SignListDAO();
		
		List<SignListDTO> list = dao.projectlist();
		
		req.setAttribute("list", list);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/sign/signadd.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SignListDAO dao = new SignListDAO();
		
		try {
			
			MultipartRequest multi = new MultipartRequest(
					
									req,
									req.getRealPath("/asset/productfile"),
									1024 * 1024 * 10,
									"UTF-8",
									new DefaultFileRenamePolicy()
									
								);
			
			System.out.println(req.getRealPath("/asset/productfile"));
			
			HttpSession session = req.getSession();
			String employeeSeq = (String) session.getAttribute("employeeSeq");
			
			String title = multi.getParameter("title");
			String content = multi.getParameter("content");
			String projectseq = multi.getParameter("project");
			String filename = multi.getFilesystemName("filename");
			
			
			SignListDTO dto = new SignListDTO();
			
			dto.setTitle(title);
			dto.setContent(content);
			dto.setEmployeeseq(employeeSeq);
			dto.setProjectseq(projectseq);
			dto.setFilename(filename);
			
			int result = dao.addsign(dto);
			
			if (result >= 1) {
				
				resp.sendRedirect("/pms/sign/signlist.do");
				
			} else {
				PrintWriter writer = resp.getWriter();
				
				writer.write("<script>alert('failed');history.back();</script>");
				writer.close();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}

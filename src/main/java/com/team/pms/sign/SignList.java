package com.team.pms.sign;

import java.io.IOException;
import java.util.HashMap;
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

@WebServlet("/sign/signlist.do")
public class SignList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//SignList.java
		
		test(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		test(req, resp);
	}

	private void test(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
	      
	      //읽음 제어
	      session.setAttribute("read", "n");
	      
	      String page = req.getParameter("page");
	      
	      String employeeSeq = (String) session.getAttribute("employeeSeq");
	      
	      
	      //페이징
	      int nowPage = 1;   //현재 페이지 번호
	      int totalCount = 0;   //총 게시물 수
	      int pageSize = 10;   //한페이지에서 출력할 게시물 수
	      int totalPage = 0;   //총 페이지 수
	      int begin = 0;
	      int end = 0;
	      int n = 0;
	      int loop = 0;
	      int blockSize = 10; //한번에 보여질 페이지 개수
	      
	      if (page == null || page == "") nowPage = 1;
	      else nowPage = Integer.parseInt(page);

	      begin = ((nowPage - 1) * pageSize) + 1;
	      end = begin + pageSize - 1;
	      
	      HashMap<String, String> map = new HashMap<String,String>();
          

	      map.put("begin", begin + "");
	      map.put("end", end + "");
	      map.put("employee", employeeSeq);
	      
	      SignListDAO dao = new SignListDAO();
	      
	      EmployeeDAO daot = new EmployeeDAO();
	      EmployeeDTO dto = daot.myInfo(employeeSeq);
	      
//	      List<IssueDTO> list = dao.issuelist(employeeSeq);
	      List<SignListDTO> list = dao.list(map);
	      
	      
	      //System.out.println(list);
	      

	      totalCount = dao.getTotalCount();
	      //System.out.println(totalCount);
	      
	      totalPage = (int)Math.ceil((double)totalCount / pageSize);
	      

	      StringBuilder sb = new StringBuilder();

	      
	      
	      
	      
	      loop = 1; //루프 변수(10바퀴)
	      n = ((nowPage - 1) / blockSize) * blockSize + 1; //페이지 번호
	      
	      
	      //이전 10페이지
	      if (n == 1) {
	         sb.append(String.format("<a href=\"#!\">[이전 %d페이지]</a>", blockSize));
	      } else {
	         sb.append(String.format("<a href=\"/pms/sign/signlist.do?page=%d\">[이전 %d페이지]</a>", n - 1, blockSize));
	      }
	      
	      
	      while (!(loop > blockSize || n > totalPage)) {
	         
	         if (n == nowPage) {
	            sb.append(String.format(" <a href=\"#!\" style='color: tomato;'>%d</a> ",n));
	         } else {
	            sb.append(String.format(" <a href=\"/pms/sign/signlist.do?page=%d\">%d</a> ", n, n));
	         }
	         
	         loop++;
	         n++;
	      }
	      
	      
	      //다음 10페이지
	      if (n > totalPage) {
	         sb.append(String.format("<a href=\"#!\">[다음 %d페이지]</a>", blockSize));
	      } else {
	         sb.append(String.format("<a href=\"/pms/sign/signlist.do?page=%d\">[다음 %d페이지]</a>", n, blockSize));
	      }
	      
	      
//	      req.setAttribute("list", list);
	      req.setAttribute("employeeseq", employeeSeq);
	      req.setAttribute("name", dto.getName());
	      req.setAttribute("position", dto.getPosition());
	      req.setAttribute("teamname", dto.getTeamName());
	      req.setAttribute("list", list);
	      req.setAttribute("map", map);
	      req.setAttribute("totalCount", totalCount);
	      req.setAttribute("totalPage", totalPage);
	      req.setAttribute("nowPage", nowPage);
	      req.setAttribute("pagination", sb);
	      

	      RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/sign/signlist.jsp");
	      dispatcher.forward(req, resp);
		
	}
	
	

}

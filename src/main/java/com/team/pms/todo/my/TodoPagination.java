package com.team.pms.todo.my;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/todo/my/todopagination.do")
public class TodoPagination extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//TodoList2.java

		HttpSession session = req.getSession();
		
		
		String page = req.getParameter("page");
		
		String pjseq = req.getParameter("pjseq");

		
		//페이징
		int nowPage = 1;	//현재 페이지 번호
		int totalCount = 0;	//총 게시물 수
		int pageSize = 10;	//한페이지에서 출력할 게시물 수
		int totalPage = 0;	//총 페이지 수
		int begin = 0;
		int end = 0;
		int n = 0;
		int loop = 0;
		int blockSize = 10; //한번에 보여질 페이지 개수
		
		if (page == null || page == "") nowPage = 1;
		else nowPage = Integer.parseInt(page);

		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1;
		
		
		String emseq = (String) session.getAttribute("employeeSeq");
	
		
		
		HashMap<String, String> map = new HashMap<String,String>();
				

		
		
		map.put("begin", begin + "");
		map.put("end", end + "");
		map.put("emseq", emseq);
		map.put("pjseq", pjseq);
		
//		System.out.println("emseq:" +emseq);
//		System.out.println("pjseq:" +pjseq);
		
		TodoDAO dao = new TodoDAO();
		
		List<TodoDTO> list = dao.list(map);
		
//		System.out.println("list" + list);
		
		totalCount = dao.getTotalCount2(map);

		
		totalPage = (int)Math.ceil((double)totalCount / pageSize);
		
		

		StringBuilder sb = new StringBuilder();
		
		
		loop = 1; //루프 변수(10바퀴)
		n = ((nowPage - 1) / blockSize) * blockSize + 1; //페이지 번호
		
		
		//이전 10페이지
		if (n == 1) {
			sb.append(String.format("<a href=\"#!\">[이전 %d페이지]</a>", blockSize));
		} else {
			sb.append(String.format("<a href=\"/pms/todo/my/todolist.do?page=%d\">[이전 %d페이지]</a>", n - 1, blockSize));
		}
		
		
		while (!(loop > blockSize || n > totalPage)) {
			
			if (n == nowPage) {
				sb.append(String.format(" <a href=\"#!\" style='color: tomato;'>%d</a> ",n));
			} else {
				sb.append(String.format(" <a href=\"/pms/todo/my/todolist.do?page=%d\">%d</a> ", n, n));
			}
			
			loop++;
			n++;
		}
		
		
		//다음 10페이지
		if (n > totalPage) {
			sb.append(String.format("<a href=\"#!\">[다음 %d페이지]</a>", blockSize));
		} else {
			sb.append(String.format("<a href=\"/pms/todo/my/todolist.do?page=%d\">[다음 %d페이지]</a>", n, blockSize));
		}
		
		
		
		

		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		
		
				
		resp.setContentType("text/html");

		
		writer.print(sb.toString());
		writer.close();
	}
}

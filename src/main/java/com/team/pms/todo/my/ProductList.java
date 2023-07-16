package com.team.pms.todo.my;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/todo/my/productlist.do")
public class ProductList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//ProductList.java
		test(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
			
		
		String page = req.getParameter("page");
		
		String pjseq = req.getParameter("pjseq");

		
		//페이징
		int nowPage = 1;	//현재 페이지 번호
		int pageSize = 10;	//한페이지에서 출력할 게시물 수
		int begin = 0;
		int end = 0;
		
		
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
		
		
		TodoDAO dao = new TodoDAO();
		
		List<ProductDTO> plist = dao.plist(map);
		

		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		
		JSONArray arr = new JSONArray();
		
		
		
		for(ProductDTO dto : plist) {
			
			JSONObject obj = new JSONObject();
			
			obj.put("prseq", dto.getPrseq());
			obj.put("pjname", dto.getPjname());
			obj.put("prname", dto.getPrname());
			obj.put("emname", dto.getEmname());
			obj.put("prdate", dto.getPrdate());
			obj.put("rnum", dto.getRnum());
			
			
			arr.add(obj);
			
			
		
		}
		
		
		resp.setContentType("application/json");

		
		writer.print(arr);
		writer.close();
	}
	
	
	private void test(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		//읽음 제어
		
		String page = req.getParameter("page");
		String emseq = (String) session.getAttribute("employeeSeq");
		String pjseq = "all";
				
		

		
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
		
		
		
	
		
		
		HashMap<String, String> map = new HashMap<String,String>();
				

		map.put("begin", begin + "");
		map.put("end", end + "");
		map.put("emseq", emseq);
		map.put("pjseq", pjseq);
		
		
		
		TodoDAO dao = new TodoDAO();
		
		List<ProductDTO> plist = dao.plist(map);
		
		
		
		
		

		totalCount = dao.getTotalCountPr(map);
		
		
		totalPage = (int)Math.ceil((double)totalCount / pageSize);
		
		

		StringBuilder sb = new StringBuilder();

		
		
		
		
		loop = 1; //루프 변수(10바퀴)
		n = ((nowPage - 1) / blockSize) * blockSize + 1; //페이지 번호
		
		
		//이전 10페이지
		if (n == 1) {
			sb.append(String.format("<a href=\"#!\">[이전 %d페이지]</a>", blockSize));
		} else {
			sb.append(String.format("<a href=\"/pms/todo/my/productlist.do?page=%d\">[이전 %d페이지]</a>", n - 1, blockSize));
		}
		
		
		while (!(loop > blockSize || n > totalPage)) {
			
			if (n == nowPage) {
				sb.append(String.format(" <a href=\"#!\" style='color: tomato;'>%d</a> ",n));
			} else {
				sb.append(String.format(" <a href=\"/pms/todo/my/productlist.do?page=%d\">%d</a> ", n, n));
			}
			
			loop++;
			n++;
		}
		
		
		//다음 10페이지
		if (n > totalPage) {
			sb.append(String.format("<a href=\"#!\">[다음 %d페이지]</a>", blockSize));
		} else {
			sb.append(String.format("<a href=\"/pms/todo/my/productlist.do?page=%d\">[다음 %d페이지]</a>", n, blockSize));
		}
		
		
		
		
		
		
		List<ProductDTO> pjlist = dao.pjlist(emseq);
		
		
		req.setAttribute("pjlist", pjlist);	
		req.setAttribute("plist", plist);
		req.setAttribute("map", map);
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("nowPage", nowPage);
		req.setAttribute("pagination", sb);
		
		
		

				
	        
		
		
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/todo/my/productlist.jsp");
		dispatcher.forward(req, resp);
		
	}
	
}

package com.team.pms.todo.my;

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

@WebServlet("/todo/my/productedit.do")
public class ProductEdit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String emseq = (String) session.getAttribute("employeeSeq");
		
		String seq = req.getParameter("seq");
		
		TodoDAO dao = new TodoDAO();
		
		List<ProductDTO> pjlist = dao.pjlist(emseq);
				
		ProductDTO dto =  dao.get(seq,emseq);
		
		req.setAttribute("pjlist", pjlist);
		req.setAttribute("dto", dto);
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/todo/my/productedit.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
	      
		  String prseq = req.getParameter("prseq");
	      String product = req.getParameter("product");
	      String emname = req.getParameter("emname");
	      String date = req.getParameter("date");
	      String file = req.getParameter("file");
	      String content = req.getParameter("content");
	      String pjseq = req.getParameter("pjseq");
	      
	      //2.
	      TodoDAO dao = new TodoDAO();
	      
	      ProductDTO dto = new ProductDTO();
	      dto.setPrname(product);
	      dto.setEmname(emname);
	      dto.setPrdate(date);
	      dto.setContent(content);
	      dto.setPjseq(pjseq);
	      dto.setPrseq(prseq);
	      
	      int result = dao.ProductEdit(dto);
	      
	      if (result == 1) {
	         resp.sendRedirect("productlist.do");
	      } else {
	         PrintWriter writer = resp.getWriter();
	         writer.write("<script>alert('failed'); history.back();</script>");
	         writer.close();
	      }
	}
}

package com.team.pms.center.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/center/product/cproductdetail.do")
public class CProductDetail extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      //CProductDetail.java
      HttpSession session = req.getSession();
       String employeeseq = (String)session.getAttribute("employeeseq");
       
       String projectseq = req.getParameter("projectseq");
       String productseq = req.getParameter("productseq");
       
       CProductDAO dao = new CProductDAO();
       CProductDTO dto = dao.getproduct(productseq, projectseq);
       
       req.setAttribute("dto", dto);
       
      RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/center/product/cproductdetail.jsp");
      dispatcher.forward(req, resp);
   }

}
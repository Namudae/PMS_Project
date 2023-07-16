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

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team.pms.employee.repository.EmployeeDAO;
import com.team.pms.employee.repository.EmployeeDTO;


@WebServlet("/todo/my/productadd.do")
public class ProductAdd extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      //ProductAdd.java
      
      HttpSession session = req.getSession();
      String emseq = (String) session.getAttribute("employeeSeq");
      
      
      EmployeeDAO edao = new EmployeeDAO();
      TodoDAO dao = new TodoDAO();
      
      List<ProductDTO> pjlist = dao.pjlist(emseq);
      EmployeeDTO dto = edao.myInfo(emseq);
      
      req.setAttribute("name", dto.getName());
      req.setAttribute("pjlist", pjlist);
      
      System.out.println(pjlist);
      

      RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/todo/my/productadd.jsp");
      dispatcher.forward(req, resp);
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      req.setCharacterEncoding("UTF-8");
      
      
      try {
            
            MultipartRequest multi = new MultipartRequest(
                  
                              req,
                              req.getRealPath("/asset/productfiles"),
                              1024 * 1024 * 10,
                              "UTF-8",
                              new DefaultFileRenamePolicy()
                              
                           );
            
            System.out.println(req.getRealPath("/asset/productfiles"));
            
            HttpSession session = req.getSession();
            String employeeSeq = (String) session.getAttribute("employeeSeq");
            
            String pjseq = multi.getParameter("pjseq");
            String prname = multi.getParameter("prname");
            String date = multi.getParameter("date");
            String file = multi.getFilesystemName("file");
            String content = multi.getParameter("content");

            
            TodoDAO dao = new TodoDAO();
            ProductDTO dto = new ProductDTO();
            
            dto.setPjseq(pjseq);
            dto.setPrname(prname);
            dto.setPrdate(date);
            dto.setFile(file);
            dto.setEmseq(employeeSeq);
            dto.setContent(content);
            
            
            int result = dao.ProductAdd(dto);
            
            int result2 = dao.ProductFileAdd(dto);
            
            if (result >= 1) {
               
               resp.sendRedirect("/pms/todo/my/productlist.do");
               
            } else {
               PrintWriter writer = resp.getWriter();
               
               writer.write("<script>alert('failed');history.back();</script>");
               writer.close();
            }
            
            
         } catch (Exception e) {
            e.printStackTrace();
         }
      
      
      
      
      
      
      
      
      
      
      //------------------------------------------------------------
         
         String product = req.getParameter("prname");
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
         
         int result = dao.ProductAdd(dto);
         
         if (result == 1) {
            resp.sendRedirect("productlist.do");
         } else {
            PrintWriter writer = resp.getWriter();
            writer.write("<script>alert('failed'); history.back();</script>");
            writer.close();
         }
      
   }
}


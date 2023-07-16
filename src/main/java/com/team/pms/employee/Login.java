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

import com.team.pms.employee.repository.RegisterDAO;
import com.team.pms.employee.repository.RegisterDTO;


@WebServlet("/employee/login.do")
public class Login extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      // Login.java

      
      
      
      RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/employee/login.jsp");

      dispatcher.forward(req, resp);
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      String id = req.getParameter("id");
      String pw = req.getParameter("pw");
      
      
      System.out.println(id + " 아이디");
      System.out.println(pw + " 비밀번호");
      
      
      RegisterDAO dao = new RegisterDAO();
      RegisterDTO dto = new RegisterDTO();

      dto.setId(id);
      dto.setPw(pw);
      
   

      List<RegisterDTO> list = dao.login(dto);
      
      

      System.out.println(list);
      
      
      
      if (list.size() > 0) {
      
          RegisterDTO item = list.get(0);
             String employeeSeq = item.getEmployeeseq();
             String id1 = item.getId();
             String lv = item.getLv();
         
         HttpSession session = req.getSession();
         session.setAttribute("employeeSeq", employeeSeq); // 인증 티켓 (사원번호 발급)
         session.setAttribute("id", id1); 
         session.setAttribute("lv", lv);

         resp.sendRedirect("/pms/main.do");

      } else {
         PrintWriter writer = resp.getWriter();

         writer.print("<script>alert('failed'); history.back();</script>");
         writer.close();
      }

   }
}
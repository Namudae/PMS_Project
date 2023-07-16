package com.team.pms.center.version;

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

import com.team.pms.center.issue.CIssueDAO;
import com.team.pms.center.issue.CIssueDTO;

@WebServlet("/center/version/versionlist.do")
public class VersionList extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      //VersionList.java
      
      test(req, resp);
      
   }

   private void test(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      //Board.java
      
      //1. DB 작업 > select
      //2. 결과 반환
      
      HttpSession session = req.getSession();
      
      //읽음 제어
      
      String page = req.getParameter("page");
      
      
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
      
      
      String emseq = (String) session.getAttribute("employeeSeq");
   
      
      
      HashMap<String, String> map = new HashMap<String,String>();
            

      //String projectseq = "1";
      String projectseq = req.getParameter("pjseq");
      
      System.out.println("버전리스트"+projectseq);
      map.put("begin", begin + "");
      map.put("end", end + "");
      map.put("emseq", emseq);
      map.put("projectseq", projectseq);
      
      
      
      
      
      VersionDAO dao = new VersionDAO();
      
      List<VersionDTO> vslist = dao.vslist(map);
   
      System.out.println("버전ㄹ시트vslist" + vslist); 
      totalCount = dao.getTotalCount(projectseq);
   
      totalPage = (int)Math.ceil((double)totalCount / pageSize);

      StringBuilder sb = new StringBuilder();

      
      loop = 1; //루프 변수(10바퀴)
      n = ((nowPage - 1) / blockSize) * blockSize + 1; //페이지 번호
      
      
      //이전 10페이지
      if (n == 1) {
         sb.append(String.format("<a href=\"#!\">[이전 %d페이지]</a>", blockSize));
      } else {
         sb.append(String.format("<a href=\"/pms/center/version/versionlist.do?pjseq=%s&page=%d\">[이전 %d페이지]</a>", projectseq, n - 1, blockSize));
      }
      
      
      while (!(loop > blockSize || n > totalPage)) {
         
         if (n == nowPage) {
            sb.append(String.format(" <a href=\"#!\" style='color: tomato;'>%d</a> ",n));
         } else {
            sb.append(String.format(" <a href=\"/pms/center/version/versionlist.do?pjseq=%s&page=%d\">%d</a> ", projectseq, n, n));
         }
         
         loop++;
         n++;
      }
      
      
      //다음 10페이지
      if (n > totalPage) {
         sb.append(String.format("<a href=\"#!\">[다음 %d페이지]</a>", blockSize));
      } else {
         sb.append(String.format("<a href=\"/pms/center/version/versionlist.do?pjseq=%s&page=%d\">[다음 %d페이지]</a>", projectseq, n, blockSize));
      }
      
      
      
      
      
      
      
      
      
         
      req.setAttribute("vslist", vslist);
      req.setAttribute("map", map);
      req.setAttribute("totalCount", totalCount);
      req.setAttribute("totalPage", totalPage);
      req.setAttribute("nowPage", nowPage);
      req.setAttribute("pagination", sb);
      req.setAttribute("projectseq", projectseq);
      
      
      String employeeseq = (String)session.getAttribute("employeeseq");
       
       //합치면
//       String projectseq = req.getParameter("projectseq");
      
      
      List<VersionDTO> list = dao.versionlist(projectseq);

//      String lv = dao.getlv(employeeseq);
      String lv = (String)session.getAttribute("lv");
      System.out.println("레벨" + lv);
      
      req.setAttribute("list", list);
      req.setAttribute("lv", lv);
      

      RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/center/version/versionlist.jsp");
      dispatcher.forward(req, resp);
   }

}
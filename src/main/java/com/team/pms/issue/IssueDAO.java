package com.team.pms.issue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.test.my.DBUtil;



public class IssueDAO {
   private Connection conn;
   private Statement stat;
   private PreparedStatement pstat;
   private ResultSet rs;


   public IssueDAO() {
      conn =  DBUtil.open("localhost","team","java1234");
   }



   
   /*public List<IssueDTO> issuelist(String employeeSeq) {

      try {

         String sql = "select name,title,issuetype, to_char(issuedate,'yyyy-mm-dd') as issuedate, to_char(deadline,'yyyy-mm-dd') as deadline,issueseq,status from issue i\r\n"
               
               + "inner join employee e\r\n"
               + "on i.employeeSeq = e.employeeseq ";

//         pstat = conn.prepareStatement(sql);
//
//         pstat.setString(1, employeeSeq);
//
//         rs = pstat.executeQuery();

         stat = conn.createStatement();
         rs = stat.executeQuery(sql);
         
         List<IssueDTO> list = new ArrayList<IssueDTO>();

         while (rs.next()) {

            IssueDTO dto = new IssueDTO();

            dto.setTitle(rs.getString("title"));
            dto.setIssuetype(rs.getString("issuetype"));
            dto.setName(rs.getString("name"));
            dto.setIssuedate(rs.getString("issuedate"));
            dto.setDeadline(rs.getString("deadline"));
            dto.setIssueseq(rs.getString("issueseq"));
            
            
            list.add(dto);
         }

         System.out.println(list);
         return list;

      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return null;
   }
*/

   public List<IssueDTO> ilist() {

      
      try {

         String sql = "select * from issue";

         stat = conn.createStatement();
         rs = stat.executeQuery(sql);

         List<IssueDTO> list = new ArrayList<IssueDTO>();

         while (rs.next()) {

            IssueDTO dto = new IssueDTO();

            

            list.add(dto);
         }

         return list;

      } catch (Exception e) {
         e.printStackTrace();
      }
      
      
      return null;
   }


   public List<IssueDTO> projectlist() {

      try {

         String sql = "select projectseq, name from project";

         stat = conn.createStatement();
         rs = stat.executeQuery(sql);

         List<IssueDTO> list = new ArrayList<IssueDTO>();

         while (rs.next()) {

            IssueDTO dto = new IssueDTO();

            dto.setProjectseq(rs.getString("projectseq"));
            dto.setProjectname(rs.getString("name"));
            
            list.add(dto);
         }

         
         return list;

      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return null;
   }


   public int addlist(IssueDTO dto) {

      try {

         String sql = "insert into issue values(issueseq.nextVal, ?, ?, default, ?, default, ?,?,? )";

         pstat = conn.prepareStatement(sql);

         
         pstat.setString(1, dto.getTitle());
         pstat.setString(2, dto.getIssuetype());
         pstat.setString(3, dto.getDeadline());
         pstat.setString(4, dto.getIssuecontent());
         pstat.setString(5, dto.getProjectseq());
         pstat.setString(6, dto.getEmployeeseq());
         
         return pstat.executeUpdate();

      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return 0;
   }


   public List<IssueDTO> issuelistdetail() {

      try {

         String sql = "select* from issue i\r\n"
               + "inner join employee e\r\n"
               + "on i.employeeSeq = e.employeeseq\r\n"
               + "inner join project p\r\n"
               + "on p.projectSeq = i.projectseq";

//         pstat = conn.prepareStatement(sql);
//
//         pstat.setString(1, employeeSeq);
//
//         rs = pstat.executeQuery();

         stat = conn.createStatement();
         rs = stat.executeQuery(sql);
         
         List<IssueDTO> list = new ArrayList<IssueDTO>();

         while (rs.next()) {

            IssueDTO dto = new IssueDTO();

            dto.setTitle(rs.getString("title"));
            dto.setIssuetype(rs.getString("issuetype"));
            dto.setName(rs.getString("name"));
            dto.setIssuedate(rs.getString("issuedate"));
            dto.setDeadline(rs.getString("deadline"));
            dto.setIssueseq(rs.getString("issueseq"));
            dto.setStatus(rs.getString("status"));
            dto.setIssuecontent(rs.getString("issuecontent"));
            
            list.add(dto);
         }

         
         return list;

      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return null;
   }


   public List<IssueDTO> get(String seq) {

      
      try {

         //String sql = "select issuedate, title, name, deadline, status, issuecontent from issue where issueseq = ?";
         
         
         String sql = "select to_char(issuedate,'yyyy-mm-dd') as issuedate, title, e.name, to_char(deadline,'yyyy-mm-dd') as deadline, status, issuecontent, i.issueseq from issue i inner join employee e on i.employeeSeq = e.employeeseq inner join project p on p.projectseq = i.projectseq where issueseq = ?";

         pstat = conn.prepareStatement(sql);

         pstat.setString(1, seq);

         rs = pstat.executeQuery();

         List<IssueDTO> list = new ArrayList<IssueDTO>();

         while (rs.next()) {

            IssueDTO dto = new IssueDTO();

            dto.setIssuedate(rs.getString("issuedate"));
            dto.setTitle(rs.getString("title"));
            dto.setName(rs.getString("name"));
            dto.setDeadline(rs.getString("deadline"));
            dto.setStatus(rs.getString("status"));
            dto.setIssuecontent(rs.getString("issuecontent"));
            dto.setIssueseq(rs.getString("issueseq"));
            
            list.add(dto);
         }

      
         return list;

      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return null;
   }


   public List<IssueDTO> projectlistEdit(String seq) {

      try {

         String sql = "select title, issuetype,to_char(deadline,'yyyy-mm-dd') as deadline,issuecontent,status from project p\r\n"
               + "inner join issue i\r\n"
               + "on i.projectSeq = p.projectseq where issueseq = ?";

      pstat = conn.prepareStatement(sql);
      pstat.setString(1, seq);
      rs = pstat.executeQuery();
      
         List<IssueDTO> list = new ArrayList<IssueDTO>();

         while (rs.next()) {

            IssueDTO dto = new IssueDTO();

            dto.setTitle(rs.getString("title"));
            dto.setIssuetype(rs.getString("issuetype"));
            dto.setDeadline(rs.getString("deadline"));
            dto.setIssuecontent(rs.getString("issuecontent"));
            dto.setStatus(rs.getString("status"));
            
            list.add(dto);
         }

         
         return list;

      } catch (Exception e) {
         e.printStackTrace();
      }   
      
      return null;
   }


   

   public int editissue(IssueDTO dto) {

      try {

         String sql = "update issue set status = ?, issuecontent = ? where issueseq = ?";

         pstat = conn.prepareStatement(sql);

         pstat.setString(1, dto.getStatus());
         pstat.setString(2, dto.getIssuecontent());
         pstat.setString(3, dto.getIssueseq());

         return pstat.executeUpdate();

         
         
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      
      return 0;
   }


   public int delissue(IssueDTO dto) {

      try {

         String sql = "delete from issue where issueseq = ?";

         pstat = conn.prepareStatement(sql);

         pstat.setString(1, dto.getIssueseq());

         return pstat.executeUpdate();

      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return 0;
   }




public List<IssueDTO> list(HashMap<String, String> map) {
      
      List<IssueDTO> list = new ArrayList<IssueDTO>();
      
      try {
         
         String sql = String.format("SELECT *\r\n"
               + "FROM (\r\n"
               + "  SELECT a.*, ROWNUM AS rnum\r\n"
               + "  FROM (\r\n"
               + "    SELECT *\r\n"
               + "    FROM vwissue\r\n"
               + "    ORDER BY issuedate DESC\r\n"
               + "  ) a\r\n"
               + ")\r\n"
               + "WHERE rnum BETWEEN %s AND %s\r\n"
               + "ORDER BY rnum"                              
               , map.get("begin")
               , map.get("end")
            );
         
         stat = conn.createStatement();
         rs = stat.executeQuery(sql);
         
         
         while  (rs.next()) {
            
            IssueDTO dto = new IssueDTO();
            
            dto.setTitle(rs.getString("title"));
            dto.setIssuetype(rs.getString("issuetype"));
            dto.setName(rs.getString("name"));
            dto.setIssuedate(rs.getString("issuedate"));
            dto.setDeadline(rs.getString("deadline"));
            dto.setIssueseq(rs.getString("issueseq"));
            dto.setStatus(rs.getString("status"));
            dto.setRnum(rs.getString("rnum"));
            
            list.add(dto);
            
         }
         
         
         return list;

      } catch (Exception e) {
         e.printStackTrace();
      }
      
      
      return list;
   }




public int getTotalCount() {

   
   
   try {


      String sql = "select count(*) as cnt from vwissue";

      pstat = conn.prepareStatement(sql);
      rs = pstat.executeQuery();

      if (rs.next()) {

         return rs.getInt("cnt");
      }

   } catch (Exception e) {
      e.printStackTrace();
   }
   
   return 0;
}




public String getIssue(String employeeSeq) {

      try {

         String sql = "select count(*) as cnt from issue where employeeseq = ?";

         pstat = conn.prepareStatement(sql);

         pstat.setString(1, employeeSeq);

         rs = pstat.executeQuery();

         if (rs.next()) {

            return rs.getString("cnt");
         }

      } catch (Exception e) {
         e.printStackTrace();
      }
   return null;
}




public String issuecount() {

   try {

      String sql = "select count(*) as cnt from issue where status = 'w'";

      stat = conn.createStatement();
      rs = stat.executeQuery(sql);

      if (rs.next()) {

         return rs.getString("cnt");
      }

   } catch (Exception e) {
      e.printStackTrace();
   }
   
   return null;
}














   

   



   
   
}

   
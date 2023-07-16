package com.team.pms.center.issue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.team.pms.center.product.CProductDTO;
import com.test.my.DBUtil;

public class CIssueDAO {
      private Connection conn;
      private Statement stat;
      private PreparedStatement pstat;
      private ResultSet rs;


      public CIssueDAO() {
         conn =  DBUtil.open("localhost", "team", "java1234");
      }


   public List<CIssueDTO> cissuelist(String projectseq) {
      
      List<CIssueDTO> list = new ArrayList<CIssueDTO>();
       
      try {

            String sql = "select * from centerissue where projectseq = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, projectseq);
            rs = pstat.executeQuery();

            

            while (rs.next()) {

               CIssueDTO dto = new CIssueDTO();


               dto.setIssueseq(rs.getString("issueseq"));
               dto.setTitle(rs.getString("title"));
               dto.setIssuetype(rs.getString("issuetype"));
//               dto.setName(rs.getString("name"));
               dto.setEmployeeseq(rs.getString("name"));
               dto.setIssuedate(rs.getString("issuedate"));
               dto.setDeadline(rs.getString("deadline"));
               dto.setStatus(rs.getString("status"));
               dto.setProjectseq(rs.getString("projectseq"));
               
               list.add(dto);
               
               
            }

            System.out.println(list);
            return list;


         } catch (Exception e) {
            e.printStackTrace();
         }
         
      return null;
   }


   public CIssueDTO getissue(String issueseq, String projectseq) {
      
         try {

            String sql = "select * from centerissue where projectseq = ? and issueseq = ?";

            pstat = conn.prepareStatement(sql);

            pstat.setString(1, projectseq);
            pstat.setString(2, issueseq);

            rs = pstat.executeQuery();

            if (rs.next()) {

               CIssueDTO dto = new CIssueDTO();

               dto.setIssueseq(rs.getString("issueseq"));
               dto.setTitle(rs.getString("title"));
               dto.setIssuedate(rs.getString("issuedate"));
               dto.setEmployeeseq(rs.getString("name"));
                  dto.setDeadline(rs.getString("deadline"));
                  dto.setStatus(rs.getString("status"));
                  dto.setIssuecontent(rs.getString("issuecontent"));
                  dto.setProjectseq(rs.getString("projectseq"));
                  
               return dto;
            }

         } catch (Exception e) {
            e.printStackTrace();
         }
         
         
      return null;
   }


   public List<CIssueDTO> cislist(HashMap<String, String> map) {
      
      List<CIssueDTO> cislist = new ArrayList<CIssueDTO>();
      
try {
         
         String sql = String.format("select * from (select a.* , rownum as rnum from centerissue a where projectseq=%s) where rnum between %s and %s"                              
                              , map.get("projectseq")
                              , map.get("begin")
                              , map.get("end")
                           );
         
         stat = conn.createStatement();
         rs = stat.executeQuery(sql);
         
         
         while  (rs.next()) {
            
            CIssueDTO dto = new CIssueDTO();
            
            dto.setProjectseq(rs.getString("projectseq"));
            dto.setIssueseq(rs.getString("issueseq"));
            dto.setTitle(rs.getString("title"));
            dto.setIssuedate(rs.getString("issuedate"));
            dto.setEmployeeseq(rs.getString("name"));
               dto.setDeadline(rs.getString("deadline"));
               dto.setStatus(rs.getString("status"));
               dto.setIssuecontent(rs.getString("issuecontent"));
               dto.setIssuetype(rs.getString("issuetype"));
               dto.setRnum(rs.getString("rnum"));
               cislist.add(dto);
               
         }
         
         
         return cislist;

      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return cislist;
   }


   public int getTotalCount(String pjseq) {
      
try {

         String sql = "select count(*) as cnt from centerissue where projectseq=?";

         pstat = conn.prepareStatement(sql);
         pstat.setString(1, pjseq);
         rs = pstat.executeQuery();

         if (rs.next()) {

            return rs.getInt("cnt");
         }

      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return 0;
   }
      
}
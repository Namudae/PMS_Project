package com.team.pms.center.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.test.my.DBUtil;

public class CProductDAO {
   private Connection conn;
   private Statement stat;
   private PreparedStatement pstat;
   private ResultSet rs;

   public CProductDAO() {
      conn = DBUtil.open("localhost","team","java1234");
   }

   public ArrayList<CProductDTO> getTeamProduct(String employeeseq) {


      try {

         //String sql = "select rownum as rnum, cp.* from centerproduct cp where projectseq = (select max(projectseq) from ownproject where employeeseq = ?)";
         String sql = "select cp.*, rownum as rnum, pf.filename, pf.fileseq from centerproduct cp\r\n"
         		+ "inner join productfile pf\r\n"
         		+ "on cp.productseq = pf.productseq\r\n"
         		+ "where cp.projectseq = (select max(projectseq) from ownproject where employeeseq = ?)";
         pstat = conn.prepareStatement(sql);

         pstat.setString(1, employeeseq);

         rs = pstat.executeQuery();

         ArrayList<CProductDTO> list = new ArrayList<CProductDTO>();

         while (rs.next()) {

            CProductDTO dto = new CProductDTO();

            dto.setProductseq(rs.getString("productseq"));
            dto.setProductname(rs.getString("productname"));
            dto.setContent(rs.getString("content"));
            dto.setFile(rs.getString("fileName"));
            dto.setFileseq(rs.getString("fileseq"));
            dto.setProductdate(rs.getString("productdate"));
            dto.setEmployeeseq(rs.getString("name"));
            dto.setProjectseq(rs.getString("projectseq"));
            dto.setRnum(rs.getString("rnum"));
            
            list.add(dto);
         }

         return list;

      } catch (Exception e) {
         e.printStackTrace();
      }

      return null;
   }

   public List<CProductDTO> cproductlist(String projectseq) {

      try {

         String sql = "select * from centerproduct where projectseq = ?";

         pstat = conn.prepareStatement(sql);

         pstat.setString(1, projectseq);

         rs = pstat.executeQuery();

         List<CProductDTO> list = new ArrayList<CProductDTO>();

         while (rs.next()) {

            CProductDTO dto = new CProductDTO();

            dto.setProductseq(rs.getString("productseq"));
            dto.setProductname(rs.getString("productname"));
            dto.setContent(rs.getString("content"));
            dto.setProductdate(rs.getString("productdate"));
            dto.setEmployeeseq(rs.getString("name"));
            dto.setProjectseq(rs.getString("projectseq"));

            list.add(dto);
         }

         return list;

      } catch (Exception e) {
         e.printStackTrace();
      }

      return null;
   }

   public CProductDTO getproduct(String productseq, String projectseq) {

      try {

         String sql = "select * from centerproduct cp\r\n"
               + "    inner join productfile pf\r\n"
               + "        on cp.productseq = pf.productseq\r\n"
               + "             where cp.projectseq = ? and pf.productseq = ?";

         pstat = conn.prepareStatement(sql);

         pstat.setString(1, projectseq);
         pstat.setString(2, productseq);

         rs = pstat.executeQuery();

         if (rs.next()) {

            CProductDTO dto = new CProductDTO();
            
            dto.setProjectseq(rs.getString("projectseq"));
            dto.setProductseq(rs.getString("projectseq"));
            dto.setProductname(rs.getString("productname"));
            dto.setProductdate(rs.getString("productdate"));
            dto.setContent(rs.getString("content"));
            dto.setEmployeeseq(rs.getString("name"));
            dto.setFile(rs.getString("filename"));
            

            return dto;
         }

      } catch (Exception e) {
         e.printStackTrace();
      }

      return null;
   }

   public List<CProductDTO> cplist(HashMap<String, String> map) {

      List<CProductDTO> cplist = new ArrayList<CProductDTO>();

      try {

         String sql = String.format(
               "select * from (select a.* , rownum as rnum from centerproduct a where projectseq=%s) where rnum between %s and %s",
               map.get("projectseq"), map.get("begin"), map.get("end"));

         stat = conn.createStatement();
         rs = stat.executeQuery(sql);

         while (rs.next()) {

            CProductDTO dto = new CProductDTO();

            dto.setProductseq(rs.getString("productseq"));
            dto.setProductname(rs.getString("productname"));
            dto.setContent(rs.getString("content"));
            dto.setProductdate(rs.getString("productdate"));
            dto.setEmployeeseq(rs.getString("name"));
            dto.setProjectseq(rs.getString("projectseq"));
            dto.setRnum(rs.getString("rnum"));
            
            cplist.add(dto);

         }

         return cplist;

      } catch (Exception e) {
         e.printStackTrace();
      }

      return cplist;
   }

   public int getTotalCount(String pjseq) {

      try {

         String sql = "select count(*) as cnt from centerproduct where projectseq=?";

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
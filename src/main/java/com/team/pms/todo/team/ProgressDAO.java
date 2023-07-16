package com.team.pms.todo.team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.team.pms.center.wbs.WbsDTO;
import com.test.my.DBUtil;

public class ProgressDAO {

   Connection conn;
   Statement stat;
   PreparedStatement pstat;
   ResultSet rs;

   public ProgressDAO() {
      conn = DBUtil.open("localhost","team","java1234");
   }

   public ArrayList<ProgressDTO> getProgress(String employeeseq, int n) {
	      try {
	         String sql = "select \r\n"
	         		+ "        b.*\r\n"
	         		+ "        ,(select name from employee where employeeseq = b.employeeseq) as name\r\n"
	         		+ "        ,rownum as rnum1\r\n"
	         		+ "from\r\n"
	         		+ "(select a.*, rownum as rnum\r\n"
	         		+ "from                    \r\n"
	         		+ "(select w.*  \r\n"
	         		+ "from wbs w\r\n"
	         		+ "Inner join project p  \r\n"
	         		+ "on w.projectseq = p.projectseq\r\n"
	         		+ "where employeeseq in (select employeeseq from employee where teamseq = (select teamseq from employee where employeeseq = ?)) and w.projectseq = (select max(projectseq) from ownproject where employeeseq = ?) \r\n"
	         		+ "order by w.wbsseq asc) a) b\r\n"
	         		+ "where rnum between ? and ?";

	         pstat = conn.prepareStatement(sql);
	         pstat.setString(1, employeeseq);
	         pstat.setString(2, employeeseq);
	         pstat.setInt(3, n);
	         pstat.setInt(4, n + 9);
	         rs = pstat.executeQuery();

	         ArrayList<ProgressDTO> list = new ArrayList<ProgressDTO>();

	         while (rs.next()) {
	            ProgressDTO dto = new ProgressDTO();
	            
	            dto.setRownum(rs.getString("rnum"));
	            dto.setWbsseq(rs.getString("wbsseq"));
	            dto.setWbsname(rs.getString("wbsname"));
	            dto.setPercent(rs.getString("percent"));
	            dto.setProjectseq(rs.getString("projectseq"));
	            dto.setName(rs.getString("name"));

	            list.add(dto);
	         }
	         return list;
	      } catch (Exception e) {
	         e.printStackTrace();
	      }

	      return null;
	   }


   public int getLv(String employeeseq) {
      try {
         String sql = "select lv from employee where employeeseq = ?";

         pstat = conn.prepareStatement(sql);
         pstat.setString(1, employeeseq);

         rs = pstat.executeQuery();

         if (rs.next()) {
            return rs.getInt("lv");
         }
      } catch (Exception e) {
         e.printStackTrace();
      }

      return 0;
   }

   public ArrayList<ProgressDTO> getWbs(String employeeseq, int n) {
      try {
         String sql = "select rownum as rnum1, e.* from (select a.*, rownum as rnum \r\n"
         		+ "from (select * from vwwbs where employeeseq in (select employeeseq from employee where teamseq = \r\n"
         		+ "(select teamseq from employee where employeeseq = ?))\r\n"
         		+ "and projectseq = (select max(projectseq) from ownproject where employeeseq = ?)) a\r\n"
         		+ "order by wbsseq) e\r\n"
         		+ "where rnum between ? and ?";

         pstat = conn.prepareStatement(sql);

         pstat.setString(1, employeeseq);
         pstat.setString(2, employeeseq);
         pstat.setInt(3, n);
         pstat.setInt(4, n + 9);
         
         rs = pstat.executeQuery();

         ArrayList<ProgressDTO> list = new ArrayList<ProgressDTO>();
         while (rs.next()) {
            ProgressDTO dto = new ProgressDTO();

            dto.setStartdate(rs.getString("startdate"));
            dto.setEnddate(rs.getString("enddate"));
            dto.setName(rs.getString("name"));
            dto.setPosition(rs.getString("position"));
            dto.setWbsname(rs.getString("wbsname"));
            dto.setWbsseq(rs.getString("wbsseq"));
            dto.setRownum(rs.getString("rnum"));

            list.add(dto);
         }
         return list;

      } catch (Exception e) {
         e.printStackTrace();
      }

      return null;
   }

   public ArrayList<ProgressDTO> getTeam(String employeeseq) {
      try {
         String sql = "select e.name, e.employeeseq, e.position \r\n"
         		+ "from employee e\r\n"
         		+ "Inner join ownproject op\r\n"
         		+ "on e.employeeseq = op.employeeseq\r\n"
         		+ "where e.teamseq = (select teamseq from employee where employeeseq = ?) and op.projectseq = (select max(projectseq) from ownproject where employeeseq = ?)";

         pstat = conn.prepareStatement(sql);
         pstat.setString(1, employeeseq);
         pstat.setString(2, employeeseq);

         rs = pstat.executeQuery();
         ArrayList<ProgressDTO> list = new ArrayList<ProgressDTO>();

         while (rs.next()) {
            ProgressDTO dto = new ProgressDTO();

            dto.setPosition(rs.getString("position"));
            dto.setName(rs.getString("name"));
            dto.setEmployeeseq(rs.getString("employeeseq"));
            list.add(dto);
         }
         return list;
      } catch (Exception e) {
         e.printStackTrace();
      }

      return null;
   }

   public String getPosition(String seq) {
      try {
         String sql = "select position from employee where employeeseq = ?";

         pstat = conn.prepareStatement(sql);
         pstat.setString(1, seq);

         rs = pstat.executeQuery();

         if (rs.next()) {
            return rs.getString("position");
         }
      } catch (Exception e) {
         e.printStackTrace();
      }

      return null;
   }

   public int insertWbs(ProgressDTO dto) {
      try {
         String projectseq = myProject(dto.getEmployeeseq());
         
         
         String sql = "insert into wbs values(wbsseq.nextval, ?, ?, ?, 0, ?, ?)";
         
         pstat = conn.prepareStatement(sql);
         pstat.setString(1, dto.getWbsname());
         pstat.setString(2, dto.getStartdate());
         pstat.setString(3, dto.getEnddate());
         pstat.setString(4, projectseq);
         pstat.setString(5, dto.getEmployeeseq());
         
         return pstat.executeUpdate();
         
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return 0;
   }
   
   public String myProject(String seq) {
      try {
         String sql = "select max(projectseq) as projectseq from ownproject where employeeseq = ?";
         
         pstat = conn.prepareStatement(sql);
         pstat.setString(1, seq);
         
         rs = pstat.executeQuery();
         
         if(rs.next()) {
            return rs.getString("projectseq");
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      
      return null;
   }

   public int updateWbs(ProgressDTO dto) {
      try {
         String sql = "update wbs set wbsname = ?, startdate = ?, enddate = ?, employeeseq = ? where wbsseq =?";
         
         pstat = conn.prepareStatement(sql);
         pstat.setString(1, dto.getWbsname());
         pstat.setString(2, dto.getStartdate());
         pstat.setString(3, dto.getEnddate());
         pstat.setString(4, dto.getEmployeeseq());
         pstat.setString(5, dto.getWbsseq());
         
         return pstat.executeUpdate();
         
      } catch (Exception e) {
         e.printStackTrace();
      }
      return 0;
   }

   public int delete(String wbsseq) {
      try {
         String sql = "delete from wbs where wbsseq = ?";
         
         pstat = conn.prepareStatement(sql);
         pstat.setString(1, wbsseq);
         
         return pstat.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return 0;
   };

   
   public int getNewWbsSeq(String employeeseq) {
      try {
         String sql = "select max(wbsseq) as wbsseq \r\n"
               + "from vwwbs  \r\n"
               + "where employeeseq in (select employeeseq from employee where teamseq = (select teamseq from employee where employeeseq = ?))";
         
         pstat = conn.prepareStatement(sql);
         pstat.setString(1, employeeseq);
         
         rs = pstat.executeQuery();
         
         if(rs.next()) {
            return rs.getInt("wbsseq");
         }
         
      } catch (Exception e) {
         e.printStackTrace();
      }
         
      
      return 0;
      
   }

   public ArrayList<ProgressDTO> selectWbs(String employeeseq) {
      try {
         String sql = "select rownum as rnum, w.* from vwwbs w where employeeseq = ? and projectseq = (select max(projectseq) from ownproject where employeeseq = ?)";
         
         pstat = conn.prepareStatement(sql);
         pstat.setString(1, employeeseq);
         pstat.setString(2, employeeseq);
         
         rs = pstat.executeQuery();
         
         ArrayList<ProgressDTO> list = new ArrayList<ProgressDTO>();
         
         while(rs.next()) {
            ProgressDTO dto = new ProgressDTO();
            
            dto.setRownum(rs.getString("rnum"));
            dto.setWbsseq(rs.getString("wbsseq"));
            dto.setWbsname(rs.getString("wbsname"));
            dto.setName(rs.getString("name"));
            dto.setPosition(rs.getString("position"));
            dto.setStartdate(rs.getString("startdate"));
            dto.setEnddate(rs.getString("enddate"));
            
            list.add(dto);
         }
         return list;
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return null;
   }
   
   public int teamMaxRow(String employeeseq) {
      try {
         String sql = "select max(rownum) as max from (select rownum as rnum,e.* from vwwbs e where employeeseq in (select employeeseq from employee where teamseq = (select teamseq from employee where employeeseq = ?)))";
         
         pstat = conn.prepareStatement(sql);
         
         pstat.setString(1, employeeseq);
         
         rs = pstat.executeQuery();
         
         if(rs.next()) {
            return rs.getInt("max");
         }
         
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return 0;
   }

   public int maxRow(String employeeseq) {
      try {
         String sql = "select max(rownum) as max from (select rownum as rnum, w.* from vwwbs w where employeeseq = ?)";
         
         pstat = conn.prepareStatement(sql);
         
         pstat.setString(1, employeeseq);
         
         rs = pstat.executeQuery();
         
         if(rs.next()) {
            return rs.getInt("max");
         }
         
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return 0;
   }

   public List<WbsDTO> getTeamChart(String employeeseq) {
      try {
         String sql ="select e.employeeseq, count(*) as cnt, e.name from wbs w\r\n"
               + "inner join employee e\r\n"
               + "on w.employeeseq = e.employeeseq\r\n"
               + "where e.employeeseq in (select e.employeeseq as employeeseq  from wbs w\r\n"
               + "inner join employee e\r\n"
               + "on w.employeeseq = e.employeeseq\r\n"
               + "where e.teamseq = (select teamseq from employee where employeeseq = ?))\r\n"
               + "group by e.employeeseq, e.name\r\n"
               + "order by e.employeeseq asc";
         
         pstat = conn.prepareStatement(sql);
         
         pstat.setString(1, employeeseq);
         
         rs = pstat.executeQuery();
         
         List<WbsDTO> list = new ArrayList<WbsDTO>();
         while(rs.next()) {
            WbsDTO dto = new WbsDTO();
            
            dto.setEmployeeseq(rs.getString("employeeseq"));
            dto.setPname(rs.getString("name"));
            dto.setCount(rs.getInt("cnt"));
            
            list.add(dto);
         }
         return list;
         
      } catch (Exception e) {
         e.printStackTrace();
      
      }
      return null;
   }

   public ArrayList<Integer> getTeamChartPercent(String employeeseq) {
      
      try {
         String sql = "select e.employeeseq, count(*) as cnt, e.name from wbs w\r\n"
               + "inner join employee e\r\n"
               + "on w.employeeseq = e.employeeseq\r\n"
               + "where e.employeeseq in (select e.employeeseq as employeeseq  from wbs w\r\n"
               + "inner join employee e\r\n"
               + "on w.employeeseq = e.employeeseq\r\n"
               + "where e.teamseq = (select teamseq from employee where employeeseq = ?)) and percent = 100\r\n"
               + "group by e.employeeseq, e.name\r\n"
               + "order by e.employeeseq asc";
         
         pstat = conn.prepareStatement(sql);
         pstat.setString(1, employeeseq);
         
         rs = pstat.executeQuery();
         
         ArrayList<Integer> list = new ArrayList<Integer>();
         while(rs.next()) {
            list.add(rs.getInt("cnt"));
         }
         return list;
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      
      return null;
   }
}
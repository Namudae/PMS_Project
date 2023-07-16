package com.team.pms.sign.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.test.my.DBUtil;
import com.team.pms.sign.repository.SignListDTO;

public class SignListDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public SignListDAO() {
		this.conn = DBUtil.open("localhost","team","java1234");
	}
	
	
	//View 서블릿이 번호를 줄테니 레코드 1줄(DTO)를 주세요~
	public List<SignListDTO> get(String seq) {
		
		try {
			

			String sql = "select sign.*, (select name from employee where employeeseq = sign.employeeseq) as name, (select filename from productFile where productFile.fileseq = sign.fileseq) as filename from Sign where signseq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, seq);

			rs = pstat.executeQuery();
			
			List<SignListDTO> list = new ArrayList<SignListDTO>();

			while (rs.next()) {

				SignListDTO dto = new SignListDTO();

				dto.setSignseq(rs.getString("signseq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setSigndate(rs.getString("signdate"));
				dto.setSignokdate(rs.getString("signokdate"));
				dto.setSignok(rs.getString("signok"));
				dto.setEmployeeseq(rs.getString("employeeseq"));
				dto.setProjectseq(rs.getString("projectseq"));
				dto.setFileseq(rs.getString("fileseq"));
				dto.setName(rs.getString("name"));
				dto.setFilename(rs.getString("filename"));
				
				list.add(dto);

			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public List<SignListDTO> signlist(String employeeSeq) {

		try {

	         String sql = "select signseq, title, content, to_char(signdate, 'yyyy-mm-dd') as signdate, to_char(signokdate, 'yyyy-mm-dd') as signokdate, signok, employeeseq, projectseq, fileseq, (select name from employee where employeeseq = sign.employeeseq) as name from Sign order by signseq desc";


	         stat = conn.createStatement();
	         rs = stat.executeQuery(sql);
	         
	         List<SignListDTO> list = new ArrayList<SignListDTO>();

	         while (rs.next()) {

	        	SignListDTO dto = new SignListDTO();

				dto.setSignseq(rs.getString("signseq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setSigndate(rs.getString("signdate"));
				dto.setSignokdate(rs.getString("signokdate"));
				dto.setSignok(rs.getString("signok"));
				dto.setEmployeeseq(rs.getString("employeeseq"));
				dto.setProjectseq(rs.getString("projectseq"));
				dto.setName(rs.getString("name"));

	            
	            
	            list.add(dto);
	         }

	         System.out.println(list);
	         return list;

	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
		return null;
	}
	
	public List<SignListDTO> list(HashMap<String, String> map) {
	      
	      List<SignListDTO> list = new ArrayList<SignListDTO>();
	      
	      try {
	         
	         String sql = String.format("select * from (select a.*, rownum as rnum from vwsign a) where rnum between %s and %s order by signseq desc"                              
	               , map.get("begin")
	               , map.get("end")
	            );
	         
	         stat = conn.createStatement();
	         rs = stat.executeQuery(sql);
	         
	         
	         while  (rs.next()) {
	            
	        	SignListDTO dto = new SignListDTO();
	            
	        	dto.setSignseq(rs.getString("signseq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setSigndate(rs.getString("signdate"));
				dto.setSignokdate(rs.getString("signokdate"));
				dto.setSignok(rs.getString("signok"));
				dto.setEmployeeseq(rs.getString("employeeseq"));
				dto.setProjectseq(rs.getString("projectseq"));
				dto.setName(rs.getString("name"));
	            
	            list.add(dto);
	            
	         }
	         
	         
	         return list;

	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	      
	      return list;
	   }
	
	//Edit 서블릿이 DTO를 줄테니 수정해주세요.
	public int edit(SignListDTO dto) {
		
		try {

			String sql = "update sign set title = ?, content = ? where signseq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getSignseq());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	//Del
	public int delsign(SignListDTO dto) {
		
		try {

			String sql = "delete from sign where signseq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getSignseq());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int addsign(SignListDTO dto) {
		
		try {

			String sql = "INSERT ALL\r\n"
					+ "  INTO sign (signseq, title, content, signdate, signokdate, signok, employeeseq, projectseq, fileseq)\r\n"
					+ "    VALUES (signseq.nextVal, ?, ?, default, '', default, ?, ?, fileseq.nextVal)\r\n"
					+ "  INTO productfile (fileseq, productseq, filename)\r\n"
					+ "    VALUES (fileseq.nextVal, '', ?)\r\n"
					+ "SELECT * FROM dual";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getEmployeeseq());
			pstat.setString(4, dto.getProjectseq());
			pstat.setString(5, dto.getFilename());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}


	public List<SignListDTO> projectlist() {

		try {

			String sql = "select projectseq, name from project";

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			List<SignListDTO> list = new ArrayList<SignListDTO>();

			while (rs.next()) {

				SignListDTO dto = new SignListDTO();

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


	public int signokedit(SignListDTO dto) {
		
		try {

			String sql = "update sign set signokdate = sysdate, signok = 'y' where signseq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getSignseq());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}


	public int signnoedit(SignListDTO dto) {
		
		try {

			String sql = "update sign set signokdate = sysdate, signok = 'n' where signseq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getSignseq());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}


	public int getTotalCount() {
		
		try {


		      String sql = "select count(*) as cnt from vwsign";

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


	public String signwait() {
		try {
			
			String sql = "select count(*) as signwait from sign where signok = 'w'";
			
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				
				return rs.getString("signwait");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

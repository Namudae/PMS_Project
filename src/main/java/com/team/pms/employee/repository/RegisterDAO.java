package com.team.pms.employee.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.team.pms.notice.repository.NoticeDTO;
import com.test.my.DBUtil;

public class RegisterDAO {
	Connection conn;
	Statement stat;
	PreparedStatement pstat;
	ResultSet rs;

	public RegisterDAO() {
		conn = DBUtil.open("localhost", "team", "java1234");
	}

	public List<RegisterDTO> login(RegisterDTO dto) {

	      try {

	         String sql = "SELECT *\r\n"
	               + "FROM employee e\r\n"
	               + "INNER JOIN register r ON e.employeeseq = r.employeeseq\r\n"
	               + "inner join wbs w\r\n"
	               + "on e.employeeseq = w.employeeseq\r\n"
	               + "inner join project p\r\n"
	               + "on w.projectseq = p.projectseq\r\n"
	               + "WHERE id = ? AND pw = ?";

	         pstat = conn.prepareStatement(sql);

	         pstat.setString(1, dto.getId());
	         pstat.setString(2, dto.getPw());

	         rs = pstat.executeQuery();

	         List<RegisterDTO> list = new ArrayList<RegisterDTO>();

	         while (rs.next()) {

	            RegisterDTO dtot = new RegisterDTO();
	            dtot.setId(rs.getString("id"));
	            dtot.setPw(rs.getString("pw"));
	            dtot.setLv(rs.getString("lv"));
	            dtot.setEmployeeseq(rs.getString("employeeseq"));
	            dtot.setProjectseq(rs.getString("projectseq"));

	            list.add(dtot);
	         }

	         return list;

	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return null;
	   }

	public RegisterDTO myInfoPlus(String employeeSeq) {
		
		RegisterDTO dto = new RegisterDTO();
		
		try {

			String sql = "select r.id, e.name, e.lv, e.email from register r\r\n"
					+ "    inner join employee e \r\n"
					+ "on r.employeeSeq = e.employeeSeq where id = '?'";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, employeeSeq);

			rs = pstat.executeQuery();

			while (rs.next()) {
				
				dto.setName(rs.getString("name"));
				dto.setLv(rs.getString("lv"));
				dto.setEmail(rs.getString("email"));
				dto.setId(rs.getString("id"));
				
				return dto;
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}



	public RegisterDTO userdetail(String employeeSeq) {
		try {
			String sql = "select e.name, e.position, e.email, r.id  from register r\r\n"
					+ "inner join employee e on r.employeeseq = e.employeeseq where e.employeeseq=?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1,employeeSeq);
			

			rs = pstat.executeQuery();

			if (rs.next()) {
				
				RegisterDTO dto = new RegisterDTO();
				
				dto.setName(rs.getString("name"));
				dto.setPs(rs.getString("position"));
				dto.setEmail(rs.getString("email"));
				dto.setId(rs.getString("id"));
				
				return dto;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public int PwEdit(String newPw, String newPw2, String employeeSeq) {
		try {

			
			
				String sql = "update register set pw = ? where employeeSeq = ?";
	
				pstat = conn.prepareStatement(sql);
	
				pstat.setString(1, newPw);
				pstat.setString(2, employeeSeq);

				
				return pstat.executeUpdate();
				
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}



	public List<RegisterDTO> teamlist() {
		
		List<RegisterDTO> teamlist = new ArrayList<RegisterDTO>();
		
		try {
			String sql = "SELECT * FROM team";

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			

			while (rs.next()) {
				
				RegisterDTO dto = new RegisterDTO();
				
				dto.setTeamseq(rs.getString("teamseq"));
				dto.setTeam(rs.getString("name"));
				
				
				teamlist.add(dto);
				
				
			}
			
			return teamlist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public int EmployeeAdd(RegisterDTO dto) {
		
		try {

			String sql = "insert into employee values (employeeseq.nextVal, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstat = conn.prepareStatement(sql);

		
			
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getTel());
			pstat.setString(3, dto.getJoindate());
			pstat.setString(4, dto.getBirth());
			pstat.setString(5, dto.getPs());
			pstat.setString(6, dto.getLv());
			pstat.setString(7, dto.getEmail());
			pstat.setString(8, dto.getAddress());
			pstat.setString(9, dto.getTeamseq());
			
			

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int RegisterAdd(RegisterDTO dto) {
		
		try {

			String sql = "insert into register values (?, ?, (select max(employeeseq) from employee))";

			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public String checkId(String id) {
		try {
			String sql = "SELECT ID FROM REGISTER";
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				String dbId = rs.getString("id");
				
				if(id.equals(dbId)) {
					System.out.println("실패");
					return "실패";
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("성공");
		return "성공";
		
	}

	
}

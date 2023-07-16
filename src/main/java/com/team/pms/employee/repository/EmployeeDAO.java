package com.team.pms.employee.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.my.DBUtil;

public class EmployeeDAO {
	Connection conn;
	Statement stat;
	PreparedStatement pstat;
	ResultSet rs;

	public EmployeeDAO() {
		conn =  DBUtil.open("localhost", "team", "java1234");
	}

	public EmployeeDTO myInfo(String employeeSeq) {
		EmployeeDTO dto = new EmployeeDTO();

		try {
			String sql = "select employee.*, (select name from team where teamseq = employeeseq) as teamName from employee where employeeseq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, employeeSeq);

			rs = pstat.executeQuery();
			
			if (rs.next()) {
				dto.setEmployeeSeq(employeeSeq);
				
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dto.setJoinDate(rs.getString("joindate"));
				dto.setBirth(rs.getString("birth"));
				dto.setPosition(rs.getString("Position"));
				dto.setLv(rs.getString("lv"));
				dto.setEmail(rs.getString("email"));
				dto.setAddress(rs.getString("address"));
				dto.setTeamSeq(rs.getString("teamSeq"));
				dto.setTeamName(rs.getString("teamname"));
				
				return dto;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public String teamName(String teamSeq) {
		try {
			String sql = "SELECT name from team where teamSeq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, teamSeq);
			
			rs = pstat.executeQuery();
			if (rs.next()) {
				return rs.getString("name");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}
//
//	public List<EmployeeDTO> get(String seq) {
//		
//		try {
//
//			String sql = "sql";
//
//			pstat = conn.prepareStatement(sql);
//			pstat.setString(1, seq);
//
//			rs = stat.executeQuery(sql);
//
//			List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
//
//			while (rs.next()) {
//
//				EmployeeDTO dto = new EmployeeDTO();
//
//				
//
//				list.add(dto);
//			}
//
//			return list;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return null;
//	}

	public ArrayList<EmployeeDTO> myTeam(String employeeSeq) {
		try {
			String sql = "select * from employee where teamseq = (select teamseq from employee where employeeseq = ?) and employeeseq != ? "
					+ "order by employeeseq asc";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, employeeSeq);
			pstat.setString(2, employeeSeq);
			
			rs = pstat.executeQuery();
			
			
			ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
			
			while(rs.next()) {
				
				EmployeeDTO dto = new EmployeeDTO();
				dto.setEmployeeSeq(rs.getString("employeeseq"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dto.setJoinDate(rs.getString("joindate"));
				dto.setBirth(rs.getString("birth"));
				dto.setPosition(rs.getString("position"));
				dto.setLv(rs.getString("lv"));
				dto.setEmail(rs.getString("email"));
				dto.setAddress(rs.getString("address"));
				dto.setTeamSeq(rs.getString("teamSeq"));
				
				list.add(dto);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}

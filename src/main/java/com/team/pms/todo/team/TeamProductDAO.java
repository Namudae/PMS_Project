package com.team.pms.todo.team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.test.my.DBUtil;

public class TeamProductDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public TeamProductDAO() {
		this.conn = DBUtil.open("localhost","team","java1234");
	}

	public TeamProductDTO get(String productseq) {

		try {

			
			String sql = "select * from vwdetailproduct where productseq = ?";
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, productseq);

			rs = pstat.executeQuery();

			if (rs.next()) {
				TeamProductDTO dto = new TeamProductDTO();

				dto.setProductSeq(rs.getString("productSeq"));
				dto.setProductName(rs.getString("productName"));
				dto.setProductDate(rs.getString("productDate").substring(0, 10));
				dto.setContent(rs.getString("content"));
				dto.setProjectName(rs.getString("projectName"));
				dto.setFileName(rs.getString("fileName"));
				dto.setFileSeq(rs.getString("fileSeq"));
				dto.setEmployeeName(rs.getString("employeeName"));
				
				return dto;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
}

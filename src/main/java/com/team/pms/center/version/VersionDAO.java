package com.team.pms.center.version;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.team.pms.center.issue.CIssueDTO;
import com.test.my.DBUtil;

public class VersionDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public VersionDAO() {
		   conn =  DBUtil.open("localhost", "team", "java1234");
	}

	public List<VersionDTO> versionlist(String projectseq) {
		
		try {

			String sql = "select * from centerversion where projectseq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, projectseq);

			rs = pstat.executeQuery();

			List<VersionDTO> list = new ArrayList<VersionDTO>();

			while (rs.next()) {

				VersionDTO dto = new VersionDTO();

				dto.setVersionseq(rs.getString("versionseq"));
				dto.setVersion(rs.getString("version"));
				dto.setContent(rs.getString("content"));
				dto.setVersiondate(rs.getString("versiondate"));
				dto.setFilename(rs.getString("filename"));
				dto.setProjectname(rs.getString("name"));

				list.add(dto);
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public VersionDTO getversion(String versionseq, String projectseq) {
		
		try {

			String sql = "select * from centerversion where projectseq = ? and versionseq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, projectseq);
			pstat.setString(2, versionseq);

			rs = pstat.executeQuery();

			if (rs.next()) {

				VersionDTO dto = new VersionDTO();

				dto.setVersionseq(rs.getString("versionseq"));
				dto.setVersion(rs.getString("version"));
				dto.setContent(rs.getString("content"));
				dto.setVersiondate(rs.getString("versiondate"));
				dto.setFilename(rs.getString("filename"));
				dto.setProjectname(rs.getString("name"));
				dto.setProjectseq(rs.getString("projectseq"));

				return dto;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int addversion(VersionDTO dto) {
		
	try {

		String sql = "INSERT INTO version (versionseq, version, content, versiondate, filename, projectseq)\r\n"
				+ "VALUES (versionseq.nextVal, ?, ?, ?, ?, ?)";

		pstat = conn.prepareStatement(sql);

		pstat.setString(1, dto.getVersion());
		pstat.setString(2, dto.getContent());
		pstat.setString(3, dto.getVersiondate());
		pstat.setString(4, dto.getFilename());
		pstat.setString(5, dto.getProjectseq());
		

		return pstat.executeUpdate();

	} catch (Exception e) {
		e.printStackTrace();
	}
		
		return 0;
	}

	public VersionDTO getversionproname(String projectseq) {
		
		try {

			String sql = "select distinct(name) as name , projectseq from centerversion where projectseq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, projectseq);


			rs = pstat.executeQuery();

			if (rs.next()) {

				VersionDTO dto = new VersionDTO();

				dto.setProjectname(rs.getString("name"));
				dto.setProjectseq(rs.getString("projectseq"));

				return dto;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	public int versionedit(VersionDTO dto) {
		
		try {

			String sql = "UPDATE version\r\n"
					+ "SET version = ?, content = ?, versiondate = ?, filename = ?\r\n"
					+ "WHERE versionseq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getVersion());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getVersiondate());
			pstat.setString(4, dto.getFilename());
			pstat.setString(5, dto.getVersionseq());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int delversion(String versionseq) {

		try {

			String sql = "delete version where versionseq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, versionseq);

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public String getlv(String employeeseq) {
		
		try {

			String sql = "select lv from employee where employeeseq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, employeeseq);

			rs = pstat.executeQuery();

			if (rs.next()) {

				return rs.getString("lv");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public List<VersionDTO> vslist(HashMap<String, String> map) {
		
		List<VersionDTO> vslist = new ArrayList<VersionDTO>();
		
		try {
					
					String sql = String.format("select * from (select a.* , rownum as rnum from centerversion a where projectseq=%s) where rnum between %s and %s"										
												, map.get("projectseq")
												, map.get("begin")
												, map.get("end")
											);
					
					stat = conn.createStatement();
					rs = stat.executeQuery(sql);
					
					
					while  (rs.next()) {
						
						VersionDTO dto = new VersionDTO();
						
						dto.setVersionseq(rs.getString("versionseq"));
						dto.setVersion(rs.getString("version"));
						dto.setContent(rs.getString("content"));
						dto.setVersiondate(rs.getString("versiondate"));
						dto.setFilename(rs.getString("filename"));
						dto.setProjectname(rs.getString("name"));
						dto.setProjectseq(rs.getString("projectseq"));
						
			            vslist.add(dto);
			            
					}
					
					
					return vslist;

				} catch (Exception e) {
					e.printStackTrace();
				}
		
		return vslist;
	}

	public int getTotalCount(String pjseq) {
		
		try {

			String sql = "select count(*) as cnt from centerversion where projectseq=?";

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


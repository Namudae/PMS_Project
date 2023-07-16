package com.team.pms.notice.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.test.my.DBUtil;

public class NoticeDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public NoticeDAO() {
		this.conn = DBUtil.open("localhost", "team", "java1234");
	}

	public List<NoticeDTO> noticelist(String employeeSeq) {
		
		try {

			String sql = "select noticeseq, noticetype, title, name, noticedate from notice n\r\n"
					+ "inner join employee e\r\n"
					+ "on n.employeeseq = e.employeeseq order by noticedate desc";
			
			stat = conn.createStatement();


			rs = stat.executeQuery(sql);

			List<NoticeDTO> list = new ArrayList<NoticeDTO>();

			while (rs.next()) {

				NoticeDTO dto = new NoticeDTO();
				
				dto.setNoticeseq(rs.getString("noticeseq"));
				dto.setTitle(rs.getString("title"));
				dto.setNoticetype(rs.getString("noticetype"));
				dto.setNoticedate(rs.getString("noticedate"));
				dto.setName(rs.getString("name"));
				
				list.add(dto);
				
		
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<NoticeDTO> teamlist() {
		
		try {

			String sql = "select noticetype from notice";

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			List<NoticeDTO> list = new ArrayList<NoticeDTO>();

			while (rs.next()) {

				NoticeDTO dto = new NoticeDTO();

		
				dto.setNoticetype(rs.getString("noticetype"));
				
				

				list.add(dto);
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int addlist(NoticeDTO dto) {
		
		try {

			String sql = "insert into notice values (noticeseq.nextVal, ?, default, ?, ?, ?)";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getNoticetype());
			pstat.setString(4, dto.getEmployeeseq());
			

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<NoticeDTO> noticelistEdit(String seq) {
		
		try {

			String sql = "select title, noticetype, content from notice where noticeseq = ? ";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);

			rs = stat.executeQuery(sql);

			List<NoticeDTO> list = new ArrayList<NoticeDTO>();

			while (rs.next()) {

				NoticeDTO dto = new NoticeDTO();
				
				dto.setTitle(rs.getString("title"));
				dto.setNoticetype(rs.getString("noticetype"));
				dto.setContent(rs.getString("content"));
				

				list.add(dto);
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int editnotice(NoticeDTO dto) {
		
		try {

			String sql = "update notice set content = ? where noticeseq = ?";

			pstat = conn.prepareStatement(sql);

			System.out.println(dto.getContent());
			System.out.println(dto.getNoticeseq());
			
			pstat.setString(1, dto.getContent());
			pstat.setString(2, dto.getNoticeseq());
			
			

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<NoticeDTO> get(String seq) {
		
		try {

			//String sql = "select title, noticetype, noticedate, content, employeeseq from notice where noticeseq=?";
			
			String sql = "select to_char(noticedate, 'yyyy-mm-dd') as noticedate, title, e.name, noticetype, content, n.noticeseq, e.employeeseq from notice n inner join employee e on n.employeeSeq = e.employeeSeq where noticeseq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);

			rs = pstat.executeQuery();

			List<NoticeDTO> list = new ArrayList<NoticeDTO>();

			while (rs.next()) {

				NoticeDTO dto = new NoticeDTO();
				
				dto.setTitle(rs.getString("title"));
				dto.setNoticetype(rs.getString("noticetype"));
				dto.setNoticedate(rs.getString("noticedate"));
				dto.setName(rs.getString("name"));
				dto.setContent(rs.getString("content"));
				dto.setEmployeeseq(rs.getString("employeeseq"));
				
				list.add(dto);
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int delnotice(NoticeDTO dto) {
		
		try {

			String sql = "delete from notice where noticeseq = ?";

			pstat = conn.prepareStatement(sql);

			System.out.println(dto.getNoticeseq());
			
			pstat.setString(1, dto.getNoticeseq());
			
		
			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public List<NoticeDTO> list(HashMap<String, String> map) {
		
		
		List<NoticeDTO> list = new ArrayList<NoticeDTO>();
		
		
		try {
	         
	         String sql = String.format("SELECT *\r\n"
	         		+ "FROM (\r\n"
	         		+ "  SELECT a.*, ROWNUM AS rnum\r\n"
	         		+ "  FROM (\r\n"
	         		+ "    SELECT *\r\n"
	         		+ "    FROM vwnotice\r\n"
	         		+ "    ORDER BY noticedate DESC\r\n"
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
	            
	            NoticeDTO dto = new NoticeDTO();
	            

				dto.setTitle(rs.getString("title"));
				dto.setNoticetype(rs.getString("noticetype"));
				dto.setNoticedate(rs.getString("noticedate"));
				dto.setName(rs.getString("name"));
				dto.setRnum(rs.getString("rnum"));
				dto.setNoticeseq(rs.getString("noticeseq"));
				
	            list.add(dto);
	            
	         }
	         
	         
	         return list;

	      } catch (Exception e) {
	         e.printStackTrace();
	         
	         
	      } return null;
	      
	}

	public int getTotalCount() {

		try {


		      String sql = "select count(*) as cnt from vwnotice";

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


	
	
}

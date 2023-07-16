package com.team.pms.todo.schedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.my.DBUtil;

public class CalendarDAO {
	Connection conn;
	Statement stat;
	PreparedStatement pstat;
	ResultSet rs;

	public CalendarDAO() {
		conn = DBUtil.open("localhost","team","java1234");
	}

	public ArrayList<CalendarDTO> getThisMonth(String start, String end, String seq) {
		try {
			String sql = "select " + "    calendarseq, " + "    to_char(startdate, 'yyyy-mm-dd') as startdate,"
					+ "    to_char(enddate, 'yyyy-mm-dd') as enddate," + "    content," + "    employeeseq "
					+ "from calendar " + "where startdate >= ? and startdate < ? and employeeseq = ? "
					+ "order by calendarseq asc";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, start);
			pstat.setString(2, end);
			pstat.setString(3, seq);

			rs = pstat.executeQuery();

			ArrayList<CalendarDTO> list = new ArrayList<CalendarDTO>();

			while (rs.next()) {
				CalendarDTO dto = new CalendarDTO();

				dto.setCalendarseq(rs.getString("calendarseq"));
				dto.setStartDate(rs.getString("startdate"));
				dto.setEndDate(rs.getString("enddate"));
				dto.setContent(rs.getString("content"));
				dto.setEmployeeSeq(rs.getString("employeeseq"));

				list.add(dto);
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Object getEndDate(String index) {
		try {
			String sql = "select to_char(startdate, 'yyyy-mm-dd') as startdate from calendar where calendarseq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, index);

			return pstat.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Object getStartDate(String index) {
		try {
			String sql = "select to_char(enddate, 'yyyy-mm-dd') as enddate from calendar where calendarseq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, index);

			return pstat.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Object getTitle(String index) {
		try {
			String sql = "select content from calendar where calendarseq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, index);

			return pstat.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public int calendarAdd(String input, String seq, String day) {
		try {
			String sql = "insert into calendar values(calendarseq.nextval, ?, ?, ?, ?)";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, day);
			pstat.setString(2, day);
			pstat.setString(3, input);
			pstat.setString(4, seq);

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public CalendarDTO getNewLog(String seq) {
		try {
			String sql = "select * from calendar where calendarSeq = (select max(calendarSeq) from calendar where employeeseq = ?)";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);

			rs = pstat.executeQuery();

			CalendarDTO dto = new CalendarDTO();
			if (rs.next()) {
				dto.setEmployeeSeq(seq);
				dto.setContent(rs.getString("content"));
				dto.setStartDate(rs.getString("startdate"));
				dto.setCalendarseq(rs.getString("calendarseq"));

				return dto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public int edit(String input, String seq, String calendarSeq) {
		try {
			String sql = "update calendar set content = ? where employeeseq = ? and calendarseq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, input);
			pstat.setString(2, seq);
			pstat.setString(3, calendarSeq);

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int del(String seq) {
		try {
			String sql = "delete from calendar where calendarseq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);

			return pstat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<CalendarDTO> getHoliday(String startDate, String endDate) {
		try {
			String sql = "select name, holidaydate from holiday where holidaydate >= ? and holidaydate < ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, startDate);
			pstat.setString(2, endDate);

			rs = pstat.executeQuery();

			ArrayList<CalendarDTO> list = new ArrayList<CalendarDTO>();
			while (rs.next()) {
				CalendarDTO dto = new CalendarDTO();
				
				dto.setHolidayDate(rs.getString("holidaydate"));
				dto.setName(rs.getString("name"));
				
				list.add(dto);
			}

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}

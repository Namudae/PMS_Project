package com.team.pms.center.project.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.team.pms.employee.repository.EmployeeDTO;
import com.test.my.DBUtil;

public class ProjectDAO {

	Connection conn;
	Statement stat;
	PreparedStatement pstat;
	ResultSet rs;

	public ProjectDAO() {
		this.conn = DBUtil.open("localhost", "team", "java1234");
	}

	public List<ProjectDTO> list(HashMap<String, String> map) {

		try {

			String where = "";

			if (map.get("isSearch").equals("y")) {

				if (map.get("column").equals("name")) {
					where = String.format("where name like '%%s%%'", map.get("searchBar"));
				}

			}

			String sql = "select * from project ? order by endDate desc";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, where);

			rs = pstat.executeQuery();

			List<ProjectDTO> list = new ArrayList<ProjectDTO>();

			while (rs.next()) {

				ProjectDTO dto = new ProjectDTO();

				dto.setProjectSeq(rs.getString("projectSeq"));
				dto.setName(rs.getString("name"));
				dto.setStartDate(rs.getString("startDate"));
				dto.setEndDate(rs.getString("endDate"));
				dto.setProjectType(rs.getString("projectType"));
				dto.setRndType(rs.getString("rndType"));
				dto.setBudget(rs.getString("budget"));
				dto.setContent(rs.getString("content"));
				dto.setComplete(rs.getString("complete"));

				list.add(dto);

			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 팀 목록 뽑아오기
	public List<EmployeeDTO> teamList() {

		try {

			String sql = "select * from team";

			stat = conn.createStatement();

			rs = stat.executeQuery(sql);

			List<EmployeeDTO> teamList = new ArrayList<EmployeeDTO>();

			while (rs.next()) {

				EmployeeDTO dto = new EmployeeDTO();

				dto.setTeamName(rs.getString("name"));
				dto.setTeamSeq(rs.getString("teamSeq"));

				teamList.add(dto);

			}

			return teamList;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 프로젝트 목록 출력 메소드
	public List<ProjectDTO> list() {

		try {

			String sql = "select \r\n"
					+ "    projectSeq, name, projectType, rndtype, budget, content, complete,\r\n"
					+ "    to_char(startdate, 'yyyy-mm-dd') as startdate , to_char(enddate, 'yyyy-mm-dd') as enddate \r\n"
					+ "from project";

			stat = conn.createStatement();

			rs = stat.executeQuery(sql);

			List<ProjectDTO> list = new ArrayList<ProjectDTO>();

			while (rs.next()) {

				ProjectDTO dto = new ProjectDTO();

				dto.setProjectSeq(rs.getString("projectSeq"));
				dto.setName(rs.getString("name"));
				dto.setStartDate(rs.getString("startDate"));
				dto.setEndDate(rs.getString("enddate"));
				dto.setProjectType(rs.getString("projectType"));
				dto.setRndType(rs.getString("rndType"));
				dto.setBudget(rs.getString("budget"));
				dto.setContent(rs.getString("content"));
				dto.setComplete(rs.getString("complete"));

				list.add(dto);

			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 프로젝트 등록 메소드
	public int addProject(ProjectDTO dto) {

		// 반환값X , 매개변수o

		try {

			String sql = "insert into project(projectSeq, name, startDate, endDate, projectType, rndType, budget, content, complete) "
					+ " values(projectSeq.nextVal, ?, ?, ?, ?, ?, ?, ?, 'n')";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getStartDate());
			pstat.setString(3, dto.getEndDate());
			pstat.setString(4, dto.getProjectType());
			pstat.setString(5, dto.getRndType());
			pstat.setString(6, dto.getBudget());
			pstat.setString(7, dto.getContent());

			return pstat.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return 0;
	}

	// 프로젝트 번호를 매개변수로 프로젝트,직원,
	public List<ProjectDTO> list(String seq) {
		// TODO Auto-generated method stub

		try {

			String sql = "select * from vwCenter where projectSeq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, seq);

			rs = pstat.executeQuery();

			List<ProjectDTO> list = new ArrayList<ProjectDTO>();

			while (rs.next()) {

				ProjectDTO dto = new ProjectDTO();

				dto.setProjectSeq(rs.getString("projectSeq"));
				dto.setName(rs.getString("name"));
				dto.setStartDate(rs.getString("startDate"));
				dto.setEndDate(rs.getString("endDate"));
				dto.setProjectType(rs.getString("projectType"));
				dto.setRndType(rs.getString("rndType"));
				dto.setBudget(rs.getString("budget"));
				dto.setContent(rs.getString("content"));
				dto.setComplete(rs.getString("complete"));
				dto.setEmployeeName(rs.getString("employeeName"));
				dto.setEmployeeLv(rs.getString("lv"));

				list.add(dto);

			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
	public List<ProjectDTO> getList() {
		// TODO Auto-generated method stub
		
		try {
			
			String sql = "select projectSeq, to_char(startDate, 'yyyy-mm-dd') as startDate, to_char(endDate, 'yyyy-mm-dd') as endDate, "
					+ "name, projectType, employeeName, lv "
 					+ "from vwCenter where lv = 2";
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			List<ProjectDTO> list = new ArrayList<ProjectDTO>();
			
			while (rs.next()) {
				
				ProjectDTO dto = new ProjectDTO();
				
				dto.setProjectSeq(rs.getString("projectSeq"));
				dto.setName(rs.getString("name"));
				dto.setStartDate(rs.getString("startDate"));
				dto.setEndDate(rs.getString("endDate"));
				dto.setProjectType(rs.getString("projectType"));
				dto.setEmployeeName(rs.getString("employeeName"));
				dto.setEmployeeLv(rs.getString("lv"));
				
				list.add(dto);
				
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	// 팀번호에 따라 직원 목록 가져오기
	public List<EmployeeDTO> getList(String teamSeq) {

		try {

			String sql = "select name, employeeSeq, lv from employee where teamSeq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, teamSeq);

			rs = pstat.executeQuery();

			List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();

			while (rs.next()) {

				EmployeeDTO dto = new EmployeeDTO();

				dto.setName(rs.getString("name"));
				dto.setLv(rs.getString("lv"));
				dto.setEmployeeSeq(rs.getString("employeeSeq"));

				list.add(dto);

			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<EmployeeDTO> getEmployeeList(String employeeseq) {

		try {

			String sql = "select name, employeeSeq from employee where employeeSeq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, employeeseq);

			rs = pstat.executeQuery();

			List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();

			while (rs.next()) {

				EmployeeDTO dto = new EmployeeDTO();

				dto.setName(rs.getString("name"));
				dto.setEmployeeSeq(rs.getString("employeeSeq"));

				list.add(dto);
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<CostDTO> costList(String seq) {

		try {

			String sql = "select to_char(costdate, 'yyyy-mm-dd') as costdate, to_char(signdate, 'yyyy-mm-dd') as signdate,"
					+ " to_char(money, '9,999,999,999') as money, c.*, p.name "
					+ "from cost c inner join project p on c.projectSeq = p.projectSeq where p.projectSeq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, seq);

			rs = pstat.executeQuery();

			List<CostDTO> list = new ArrayList<CostDTO>();

			while (rs.next()) {

				CostDTO dto = new CostDTO();
				
				dto.setCostSeq(rs.getString("costSeq"));
				dto.setItems(rs.getString("items"));
				dto.setMoney(rs.getString("money"));
				dto.setCostDate(rs.getString("costDate"));
				dto.setSignDate(rs.getString("signDate"));
				dto.setProjectSeq(rs.getString("projectSeq"));
				dto.setProjectName(rs.getString("name"));

				list.add(dto);
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public int addEmployee(ProjectDTO dto) {

		try {

			String sql = "insert into ownProject(projectSeq, employeeSeq) values((select max(projectseq) as maxseq from project), ?)";

			pstat = conn.prepareStatement(sql);

			for (String employee : dto.getAddEmployee()) {

				pstat.setString(1, employee);

				pstat.executeUpdate();

			}

			pstat.setString(1, dto.getPmName());

			pstat.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return 0;
	}

	public ProjectDTO projectList(String seq) {

		try {

			String sql = "select projectSeq, name, projectType, rndType, "
					+ " TO_CHAR(budget, '9,999,999,999') AS budget, content, complete, to_char(startdate, 'yyyy-mm-dd') as startdate , to_char(enddate, 'yyyy-mm-dd') as enddate "
					+ 	"from project where projectSeq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, seq);

			rs = pstat.executeQuery();

			if (rs.next()) {

				ProjectDTO dto = new ProjectDTO();

				dto.setProjectSeq(rs.getString("projectSeq"));
				dto.setName(rs.getString("name"));
				dto.setStartDate(rs.getString("startDate"));
				dto.setEndDate(rs.getString("endDate"));
				dto.setProjectType(rs.getString("projectType"));
				dto.setRndType(rs.getString("rndType"));
				dto.setBudget(rs.getString("budget"));
				dto.setContent(rs.getString("content"));
				dto.setComplete(rs.getString("complete"));

				return dto;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public CostDTO addCost(CostDTO dto) {

		try {

			String sql = "insert into cost(costSeq, items, money, costDate, signDate, projectSeq)"
					+ "	values(costSeq.nextVal, ?, ?, ?, ?, ?)";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getItems());
			pstat.setString(2, dto.getMoney());
			pstat.setString(3, dto.getCostDate());
			pstat.setString(4, dto.getSignDate());
			pstat.setString(5, dto.getProjectSeq());

			pstat.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	public List<ProjectDTO> elist(String seq) {

		try {

			String sql = "select e.name as employeeName, e.lv as employeeLv from employee e\r\n"
					+ "inner join ownProject op\r\n" + "    on e.employeeSeq = op.employeeSeq\r\n"
					+ "        where op.projectSeq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, seq);

			rs = pstat.executeQuery();

			List<ProjectDTO> list = new ArrayList<ProjectDTO>();

			while (rs.next()) {

				ProjectDTO dto = new ProjectDTO();

				dto.setEmployeeName(rs.getString("employeeName"));
				dto.setEmployeeLv(rs.getString("employeeLv"));

				list.add(dto);
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<String> getRndType() {
		try {
			String sql = "select distinct rndType from project";

			stat = conn.createStatement();

			rs = stat.executeQuery(sql);

			ArrayList<String> strList = new ArrayList<String>();

			while (rs.next()) {
				String str = rs.getString("rndType");
				strList.add(str);
			}

			return strList;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<String> getProjectType() {
		try {
			String sql = "select distinct projectType from project";

			stat = conn.createStatement();

			rs = stat.executeQuery(sql);

			ArrayList<String> strList = new ArrayList<String>();

			while (rs.next()) {
				String str = rs.getString("projecttype");

				strList.add(str);
			}

			return strList;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	
	
	
	public CostDTO updateCost(CostDTO dto) {
		
		//반환값X , 매개변수o

		try {
			
			
			
			
			String sql = "update cost set items = ?, money = ? , costDate = ? , signDate = ? "
						+ "where costSeq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getItems());
			pstat.setString(2, dto.getMoney());
			pstat.setString(3, dto.getCostDate());
			pstat.setString(4, dto.getSignDate());
			pstat.setString(5, dto.getCostSeq());

			pstat.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
		
		
		return null;
	}

	public List<ProjectDTO> pjlist(HashMap<String, String> map) {

		
		List<ProjectDTO> pjlist = new ArrayList<ProjectDTO>();
		
		String pjseq = map.get("pjseq");
		String where = "";

		if (pjseq.equals("all")) {
		    // "pjseq"가 "all"인 경우
		    where = "";
		} else {
		    try {
		        int projectSeq = Integer.parseInt(pjseq);
		        if (projectSeq >= 1 && projectSeq <= 100000) {
		            // "pjseq"가 1부터 100000 범위에 해당하는 경우
		            where = "and projectseq=" + projectSeq;
		        } else {
		            // 유효한 범위를 벗어나는 경우
		            // 처리할 로직 추가
		        }
		    } catch (NumberFormatException e) {
		        // "pjseq"가 숫자로 변환할 수 없는 경우
		        // 처리할 로직 추가
		    }
		}
		
		
		try {
			
			String sql = String.format("select * from (select a.*, rownum as rnum from vwCenter a where lv=%s %s) where rnum between %s and %s order by rnum"										
										, "2"
										, where
										, map.get("begin")
										, map.get("end")
									);
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			
			while  (rs.next()) {
				
				ProjectDTO dto = new ProjectDTO();
				
				dto.setProjectSeq(rs.getString("projectSeq"));
				dto.setName(rs.getString("name"));
				dto.setStartDate(rs.getString("startDate"));
				dto.setEndDate(rs.getString("endDate"));
				dto.setProjectType(rs.getString("projectType"));
				dto.setEmployeeName(rs.getString("employeeName"));
				dto.setEmployeeLv(rs.getString("lv"));
				
				pjlist.add(dto);
				
			}
			
			
			return pjlist;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	
	
	
	}

	public int getTotalCountPr() {
		
		
		
		
		try {
			

			String sql = "select count(*) as cnt from vwCenter where lv = 2";

			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);

			if (rs.next()) {

				return rs.getInt("cnt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getTotalCount2(HashMap<String, String> map) {

		String pjseq = map.get("pjseq");
		String where = "";

		if (pjseq.equals("all")) {
		    // "pjseq"가 "all"인 경우
		    where = "";
		} else {
		    try {
		        int projectSeq = Integer.parseInt(pjseq);
		        if (projectSeq >= 1 && projectSeq <= 100000) {
		            // "pjseq"가 1부터 100000 범위에 해당하는 경우
		            where = "and projectseq=" + projectSeq;
		        } else {
		            // 유효한 범위를 벗어나는 경우
		            // 처리할 로직 추가
		        }
		    } catch (NumberFormatException e) {
		        // "pjseq"가 숫자로 변환할 수 없는 경우
		        // 처리할 로직 추가
		    }
		}
		
		
		
	
	try {
		

		String sql = String.format("select count(*) as cnt from vwCenter where lv = 2 %s"
												,where
									);

		stat = conn.createStatement();
		rs = stat.executeQuery(sql);

		if (rs.next()) {

			return rs.getInt("cnt");
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return 0;
		
		
	}

	public String getCseq() {
	
		
		try {

			String sql = "select max(costSeq) as costSeq from cost";

			stat = conn.createStatement();
		
			rs = stat.executeQuery(sql);

			if (rs.next()) {
				return rs.getString("costSeq");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return null;
	}

	public void delCost(String cseq) {

		
		//반환값X , 매개변수o

		try {

			String sql = "delete from cost where costSeq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, cseq);
			pstat.executeUpdate();

			
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
	}

	public void editDetailProject(ProjectDTO dto) {
	
		try {

			String sql = "update project set name = ?, startDate = ?, "
					+ "endDate = ? , budget = ?, content = ?, rndType = ?, projectType = ?"
					+ "where projectSeq = ?";
			
			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getStartDate());
			pstat.setString(3, dto.getEndDate());
			pstat.setString(4, dto.getBudget());
			pstat.setString(5, dto.getContent());
			pstat.setString(6, dto.getRndType());
			pstat.setString(7, dto.getProjectType());
			pstat.setString(8, dto.getProjectSeq());
			
			pstat.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
		
	}




}

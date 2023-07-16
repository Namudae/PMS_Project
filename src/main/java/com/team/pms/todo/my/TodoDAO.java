package com.team.pms.todo.my;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.team.pms.PjDTO;
import com.test.my.DBUtil;


public class TodoDAO {
	private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;
   
    public TodoDAO() {
    	this.conn = DBUtil.open("localhost","team","java1234");
    }
    

	public List<TodoDTO> listWbs() {
		
		try {
			
			String sql = "select \n"
					+ "    distinct w.wbsseq, w.wbsname, pj.name as pjname, e.name as emname, to_char(w.startdate,'yyyy-mm-dd') as startdate, to_char(w.enddate,'yyyy-mm-dd') as enddate,w.percent\n"
					+ "from \n"
					+ "    product p \n"
					+ "    inner join project pj on p.projectseq = pj.projectseq\n"
					+ "    inner join employee e on e.employeeseq = p.employeeseq\n"
					+ "    inner join wbs w on w.projectseq = pj.projectseq\n"
					+ "    where e.employeeseq = ?\n"
					+ "    order by wbsseq";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			List<TodoDTO> wlist = new ArrayList<TodoDTO>();
			
			while  (rs.next()) {
				
				TodoDTO dto = new TodoDTO();
				
				dto.setSeq(rs.getString("wbsseq"));
				dto.setWbsname(rs.getString("wbsname"));
				dto.setStart(rs.getString("startdate"));
				dto.setEnd(rs.getString("enddate"));
				dto.setPer(rs.getString("percent"));
				dto.setPjname(rs.getString("pjname"));
				dto.setEmname(rs.getString("emname"));
				
				
				wlist.add(dto);
				
			}
			
			
			
			return wlist;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	public List<ProductDTO> listProduct(String emseq) {
		
		try {
			
			String sql = "select a.*, rownum as rnum from(select\n"
					+ "p.productseq, pj.name as pjname, p.productname, e.name as emname, to_char(p.productdate ,'yyyy-mm-dd') as productdate\n"
					+ "from\n"
					+ "product p inner join project pj on p.projectseq = pj.projectseq\n"
					+ "inner join employee e on e.employeeseq = p.employeeseq\n"
					+ "where e.employeeseq = ?\n"
					+ "order by productdate desc) a";
			
			
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, emseq);
			rs = pstat.executeQuery();
			
			List<ProductDTO> plist = new ArrayList<ProductDTO>();
						
			
			while  (rs.next()) {
				
				ProductDTO dto = new ProductDTO();
				
				dto.setPrseq(rs.getString("productseq"));
				dto.setPjname(rs.getString("pjname"));
				dto.setPrname(rs.getString("productname"));
				dto.setEmname(rs.getString("emname"));
				dto.setPrdate(rs.getString("productdate"));
				dto.setPrdate(rs.getString("productdate"));
				dto.setRnum(rs.getString("rnum"));

				
				
				plist.add(dto);
				
			}
			
			
			
			return plist;
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		return null;
	}


	public ProductDTO get(String seq ,String emseq) {
		
try {
			
			String sql = "select \n"
					+ "    p.productseq, p.content , pj.name as pjname, p.productname, e.name as emname, to_char(p.productdate,'yyyy-mm-dd') as productdate ,pf.filename \n"
					+ "from \n"
					+ "    product p inner join project pj on p.projectseq = pj.projectseq\n"
					+ "    inner join employee e on e.employeeseq = p.employeeseq\n"
					+ "    inner join productfile pf on pf.productseq = p.productseq\n"
					+ "    where e.employeeseq = ? and p.productseq=?\n"
					+ "    order by productseq";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, emseq);
			pstat.setString(2, seq);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				ProductDTO dto = new ProductDTO();
				
				dto.setPrseq(rs.getString("productseq"));
				dto.setPjname(rs.getString("pjname"));
				dto.setPrname(rs.getString("productname"));
				dto.setEmname(rs.getString("emname"));
				dto.setPrdate(rs.getString("productdate"));
				dto.setContent(rs.getString("content"));
				dto.setFile(rs.getString("filename"));
				
				
				return dto;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}




	public int updatepercent(HashMap<String, String> map) {
		try {
			String sql = "update wbs set percent = ? where wbsseq= ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, map.get("per"));
			pstat.setString(2, map.get("seq"));
			
			return pstat.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}


	public List<ProductDTO> pjlist(String emseq) {
		
		try {
	         
	         String sql = "select distinct pj.projectseq, pj.name from project pj\n"
	         		+ "inner join product p on pj.projectseq= p.projectseq\n"
	         		+ "inner join employee e on e.employeeseq=p.employeeseq\n"
	         		+ "where p.employeeseq=?";
	         
	        pstat = conn.prepareStatement(sql);
			pstat.setString(1, emseq);
				
			rs = pstat.executeQuery();
	         
	         List<ProductDTO> pjlist = new ArrayList<ProductDTO>();
	         
	         while (rs.next()) {
	            ProductDTO dto = new ProductDTO();
	            
	            dto.setPjseq(rs.getString("projectseq"));
	            dto.setPjname(rs.getString("name"));
	            
	            pjlist.add(dto);
	         }
	   
	         return pjlist;
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
		return null;
	}


	public int ProductAdd(ProductDTO dto) {
		
		try {
	         
	         String sql = "insert into product(productseq, productname, content, productdate, employeeseq, projectseq) values (productSeq.nextVal, ?, ?, ?,?,?)";
	         
	         pstat = conn.prepareStatement(sql);
	         pstat.setString(1, dto.getPrname());
	         pstat.setString(2, dto.getContent());
	         pstat.setString(3, dto.getPrdate());
	         pstat.setString(4, dto.getEmseq());
	         pstat.setString(5, dto.getPjseq());
	         
	         return pstat.executeUpdate();
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
		return 0;
	}
	
	public int ProductFileAdd(ProductDTO dto) {
		
		try {
	         
	         String sql = "insert into productfile values(fileseq.nextVal, (select max(productseq) from product) , ?)";
	         
	         pstat = conn.prepareStatement(sql);
	         pstat.setString(1, dto.getFile());
	         
	         
	         
	         return pstat.executeUpdate();
	         
	         
	         
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
		return 0;
	}


	public int ProductEdit(ProductDTO dto) {
		
		try {
			String sql = "update product set productname = ? , content= ? , productdate=?, employeeseq=1, projectseq=? where productseq= ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getPrname());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getPrdate());
			pstat.setString(4, dto.getPjseq());
			pstat.setString(5, dto.getPrseq());
			
			return pstat.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}


	public int getTotalCount(HashMap<String, String> map) {
		
		try {
			

			String sql = "select count(*) as cnt from vwtodo where employeeseq=?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, map.get("emseq"));
			rs = pstat.executeQuery();

			if (rs.next()) {

				return rs.getInt("cnt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}


	public List<TodoDTO> list(HashMap<String, String> map) {
		
		List<TodoDTO> list = new ArrayList<TodoDTO>();
		
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
			
			String sql = String.format("select * from (select a.*, rownum as rnum from vwtodo a where employeeseq=%s %s) where rnum between %s and %s order by rnum"										
										, map.get("emseq")
										, where
										, map.get("begin")
										, map.get("end")
									);
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			
			while  (rs.next()) {
				
				TodoDTO dto = new TodoDTO();
				
				dto.setSeq(rs.getString("wbsseq"));
				dto.setWbsname(rs.getString("wbsname"));
				dto.setStart(rs.getString("startdate"));
				dto.setEnd(rs.getString("enddate"));
				dto.setPer(rs.getString("percent"));
				dto.setPjname(rs.getString("pjname"));
				dto.setEmname(rs.getString("emname"));
				dto.setRnum(rs.getString("rnum"));
				
				
				list.add(dto);
				
			}
			
			
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}


	public int prdel(String prseq) {
		
		try {

			String sql = "delete from product where productseq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, prseq);

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}


	public int prfiledel(String prseq) {
		
		try {

			String sql = "delete from productfile where productseq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, prseq);

			return pstat.executeUpdate();

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
			

			String sql = String.format("select count(*) as cnt from vwtodo where employeeseq=%s %s"
													,map.get("emseq")
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


	public List<ProductDTO> plist(HashMap<String, String> map) {
		
		List<ProductDTO> plist = new ArrayList<ProductDTO>();
		
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
			
			String sql = String.format("select * from (select a.*, rownum as rnum from vwproduct a where employeeseq=%s %s) where rnum between %s and %s order by rnum"										
										, map.get("emseq")
										, where
										, map.get("begin")
										, map.get("end")
									);
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			
			while  (rs.next()) {
				
				ProductDTO dto = new ProductDTO();
				
				dto.setPrseq(rs.getString("productseq"));
				dto.setPjname(rs.getString("pjname"));
				dto.setPrname(rs.getString("productname"));
				dto.setEmname(rs.getString("emname"));
				dto.setPrdate(rs.getString("productdate"));
				dto.setRnum(rs.getString("rnum"));
				
				
				plist.add(dto);
				
			}
			
			
			return plist;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}


	public int getTotalCountPr(HashMap<String, String> map) {
		
		try {
			

			String sql = "select count(*) as cnt from vwproduct where employeeseq=?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, map.get("emseq"));
			rs = pstat.executeQuery();

			if (rs.next()) {

				return rs.getInt("cnt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}


public List<TodoDTO> joblist(String employeeSeq) {
		
		try {
	         
	         String sql = "select wbsname,percent,rownum as rnum from wbs where employeeseq=? and projectseq=10	 order by rnum";
	         pstat = conn.prepareStatement(sql);
			 pstat.setString(1, employeeSeq);
			 rs = pstat.executeQuery();
	         
	         List<TodoDTO> joblist = new ArrayList<TodoDTO>();
	         
	         while (rs.next()) {
	            
	        	 TodoDTO dto = new TodoDTO();
	            
	            
	        	dto.setRnum(rs.getString("rnum"));
	            dto.setWbsname(rs.getString("wbsname"));
	            dto.setPer(rs.getString("percent"));
	            
	            joblist.add(dto);
	         }
	   
	         return joblist;
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
		
		return null;
	}


	public String todocnt(String employeeSeq) {
		
		try {
			

			String sql = "select count(*) as cnt from wbs where employeeseq=? and percent <> 100";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, employeeSeq);
			rs = pstat.executeQuery();

			if (rs.next()) {

				return rs.getString("cnt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	public PjDTO listpj() {
		
		
		try {
			
			String sql ="select name, rndtype, to_char(startdate, 'yyyy-mm-dd') as startdate,complete  from project where projectseq=10";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			
			if (rs.next()) {
				
				PjDTO dto = new PjDTO();
				
				
				String str = rs.getString("name");
				String str2 = str.substring(0,20) + "...";
				
				dto.setPjname(str2);
				dto.setPjtype(rs.getString("rndtype"));
				dto.setPjdate(rs.getString("startdate"));
				dto.setPjing(rs.getString("complete"));
				
				return dto;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String wbscnt(String employeeSeq) {
		
		try {
			

			String sql = "select count(*) as cnt from product p inner join project pj on p.projectseq= pj.projectseq\n"
					+ "where p.employeeseq=? and pj.complete='진행중'";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, employeeSeq);
			rs = pstat.executeQuery();

			if (rs.next()) {

				return rs.getString("cnt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	


	



}

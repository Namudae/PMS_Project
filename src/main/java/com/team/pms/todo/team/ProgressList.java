package com.team.pms.todo.team;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.pms.center.wbs.WbsDAO;
import com.team.pms.center.wbs.WbsDTO;
import com.team.pms.employee.repository.EmployeeDAO;
import com.team.pms.employee.repository.EmployeeDTO;

@WebServlet("/todo/team/progresslist.do")
public class ProgressList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// ProgressList.java
		HttpSession session = req.getSession();

		ProgressDAO dao = new ProgressDAO();
		String employeeseq = (String) session.getAttribute("employeeSeq");
		int teamMaxRow = dao.teamMaxRow(employeeseq);

		EmployeeDAO daot = new EmployeeDAO();
		EmployeeDTO dto = daot.myInfo(employeeseq);
		req.setAttribute("name", dto.getName());
		req.setAttribute("position", dto.getPosition());
		req.setAttribute("teamname", dto.getTeamName());

		ArrayList<ProgressDTO> list = dao.getProgress(employeeseq, 1);
		req.setAttribute("list", list);

		WbsDAO daoChart = new WbsDAO();
		List<WbsDTO> listChart = daoChart.getChart(employeeseq);

		WbsDAO daoChartTeam = new WbsDAO();
		int listChartTeam = daoChartTeam.getMyChart(employeeseq);

		// System.out.println(listChartTeam);
		// req.setAttribute("listChartTeam", listChartTeam);

		WbsDAO ww = new WbsDAO();
		int oh = ww.gethundred(employeeseq);

		int result = 20 / listChartTeam;

		result *= oh;
		req.setAttribute("listChart", listChart);
		// listChart.get(0).setPercent(Integer.toString(result));
		// 팀전체

		listChart.clear();
		// 맡은 wbs개수 > cnt || 그걸맡은 사람 이름 pname || 그걸 맡은사람의 시퀀스 employeeseq
		listChart = dao.getTeamChart(employeeseq);

		// 완료된 wbs 개수 가져오는거임
		ArrayList<Integer> numList = new ArrayList<Integer>();
		numList = dao.getTeamChartPercent(employeeseq);

		int index = 0;
		for (int num : numList) {
			int allResult = 20 / listChart.get(index).getCount();

			allResult *= num;
			listChart.get(index).setPercent(Integer.toString(allResult));
			index++;
		}

		req.setAttribute("teamMaxRow", teamMaxRow);
		req.setAttribute("listchart2", listChart);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/todo/team/progresslist.jsp");
		dispatcher.forward(req, resp);
	}
}
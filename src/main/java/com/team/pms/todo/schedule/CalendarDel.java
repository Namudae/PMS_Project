package com.team.pms.todo.schedule;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/todo/schedule/calendardel.do")
public class CalendarDel extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String seq = req.getParameter("seq");

		CalendarDAO dao = new CalendarDAO();

		int result = dao.del(seq);

		if (result == 1) {
			System.out.println("삭제 성공~");
		}
	}
}

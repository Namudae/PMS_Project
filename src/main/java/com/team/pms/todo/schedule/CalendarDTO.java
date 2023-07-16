package com.team.pms.todo.schedule;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalendarDTO {
	private String calendarseq;
	private String startDate;
	private String endDate;
	private String content;
	private String employeeSeq;
	
	private String name;
	private String holidayDate;
}

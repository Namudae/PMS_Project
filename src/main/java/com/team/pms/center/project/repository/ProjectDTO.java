package com.team.pms.center.project.repository;

import lombok.Data;

@Data
public class ProjectDTO {

	
	private String projectSeq;
	private String name;
	private String startDate;
	private String endDate;
	private String projectType;
	private String rndType;
	private String budget;
	private String content;
	private String complete;
	
	
	private String[] addEmployee; 
	
	private String employeeSeq;
	private String employeeName;
	private String teamName;
	private String paName;
	private String pmName;
	private String employeeLv;
	
	
	

	
}

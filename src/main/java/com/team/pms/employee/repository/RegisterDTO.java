package com.team.pms.employee.repository;

import lombok.Data;

@Data
public class RegisterDTO {
	
	
	private String id;
	private String pw;
	private String employeeseq;
	private String projectseq;
	
	
	private String name;
	private String email;
	private String ps;
	private String lv;
	
	private String team;
	private String teamseq;
	
	private String joindate;
	private String address;
	private String birth;
	
	private String tel;
	
}

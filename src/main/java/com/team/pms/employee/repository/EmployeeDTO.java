package com.team.pms.employee.repository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {

	private String employeeSeq;
	private String name;
	private String tel;
	private String joinDate;
	private String birth;
	private String position;
	private String lv;
	private String email;
	private String address;
	private String teamSeq;

	private String teamName;
	private String noticetype;
//	employeeSeq NUMBER NOT NULL PRIMARY KEY, /* 직원번호 */
//	name VARCHAR2(15) NOT NULL, /* 이름 */
//	tel VARCHAR2(50) NOT NULL, /* 연락처 */
//	joinDate DATE NOT NULL, /* 입사일 */
//	birth VARCHAR2(50) NOT NULL, /* 주민등록번호 */
//	position VARCHAR2(15) NOT NULL, /* 직급 */
//	lv NUMBER NOT NULL, /* 직책 */
//	email VARCHAR2(50) NOT NULL, /* 이메일 */
//	address VARCHAR2(200) NOT NULL, /* 주소 */
//	teamSeq NUMBER REFERENCES team(teamSeq)/* 팀번호 */
}
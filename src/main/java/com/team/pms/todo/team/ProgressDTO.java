package com.team.pms.todo.team;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProgressDTO {
	  private String wbsseq;
	   private String wbsname;
	   private String startdate;
	   private String enddate;
	   private String percent;
	   private String employeeseq;
	   private String projectseq;
	   private String projectname;
	   
	   //담당자 이름
	   private String name;
	   //담당자 직급
	   private String position;
	   private String rownum;
	
}

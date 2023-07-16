package com.team.pms.sign.repository;

import lombok.Data;

@Data
public class SignListDTO {
	
	private String signseq;
	private String title;
	private String content;
	private String signdate;
	private String signokdate;
	private String signok;
	private String employeeseq;
	private String projectseq;
	private String fileseq;
	private String filename;
	private String id;
	
	private String projectname;
	
	private String name; //작성자
	
	private double isnew; //최신글 
	
	private String signwait;

}

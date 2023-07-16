package com.team.pms.center.version;

import lombok.Data;

@Data
public class VersionDTO {
	
	private String versionseq;
	private String version;
	private String content;
	private String versiondate;
	private String filename;
	private String projectseq;
	
	private String projectname;
}
//VERSIONSEQ  NOT NULL NUMBER         
//VERSION     NOT NULL VARCHAR2(15)   
//CONTENT     NOT NULL VARCHAR2(4000) 
//VERSIONDATE NOT NULL DATE           
//FILENAME             VARCHAR2(100)  
//PROJECTSEQ  NOT NULL NUMBER    
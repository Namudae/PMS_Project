package com.team.pms.issue;

import java.util.Date;

import lombok.Data;

@Data
public class IssueDTO {

   private String issueseq;
   private String title;
   private String issuetype;
   private String issuedate;
   private String deadline;
   private String status;
   private String issuecontent;
   private String name;
   private String projectname;
   private String projectseq;
   private String employeeseq;
   private String cnt;
   private String rnum;
}
package com.team.pms.center.issue;

import lombok.Data;

@Data
public class CIssueDTO {
   private String issueseq;
   private String title;
   private String issuetype;
   private String issuedate;
   private String deadline;
   private String status;
   private String issuecontent;
   private String projectseq;
   private String employeeseq;
   
   private String rnum;
}
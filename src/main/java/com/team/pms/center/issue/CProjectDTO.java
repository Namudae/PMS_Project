package com.team.pms.center.issue;

import lombok.Data;

@Data
public class CProjectDTO {
   private String projectseq;
   private String name;
   private String startdate;
   private String enddate;
   private String projecttype;
   private String rndtype;
   private String budget;
   private String content;
   private String complete;
}
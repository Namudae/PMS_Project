package com.team.pms.center.wbs;

import java.util.Date;

import lombok.Data;

@Data

public class WbsDTO {
   
   
   private String wseq;
   private String wname;
   private Date wstartdate;
   private Date wenddate;
   private String percent;
   private String projectseq;
   private String employeeseq;
   private String diff;
   
   private Date pstartdate;
   private Date penddate;
   private String pname;
   private int count;
   
}
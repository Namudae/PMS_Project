<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ page import="java.util.Date" %>
<%@ page import="java.util.concurrent.TimeUnit" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/pms/asset/css/common.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />


<style>

   @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');
* {
font-family: 'Noto Sans KR', sans-serif;
}
        body {
            margin: 0;
            padding: 0;
        }

        #container {
            display: flex;
            height: 100vh;
        }

        #sidebar {
            width: 250px;
            background-color: #F2F4F7;
            color: #1C1C1C;
            padding: 15px 0 18px 0px;
            font-family: "맑은 고딕", Arial, sans-serif;
            font-size: 17px;
        }

        #sidebar ul {
           list-style-type: none;
           padding-inline-start: 0px;
           padding-inline-end: 0px;
           /* padding-left: 20px; */
        }

       /* #sidebar ul :hover {
           background-color: #D9DADF;
        } */
        

        #sidebar > #info {
            color: #1C1C1C;
            font-size: small;
            text-align: center;
        }

        #sidebar a {
            color: #1C1C1C;
            text-decoration: none;
            padding: 17px 15px;
            display: block;
        }

        #sidebar a:hover {
            background-color: #D9DADF;
        }

        .manage ul {
            padding-left: 10px;
        }

        .manage ul li {
            margin-bottom: 5px;
        }

        .manageDetail ul li {
            padding-left: 30px;
        }

        #content {
            flex: 1;
            /* padding: 20px; */
        }

        #content > hr {
            border-width: 3px;
            border-style: solid;
            color: #9DB2BF;
        }
        
        

        #topMenu > table {
            /* width: 100%; */
             width: 100%;
            table-layout: fixed;
            align-items: center;
            /* margin-left: 20px; */
            margin-bottom: 20px;
        }

        #topMenu .tbTop {
            height: 70px;
            background-color: #2A3954;
        }

        #topMenu .tbTop > td:hover {
            background-color: #000032;
        }

        #topMenu .tbTop td {
            width: 20%;
            text-align: center;
            font-size: large;
            font-weight: bold;
        }

        #topMenu a {
            color: white;
            text-decoration: none;
        }

        h2.subtitle {
            margin-left: 55px;
            color: #1C1C1C;
        }

        /* img {
            width: 110px;
            height: 120px;
            margin-left: 20px;
        } */

      .smwork {
        padding-left: 27px;
        padding-right: 27px;
        padding-top: calc(3px - 3px);
        padding-bottom: calc(3px - 3px);
        font-size: 15px;
        text-indent: -2px;
        }
#chart{
width: 0px;
}

#chart > div{
      border: 1px solid #999;
      font-size: 12px;
      padding: 4px;
      text-align: right;
      margin-bottom: 5px;
   }
   
   #chart > div:nth-child(1){
      background-color: tomato;
      color: white;
   }
   #chart > div:nth-child(2){
      background-color: gold;
   }
   #chart > div:nth-child(3){
      background-color: cornflowerblue;
      color: white;
   }
   #chart > div:nth-child(4){
      background-color: orange;
   }
   #chart > div:nth-child(5){
      background-color: tomato;
      color: white;
   }
   #chart > div:nth-child(6){
      background-color: gold;
   }
   #chart > div:nth-child(7){
      background-color: cornflowerblue;
      color: white;
   }
   #chart > div:nth-child(8){
      background-color: orange;
   }
   #chart > div:nth-child(9){
      background-color: tomato;
      color: white;
   }
   #chart > div:nth-child(10){
      background-color: gold;
   }
   #chart > div:nth-child(11){
      background-color: cornflowerblue;
      color: white;
   }
   #chart > div:nth-child(12){
      background-color: orange;
   }
   #chart > div:nth-child(13){
      background-color: tomato;
      color: white;
   }
   #chart > div:nth-child(14){
      background-color: gold;
   }
   #chart > div:nth-child(15){
      background-color: cornflowerblue;
      color: white;
   }
   #chart > div:nth-child(16){
      background-color: orange;
   }
   #chart > div:nth-child(17){
      background-color: tomato;
      color: white;
   }
   #chart > div:nth-child(18){
      background-color: gold;
   }
   #chart > div:nth-child(19){
      background-color: cornflowerblue;
      color: white;
   }
   #chart > div:nth-child(20){
      background-color: orange;
   }
   
   .content{
   
   border: 1px solid black;
   width: 10%;
   height: 10px;
   }
   
   #gant {
  margin: 1em auto;
}

#sidebar {
height: 1500px;
}

<!-- 테두리 지우기 -->

#content > div:nth-child(4) > table > tbody > tr > td {
	border: none;
}

#gant {
	width: 1000px;
}


#content > div:nth-child(4) > table {
	border: none;
}

#content > div:nth-child(4) > table > tbody > tr > td {
border: 0px;
}

</style>
</head>
<body>
    <div id="container">
        <%@ include file="/WEB-INF/views/inc/sidebar.jsp" %>

        <div id="content">
        <h2> &nbsp; 프로젝트 센터 > WBS</h2>
            <hr>
            <div id="topMenu">
                <table>
                    <tr class="tbTop">
                        <td><a href="/pms/center/project/projectlist.do">프로젝트 목록</a></td>
                        <td><a href="/pms/center/project/projectdetail.do?projectSeq=${list.get(0).projectseq}">상세정보</a></td>
                        <td><a href="/pms/center/wbs/view.do?pjseq=${list.get(0).projectseq}">WBS</a></td>
                        <td><a href="/pms/center/issue/cissuelist.do?pjseq=${list.get(0).projectseq}">이슈</a></td>
                  <td><a href="/pms/center/product/cproductlist.do?pjseq=${list.get(0).projectseq}">산출물</a></td>
                  <td><a href="/pms/center/version/versionlist.do?pjseq=${list.get(0).projectseq}">버전</a></td>
                    </tr>
                    <tr class="tbMid">
                        <td></td>
                    </tr>
                </table>
            </div>

        <div>
    <h2 class="subtitle" style="display: inline-block;">WBS</h2>
    
    
    <table class="listtbl">
       <tr>
       <td><div id="gant" style="width:1100px; margin-left: 0px; "></div></td>
       </tr>
    </table>
   
    
</div>
</div>
   
</div>          
   <div id="wbslist">
   <c:forEach items="${list}" var="dto">
      <div class="wbs">
         <input type="hidden" value="${dto.pstartdate}">
         <input type="hidden" value="${dto.penddate}">
         <input type="hidden" value="${dto.pname}">
         <input type="hidden" value="${dto.projectseq}">
         <input type="hidden" value="${dto.wstartdate}">
         <input type="hidden" value="${dto.wenddate}">
         <input type="hidden" value="${dto.wname}">
         <input type="hidden" value="${dto.wseq}">
      </div>   
   </c:forEach>
   </div>
    <script src="js/jquery-3.6.4.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://code.highcharts.com/gantt/highcharts-gantt.js"></script>
<script src="https://code.highcharts.com/gantt/modules/accessibility.js"></script>
    <script>
    var today = new Date(),
    day = 1000 * 60 * 60 * 24;

    var wbs = document.querySelector('.wbs');
    
    console.log($('#wbslist').find('.wbs').children().eq(1).val());
   
    var pstartdate = new Date($('#wbslist').find('.wbs').children().eq(0).val());
    var penddate = new Date($('#wbslist').find('.wbs').children().eq(1).val());
    var pname = new Date($('#wbslist').find('.wbs').children().eq(2).val());
    var projectseq = new Date($('#wbslist').find('.wbs').children().eq(3).val());
    var wstartdate = new Date($('#wbslist').find('.wbs').children().eq(4).val());
    var wenddate = new Date($('#wbslist').find('.wbs').children().eq(5).val());
    var wname = new Date($('#wbslist').find('.wbs').children().eq(6).val());
    var wseq = new Date($('#wbslist').find('.wbs').children().eq(7).val());
    
    
    const wbsData = [

    	<c:forEach items="${list}" var="dto">
    	{
            name: '${dto.wname}',
            id: 'requirements',
            start: Date.parse('${dto.wstartdate}'),
            end: Date.parse('${dto.wenddate}')
        },
    	</c:forEach>
    ];
    
    
    
    
  // Set to 00:00:00:000 today
  today.setUTCHours(0);
  today.setUTCMinutes(0);
  today.setUTCSeconds(0);
  today.setUTCMilliseconds(0);


  // THE CHART
  Highcharts.ganttChart('gant', {
    title: {
      text: '개발 1팀 : 금융상품 추천 어플리케이션 제작 프로젝트'
    },
    xAxis: {
      min: pstartdate.getTime(),
      max: penddate.getTime()
    },
    accessibility: {
      keyboardNavigation: {
        seriesNavigation: {
          mode: 'serialize'
        }
      },
      point: {
        descriptionFormatter: function (point) {
          var dependency = point.dependency &&
              point.series.chart.get(point.dependency).name,
            dependsOn = dependency ? ' Depends on ' + dependency + '.' : '';

          return Highcharts.format(
            '{point.yCategory}. Start {point.x:%Y-%m-%d}, end {point.x2:%Y-%m-%d}.{dependsOn}',
            { point, dependsOn }
          );
        }
      }
    },
    lang: {
      accessibility: {
        axis: {
          xAxisDescriptionPlural: 'The chart has a two-part X axis showing time in both week numbers and days.'
        }
      }
    },
    series: [{
      name: 'Project 1',
      data: wbsData
    }]
  });
    </script>
</body>

</html>

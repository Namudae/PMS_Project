<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/pms/asset/css/common.css">
<link rel="stylesheet"
   href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

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
            margin-bottom: 50px;
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
        
    #progresstbl{
       text-align: center;
      width: 900px;
    }    
    
    #progresstbl th{
       text-align: center
    }

    #progresstbl th:nth-child(1) {
      width: 60px;
   }
    #progresstbl th:nth-child(2) {
      width: 500px;
   }
    #progresstbl th:nth-child(3) {
      width: 90px;
   }
    #progresstbl th:nth-child(4) {
      width: 90px;
   }
   
   #progresstbl td:nth-child(2) {
      text-align: left;
   }
   
      .e0_3 { 
/*     background-color: #f2f4f7; */
   width:1200px;
   height:795px;
   position:absolute;
}
.e0_4 { 
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    width: 184px;
    height: 133px;
    position: absolute;
    left: 60px;
    top: 50px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    border-bottom-left-radius: 10px;
    border-bottom-right-radius: 10px;
}
.e0_5 { 
   border: 1px solid #2A3954;
   background-color:rgba(255, 255, 255, 1);
   width:184px;
   height:133px;
   position:absolute;
   left:0px;
   top:0px;
   border-top-left-radius:10px;
   border-top-right-radius:10px;
   border-bottom-left-radius:10px;
   border-bottom-right-radius:10px;
}
.0_5 { 
   border:2px solid rgba(0, 0, 0, 1);
}
.e0_6 { 
   color:rgba(0, 0, 0, 1);
   width:147px;
   height:26px;
   position:absolute;
   left:18.5px;
   top:9.5px;
   font-family:Roboto;
   text-align:right;
   font-size:54px;
   letter-spacing:0;
}
.e0_7 { 
   color:rgba(0, 0, 0, 1);
   width:138px;
   height:40px;
   position:absolute;
   left:23px;
   top:83.5px;
   font-family:Roboto;
   text-align:right;
   font-size:22px;
   letter-spacing:0;
}
.e2_11 { 
   box-shadow:0px 4px 4px rgba(0, 0, 0, 0.25);
   width:184px;
   height:133px;
   position:absolute;
   left:285px;
   top:50px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    border-bottom-left-radius: 10px;
    border-bottom-right-radius: 10px;
}
.e2_12 { 
   border: 1px solid #2A3954;
   background-color:rgba(255, 255, 255, 1);
   width:184px;
   height:133px;
   position:absolute;
   left:0px;
   top:0px;
   border-top-left-radius:10px;
   border-top-right-radius:10px;
   border-bottom-left-radius:10px;
   border-bottom-right-radius:10px;
}
.2_12 { 
   border:2px solid rgba(0, 0, 0, 1);
}
.e2_13 { 
   color:rgba(0, 0, 0, 1);
   width:147px;
   height:26px;
   position:absolute;
   left:18.5px;
   top:9.5px;
   font-family:Roboto;
   text-align:right;
   font-size:54px;
   letter-spacing:0;
}
.e2_14 { 
   color:rgba(0, 0, 0, 1);
   width:138px;
   height:40px;
   position:absolute;
   left:23px;
   top:83.5px;
   font-family:Roboto;
   text-align:right;
   font-size:22px;
   letter-spacing:0;
}
.e2_15 { 
   box-shadow:0px 4px 4px rgba(0, 0, 0, 0.25);
   width:184px;
   height:133px;
   position:absolute;
   left:510px;
   top:50px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    border-bottom-left-radius: 10px;
    border-bottom-right-radius: 10px;
}
.e2_16 { 
   border: 1px solid #2A3954;
   background-color:rgba(255, 255, 255, 1);
   width:184px;
   height:133px;
   position:absolute;
   left:0px;
   top:0px;
   border-top-left-radius:10px;
   border-top-right-radius:10px;
   border-bottom-left-radius:10px;
   border-bottom-right-radius:10px;
}
.2_16 { 
   border:2px solid rgba(0, 0, 0, 1);
}
.e2_17 { 
   color:rgba(0, 0, 0, 1);
   width:147px;
   height:26px;
   position:absolute;
   left:18.5px;
   top:9.5px;
   font-family:Roboto;
   text-align:right;
   font-size:54px;
   letter-spacing:0;
}
.e2_18 { 
   color:rgba(0, 0, 0, 1);
   width:138px;
   height:40px;
   position:absolute;
   left:23px;
   top:83.5px;
   font-family:Roboto;
   text-align:right;
   font-size:22px;
   letter-spacing:0;
}
.e2_19 { 
   box-shadow:0px 4px 4px rgba(0, 0, 0, 0.25);
   width:184px;
   height:133px;
   position:absolute;
   left:733px;
   top:50px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    border-bottom-left-radius: 10px;
    border-bottom-right-radius: 10px;
}
.e2_20 { 
   border: 1px solid #2A3954;
   background-color:rgba(255, 255, 255, 1);
   width:184px;
   height:133px;
   position:absolute;
   left:0px;
   top:0px;
   border-top-left-radius:10px;
   border-top-right-radius:10px;
   border-bottom-left-radius:10px;
   border-bottom-right-radius:10px;
}
.2_20 { 
   border:2px solid rgba(0, 0, 0, 1);
}
.e2_21 { 
   color:rgba(0, 0, 0, 1);
   width:147px;
   height:26px;
   position:absolute;
   left:18.5px;
   top:9.5px;
   font-family:Roboto;
   text-align:right;
   font-size:54px;
   letter-spacing:0;
}
.e2_22 { 
   color:rgba(0, 0, 0, 1);
   width:138px;
   height:40px;
   position:absolute;
   left:23px;
   top:83.5px;
   font-family:Roboto;
   text-align:right;
   font-size:22px;
   letter-spacing:0;
}
.e2_23 { 
   box-shadow:0px 4px 4px rgba(0, 0, 0, 0.25);
   width:184px;
   height:133px;
   position:absolute;
   left:955px;
   top:50px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    border-bottom-left-radius: 10px;
    border-bottom-right-radius: 10px;
}
.e2_24 { 
   border: 1px solid #2A3954;
   background-color:rgba(255, 255, 255, 1);
   width:184px;
   height:133px;
   position:absolute;
   left:0px;
   top:0px;
   border-top-left-radius:10px;
   border-top-right-radius:10px;
   border-bottom-left-radius:10px;
   border-bottom-right-radius:10px;
}
.2_24 { 
   border:2px solid rgba(0, 0, 0, 1);
}
.e2_25 { 
   color:rgba(0, 0, 0, 1);
   width:147px;
   height:26px;
   position:absolute;
   left:18.5px;
   top:9.5px;
   font-family:Roboto;
   text-align:right;
   font-size:54px;
   letter-spacing:0;
}
.e2_26 { 
   color:rgba(0, 0, 0, 1);
   width:138px;
   height:40px;
   position:absolute;
   left:23px;
   top:83.5px;
   font-family:Roboto;
   text-align:right;
   font-size:22px;
   letter-spacing:0;
}
.e0_24 { 
   width:1079px;
   height:536.162841796875px;
   position:absolute;
   left:60px;
   top:219.08721923828125px;
}
.e0_25 { 
   border: 1px solid #2A3954;
   box-shadow:0px 4px 4px rgba(0, 0, 0, 0.25);
   background-color:rgba(255, 255, 255, 1);
   width:633.566650390625px;
   height:251.44186401367188px;
   position:absolute;
   left:0.9221893548965454px;
   top:0px;
   border-top-left-radius:10px;
   border-top-right-radius:10px;
   border-bottom-left-radius:10px;
   border-bottom-right-radius:10px;
}
.0_25 { 
   border:2px solid rgba(0, 0, 0, 1);
}
.e0_26 { 
   color:rgba(0, 0, 0, 1);
   width:585px;
   height:229px;
   position:absolute;
   left:24.2833251953125px;
   top:11.220932006835938px;
   font-family:Roboto;
   text-align:right;
   font-size:22px;
   letter-spacing:0;
}
.e0_27 { 
   border: 1px solid #2A3954;
   box-shadow:0px 4px 4px rgba(0, 0, 0, 0.25);
   background-color:rgba(255, 255, 255, 1);
   width:409.4666442871094px;
   height:251.44186401367188px;
   position:absolute;
   left:669.5333251953125px;
   top:0px;
   border-top-left-radius:10px;
   border-top-right-radius:10px;
   border-bottom-left-radius:10px;
   border-bottom-right-radius:10px;
}
.0_27 { 
   border:2px solid rgba(0, 0, 0, 1);
}
.e0_28 { 
   color:rgba(0, 0, 0, 1);
   width:355px;
   height:229px;
   position:absolute;
   left:27.233322143554688px;
   top:11.220932006835938px;
   font-family:Roboto;
   text-align:right;
   font-size:22px;
   letter-spacing:0;
}
.e0_29 { 
   border: 1px solid #2A3954;
   box-shadow:0px 4px 4px rgba(0, 0, 0, 0.25);
   background-color:rgba(255, 255, 255, 1);
   width:1079px;
   height:245.89535522460938px;
   position:absolute;
   left:0px;
   top:290.2674560546875px;
   border-top-left-radius:10px;
   border-top-right-radius:10px;
   border-bottom-left-radius:10px;
   border-bottom-right-radius:10px;
}
.0_29 { 
   border:2px solid rgba(0, 0, 0, 1);
}
.e0_30 { 
   color:rgba(0, 0, 0, 1);
   width:1014px;
   height:229px;
   position:absolute;
   left:32.5px;
   top:8.447677612304688px;
   font-family:Roboto;
   text-align:right;
   font-size:22px;
   letter-spacing:0;
}

.e0_3 .nemobox {
    border: 3px solid #2A3954;
}
.e0_3 .nemobig {
    border: 3px solid #9db2bf;
}

#chartdiv2 {
  width: 900px;
  height: 500px;
  margin-right: 150px;
  margin-left: 45px;
}
    
    #chartdiv2 > div > svg > g > g:nth-child(2) > g:nth-child(2) > g > g:nth-child(3){
       display:none;
    }
    
    #chartdiv2 > div > svg > g > g:nth-child(2) > g:nth-child(1){
       margin-right: 300px;
    }
   
   
</style>
</head>
<body>
<div id="container">
   <%@ include file="/WEB-INF/views/inc/sidebar.jsp" %>

        <div id="content">
           <p>&nbsp일반작업 > 프로그램 진척도</p>
            <hr>
            <div id="topMenu">
                <table>
                    <tr class="tbTop">
                        <td><a href="/pms/todo/team/progresslist.do">프로젝트 진척도</a></td>
                        <c:if test="${lv == 2}">
                           <td><a href="/pms/todo/team/wbsadd.do">프로젝트 작업 등록</a></td>
                       </c:if>
                        <td><a href="/pms/todo/team/teamproductlist.do">프로젝트 전체 산출물 조회</a></td>
                    </tr>
                    <tr class="tbMid">
                        <td></td>
                    </tr>
                </table>
            </div>
            <div style="margin-left: 385px;"><h2>인원별 프로젝트 진척도</h2></div>
            <div id="chartdiv2"></div>
            
            
         <div id="progress">
            <div id="chart"></div>
            <div id="mychart"></div>
      
            <table class="listtbl" id="progresstbl">
               <thead>
                  <tr>
                     <th>번호</th>
                     <th>작업명</th>
                     <th>담당자</th>
                     <th>완료율(%)</th>
                  </tr>
               </thead>
               <tbody>
                  <c:forEach items="${list}" var="dto">
                     <tr class="wbsItem">
                        <td>${dto.rownum}</td>
                        <td>${dto.wbsname}</td>
                        <td>${dto.name}</td>
                        <td>${dto.percent}%</td>
                     </tr>
                  </c:forEach>
               </tbody>
            </table>   
         </div>
            <div class="addView">
            <input type="button" value="더 보기" class="btn viewbtn"
               style="margin-left: 450px;">
         </div>
      </div>
   </div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://cdn.amcharts.com/lib/4/core.js"></script>
<script src="https://cdn.amcharts.com/lib/4/charts.js"></script>
<script src="https://cdn.amcharts.com/lib/4/themes/animated.js"></script>
<script>


am4core.ready(function() {
    // Themes begin
    am4core.useTheme(am4themes_animated);
    // Themes end

    var chart = am4core.create("chartdiv2", am4charts.PieChart3D);
    chart.hiddenState.properties.opacity = 0; // this creates initial fade-in

    chart.legend = new am4charts.Legend();
   
    let total = 100;
    <c:forEach items="${listchart2}" var = "dto">
       total = total - ${dto.percent};
    </c:forEach>
    
    // 서버로부터 가져온 데이터를 JSON 형식으로 변환하여 사용
    var chartData = [
       
      <c:forEach items="${listchart2}" var="dto">
        {
         
          country: '${dto.pname}',
          
          litres: '${dto.percent}'
        },
          
             
      </c:forEach>
       {
         country: '미완료',
         litres: total
       }
    ];
    
    // 데이터 객체의 구조를 수정하여 올바른 형식으로 변경
    chart.data = chartData;
    

    chart.innerRadius = 70;

    var series = chart.series.push(new am4charts.PieSeries3D());
    series.dataFields.value = "litres";
    series.dataFields.category = "country";
  });

  let teamMaxRow = ${teamMaxRow};
  
  function addView(row){
     let trLen2 =$(document).find('.wbsItem').length;
     
     if(trLen2 == row){
        $('.viewbtn').remove();
     }else{
        $('.addView').html(`<input type="button" value="더보기" class="btn viewbtn" style="margin-left: 450px;">`);
     }
  }
  
  addView(teamMaxRow);

  $(document).on('click', '.viewbtn', function plusview(){
     let trLen = $(document).find('.wbsItem').length;
     
     $.ajax({
        url: '/pms/todo/team/progressadd.do',
        type: 'POST',
        data: {
           trLen: trLen,
        },
        dataType: 'json',
        success: result => {
           let temp = $('#progresstbl > tbody').html();
           $(result).each((index, item)=>{
              temp += '<tr class="wbsItem">' +
                 '<td>' + item.rownum  +'</td>' +
                 '<td class="edit">' + item.wbsname + '</td>' +
                 '<td>' + item.name + '</td>' +
                 '<td>' + item.percent + '%</td>'
                 '</tr>';
           });
           $('#progresstbl > tbody').html(temp);
           trLen = $('.wbsItem').length;
           addView(teamMaxRow);
        },
        error: (a,b,c) => console.log(a,b,c)
     });
     
  });
</script>
</body>
</html>
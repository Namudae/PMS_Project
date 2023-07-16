<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
            color: #9db2bf;
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

     .div-container {
      display: flex;
      flex-direction: column;
    }
    
    .div-container div {
      margin-bottom: 10px;
    
    }
    .dash{
       border: 1px solid black;
       display: inline-block;
        width: 100px;
        height: 100px;
        
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

#chartdiv {
  width: 100%;
  height: 500px;
}

.nemobox span:nth-child(1) {
padding-top: 20px;
}
    
    
    
    
    
    
    
    
    /* 도넛차트 */
/*    #chartdiv > div > svg > g > g:nth-child(2) > g:nth-child(1) > g > g > g > g:nth-child(2) > g{ */
/*       display:none; */
/*    } */
    
/*     #chartdiv > div > svg > g > g:nth-child(2) > g:nth-child(2) > g > g:nth-child(3){ */
/*     display:none; */
/*     } */

   g {
   }

   /* 큰 도넛 */
   #id-271 {
      fill: #324883;
       stroke: #324883;
   }
   
   #id-271 > g > g:nth-child(1) {
   fill: #1E346F;
    stroke: #1E346F;
   }
   
   #id-271 > g > g:nth-child(2) {
   fill: #1E346F;
    stroke: #1E346F;
   }
   
   #id-271 > g > g:nth-child(3) {
   fill: #1E346F;
    stroke: #1E346F;
   }
   
   /* 두번째 도넛 */
   #id-126 {
   fill: #FAF0CA;
    stroke: #FAF0CA;
   }
   
   #id-126 > g > g:nth-child(1) {
   fill: #E6DCB6;
    stroke: #E6DCB6;
   }
   #id-126 > g > g:nth-child(2) {
   fill: #E6DCB6;
    stroke: #E6DCB6;
   }
   #id-126 > g > g:nth-child(3) {
   fill: #FAF0CA;
    stroke: #FAF0CA;
   }
    #id-126 > g > g:nth-child(4) { 
   fill: #E6DCB6; 
    stroke: #E6DCB6; 
   } 
    #id-126 > g > g:nth-child(5) { 
    fill: #E6DCB6; 
    stroke: #E6DCB6; 
    } 
   
   /* 세번째 */
   #id-163 {
   fill: #f4d35e;
    stroke: #f4d35e;
   }
   
   #id-163 > g > g:nth-child(1) {
   fill: #E0BF4A;
    stroke: #E0BF4A;
   }
   #id-163 > g > g:nth-child(2) {
   fill: #E0BF4A;
    stroke: #E0BF4A;
   }
   #id-163 > g > g:nth-child(3) {
   fill: #f4d35e;
    stroke: #f4d35e;
   }
   #id-163 > g > g:nth-child(4) {
   fill: #E0BF4A;
    stroke: #E0BF4A;
   }
   #id-163 > g > g:nth-child(5) {
   fill: #E0BF4A;
    stroke: #E0BF4A;
   }
   
   /* 네번째 */
   #id-199 {
   fill: #ee964b;
    stroke: #ee964b;
   }
   
   #id-199 > g > g:nth-child(1) {
   fill: #E48C41;
    stroke: #E48C41;
   }
   #id-199 > g > g:nth-child(2) {
   fill: #E48C41;
    stroke: #E48C41;
   }
   #id-199 > g > g:nth-child(3) {
   fill: #ee964b;
    stroke: #ee964b;
   }
   #id-199 > g > g:nth-child(4) {
   fill: #E48C41;
    stroke: #E48C41;
   }
   #id-199 > g > g:nth-child(5) {
   fill: #E48C41;
    stroke: #E48C41;
   }
   
   /* 다섯번째 */
   #id-235 {
   fill: #f95738 !important;
    stroke: #f95738 !important;
   }
   
   #id-235 > g > g:nth-child(1) {
   fill: #E54324;
    stroke: #E54324;
   }
   #id-235 > g > g:nth-child(2) {
   fill: #E54324;
    stroke: #E54324;
   }
   #id-235 > g > g:nth-child(3) {
   fill: #f95738 !important;
    stroke: #f95738 !important;
   }
   #id-235 > g > g:nth-child(4) {
   fill: #E54324;
    stroke: #E54324;
   }
   #id-235 > g > g:nth-child(5) {
   fill: #E54324;
    stroke: #E54324;
   }
   
   
   /* 범례 */
   #chartdiv > div > svg > g > g:nth-child(2) > g:nth-child(1) > g > g > g > g:nth-child(2) > g > g:nth-child(1) > g:nth-child(2) > g:nth-child(1) > g:nth-child(2) > g {
   fill: #FAF0CA;
    stroke: #FAF0CA;
   }
   
   #chartdiv > div > svg > g > g:nth-child(2) > g:nth-child(1) > g > g > g > g:nth-child(2) > g > g:nth-child(2) > g:nth-child(2) > g:nth-child(1) > g:nth-child(2) > g {
   fill: #f4d35e;
    stroke: #f4d35e;
   }
   
   #chartdiv > div > svg > g > g:nth-child(2) > g:nth-child(1) > g > g > g > g:nth-child(2) > g > g:nth-child(3) > g:nth-child(2) > g:nth-child(1) > g:nth-child(2) > g {
   fill: #ee964b;
    stroke: #ee964b;
   }
   
   #chartdiv > div > svg > g > g:nth-child(2) > g:nth-child(1) > g > g > g > g:nth-child(2) > g > g:nth-child(4) > g:nth-child(2) > g:nth-child(1) > g:nth-child(2) > g {
   fill: #f95738;
    stroke: #f95738;
   }
   
   #chartdiv > div > svg > g > g:nth-child(2) > g:nth-child(1) > g > g > g > g:nth-child(2) > g > g:nth-child(5) > g:nth-child(2) > g:nth-child(1) > g:nth-child(2) > g {
   fill: #0D3B66;
    stroke: #0D3B66;
   }
    
    
    #chartdiv > div > svg > g > g:nth-child(2) > g:nth-child(2) > g > g:nth-child(3){
       display:none;
    }
    
    
    /* 동현 */
    #tbltodo {
    margin-top: 5px;
    margin-left: 10px;
    width: 380px;
    height: 160px; 
}

.todoing {
	margin-top: 50px;
	margin-left: 10px;
	font-weight: bold;
	color:#1D267D;
	font-size: 18px;
}

#tblpj {
	margin-top: 50px;
	width: 600px;
	height: 180px;
}
#tblpj th {
	font-weight: bold;
	color:#1D267D;
}

#sidebar {
 height: 1300px;
}


    
    
</style>
</head>
<body>
    <div id="container">
        <%@ include file="/WEB-INF/views/inc/sidebar.jsp" %>

       <div id="content">
           <p>&nbsp종합 대시보드</p>
            <hr>
            <div id="topMenu">
                <table>
<!--                     <tr class="tbTop"> -->
<!--                         <td><a href="#">프로젝트 목록</a></td> -->
<!--                         <td><a href="#">상세정보</a></td> -->
<!--                         <td><a href="#">WBS</a></td> -->
<!--                         <td><a href="#">이슈</a></td> -->
<!--                         <td><a href="#">산출물</a></td> -->
<!--                     </tr> -->
                    <tr class="tbMid">
                    <td>
                        <div class=e0_3>
                    <div class=e0_4>
                    <a href="/pms/todo/my/todolist.do">
                      <div class="e0_5 nemobox"><span  class="e0_6">${jobcnt}</span><span class="material-symbols-outlined" style="
    position: absolute;
    top: 15px;
    left: 10px;
    font-size: 80px;
    opacity: 0.6;
">
inventory
</span><span  class="e0_7">내 작업</span></div>
</a>
                    </div>
                    <div class=e2_11>
                    <a href="/pms/issue/issuelist.do">
                      <div class="e2_12 nemobox"><span  class="e2_13">${issuecount}</span><span class="material-symbols-outlined" style="
    position: absolute;
    top: 15px;
    left: 10px;
    font-size: 80px;
    opacity: 0.6;
">
sms_failed
</span><span  class="e2_14">이슈</span></div>
</a>
                    </div>
                    <div class=e2_15>
                    <a href="/pms/sign/signlist.do">
                      <div class="e2_16 nemobox"><span  class="e2_17">${signwait}</span><span class="material-symbols-outlined" style="
    position: absolute;
    top: 5px;
    left: 10px;
    font-size: 80px;
    opacity: 0.6;
">
how_to_reg
</span><span  class="e2_18">결재 요청</span></div>
</a>
                    </div>
                    <div class=e2_19>
                    <a href="/pms/todo/my/productlist.do">
                      <div class="e2_20 nemobox"><span  class="e2_21">${wbscnt}</span><span class="material-symbols-outlined" style="
    position: absolute;
    top: 15px;
    left: 10px;
    font-size: 80px;
    opacity: 0.6;
">
file_copy
</span><span  class="e2_22">산출물</span></div>
</a>
                    </div>
                    <div class=e2_23>
                    <a href="/pms/center/project/projectlist.do">
                      <div class="e2_24 nemobox"><span  class="e2_25">1</span><span class="material-symbols-outlined" style="
    position: absolute;
    top: 7px;
    left: 10px;
    font-size: 80px;
    opacity: 0.6;
">
folder_open
</span><span  class="e2_26">프로젝트</span></div>
</a>
                    </div>
                    <div class=e0_24>
                      <div class="e0_25 nemobig"><span  class="e0_26" style="margin-top: 8px;">전체 프로젝트 현황</span>
                         <table id="tblpj" style="margin-left: 30px;">
                            <tr>
                               <th>팀</th>
                               <th>프로젝트명</th>
                               <th>프로젝트 유형</th>
                               <th>시작일</th>
                               <th>진행여부</th>
                            </tr>
                            <tr>
                               <td>개발1팀</td>
                               <td>${pjdto.pjname}</td>
                               <td>${pjdto.pjtype }</td>
                               <td>${pjdto.pjdate }</td>
                               <td>${pjdto.pjing }</td>
                            </tr>
                            <tr>
                               <td>개발2팀</td>
                               <td>웹 서버 개발 프로젝트</td>
                               <td>웹 개발</td>
                               <td>2023-05-21</td>
                               <td>${pjdto.pjing }</td>
                            </tr>
                            <tr>
                               <td>개발3팀</td>
                               <td>음식 관련 소셜 네트워크 웹 …</td>
                               <td>웹 개발</td>
                               <td>2023-04-09</td>
                               <td>${pjdto.pjing }</td>
                            </tr>
                         </table>
                      </div>
                      <div class="e0_27 nemobig"><span  class="e0_28" style="margin-top: 8px;">내 작업</span>
                      <div class="todoing" style="margin-left: 50px; font-size: 14px;">진행중인 작업 목록</div>
                         <table id="tbltodo" style="margin-left: 30px;">
                            <c:forEach items="${joblist}" var="dto">
                            <tr>
                               <td>${dto.rnum}  &nbsp</td>
                               <td>${dto.wbsname}</td>
                               <td>${dto.per}%</td>
                            </tr>
                            </c:forEach>
                            
                         </table>
                      
                      </div>
                      <div class="e0_29 nemobig" style="height:650px; margin-bottom:100px;" ><span  class="e0_30" style="height:550px;">
                  <div>
                      <p style="font-size: 24px;">나의 작업 진척도</p>
                      <br>
<div id="chartdiv"></div>
                      </div>
                  
                  
    <br><br>
    <br><br>
    <br><br>
                  
                  </span></div>
                    </div>
                  </div>
                  </td>
                    </tr>
                </table>
                
            </div>
        </div>
    </div>
            
      <!-- Resources -->
<script src="https://cdn.amcharts.com/lib/4/core.js"></script>
<script src="https://cdn.amcharts.com/lib/4/charts.js"></script>
<script src="https://cdn.amcharts.com/lib/4/themes/animated.js"></script>
      
    <script src="js/jquery-3.6.4.js"></script>
    <script>

    am4core.ready(function() {
        // Themes begin
        am4core.useTheme(am4themes_animated);
        // Themes end

        var chart = am4core.create("chartdiv", am4charts.PieChart3D);
        chart.hiddenState.properties.opacity = 0; // this creates initial fade-in

        chart.legend = new am4charts.Legend();

        // 서버로부터 가져온 데이터를 JSON 형식으로 변환하여 사용
        var chartData = [
          <c:forEach items="${listChart}" var="dto">
            {
              country: '${dto.wname}',
              litres: '${dto.percent}',
              
            },
          </c:forEach>
            {
               country: '전체',
               litres: '1600'
            }
        ];
        
        // 데이터 객체의 구조를 수정하여 올바른 형식으로 변경
        chart.data = chartData;
        

        chart.innerRadius = 70;

        var series = chart.series.push(new am4charts.PieSeries3D());
        series.dataFields.value = "litres";
        series.dataFields.category = "country";
      });
    </script>
</body>

</html>
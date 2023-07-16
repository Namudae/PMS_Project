<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
 
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

</style>
</head>
<body>
    <div id="container">
        <%@ include file="/WEB-INF/views/inc/sidebar.jsp" %>

        <div id="content">
        <h2> &nbsp; 이슈목록 > 이슈</h2>
            <hr>
            <div id="topMenu">
                <table>
                    <tr class="tbTop">
                        <td><a href="/pms/issue/issuelist.do">이슈 목록</a></td>
                        <td><a href="/pms/issue/issueadd.do">이슈 등록</a></td>
                        
                    </tr>
                    <tr class="tbMid">
                        <td></td>
                    </tr>
                </table>
            </div>

        <div>
    <h2 class="subtitle" style="display: inline-block;">이슈 목록</h2>
    
</div>
          <table style="border-collapse: collapse;">
    <!-- <tr>
      <td colspan="5" style="text-align: right;background-color: transparent;border: none;">
      </td>
    </tr> -->
  </table>


            <table class="listtbl">
            <thead>
                <tr>
                   <th>번호</th>
                 <th style="width:350px; font-style: italic; ">이슈 제목</th>
                 <th>이슈 종류</th>
                 <th>작성자</th>
                 <th>등록일</th>
                 <th>조치 기한</th>
                 <th>조치 상태</th>
                </tr>
               </thead>
               <tbody>
               <c:forEach items="${list}" var="dto">
                <c:if test="${dto.status == 'w'}">
                    <c:set var="mstatus" value="조치대기" />
                </c:if>
                <c:if test="${dto.status == 'y'}">
                       <c:set var="mstatus" value="조치완료"/>
                   </c:if>
    <tr>
        <td>${dto.rnum}</td>
        <td><a href="/pms/issue/issuedetail.do?issueseq=${dto.issueseq}" id="aLink"><span class="dtoTitle">${dto.title}</span></a></td>
        <td>${dto.issuetype}</td>
        <td>${dto.name}</td>
        <td>${dto.issuedate}</td>
        <td>${dto.deadline}</td>
        <td id="mstatus_${dto.issueseq}">${mstatus}</td>
    </tr>
</c:forEach>
              </tbody>
            </table>
          <div id="paginatvion" style="text-align: center; margin-bottom: 15px; margin-top: 40px;">${pagination}</div>
          <input type="button" value="등록하기" class="btn btnAdd" onclick="location.href='/pms/issue/issueadd.do';" style="margin-left:1200px;">
               
        </div>
        </div>
        
  
    <script src="js/jquery-3.6.4.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script>
        var manageMenu = document.querySelector('.manage');
        var manageDetailMenu = document.querySelector('.manageDetail');

        manageMenu.addEventListener('click', function () {
            manageDetailMenu.style.display = manageDetailMenu.style.display === 'none' ? 'block' : 'none';
        });
        
        var elements = document.querySelectorAll("[id^='mstatus_']");

        elements.forEach(function(element) {
            var id = element.id;
            var value = element.textContent.trim();

            if (value === '조치완료') {
                element.style.color = 'black';
            } else if (value === '조치대기') {
                element.style.color = 'red';
            }
        });

    </script>
</body>

</html>

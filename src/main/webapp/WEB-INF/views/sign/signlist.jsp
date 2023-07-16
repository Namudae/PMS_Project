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
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">



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

        img {
            width: 110px;
            height: 120px;
            margin-left: 20px;
        }

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
        	<p>&nbsp결재 안건 관리 > 결재 목록</p>
            <hr>
            <div id="topMenu">
                <table>
                    <tr class="tbTop">
                        <td><a href="/pms/sign/signlist.do">결재 목록</a></td>
                        <td><a href="/pms/sign/signadd.do">결재 등록</a></td>
                    </tr>
<!--                     <tr class="tbMid"> -->
<!--                         <td colspan="5" style="text-align: right;background-color: transparent;border: none;"> -->
<!--                         <select> -->
<!--                             <option selected="selected">웹개발 프로젝트</option> -->
<!--                         </select> -->
<!--                     </td> -->
<!--                     </tr> -->
                </table>
            </div>

            <h2 class="subtitle">결재 목록</h2>

            <table class="listtbl">
                <thead>
      <tr>
        <th style="width:30px; text-align: center;">번호</th>
        <th style="width:auto; font-style: italic; text-align: center;">제목</th>
        <th style="width:80px; text-align: center;">작성자</th>
        <th style="width:80px; text-align: center;">등록일자</th>
        <th style="width:80px; text-align: center;">확인일자</th>
        <th style="width:80px; text-align: center;">결재여부</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${list}" var="list">
        <tr>
          <td style="text-align: center;">${list.signseq}</td>
          <td><a href="/pms/sign/signdetail.do?signseq=${list.signseq}" id="aLink"><span class="dtoTitle">${list.title}</span></a></td>
          
          <td style="text-align: center;">${list.name}</td>
          <td style="text-align: center;">${list.signdate}</td>
          <td style="text-align: center;">${list.signokdate}</td>
          <td style="text-align: center;">
		    <c:choose>
				<c:when test="${list.signok eq 'y'}">승인</c:when>
				<c:when test="${list.signok eq 'n'}">거절</c:when>
				<c:when test="${list.signok eq 'w'}">
				<span style="color: red;">승인 대기</span>
				</c:when>
			</c:choose>
		  </td>
          
        </tr>
      </c:forEach>
    </tbody>
            </table>
            <div style="text-align: right; margin-right: 80px;">
    <button class="btn" onclick="location.href='/pms/sign/signadd.do';">등록</button>
    </div>
    <div id="paginatvion" style="text-align: center; margin-bottom: 15px;">${pagination}</div>
    </div>
    </div>
    <script src="js/jquery-3.6.4.js"></script>
    <script>
        var manageMenu = document.querySelector('.manage');
        var manageDetailMenu = document.querySelector('.manageDetail');

        manageMenu.addEventListener('click', function () {
            manageDetailMenu.style.display = manageDetailMenu.style.display === 'none' ? 'block' : 'none';
        });
    </script>
</body>

</html>






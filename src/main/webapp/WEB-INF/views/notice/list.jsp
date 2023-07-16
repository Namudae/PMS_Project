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
        <p>&nbsp;공지사항</p>
        <hr>
        

        <h2 class="subtitle" style="displat: inline-block">공지사항 목록</h2>
        
        <div class="total" style="text-align: right; margin: 30px; margin-right: 70px;" >
            <div>
				<input type="button" value="공지사항 등록" class="btn btnAdd" onclick="location.href='/pms/notice/noticeAdd.do';">
            </div>
           
            
        </div>

        <table class="listtbl">
           	<thead>
            <tr>
                <th>번호</th>
                <th>부서</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일자</th>
            </tr>
            </thead>
          	<tbody>
            <c:forEach items="${list}" var="dto">
            <tr>
                <td>${dto.rnum}</td>
                <td>${dto.noticetype}</td>
                <td><a href="/pms/notice/noticedetail.do?noticeseq=${dto.noticeseq}" id="aLink"><span class="dtoTitle">${dto.title}</span></a></td>
                <td>${dto.name}</td>
                <td>${dto.noticedate}</td>
            </tr>
            </c:forEach>
           </tbody>
        </table>
        <div id="paginatvion" style="text-align: center; margin-bottom: 15px; margin-top: 40px;">${pagination}</div>
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





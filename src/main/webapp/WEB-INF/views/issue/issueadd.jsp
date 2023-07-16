<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="css/example.css"> -->
    <!-- 부트스트랩 -->
    <!-- <link rel="stylesheet" href="css/bootstrap.css">  -->
    <!-- 아이콘 설치 -->
    <!-- <link rel="stylesheet" href="../node_modules/bootstrap-icons/font/bootstrap-icons.css"> -->
    <!-- 동현 버튼 -->
     <link rel="stylesheet" href="/pms/asset/css/common.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    
<%-- <%@ include file="/WEB-INF/views/inc/asset.jsp"%> --%>
<style>
@import url('https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Noto+Sans+KR&display=swap');
* {
 font-family: 'Noto Sans KR', sans-serif; 
}
    body {
            margin: 0;
            padding: 0;
        }

        #container {
            display: flex;
         /*    height: 100vh; */
         height: 100%;
         
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
        	<h2> &nbsp; 이슈관리 > 이슈 등록</h2>
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

            <h2 class="subtitle">이슈 등록</h2>
        
        <form method="POST" action="/pms/issue/issueadd.do">   
          
   
    <table class="listtbl">
        <thead>
        <tr>
            <th>제목</th>
            <td colspan="3"><input type="text" name="title" class="txt1"></td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th>조치 희망일</th>
            <td><input type="date" name="deadline" min="10" max="100" class="txt1"></td>
           
        </tr>
        
        <tr>
            <th>이슈종류</th>
            <td><input type="text" name="issuetype" class="txt1"></td>
            <th>프로젝트명</th>
            <td><select name = 'project' id = 'project'>
							<c:forEach items='${list}' var = 'dto'>
								<option value = "${dto.projectseq}">${dto.projectname}</option>					
							</c:forEach>
						</select></td>
        </tr>
        
        </tbody>
    </table>
    <table class="listtbl" style="margin-top: 0;">
        <tr>
            <th style="border-top-left-radius: 0px;">내용</th>
            <td colspan="3"><textarea name="issuecontent" class="txtareaBig"></textarea></td>
        </tr>
    </table>
    


            <div style="text-align: center;">
               <input type="button" class="btn" style="display: inline-block" onclick="location.href='/pms/issue/issuelist.do';" value="목록"> 
            	<input type="submit" name="btn1" id="btn1" class="btn btnAdd" value="등록" onclick="location.href='/pms/issue/issuelist.do';">
              	 <input type="button" name="btn2" id="btn2" class="btnred" value="취소" onclick="location.href='/pms/issue/issuelist.do';" >
            </div>
            
            </form>
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







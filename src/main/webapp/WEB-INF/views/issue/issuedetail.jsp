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
        
        .btndel{
        margin-left:1230px;
        }

</style>
</head>
<body>
      <div id="container">
       <%@ include file="/WEB-INF/views/inc/sidebar.jsp" %>

        <div id="content">
           <h2> &nbsp; 이슈목록 > 이슈 > 상세정보</h2> 
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

            <h2 class="subtitle">이슈 상세정보</h2>
        
        <form method="POST" action="/pms/issue/issueedit.do" style="inline-block;">    
           <c:forEach items="${list}" var="list">
    <c:if test="${list.status == 'w'}">
        <c:set var="mstatus" value="조치대기" />
    </c:if>
    <c:if test="${list.status == 'y'}">
        <c:set var="mstatus" value="조치완료" />
    </c:if>
    <table class="listtbl">
    <thead>
        <tr>
            <th>제목</th>
            <td colspan="3">
                <input type="text" placeholder="${list.title}" readonly>
            </td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <th>날짜</th>
            <td>
                <input type="text" placeholder="${list.issuedate}" readonly>
            </td>
            <th>작성자</th>
            <td>
                <input type="text" placeholder="${list.name}" readonly>
                <input type="hidden" name="issueseq" value="${list.issueseq}">
            </td>
        </tr>
        <tr>
            <th>조치기한</th>
            <td>
                <input type="text" placeholder="${list.deadline}" readonly>
            </td>
            <th>조치상태</th>
            <td>
                <input type="text" placeholder="${mstatus}">
                
                <c:if test="${not empty id and lv == '2' and list.status == 'w'}">   
                    <select name="status" id="status">
                        <option value="w" ${list.status == 'w' ? 'selected' : ''}>조치대기</option>
                        <option value="y" ${list.status == 'y' ? 'selected' : ''}>조치완료</option>
                    </select>
                </c:if>
            </td>
        </tr>
    </tbody>
</table>
    <table class="listtbl" style="margin-top: 0;">
        <tr>
            <th style="border-top-left-radius: 0px;">내용</th>
            <td colspan="3"><textarea name="issuecontent">${list.issuecontent}</textarea></td>
        </tr>
    </table>
    
</c:forEach>
           <div style="text-align: center;">
                 <input type="button" class="btn" value="목록" onclick="location.href='/pms/issue/issuelist.do';"style="display: inline-block;">
              
              <c:if test="${not empty id and list.get(0).status == 'w'}">
              <button type="submit" class="btn btnAdd" value="수정" style="display: inline-block;" onclick="location.href='/pms/issue/issuelist.do';">수정</button>
              </c:if>

         </div>
 </form>
 <!--  -->
 <form method="POST" action="/pms/issue/issuedel.do" style="inline-block;">
 <c:forEach items="${list}" var="list">
    <c:if test="${list.status == 'w'}">
        <c:set var="mstatus" value="조치대기" />
    </c:if>
    <c:if test="${list.status == 'y'}">
        <c:set var="mstatus" value="조치완료" />
    </c:if>
    <table >
    <tr>
            <td ><input type="hidden" placeholder="${list.title}" readonly></td>
            
            <td><input type="hidden" placeholder="${list.issuedate}" readonly></td>
           
            <td><input type="hidden" placeholder="${list.name}" readonly></td>
            <td><input type="hidden" name="issueseq" value="${list.issueseq}"></td>
       
           
            <td><input type="hidden" placeholder="${list.deadline}" readonly></td>
          
            <td><input type="hidden" placeholder="${mstatus}">
            <select name="status" id="status" style="display:none;">
              <option value="w" ${list.status == 'w' ? 'selected' : ''}>조치대기</option>
                <option value="y" ${list.status == 'y' ? 'selected' : ''}>조치완료</option>
         </select>
            </td>
            <td><input type="hidden" placeholder="${list.issuecontent}"></td>
      
    </table>
    
</c:forEach>
 <button type="submit" class="btn btnAdd btndel btnred" value="삭제" style="display: inline-block;" onclick="location.href='/pms/issue/issuelist.do';">삭제</button>
   
 </form>
 
 <!--  -->
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






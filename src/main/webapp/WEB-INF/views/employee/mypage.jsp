<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <!-- 부트스트랩 -->
	<link rel="stylesheet" href="css/bootstrap.css">
    <!-- 아이콘 설치 -->
    <link rel="stylesheet" href="../node_modules/bootstrap-icons/font/bootstrap-icons.css">
    <!-- 동현 버튼 -->
     <link rel="stylesheet" href="/pms/asset/css/common.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    
<%-- <%@ include file="/WEB-INF/views/inc/asset.jsp"%> --%>
<style>
@import url('https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Noto+Sans+KR&display=swap');
* {
 font-family: 'Noto Sans KR', sans-serif; 
 font-size: 20px;
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
        	<p>&nbsp;마이페이지</p>
            <hr>
            <div id="topMenu">
                <table >
                    <tr class="tbTop">
                        <td><a href="#">프로젝트 목록</a></td>
                        <td><a href="#">상세정보</a></td>
                        <td><a href="#">WBS</a></td>
                        <td><a href="#">이슈</a></td>
                        <td><a href="#">산출물</a></td>
                    </tr>
                    <tr class="tbMid">
                        <td></td>
                    </tr>
                </table>
            </div>

            <!-- <h2 class="subtitle">회원 정보 등록</h2> -->
    
        
        <form method="POST" name="form1" action="/pms/employee/mypage.do">
        
            <table id="tbllist" class="listtbl">
                <thead>
                    <tr>
                        <th colspan="5" class="thAdd">내 정보 수정
                        </th>
                    </tr>
                </thead>
            	<tbody>
            	<tr class="trMenu">
                    <th class="short">이름 </th>
                    <td class="tdShort">${dto.name }</td>
                </tr>
                <tr class="trMenu">
                    <th class="short">직급 </th>
                    <td class="tdShort">${dto.ps }</td>
                </tr>
                <tr class="trMenu">
                    <th class="short">이메일 </th>
                    <td class="tdShort">${dto.email }</td>
                </tr>
                <tr class="trMenu">
                    <th class="short">아이디 </th>
                    <td class="tdShort">${dto.id }</td>
                </tr>
                <tr class="trMenu">
                    <th class="short">새 비밀번호 </th>
                    <td class="tdShort"><input type="password" placeholder="비밀번호 입력" name="newPw" class="txt1"></td>
                </tr>
                <tr class="trMenu">
                    <th class="short">비밀번호 재확인 </th>
                    <td class="tdShort"><input type="password" placeholder="비밀번호 확인" name="newPw2" class="txt1"></td>
                </tr>
              
                <!-- <tr>
                    <td colspan="5" style="text-align: center;">
                        
                </td>
                </tr> -->
                
                </tbody>
            </table>
            
            <div style="text-align: center;">
                <input type="submit" name="btn1" id="btn1" class="btn btnAdd" value="정보 변경">
       		</div>
       		
    		<input type="hidden" name="employeeSeq" value="${employeeSeq}">
       		
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

	document.form1.btn1.onclick = m1;

    function m1(){
      
        var txtpw = document.form1.newPw;
        var txtpwc = document.form1.newPw2;


      //암호 > 일치
        if(txtpw.value != txtpwc.value){
         alert('암호가 일치하지 않습니다.');
         txtpw.focus();
         return;
        }


        document.form1.submit(); 

        }
</script>
  

</body>
</html>











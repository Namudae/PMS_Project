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
            width: 100%;
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
        	<p>&nbsp내 작업 > 산출물 목록</p>
            <hr>
            <div id="topMenu">
                <table>
                    <tr class="tbTop">
                        <td><a href="/pms/todo/my/todolist.do">작업 목록</a></td>
                        <td><a href="/pms/todo/my/productlist.do">산출물</a></td>
                    </tr>
                    <tr class="tbMid">
                        <td colspan="5" style="text-align: right;background-color: transparent;border: none;">
                            <select id="pjseq" name="pjseq">
                            	<option value="all">전체보기</option>
                            	<c:forEach items="${pjlist}" var="cdto">
			                  		<option value="${cdto.pjseq}">${cdto.pjname}</option>
			               		</c:forEach>
                        	</select>
                        </td>
                    </tr>
                </table>
            </div>

            <h2 class="subtitle">산출물 목록</h2>

            <table class="listtbl">
            	<thead>
                <tr>
                    <th>번호</th>
                    <th>프로젝트명</th>
                    <th>산출물명</th>
                    <th>작성자</th>
                    <th>등록날짜</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${plist}" var="dto">
                 <tr>
                   <td>${dto.rnum}</td>
                   <td><a href="/pms/todo/my/productdetail.do?seq=${dto.prseq}">${dto.pjname}</a></td>
                   <td>${dto.prname }</td>
                   <td>${dto.emname }</td>
                   <td>${dto.prdate}</td>
                 </tr>
               </c:forEach>
               </tbody>
            </table>
            <span id="pg"><div id="pagination" style="text-align: center; margin-bottom: 15px;">${pagination}</div></span>
            <input type="button" name="btn1" id="btn1" class="btn" value="등록" onclick="location.href='/pms/todo/my/productadd.do';">
        </div>
    </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script>
    var manageMenu = document.querySelector('.manage');
        var manageDetailMenu = document.querySelector('.manageDetail');
    
        manageMenu.addEventListener('click', function() {
            manageDetailMenu.style.display = manageDetailMenu.style.display === 'none' ? 'block' : 'none';
    });
        
        
        
        
        
	$(document).ready(function(){
        	
        	
        	$("#pjseq").change(function(){
        		let pjseq = $(this).val();
        		$("#pjseq").val($(this).val());
        	
        		let tr = $('.listtbl > tbody');
        		let pg = $('#pg');
        		
        		$.ajax({
                    type: 'POST',
                    url: '/pms/todo/my/productlist.do',
                    data: {
                        pjseq: pjseq
                    },
                    dataType:'json',
                    success: (result) => {
                    	let temp;
                    	
                    	
                    	
                    	tr.html('');
                    	
                    	$(result).each((index, item)=>{
                    		
                    	
                    		
                    		
                    		temp += `<tr>
		                                <td>\${item.rnum}</td>
		                                <td><a href="/pms/todo/my/productdetail.do?seq=\${item.prseq}">\${item.pjname}</a></td>
		                                <td>\${item.prname }</td>
		                                <td>\${item.emname }</td>
		                                <td>\${item.prdate}</td>
		            				</tr>`;
                    		
	                                   		
                                   		
                    		tr.html(temp);   
                    		
                    	});
                    	
                    	
                    	
                    	/* pg.html(`<div id="pagination" style="text-align: center; margin-bottom: 15px;">\${item.pagination}</div>`); */
                    		
                    	                 
                    },
                    error: (a,b,c) => console.log(a,b,c)
                });
        		
        		$.ajax({
                    type: 'POST',
                    url: '/pms/todo/my/productpagination.do',
                    data: {
                        pjseq: pjseq
                    },
                    dataType:'html',
                    success: (result) => {
                    	
                    	
                    	pg.html(`<div id="pagination" style="text-align: center; margin-bottom: 15px;">\${result}</div>`);
                    },
                    error: (a,b,c) => console.log(a,b,c)
        		});
        		
        		

        	});
         })
</script>
</body>
</html>
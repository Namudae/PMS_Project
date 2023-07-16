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
            width: 1200px;
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
        	<p>&nbsp이슈목록 > 이슈</p>
            <hr>
            <div id="topMenu">
                <table>
                    <tr class="tbTop">
                        <td><a href="/pms/todo/my/todolist.do">작업 목록</a></td>
                        <td><a href="/pms/todo/my/productlist.do">산출물</a></td>
                    </tr>
                    <tr class="tbMid">
                        <td colspan="5" style="text-align: right;background-color: transparent;border: none;">
                    		<select name="pjseq">
                    			<option>전체보기</option>
                            	<c:forEach items="${pjlist}" var="cdto">
			                  		<option value="${cdto.pjseq}">${cdto.pjname}</option>
			                  		
			               		</c:forEach>
                        	</select>
                        </td>
                    </tr>
                </table>
            </div>

            <h2 class="subtitle">작업 목록</h2>

            <table class="listtbl">
                <tr>
                    <th>번호</th>
                    <th>작업명</th>
                    <th>프로젝트명</th>
                    <th>담당</th>
                    <th>상태</th>
                    <th>시작일</th>
                    <th>완료일</th>
                    <th>완료율</th>
                    <th>수정</th>
                </tr>
                <c:forEach items="${list}" var="dto">
                  <tr>
                    <td>${dto.seq }</td>
                    <td>${dto.wbsname }</td>
                    <td>${dto.pjname }</td>
                    <td>${dto.emname }</td>
                    <td>진행중</td>
                    <td>${dto.start}</td>
                    <td>${dto.end }</td>
                    <td colspan="">${dto.per}<span>%</span></td> 
                    <td>
                        <div>
                            <input type="button" value="수정" onclick="edit();">
                        </div>
                        <div style="display: none;">
                            <input type="button" value="확인" onclick="editok(${dto.seq});" >
                          
                        </div>
                    </td>
                    <!-- 수정 버튼 누르면 텍스트 박스 라인이 보이고 버튼내용이 완료로 바뀐다, 완료버튼을 누르면 다시 텍스트박스 보더가 사라지고 버튼내용은 수정으로 바뀐다. 완료율이 100프로가 되면 완료일이 sysdate로 입력된다.  -->
                  </tr>
                </c:forEach>                
            </table>
            <div id="pagination" style="text-align: center; margin-bottom: 15px;">${pagination}</div>
        </div>
    </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<!-- <script type="text/javascript" src="js/bootstrap.js"></script> -->
<script>
    var manageMenu = document.querySelector('.manage');
        var manageDetailMenu = document.querySelector('.manageDetail');
    
        manageMenu.addEventListener('click', function() {
            manageDetailMenu.style.display = manageDetailMenu.style.display === 'none' ? 'block' : 'none';
    });
        
        
        function edit() {
            let tr = event.target.parentElement.parentElement.parentElement;
	        
	   
	        let per = $(tr).children().eq(7).text();
	        
	        let per1 = per.substring(0,per.indexOf('%'));
	        
	    
	        
	       	
            $('#tbl > tbody').html()
            $(tr).children().eq(7).html('<input type="text" value="'+per1+'" style="width:30px">');
            
            $(event.target).parent().parent().children().last().show();
	        $(event.target).parent().hide();

        }

        function editok(seq) {

            let per = $(event.target).parent().parent().parent().children().eq(7).children().eq(0).val();
            
            const btn = event.target;
      

            $.ajax({
                type: 'POST',
                url: '/pms/todo/my/todoedit.do',
                data: {
                    seq: seq,
                    per: per
                },
                success: (result) => {
                	 	
                	
                	if(result.result == 1){
                		
                		$(btn).parent().hide();
                        $(btn).parent().parent().children().first().show();
                        
                        $(btn).parent().parent().parent().children().eq(7).text(per+"%"); 
                		
                	}                 
                },
                error: (a,b,c) => console.log(a,b,c)
            });
        }
        
        let temp 
        $(document).on('change', '', function(){
        	temp += $(tr).chidren().eq(7).html()
        });
        
        td.html(temp)
        
        

</script>
</body>
</html>
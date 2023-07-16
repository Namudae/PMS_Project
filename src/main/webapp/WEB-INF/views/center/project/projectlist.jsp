<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/pms/asset/css/common.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
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
        
        a {
		   text-decoration: none;
		   color: #1F1F1F;
		}
		
		a:hover {
		   text-decoration: underline;
		}
		
		#search{ 
			display: flex;
			justify-content: center;
			margin-top: 30px;	
		}
		
		#pjseq{
			height: 35px;
    		margin-top: 11px;
    		border-radius: 5px;
    	}
        
        



</style>

</head>
<body>
	<div id="container">
		<%@ include file="/WEB-INF/views/inc/sidebar.jsp" %>

		<div id="content">
			<h4>프로젝트 센터</h4>
			<hr>
				<div id="search">
					<select id="pjseq" name="pjseq">
                         <option value="all">전체보기</option>
                           <c:forEach items="${pjlist}" var="pdto">
			                  <option value="${pdto.projectSeq}">${pdto.name}</option>
			               </c:forEach>
                     </select>
					<input type="button" value="프로젝트 등록" class="btn btn-primary" name="addBtn" id="addBtn" onclick="location.href='/pms/center/project/projectadd.do';">
				</div>

			<div id="table_container">
				<table id="tbllist" class="listtbl">
					<thead>
						<tr>
							<th>프로젝트명</th>
							<th>프로젝트 유형</th>
							<th>PM</th>
							<th>기간</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pjlist}" var="dto">
							<tr>
								<td><a href="/pms/center/project/projectdetail.do?projectSeq=${dto.projectSeq}">${dto.name}</a></td>
								<td>${dto.projectType}</td>
								<td>${dto.employeeName}</td>
								<td>${dto.startDate} &nbsp;&nbsp;&nbsp; ~ &nbsp;&nbsp;&nbsp; ${dto.endDate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<span id="pg"><div id="pagination" style="text-align: center; margin-bottom: 15px;">${pagination}</div></span>
			</div>
		</div>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
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
                    url: '/pms/center/project/projectlist.do',
                    data: {
                        pjseq: pjseq
                    },
                    dataType:'json',
                    success: (result) => {
                    	let temp;
                    	
                    	
                    	
                    	tr.html('');
                    	
                    	$(result).each((index, item)=>{
                    		
                    	
                    		
                    		
                    		temp += `<tr>
		                                <td><a href="/pms/center/project/projectdetail.do?projectSeq=\${item.projectSeq}">\${item.name}</a></td>
		                                <td>\${item.projectType }</td>
		                                <td>\${item.employeeName }</td>
		                                <td>\${item.startDate} \${item.endDate}</td>
		            				</tr>`;
                    		
	                                   		
                                   		
                    		tr.html(temp);   
                    		
                    	});
                    	
                    	
                    	
                    	/* pg.html(`<div id="pagination" style="text-align: center; margin-bottom: 15px;">\${item.pagination}</div>`); */
                    		
                    	                 
                    },
                    error: (a,b,c) => console.log(a,b,c)
                });
        		
        		$.ajax({
                    type: 'POST',
                    url: '/pms/center/project/projectlistpage.do',
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
         });
		
		
		
	</script>
</body>
</html>
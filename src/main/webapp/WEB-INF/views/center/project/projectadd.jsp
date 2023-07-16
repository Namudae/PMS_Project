<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/pms/asset/css/common.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
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
	<!--  -->

<div id="container">
	<%@ include file="/WEB-INF/views/inc/sidebar.jsp" %>

	<div id="content">
		<h2>&nbsp; 프로젝트 센터 > 프로젝트 등록</h2>
		<hr>
		<div id="topMenu">
			<table>
				<tr class="tbTop">
                        <td><a href="/pms/center/project/projectlist.do">프로젝트 목록</a></td>
                        <td><a href="/pms/center/project/projectdetail.do?projectSeq=${dto.projectseq}">상세정보</a></td>
                        <td><a href="/pms/center/wbs/view.do?pjseq=${dto.projectSeq}">WBS</a></td>
                        <td><a href="/pms/center/issue/cissuelist.do?pjseq=${dto.projectseq}">이슈</a></td>
                  <td><a href="/pms/center/product/cproductlist.do?pjseq=${dto.projectseq}">산출물</a></td>
                  <td><a href="/pms/center/version/versionlist.do?pjseq=${dto.projectseq}">버전</a></td>
                    </tr>
				<tr class="tbMid">
					<td></td>
				</tr>
			</table>
		</div>

		<h2 class="subtitle">프로젝트 등록</h2>

		<table class="listtbl">
			<thead>
				<tr>
					<th>프로젝트명</th>
					<td colspan="3"><input type="text" name="name" class="txt1" id="projectName"></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>시작일</th>
					<td><input type="date" name="startDate" min="10" max="100" class="txt1" id="startDate"></td>
					<th>종료일</th>
					<td><input type="date" name="endDate" min="10" max="100" class="txt1" id="endDate"></td>
				</tr>
				<tr>
					<th>팀</th>
					<td>
						<select name="teamName" id="teamName">
							<c:forEach items="${teamList}" var="tdto">
								<option value="${tdto.teamSeq}">${tdto.teamName}</option>
							</c:forEach>
						</select>
					</td>
					<th>PM</th>
					<td>
						<select name="pmName" id="pmName"></select>
					</td>
				</tr>
				<tr>
					<th rowspan="3">PA</th>
					<td rowspan="3">
						<select name="paName" id="paName">
							<option>선택</option>
						</select>
						<div id="teamlist"></div>
					</td>
					<th>프로젝트 유형</th>
					<td>
						<select name='projectType' id="projectType">
							<c:forEach items="${projectType}" var="pdto">
								<option value="${pdto}">${pdto}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th>R&D개발</th>
					<td>
						<select name='rndType' id="rndType">
							<c:forEach items="${rndType}" var="pdto">
								<option value="${pdto}">${pdto}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th>초기예산</th>
					<td><input type="text" name="budget" class="txt1" id="budget"></td>
				</tr>
			</tbody>
		</table>

		<table class="listtbl" style="margin-top: 0;">
			<tr>
				<th style="border-top-left-radius: 0px;">내용</th>
				<td colspan="3"><textarea name="content" class="txtareaBig" id="addText"></textarea></td>
			</tr>
		</table>

		<div style="text-align: center;">
			<input type="button" name="btnAdd" id="btnAdd" class="btn btnAdd" value="등록">
			<input type="button" name="btnBack" id="btnBack" class="btnred" value="취소" onclick="location.href='/pms/center/project/projectlist.do';">
		</div>
	</div>
</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

	<script>
		var manageMenu = document.querySelector('.manage');
		var manageDetailMenu = document.querySelector('.manageDetail');

		manageMenu
				.addEventListener(
						'click',
						function() {
							manageDetailMenu.style.display = manageDetailMenu.style.display === 'none' ? 'block'
									: 'none';
						});
		
		let teamSeq;
		let pmSeq;

		
		
			
		const input = document.querySelector('#budget');

		input.addEventListener('keyup', function(e) {
			let value = e.target.value;
			value = Number(value.replaceAll(',', ''));
			if (isNaN(value)) { //NaN인지 판별
				input.value = '';
			} else { //NaN이 아닌 경우
				const formatValue = value.toLocaleString('ko-KR');
				input.value = formatValue;
			}
		})
		
		
		
		$(document).on('change', '#teamName' , function(){
			
			let seq = $(this).val();
			
			teamSeq = seq;
			
			$.ajax({
				url: '/pms/center/project/projectteamlist.do',
				type: 'POST',
				dataType: 'json',
				data:{
					seq: seq
				},
				success: (result) => {
					let temp = `<option>선택</option>`; 
					
					$(result).each((index, item)=>{
						if(item.lv == '2'){
							
							pmSeq = item.employeeseq;
							
						$('#pmName').html(`<option value="\${item.employeeseq}">\${item.name}</option>`); 
						
							/* $('#pmName').html('<option value="' + item.employeeseq + '">' +  item.name + '</option'); */
						}else{
							temp += '<option value="' + item.employeeseq + '">' +  item.name + '</option>';
							//$('#paname').append(`<option value="\${item.employeeseq}">\${item.name}</option>`);
							
						}
					});
					
							$('#paName').html(temp);
							
						
				},
				error: (a,b,c) => console.log(a,b,c)
			});
			 
			
		});
			
			
			
	 $(document).on('change', '#paName', function(){
			
		let employeeseq = $('#paName option:selected');		
				employeeseq.remove();
		/* $.ajax({
			url:'/pms/center/project/projectemployee.do',
			dataType:'json',
			data:{employeeseq: employeeseq
				  paName: paName	
					},
			type:'POST'
			error: (a,b,c) =>console.log(a,b,c)
					
		}); */
		
		
		
		
		
	});			 
			
	 			
		$(document).ready(() => {
		  // 셀렉트 박스 값 변경 이벤트 감지
		  $('#paName').change(() => {
		    const selectedValue = $('#paName').val(); // 선택한 값 가져오기
		    const selectedOptionText = $('#paName option:selected').text(); // 선택한 옵션의 텍스트 가져오기

		    // 선택한 값과 텍스트를 button 태그에 추가
		    $('#teamlist').append('<input type="button" class="'+ selectedValue +'" ' + 'value="' + selectedOptionText + '">');
		    
		    
		  });
		});

		$(document).find('#teamlist').on('click', 'input', function(){
			let name = $(this).val();
			let seq = $(this).attr('class');
			
			$('#paName').append('<option value="' + seq + '">' + name + '</option>');
			
			$(this).remove();
		});
	

		
		
	 	$('#btnAdd').click(function(){
			let pa = [];
	 		$(document).find('#teamlist').children().each(function(){
	 			pa.push($(this).attr('class'));
	 		});
		 		
			
	 		
			let projectName = $('#projectName').val();
			let startdate = $('#startDate').val();
			let enddate = $('#endDate').val();
			let team = teamSeq;
			let pm = pmSeq;
			let projectType = $('#projectType').val();
			let projectRnd =  $('#rndType').val();
			let budget = $('#budget').val().replace(/,/g , '');
			let content = $('#addText').val();
			
	
			$.ajax({
				url: '/pms/center/project/projectadd.do',
				type: 'POST',
				data: {
					
					projectName: projectName,
					startdate: startdate,
					enddate: enddate,
					team: team,
					pm: pm,
					projectType: projectType,
					projectRnd: projectRnd,
					budget: budget,
					content: content,
					pa: pa.toString()
				},
				success: function() {
					location.href = "/pms/center/project/projectlist.do";
				},
				error: (a,b,c) => console.log(a,b,c)
			
			});
			 
		}); 
		
	</script>
</body>
</html>
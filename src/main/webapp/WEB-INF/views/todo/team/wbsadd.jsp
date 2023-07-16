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
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap')
	;

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
#sidebar>#info {
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

#content>hr {
	border-width: 3px;
	border-style: solid;
	color: #9DB2BF;
}

#topMenu>table {
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

#topMenu .tbTop>td:hover {
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

#tbl {
	width: 1146px;
}

#tbl th {
	text-align: center;
}

#tbl td {
	text-align: center;
}

#tbl tr {
	height: 30px !important;
}

#tbl td {
	height: 30px !important;
}

#tbl td, #tbl th {
	padding: 0px;
}

#tbl th:nth-child(1) {
	width: 60px;
}

#tbl td:nth-child(2) {
	padding-left: 8px;
}

#tbl td:nth-child(2) {
	text-align: left;
	width: 410px;
}

#tbl th:nth-child(3) {
	width: 90px;
	max-width: 110px;
}

#tbl th:nth-child(4) {
	width: 60px;
	max-width: 100px;
}

#tbl th:nth-child(5) {
	width: 100px;
	max-width: 140px;
}

#tbl th:nth-child(6) {
	width: 100px;
	max-width: 140px;
}

#tbl td:nth-child(7) {
	width: 40px;
}

.edit {
	cursor: pointer;
}

.JHbtn>.btn {
	margin-left: 1130px;
}

.edit:hover {
	text-decoration: underline;
}

input[type="text"] {
	border: 0 solid black;
	size: 50;
	outline: none;
	font-size: 1.1rem;
	width: 500px;
}

select {
	width: 100px;
	height: 30px;
	padding-left: 5px;
	font-size: 15px;
}

.selected {
	margin-left: 1095px;
}
</style>
</head>
<body>
	<%-- <%@ include file="/WEB-INF/views/inc/header.jsp" %> --%>
	<div id="container">
		<%@ include file="/WEB-INF/views/inc/sidebar.jsp" %>

		<div id="content">
			<p>&nbsp일반 작업 > 프로젝트 분담 내역</p>
			<hr>
			<div id="topMenu">
				<table>
					<tr class="tbTop">
						<td><a href="/pms/todo/team/progresslist.do">프로젝트 진척도</a></td>
						<c:if test="${lv == 2}">
							<td><a href="/pms/todo/team/wbsadd.do">프로젝트 작업 등록</a></td>
						</c:if>
						<td><a href="/pms/todo/team/teamproductlist.do">프로젝트 전체
								산출물 조회</a></td>
					</tr>
					<tr class="tbMid">
						<td></td>
					</tr>
				</table>
			</div>


			<select class="selected">
				<option value="0">한눈에 보기</option>
				<c:forEach items="${teamList}" var="team">
					<option value="${team.employeeseq}">${team.name}</option>
				</c:forEach>
			</select>

			<table id="tbl" class="listtbl">
				<thead>
					<tr>
						<th>번호</th>
						<th>작업명</th>
						<th>담당</th>
						<th>직급</th>
						<th>시작날짜</th>
						<th>종료날짜</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="dto">
						<tr class="wbsItem">
							<td class="${dto.wbsseq}">${dto.rownum}</td>
							<td class="edit">${dto.wbsname}</td>
							<td>${dto.name}</td>
							<td>${dto.position}</td>
							<td>${dto.startdate}</td>
							<td>${dto.enddate}</td>
							<td><input type="button" value="삭제" class="remove btn"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<c:forEach items="${teamList}" var="team">
				<div class="team">
					<input type="hidden" value="${team.name}">
					<!-- 이름 -->
					<input type="hidden" value="${team.employeeseq}">
					<!-- 사원번호 -->
				</div>
			</c:forEach>

			<div class="JHbtn">
				<input type="button" value="+" class="btn">
			</div>

			<div class="addView">
				<input type="button" value="더 보기" class="btn viewbtn"
					style="margin-left: 597px;" onclick="plusview();">
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
	<script>
	
    var manageMenu = document.querySelector('.manage');
    var manageDetailMenu = document.querySelector('.manageDetail');

    manageMenu.addEventListener('click', function () {
        manageDetailMenu.style.display = manageDetailMenu.style.display === 'none' ? 'block' : 'none';
    });
	
    
    
	let teamName = [];
	//let position = [];
	let employeeseq = [];
	
	let teamMaxRow = ${teamMaxRow};
	
	
	$('.team').each(function(index, item){
		teamName.push($(this).children().eq(0).val());
		//position.push($(this).children().eq(1).val());
		employeeseq.push($(this).children().eq(1).val());
	});

	$('.JHbtn > input').click(function team(){
		let tr = document.createElement('tr');
		tr.classList.add('addwbs');
		for(let i = 0; i < 7; i++){
			let td = document.createElement('td');
			
			if(i == 0){
				let button = document.createElement('input');
				button.type='button';
				button.value = '등록';
				button.classList.add('addbtn');
				button.classList.add('btn');
				td.appendChild(button);
			}
			
			if(i == 1){
				let text = document.createElement('input');
				text.type = 'text';
				td.appendChild(text);
			}

			if(i == 2){
				let selectTag = document.createElement('select');
				for(let i = 0; i < $('.team').length; i++){
					let optionTag = document.createElement('option');
					optionTag.text = teamName[i];
					optionTag.value = employeeseq[i];
					selectTag.appendChild(optionTag);
				}
				td.appendChild(selectTag);
			}

			if(i == 4 || i == 5){
				let date = document.createElement('input');
				date.type = 'date';
				td.appendChild(date);
			}
			
			if(i == 6){
				let button = document.createElement('input');
				button.type = 'button';
				button.value = '-';
				button.classList.add('delbtn');
				button.classList.add('btn');
				td.appendChild(button);
			}
			
			tr.appendChild(td);
		}
		
		$('#tbl > tbody').append(tr);
	});
	
	$(document).on('change', 'select', function(){
		let seq = $(this).val();
		let td = $(this).parent().parent().children().eq(3);
		
		$.ajax({
			url: '/pms/todo/team/wbsaddajax.do',
			type: 'POST',
			data:{
				seq: seq
			},
			dataType: 'json',
			success: (result)=>{
				td.html(result.position);
			},
			error: (a,b,c)=>console.log(a,b,c)
		});
	});
	
	

	$(document).on('click', '.addbtn', function(){
		let tr = $(this).parent().parent();
		let position = tr.children().eq(3).html();
		let name = tr.find('select option:selected').text();
		let wbsname = tr.find('input[type="text"]').val();
		let seq = tr.find('select').val();
		let start = tr.children().eq(4).find('input[type="date"]').val();
		let end = tr.children().eq(5).find('input[type="date"]').val();
		
		$.ajax({
			url: '/pms/todo/team/wbsadd.do',
			type: 'POST',
			data:{
				wbsname: wbsname,
				seq: seq,
				start: start,
				end: end
			},
			dataType: 'json',
			success: result => {
				tr.children().eq(0).html(tr.index() + 1);
				tr.children().eq(0).addClass('' +result.newseq + '');
				tr.children().eq(1).html(wbsname);
				tr.children().eq(1).addClass('edit');
				tr.children().eq(2).html(name);
				tr.children().eq(3).html(position);
				
				tr.children().eq(4).find('input[type="date"]').remove();
				tr.children().eq(4).html(start);
				tr.children().eq(5).find('input[type="date"]').remove();
				tr.children().eq(5).html(end);
				
				tr.children().eq(6).html('<input type="button" value="삭제" class="remove btn">');
			},
			error: (a,b,c) => console.log(a,b,c)
		}); 
	});
	
	
	$(document).on('click', '.edit', function edit(){
		$(this).parent().children().eq(0).css('width', '160px');
		
		$(this).removeClass('edit');
		
		
		let wbsseq = $(this).parent().children().eq(0).attr('class');
		let seq = $(this).parent().children().eq(0).html();
		let wbsname = $(this).parent().children().eq(1).html();
		let name = $(this).parent().children().eq(2).html();
		let position = $(this).parent().children().eq(3).html();
		let start = $(this).parent().children().eq(4).html();
		let end = $(this).parent().children().eq(5).html();
	
		let trIndex = $(this).parent().index();

		//선택된 tr
		let tr = $('#tbl > tbody').children().eq(trIndex).children();
		
		let selectTag = '<select>'
			for(let i = 0; i < $('.team').length; i++){
				let optionTag = '<option value="' + employeeseq[i] +'">' + teamName[i] + '</option>';
				selectTag += optionTag;
			}
			
		selectTag += '</select>';
		
		tr.eq(0).html('<input type="button" value="수정" id="editbtn" class="btn"><input type="button" value="취소" class="cancel btn">');
		tr.eq(1).html('<input type="text" value="' + wbsname + '">');
		tr.eq(2).html(selectTag);
		tr.eq(4).html('<input type="date" value="' + start + '">');
		tr.eq(5).html('<input type="date" value="' + end + '">');
		
		
		//취소
		$(document).on('click', '.cancel', function(){
			
			tr.eq(1).addClass('edit');
			
			tr.eq(0).css('width', '60px');
			
			tr.eq(0).html(seq);
			tr.eq(1).html(wbsname);
			tr.eq(2).html(name);
			tr.eq(3).html(position);
			tr.eq(4).html(start);
			tr.eq(5).html(end);
		});
		
		
		//수정
		$(document).on('click', '#editbtn', function(){
			tr.eq(1).addClass('edit');
			tr.eq(0).css('width', '60px');
			
			//tr
			let me = $('#tbl > tbody').children().eq(trIndex);
			let newEmployeeseq = me.children().eq(2).find('select').val();
			
			let newWbsName = me.children().eq(1).children().eq(0).val();
			let newName = me.children().eq(2).find('select option:selected').text();
			let newPosition = me.children().eq(3).html();
			let newStart = me.children().eq(4).children().eq(0).val();
			let newEnd = me.children().eq(5).children().eq(0).val();
			
			$.ajax({ 
				url: '/pms/todo/team/wbseditajax.do',
				type: 'POST',
				data:{
					wbsseq: wbsseq,
					wbsname: newWbsName,
					employeeseq: newEmployeeseq,
					start: newStart,
					end: newEnd
				},
				dataType:'json',
				success: result => {
					if(result.result == 1){
						me.children().eq(0).html(seq);
						me.children().eq(1).html(newWbsName);
						me.children().eq(2).html(newName);
						me.children().eq(3).html(newPosition);
						me.children().eq(4).html(newStart);
						me.children().eq(5).html(newEnd); 						
					}
					
				},
				error: (a,b,c) => console.log(a,b,c)
			}); 
		});
		
	});
	
	$(document).on('click', '.remove', function(){
		let isTrue = window.confirm('정말 삭제하시겠습니까?');
		
		let selectTr = $(this).parent().parent();
		
		let wbsseq = selectTr.children().eq(0).attr('class');
		
		if(isTrue){
			selectTr.remove();
			
			$.ajax({
				url: '/pms/todo/team/wbsdelajax.do',
				type: 'POST',
				data:{
					wbsseq: wbsseq
				},
				success: result =>{
					//딱히 작업내용없음
				},
				error: (a,b,c) => console.log(a,b,c)
			});
		}
	});
	
	$(document).on('click', '.delbtn', function(){
		$(this).parent().parent().remove();
	});
	
	$('.selected').change(function(){
		//0은 전체보기
		
		let seq = $(this).val();
		
		$.ajax({
			url: '/pms/todo/team/wbsaddselect.do',
			type: 'POST',
			data:{
				employeeseq: seq
			},
			dataType: 'json',
			success: result => {
				let temp;
				$(result).each((index, item)=>{
					temp += `<tr class=wbsItem>
							<td>\${item.rownum}</td>
							<td class="edit">\${item.wbsname}</td>
							<td>\${item.name}</td>
							<td>\${item.position}</td>
							<td>\${item.startdate}</td>
							<td>\${item.enddate}</td>
							<td><input type="button" class="remove btn" value="삭제" onclick=></td>
							</tr>`;
				});
				
				
				
				$('#tbl > tbody').html(temp);
				if(seq != 0){
					addView($(result).length);
				}else{
					addView(teamMaxRow);
				}
				
			},
			error: (a,b,c) => console.log(a,b,c)
		});
	});
	
	function addView(row){
		let trLen2 =$(document).find('.wbsItem').length;
		
		if(trLen2 == row){
			$('.viewbtn').remove();
		}else{
			$('.addView').html(`<input type="button" value="더보기" class="btn viewbtn" style="margin-left: 597px;" onclick="plusview();">`);
		}
	}
	
	
	function plusview(){
		let trLen = $(document).find('.wbsItem').length;
		
		$.ajax({
			url: '/pms/todo/team/wbsaddview.do',
			type: 'POST',
			data: {
				trLen: trLen,
			},
			dataType: 'json',
			success: result => {
				let temp = $('#tbl > tbody').html();
				$(result).each((index, item)=>{
					temp += '<tr class="wbsItem">' +
						'<td class="' + item.wbsseq  + '">' + item.rownum  +'</td>' +
						'<td class="edit">' + item.wbsname + '</td>' +
						'<td>' + item.name + '</td>' +
						'<td>' + item.position + '</td>' +
						'<td>' + item.startdate + '</td>' +
						'<td>' + item.enddate + '</td>' +
						'<td><input type="button" class="remove btn" value="삭제"></td>' + 
						'</tr>';
				});
				$('#tbl > tbody').html(temp);
				trLen = $('.wbsItem').length;
				addView(teamMaxRow);
			},
			error: (a,b,c) => console.log(a,b,c)
		});
	};
	
	addView(teamMaxRow);
	
</script>
</body>
</html>
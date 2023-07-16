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
<link rel="stylesheet" href="/pms/asset/css/projectadd.css">

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
	.txt1{ width:150px;}
</style>

</head>
<body>


	<div id="container">
	<%@ include file="/WEB-INF/views/inc/sidebar.jsp" %>

	<div id="content">
		<h2>프로젝트 센터 > 프로젝트 상세정보</h2>
		<div id="topMenu">
			<hr>
			<table>
				<tr class="tbTop">
                        <td><a href="/pms/center/project/projectlist.do">프로젝트 목록</a></td>
                        <td><a href="/pms/center/project/projectdetail.do?projectSeq=${dto.projectSeq}">상세정보</a></td>
                        <td><a href="/pms/center/wbs/view.do?pjseq=${dto.projectSeq}">WBS</a></td>
                        <td><a href="/pms/center/issue/cissuelist.do?pjseq=${dto.projectSeq}">이슈</a></td>
                  <td><a href="/pms/center/product/cproductlist.do?pjseq=${dto.projectSeq}">산출물</a></td>
                  <td><a href="/pms/center/version/versionlist.do?pjseq=${dto.projectSeq}">버전</a></td>
                    </tr>
				<tr>
					<td colspan="6"
						style="text-align: right; background-color: transparent; border: none;">
						<select>
							<option selected="selected">웹개발 프로젝트</option>
					</select>
					</td>
				</tr>
			</table>

			<h2 class="subtitle">프로젝트 상세정보</h2>
			<table class="listtbl" id="tbllist" style="width:90%;">
				<tr class="trMenu">
					<th class="short">프로젝트 명:</th>
					<td class="tdShort">${dto.name}</td>
					<th class="short right">프로젝트 유형:</th>
					<td class="tdShort">${dto.projectType}</td>
				</tr>

				<tr class="trMenu">
					<th class="short right">시작일:</th>
					<td class="tdShort right">${dto.startDate}</td>
					<th class="short right">종료일:</th>
					<td class="tdShort right">${dto.endDate}</td>
				</tr>

				<tr class="trMenu">
					<th class="short">PM:</th>
					<td class="tdShort right">
						<c:forEach items="${employeeList}" var="detail">
							<c:if test="${detail.employeeLv == 2}">
								${detail.employeeName}
							</c:if>
						</c:forEach>
					</td>
					<th class="short">PA:</th>
					<td class="tdShort right">
						<c:forEach items="${employeeList}" var="detail" varStatus="loop">
							<c:if test="${detail.employeeLv == 1}">
								${detail.employeeName}
								<c:if test="${not loop.last}">, </c:if>
							</c:if>
						</c:forEach>
					</td>
				</tr>
				<tr class="trMenu">
					<th class="short right">R&D 개발:</th>
					<td class="tdShort right">${dto.rndType}</td>
					<th class="short">초기예산:</th>
					<td class="tdShort">${dto.budget}</td>
				</tr>
				<tr class="trMenu">
					<th class="short thContent">프로젝트 내용:</th>
					<td colspan="3" class="tdShort">${dto.content}</td>
				</tr>
			</table>
		</div>

		<h2 class="subtitle">비용정보</h2>
		<table class="listtbl" id="cost">
			<thead>
				<tr class="trMenu">
					<th class="short right">프로젝트 명</th>
					<th class="short right">지출항목</th>
					<th class="short right">지출비용</th>
					<th class="short right">지출일자</th>
					<th class="short right">등록일</th>
					<th class="short right">
						<input type="button" name="btnRowAdd" id="btnRowAdd" class="btn btnAdd" value="+"
							onclick="rowAdd();"> 
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${costList}" var="cdto" varStatus="colStatus">
					<tr>
						<td class="tdShort">
							${cdto.projectName}
						</td>
						<td class="tdShort">${cdto.items}</td>
						<td class="tdShort">${cdto.money}</td>
						<td class="tdShort right">${cdto.costDate}</td>
						<td class="tdShort right">${cdto.signDate}</td>
						<td class="tdShort">
							<input type="button" name="btnRowDel" id="btnRowDel" class="btnred delBtn" value="-">
							<input type="button" name="btnCostAdd" id="btnCostAdd" class="btn btnAdd editBtn" value="수정" >
							<input type="hidden" value="${cdto.costSeq}" id="cseq">	
						</td>
					</tr>
					<c:if test="${colStatus.count % 1 == 0}">
						<tr></tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
		
		<div style="text-align: center;">
			<input type="button" name="btnAdd" id="btnAdd" class="btn btnAdd" value="수정"
				onclick="location.href='/pms/center/project/projectedit.do?projectSeq=${dto.projectSeq}';">
			<input type="button" name="btnBack" id="btnBack" class="btnred" value="목록보기"
				onclick="location.href='/pms/center/project/projectlist.do';">
		</div>
	
	</div>
</div>
					<script
						src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
					

					<script>

					
					
					
					let name = $('#tbllist > tbody > tr').children().eq(1).html();
									var manageMenu = document
											.querySelector('.manage');
									var manageDetailMenu = document
											.querySelector('.manageDetail');

									manageMenu
											.addEventListener(
													'click',
													function() {
														manageDetailMenu.style.display = manageDetailMenu.style.display === 'none' ? 'block'
																: 'none';
													});
					

									/* 행추가 해주는 함수 */
									function rowAdd() {

										var innerHtml = "";
										innerHtml = '<tr class="addCost">'
												+ '<td class="tdShort insertData">' + name + '</td>'
												+ '<td class="tdShort insertData"><input type="text" name="txtname" class="txt1" value=""></td>'
												+ '<td class="tdShort insertData"><input type="text" name="txtname" class="txt1" value=""></td>'
												+ '<td class="tdShort insertData"><input type="date" name="txtname" class="txt1" value=""></td>'
												+ '<td class="tdShort insertData"><input type="date" name="txtname" class="txt1" value=""></td>'
												+ '<td class="tdShort insertData">'
												+ '<input type="button" name="btn2" id="btn_rowDel" class="btnred delBtn" value="-">'
												+ '<input type="button" name="btn1" id="btnCostAdd" class="btn insertBtn" value="등록">'
												+ '</td>' + '</tr>';
										$('#cost > tbody:last').append(innerHtml);
									}

									
								

									
									
									/* const input = document.querySelector('#budget');
									input.addEventListener(
													'keyup',
													function(e) {
														let value = e.target.value;
														value = Number(value
																.replaceAll(
																		',', ''));
														if (isNaN(value)) { //NaN인지 판별
															input.value = '';
														} else { //NaN이 아닌 경우
															const formatValue = value
																	.toLocaleString('ko-KR');
															input.value = formatValue;
														}
													}) */
									
													
													
									$(document).on('click', '.editBtn', function(){
										let trIndex = $(this).closest('td').closest('tr').index();
										let tr = $('#cost > tbody').children().eq(trIndex);

										
										let seq = ${dto.projectSeq};
										let item = tr.children().eq(1).html();
										let money = tr.children().eq(2).html();
										let costDate = tr.children().eq(3).html();
										let signDate = tr.children().eq(4).html();
										let costSeq = tr.children().eq(4).children().eq(2).val();
										
								
										tr.html('<td class="tdShort insertData">' + name + '</td>'
												+ '<td class="tdShort insertData"><input type="text" name="txtname" class="txt1" value="'
												+ item +
												'"></td>'
												+ '<td class="tdShort insertData"><input type="text" name="txtname" class="txt1" value="'
												+ money +
												'"></td>'
												+ '<td class="tdShort insertData"><input type="date" name="txtname" class="txt1" value="'
												+ costDate +
												'"></td>'
												+ '<td class="tdShort insertData"><input type="date" name="txtname" class="txt1" value="'
												+ signDate +
												'"></td>'
												+ '<td class="tdShort insertData">'
												+ '<input type="button" name="btn2" id="btn_rowDel" class="btnred okBtn" value="확인">'
												+ '<input type="button" name="btn1" id="btnCostAdd" class="btn cancelBtn" value="취소">'
												+ '<input type="hidden" value="' + costSeq + '"id="cseq">'
												+ '</td>');
										
										$(document).on('click', '.cancelBtn', function(){
											let trIndex = $(this).closest('td').closest('tr').index();
											let tr = $('#cost > tbody').children().eq(trIndex);

											let seq = ${dto.projectSeq};
											let item = tr.children().eq(1).children().eq(0).val();
											let money = tr.children().eq(2).children().eq(0).val();
											let costDate = tr.children().eq(3).children().eq(0).val();
											let signDate = tr.children().eq(4).children().eq(0).val();
											let costSeq = tr.children().eq(4).children().eq(2).val();
											
											
											tr.html('<td class="tdShort insertData">' + name + '</td>'
													+ '<td class="tdShort insertData">'+ item +'</td>'
													+ '<td class="tdShort insertData">'+ money +'</td>'
													+ '<td class="tdShort insertData">'+ costDate +'</td>'
													+ '<td class="tdShort insertData">'+ signDate +'</td>'
													+ '<td class="tdShort insertData">'
													+ '<input type="button" name="btn2" id="btn_rowDel" class="btnred delBtn" value="-">'
													+ '<input type="button" name="btn1" id="btnCostAdd" class="btn editBtn" value="수정">'
													+ '<input type="hidden" value="' + costSeq + '"id="cseq">'
													+ '</td>');
											
										});
										
										$(document).on('click', '.okBtn', function(){
										
											
											
											let seq = ${dto.projectSeq};
											let item = tr.children().eq(1).children().eq(0).val();
											let money = tr.children().eq(2).children().eq(0).val();
											let costDate = tr.children().eq(3).children().eq(0).val();
											let signDate = tr.children().eq(4).children().eq(0).val();
											let costSeq = tr.children().eq(4).children().eq(2).val();
									
											
										
											
										$.ajax({
											
											url: '/pms/center/project/projectcostedit.do',
											type: 'POST',
											data: {
												
								
												item: item,
												money: money,
												costDate: costDate,
												signDate: signDate,
												seq: seq,
												costSeq: costSeq
												
											},
											
											success: function(result){
												
											
											
												tr.children().eq(1).html(item),
												tr.children().eq(2).html(money),
												tr.children().eq(3).html(costDate),
												tr.children().eq(4).html(signDate),
												tr.children().eq(5).html('<input type="button" name="btnRowDel" id="btnRowDel" class="btnred delBtn" value="-">' +
														'<input type="button" name="btnCostAdd" id="btnCostAdd" class="btn editBtn" value="수정">'
														+'<input type="hidden" value="' + costSeq + '"id="cseq">')
												
												
											}
											
											
											
											
												});  
											});
										
										});
										
									
									
										
									$(document).on('click', '.delBtn', function(){
										
										let cseq = $(this).parent().children().eq(2).val();
										$(this).parent().parent().remove();
										
										
										
										$.ajax({
											url: '/pms/center/project/projectcostdel.do',
											type: 'POST',
											data:{
											
												cseq: cseq
												
											}
										});
									});
									
									$(document).on('click', '.insertBtn', function(){
										let trIndex = $(this).closest('td').closest('tr').index();
										let tr = $('#cost > tbody').children().eq(trIndex);
										
										
										
										let seq = ${dto.projectSeq};
										let item = tr.children().eq(1).children().eq(0).val();
										let money = tr.children().eq(2).children().eq(0).val();
										let costDate = tr.children().eq(3).children().eq(0).val();
										let signDate = tr.children().eq(4).children().eq(0).val();
										
								
										
										
									
										$.ajax({
											
											url: '/pms/center/project/projectdetail.do',
											type: 'POST',
											data: {
												
											
												item: item,
												money: money,
												costDate: costDate,
												signDate: signDate,
												seq: seq
												
												
											},
											success: function(result){
											
												tr.find('.insertData').eq(1).html(item),
												tr.find('.insertData').eq(2).html(money),
												tr.find('.insertData').eq(3).html(costDate),
												tr.find('.insertData').eq(4).html(signDate)
												tr.find('.insertData').eq(5).html('<input type="button" name="btnRowDel" id="btnRowDel" class="btnred delBtn" value="-">' +
														'<input type="button" name="btnCostAdd" id="btnCostAdd" class="btn editBtn" value="수정">'
														+'<input type="hidden" value="' + result + '"id="cseq">')
												
				
											},
											
											error: (a,b,c) => console.log(a,b,c)
											
											
										});  
										
										});  
										
								
													
								
													
								</script>
</body>
</html>
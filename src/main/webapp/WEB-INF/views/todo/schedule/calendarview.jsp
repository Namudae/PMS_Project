<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>일정보기</title>
	<!-- <link rel="stylesheet" href="https://me2.do/5BvBFJ57"> -->
<link rel="stylesheet" href="/pms/css/common.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

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
    .content {
		padding: 4px;
	}
	
	.content > div{
		margin-bottom: 4px;
	}
	
    #calendar{
        width: 1100px;
        margin-left: 50px;
    }

    #calendar > div > div{
        display: flex; 
        justify-content: space-between;
    }
	
	h3{
		margin-bottom: 0px;
		margin-top: 32px;
	}
    #month{
    	width: 1100px;
        border-collapse: collapse;
        border: 1px solid #A7ABB7;
    }
    
    #month th{
        border: 1px solid #A7ABB7;
        width: 130px;
        height: 40px;    
    }
    
    #month td{
        border: 1px solid #A7ABB7;
        width: 130px;
        height: 130px;
    }

    #month td .line{
        text-align: right;
        height:30px;
        border-bottom: 1px dashed #BBB;
        display:flex;
        justify-content: space-between;
    }
    
    #month > tbody > tr > td > div:nth-child(2){
        height:100px;
    }

    #month > tbody > tr > div > div:nth-child(1) > div:nth-child(1){
        text-align: left;
        
    }

    #month > tbody > tr > td > div:nth-child(1) > div:nth-child(2){
        text-align: right;
        margin-right: 5px;
        clear:left;
        cursor: pointer;
    }
    
     .team {
        font-size: 1.2rem;
    }

    .team > div{
        display:inline-block;
        margin-right: 25px;
    }
    .team > input[type=checkbox]{
        width: 17px;
        height:17px;
    }
    
    .my{
    	cursor:pointer;
    }
    
    .my:hover{
    	color: red;
    }
    
    .line > div:nth-child(2):hover {
		color: red;
	}
	
	.day{
		overflow-y: auto;
	}
	
	.my{
		background-color: #34A853;
		border-radius: 10%;
	}
	
	
	.holiday{
		color: red;
	}
	
	tr > td:nth-child(1) {
		color: red;
	}
	
	td:nth-child(7){
		color: cornflowerblue;
	}
	
	tr > td:nth-child(7) .holiyday{
		color: red;
	}
	
	tr > td:nth-child(7) .content{
		color: black;
	}
	
	
	
	.team > div{
		float:left;
	}
	
	#JHbtn > input[type="button"]:nth-child(3) {
		margin-right: 0px;
}
	

</style>
<body>
<div id="container">
	<%@ include file="/WEB-INF/views/inc/sidebar.jsp" %>
	
        <div id="content">
        	<p>&nbsp일정 관리</p>
            <hr>
            
    <div id="calendar">

        <div>
            <div>
                <h3></h3>
                <div style="margin-top: 20px;" id="JHbtn">
                    <input type="button" value="&lt" style="cursor: pointer;" class="btn">
                    <input type="button" value="이번달" style="cursor: pointer;" class="btn">
                    <input type="button" value="&gt" style="cursor: pointer;" class="btn">
                </div>
            </div>
        </div>
        <div style="clear:left;"></div>

        <Table id="month">
            <thead>
                <tr>
                    <th style="background-color: #DEE7EC;">일</th>
                    <th style="background-color: #DEE7EC;">월</th>
                    <th style="background-color: #DEE7EC;">화</th>
                    <th style="background-color: #DEE7EC;">수</th>
                    <th style="background-color: #DEE7EC;">목</th>
                    <th style="background-color: #DEE7EC;">금</th>
                    <th style="background-color: #DEE7EC;">토</th>
                </tr>
            </thead>
            <tbody>
              		<!-- 스크립트 레스기릿 -->
              		
            </tbody>
        </Table>
			<div class="team" style="margin-top: 10px; display:inline-block;">
				<!-- 스크립트 레스기릿 -->
			</div>
			<div style="clear:left;"></div>
    </div>

	</div>
	</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
    // alert($('#month > tbody').children().eq(0).html());
	
    let now = new Date();
    year = now.getFullYear();
    month = now.getMonth();
    
    let monthView = now.getFullYear() + "년 " + (now.getMonth() + 1) + "월";
    let a = $('h3').html(monthView).html();
    
    let colors = ['tomato', 'cornflowerblue', 'gold', 'yellowgreen'];
    let seqArr = [];
    
    //팀 checkBox만들기
    function teamCheckBox(){
        $.ajax({
        	type: 'POST',
        	url: '/pms/todo/schedule/teamcalendar.do',
        	success: result =>{
        		$(result).each((index, item)=>{
        			$('.team').append(`<div class="\${item.employeeseq}"><input type="checkbox" value="\${item.employeeseq}">\${item.name}</div>`);
        			
                    $('.' + item.employeeseq).css({
                        'background-color' : colors[index],
                        'border-radius' : '10%'
                    });
                    
                    seqArr.push(item.employeeseq);
        		});
        		
        	},
        	error: (a,b,c)=>console.log(a,b,c)
			        	
        });
    }
    teamCheckBox();
    
    $(document).on("click", ".team input", function(){
        if($(this).is(':checked')){
            teamCalendar(year, month, $(this).val());
        }else{
            teamCalendarRemove($(this).val());
        }
    });
    
    function teamCalendarRemove(employeeseq){
        $('#month > tbody tr').find('.day').each(function(index, item){
            $(this).find('.content').eq(0).find('.' + employeeseq).each(function(index, item){
                $(this).remove();
            });
        });
    }

    function teamCalendar(year, month, employeeseq){
    	$.ajax({
    		type: 'POST',
    		url: '/pms/todo/schedule/teamcalendarajax.do',
    		dataType:'json',
    		data:{
                year: year,
                month: month,
    			employeeseq: employeeseq
    		},
    		success: (result) =>{
    			
    			$(result).each((index, item)=>{
                    let contentDay = item.startdate.substring(8);
                    let content = $('#month > tbody tr').find('.day').eq(isValidDay(contentDay) - 1).find('.content').eq(0).html();
                    //alert(item.content);
                    
                    //날짜 td
                    let dd = $('#month > tbody tr').find('.day').children().eq(0).children().eq(1).html();
                    $('#month > tbody tr').find('.day').eq(isValidDay(contentDay) - 1).find('.content').eq(0).html(content + '<div class="' + employeeseq + '">' + item.content + '</div>');
            		
            	});
    			
    			for(let i = 0; i < seqArr.length; i++){
    				$('.'+ seqArr[i]).css({
    					'background-color': colors[i],
    					'border-radius': '10%'
    				})
    			}
    			
    		},
    		error: (a,b,c)=>console.log(a,b,c)
    	});
    }
    //달력생성
    function createCalendar(year, month){

        let lastDay = new Date(year, month + 1, 0).getDate();
        let firstDay = new Date(year, month, 1).getDay();
        let createDay = '';
        
        createDay += '<tr>'; 
        
        let week = 0;

        for(let i = 0; i < firstDay; i++){
            createDay += '<td></td>';
            week++;
            if(week % 7 == 0){
	            createDay += '</tr>';
	            createDay += '<tr>';
            }
        }
        
        
        for(let i = 1; i <= lastDay; i++){
            //  <td><div>${i}</div><div></div></td>`
            // 동적으로 생성된 td들만 클래스 부여
            createDay += `<td class="day"><div class="line"><div class="holiday"></div><div>\${i}</div></div><div class="content"></div></td>`;
            week++;
            if(week % 7 == 0){
                createDay += '</tr>';
                createDay += '<tr>';
            }
        }
        let lastTd = new Date(year, month, lastDay).getDay();
        //만약에 td를 다 안채우고 끝나면 더 채우라고 ㅇㅇ
        if(lastTd < 6){
            for(let i = lastTd; i < 6; i++){
                createDay += '<td></td>';
            }
        }

        createDay += '</tr>';
        $('#month > tbody').html(createDay);
        
        
        //본인캘린더 가져오기 + 팀 체크박스 만들기
        calendarLog(year, month);
        holiday(year, month);
        insert(year, month);
    }
    
    //본인 캘린더 가져오는 ajax
    function calendarLog(year, month){
	    $.ajax({
	    	url: '/pms/todo/schedule/calendarajax.do',
            type: 'POST',
            data:{
            	year: year,
            	month: month
            },
            dataType:'json',
            success: (result)=>{
                let content;
            	$(result).each((index, item)=>{
                    let contentDay = item.startdate.substring(8);
                    //alert(item.content);
                    
                    //날짜 td
                    let dd = $('#month > tbody tr').find('.day').children().eq(0).children().eq(1).html();
                    $('#month > tbody tr').find('.day').eq(isValidDay(contentDay) - 1).find('.content').eq(0).append(`<div class="my">\${item.content}<input type="hidden" value="\${item.calendarseq}"></div>`);
            		
            	});
           	},
            error: (a,b,c) => console.log(a,b,c)
	    });
    }
    
    function isValidDay(day){
    	if(day == '01'){
    		return 1;
    	}else if(day == '02'){
    		return 2;
    	}else if(day == '03'){
    		return 3;
    	}else if(day == '04'){
    		return 4
    	}else if(day == '05'){
    		return 5 
    	}else if(day == '06'){
    		return 6
    	}else if(day == '07'){
    		return 7
    	}else if(day == '08'){
    		return 8
    	}else if(day == '09'){
    		return 9
    	}else{
    		return day;
    	}
    }
    
    createCalendar(year, month);

    function holiday(year, month){
    	$.ajax({
    		url: '/pms/todo/schedule/holidayajax.do',
            type: 'POST',
            data:{
                year: year,
                month: month
            },
            success: (result)=>{
            	
                $(result).each((index, item)=>{
                	//alert(item.name);
                	let day = item.holidaydate.substring(8, 10);
                    $('.day').eq(isValidDay(day) - 1).find('.line').eq(0).children().eq(0).html(item.name);

                });
            },
            error: (a,b,c) => console.log(a,b,c)
    	});
    }
    
    //저번달
    $('#JHbtn').children().eq(0).click(function(){
        now.setMonth(now.getMonth() - 1);
        year = now.getFullYear();
        month = now.getMonth();
        $('h3').html(now.getFullYear() + "년 " + (now.getMonth() + 1) + "월");
        unChecked();
        createCalendar(year, month);
    });

    //다음달
    $('#JHbtn').children().eq(2).click(function(){
        now.setMonth(now.getMonth() + 1);
        year = now.getFullYear();
        month = now.getMonth();
        $('h3').html(now.getFullYear() + "년 " + (now.getMonth() + 1) + "월");
        unChecked();
        createCalendar(year, month);
    });
    
    //이번달
    $('#JHbtn').children().eq(1).click(function(){
        let now2 = new Date();
        now.setFullYear(now2.getFullYear());
        now.setMonth(now2.getMonth());
        
        year = now.getFullYear();
        month = now.getMonth();
        $('h3').html(now.getFullYear() + "년 " + (now.getMonth() + 1) + "월");
        unChecked();
        createCalendar(year, month);
    });
	
    //다음달, 전달, 이번달 누를때마다 팀원들 체크박스 해제해줌
    function unChecked(){
    	$('.team input').each(function(item,index){
            
    		$(this).prop('checked', false);
        });
    }

    //일정 추가
    function insert(year, month){
	    $('.line').children().each(function(index, item){
	        $(this).click(function(){
	            let input = prompt('일정을 입력해주세요');
	            let day = $(this).html();
	            if(input != null && input != ''){
	                $.ajax({
	                    type: 'POST',
	                    url: '/pms/todo/schedule/calendaradd.do',
	                    data:{
	                        input: input,
	                        year: year,
	                        month: month,
	                        day: day
	                    },
	                    success: function(result){
	                        $('.day').eq(day - 1).find('.content').eq(0).append('<div class="my">' + result.content + '<input type="hidden" value="' + result.calendarseq + '">'  + '</div>');
	                    },
	                    error: (a,b,c)=>console.log(a,b,c)
	                });
	            }
	        });
	    });
    }
    //일정 수정 or 삭제
    $(document).on("click", ".my", function(){
    	let input = prompt('삭제하려면 [삭제]를 입력하시고, 수정하려면 수정할 글을 입력해주세요.');
		let seq = $(this).children().eq(0).val();
		
        if(input != '삭제' && input != '' && input != null){
            $(this).html(input + '<input type="hidden" value="' + seq + '">');
            $.ajax({
                url: '/pms/todo/schedule/calendaredit.do',
                type: 'POST',
                data:{
                    input: input,
                    seq: seq
                },
                error: (a,b,c)=>console.log(a,b,c)
            });
        }else if(input == '삭제'){
            let target = $(this);
            $.ajax({
                url: '/pms/todo/schedule/calendardel.do',
                type: 'POST',
                data:{
                    seq: seq
                },
                success: function(result){
                	target.remove();
                },
                error: (a,b,c)=>console.log(a,b,c)
            });
        }

    });
    
    
</script>
</body>    
</html>
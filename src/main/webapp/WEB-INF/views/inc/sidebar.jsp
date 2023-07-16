<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header style="height: 100%; background-color: #F2F4F7;">-
      <div id="sidebar">
            
            <p style="font-size: 23px; font-weight: bold; text-align: center;">J<span style="color: #9DB2BF;">D</span>S<span style="color: #9DB2BF;">C</span> Company</p>
           
           <!-- 이미지넣을꺼면 여기에 --> 
            
            <br>
            <%-- <div id="info">${name}(${position}) / ${teamname}</div> --%>
            <div id="info">최재현(부장) / 개발 2팀</div>
           
            <ul class="sideMenu">
                <li><a href="/pms/main.do"><span class="material-symbols-outlined">dashboard</span> 메인 대시보드</a></li>
                <li><a href="/pms/center/project/projectlist.do"><span class="material-symbols-outlined">hub</span> 프로젝트 센터</a></li>
                <li class="manage"><a href="#"><span class="material-symbols-outlined">stress_management</span> 작업 관리</a>
                    <ul class="manageDetail">
                        <li class="smwork"><a href="/pms/todo/my/todolist.do"><span class="material-symbols-outlined">group</span> 내 작업</a></li>
                        <li class="smwork"><a href="/pms/todo/team/progresslist.do"><span class="material-symbols-outlined">diversity_3</span> 일반 작업</a></li>
                        <li class="smwork"><a href="/pms/todo/schedule/calendarview.do"><span class="material-symbols-outlined">calendar_month</span> 일정 관리</a></li>
                    </ul>
                </li>
                <li><a href="/pms/sign/signlist.do"><span class="material-symbols-outlined">draw</span> 결재 안건 관리</a></li>
            <li><a href="/pms/issue/issuelist.do"><span class="material-symbols-outlined">check_circle</span> 이슈 관리</a></li>
                <li><a href="/pms/notice/noticelist.do"><span class="material-symbols-outlined">sticky_note_2</span> 공지 사항</a></li>
                <li><a href="/pms/employee/register.do"><span class="material-symbols-outlined">app_registration</span> 사원 등록</a></li>
                <li><a href="/pms/employee/mypage.do"><span class="material-symbols-outlined">assignment_ind</span> 마이페이지</a></li>
            </ul>
             <button type="button" class="btn btn-light btn-sm" onclick="location.href='/pms/employee/login.do';">로그아웃</button>
            <br>
        </div>   
</header>
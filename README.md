# 프로젝트 관리 시스템 JDSC📋 <br>

<img src="https://github.com/Namudae/PMS_Project/assets/110042683/1598c4b7-36ef-4c8c-a92a-641f4abcb3af" width="50%">
<br><br>

## 📌프로그램 소개
<p>JDSC는 JSP/Servlet 기반의 프로젝트 관리 시스템, PMS(Project Management System) 플랫폼입니다.</p>
<p>공유 일정 관리, 결재 안건 관리, 비용 처리, WBS 차트를 통한 업무 관리 등 보다 편한 프로젝트 관리를 위한 다양한 기능을 제공합니다.</p>
<br>

## 🗓 개발 기간
- 2023.05.26 ~ 2023.06.09
<br>

## 🔧 개발 환경
### ✔ 사용 언어
- JAVA (JDK 11), SQL, HTML, CSS, JavaScript(jQuery), JSP
### ✔ 사용 기술
- JDBC, Ajax, Servlets, Bootstrap
### ✔ DB
- Oracle 11g Enterprise
### ✔ IDE
- Eclipse 2021-03, SQL Developer,
### ✔ Server
- Apache Tomcat – 8.5
<br>

## 📁 ERD

<img src="https://github.com/Namudae/PMS_Project/assets/110042683/40510eb9-1ed0-44b6-b802-79d7f7c898f4" width="90%">
<br>

## 💻 주요 기능
#### 1. 메인
> 1-1. 로그인 시, 처음 나타나는 메인 화면
<p>➜ 로그인한 계정의 직급이 평사원인지 관리자 직급인지 쿼리를 날려 체크하고 결과에 맞게 세션을 발급합니다.</p>
<p>➜ 내작업, 이슈, 결재요청, 산출물, 프로젝트에 대한 업데이트 상황을 실시간으로 확인할 수 있습니다.</p>
<p>➜ 전체 프로젝트 현황을 간략하게 출력합니다.</p>
<p>➜ 내 작업의 진척도를 표와 차트를 통해 확인할 수 있습니다.</p>

<img src="https://github.com/Namudae/PMS_Project/assets/110042683/1598c4b7-36ef-4c8c-a92a-641f4abcb3af" width="90%">
<br><br>

#### 2. 프로젝트 센터
> 2-1. 프로젝트 센터에서 프로젝트를 선택하면 나오는 화면
<p>➜ 프로젝트 상세정보를 확인 및 수정할 수 있습니다.</p>
<p>➜ 프로젝트 비용 정보에 대해 작성, 조회, 수정, 삭제가 가능합니다.</p>

<img src="https://github.com/Namudae/PMS_Project/assets/110042683/6ad73f97-e369-4ab2-9be9-cc085b4941ae" width="90%">
<br><br>

> 2-2. WBS
<p>➜ 선택한 프로젝트에 대한 wbs차트가 출력됩니다.</p>

<img src="https://github.com/Namudae/PMS_Project/assets/110042683/660d2224-b5c8-4114-a987-707ae66f0344" width="90%">
<br><br>

> 2-3 버전
<p>➜ PM은 완성된 프로젝트의 버전 업데이트를 할 수 있습니다.</p>
<p>➜ 버전 게시글에 대한 작성, 조회, 수정, 삭제가 가능하며, 파일 다운로드가 가능합니다.</p>

<img src="https://github.com/Namudae/PMS_Project/assets/110042683/97df6702-8fdf-4435-917e-19960a6e36aa" width="90%">
<br><br>

#### 3. 작업관리
> 3-1. 내 작업(작업목록)
<p>➜ 나의 작업 목록이 출력되며, select 박스로 프로젝트 별 작업 목록을 출력할 수 있습니다. 완료율에 대한 수정이 가능하며 이 완료율은 메인차트에 실시간으로 반영됩니다.</p>
<p>➜ 산출물에 대한 작성, 조회, 수정, 삭제가 가능합니다.</p>

<img src="https://github.com/Namudae/PMS_Project/assets/110042683/0c7df7f4-50aa-429f-8566-40a54ce40813" width="90%">
<br><br>

> 3-2. 일반 작업(프로젝트 진척도)
<p>➜ 인원별 프로젝트 진척도를 Pie 차트와 표를 통해 확인할 수 있습니다.</p>

<img src="https://github.com/Namudae/PMS_Project/assets/110042683/f9231ae7-5f7e-4274-bad2-2c51bf5ace1a" width="90%">
<br><br>

> 3-3. 일반 작업(프로젝트 작업 등록)
<p>➜ 프로젝트에 대한 작업 등록 및 삭제를 할 수 있습니다. 업무명과 사원이름, 시작날짜와 종료날짜를 입력합니다.</p>
> 3-4. 일반 작업(프로젝트 전체 산출물 조회)
<p>➜ 내 프로젝트에 대한 전체 산출물을 조회하고 파일을 다운로드 할 수 있습니다.</p>

<img src="https://github.com/Namudae/PMS_Project/assets/110042683/41d36ba0-e96c-41a7-b25a-f6d0fd762e16" width="90%">
<br><br>

> 3-5. 일반 작업(일정 관리)
<p>➜ 캘린더에 나의 일정을 작성, 조회, 수정, 삭제할 수 있으며, 팀원들과 일정을 공유할 수 있습니다.</p>

<img src="https://github.com/Namudae/PMS_Project/assets/110042683/60d8cdbc-5843-438e-9d08-f80417e87326" width="90%">
<br><br>

#### 4. 결재 안건 관리
> 4-1. 결재 목록
<p>➜ PA는 결재 안건을 작성, 조회, 수정, 삭제할 수 있으며, 결재 사항에 대한 파일을 업로드 할 수 있습니다. PM은 승인 또는 거절을 할 수 있으며, 확인 날짜가 업데이트됩니다. 결재 대기중인 안건의 수만큼 메인 대시보드에 숫자로 출력됩니다.</p>

<img src="https://github.com/Namudae/PMS_Project/assets/110042683/351f2349-eae9-4024-9c42-0f32b60ddaaa" width="90%">
<br><br>

#### 그 외 기능
> 5. 이슈 관리<br> ➜ PA는 이슈에 대해 작성, 조회, 수정, 삭제할 수 있으며, PM은 조치 결재되지 않은 안건의 수만큼 메인 대시보드에 숫자로 출력됩니다.
> 6. 공지사항 <br> ➜ PM은 공지사항에 대해 작성, 조회, 수정, 삭제를 할 수 있습니다. <br>
> 7. 사원등록> <br> ➜ 계정을 생성하고 사원 정보를 등록할 수 있습니다. <br>
> 8. 마이페이지 <br> ➜ 나의 정보를 조회, 수정할 수 있습니다.




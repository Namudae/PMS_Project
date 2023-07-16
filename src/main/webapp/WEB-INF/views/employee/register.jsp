<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="css/example.css"> -->
    <!-- 부트스트랩 -->
    <!-- <link rel="stylesheet" href="css/bootstrap.css">  -->
    <!-- 아이콘 설치 -->
    <!-- <link rel="stylesheet" href="../node_modules/bootstrap-icons/font/bootstrap-icons.css"> -->
    <!-- 동현 버튼 -->
     <link rel="stylesheet" href="/pms/asset/css/common.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    
<%-- <%@ include file="/WEB-INF/views/inc/asset.jsp"%> --%>
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
  <div id="container">
        <%@ include file="/WEB-INF/views/inc/sidebar.jsp" %>

        <div id="content">
           <p>&nbsp;사원 등록</p>
            <hr>
          

            <!-- <h2 class="subtitle">회원 정보 등록</h2> -->
    
        
        <form method="POST" name="form1" action="/pms/employee/register.do">
            <table id="tbllist" class="listtbl">
                <thead>
                    <tr>
                        <th colspan="5" class="thAdd">사원계정등록
                        </th>
                    </tr>
                </thead>
                
                <tr class="trMenu">
                    <th class="short">이름 </th>
                    <td class="tdShort"><input type="text" name="name" class="txt1"></td>
                </tr>
                 <tr class="trMenu">
                    <th class="short">생년월일 </th>
                    <td class="tdShort"><input type="date" name="birth" class="txt1"></td>
                </tr>
                <tr class="trMenu">
                    <th class="short">연락처 </th>
                    <td class="tdShort"><input type="text" name="tel" class="txt1"></td>
                </tr>
                <tr class="trMenu">
                    <th class="short">입사일 </th>
                    <td class="tdShort"><input type="date" name="joindate" class="txt1"></td>
                </tr>
                <tr class="trMenu">
                    <th class="short">직급 </th>
                    <td class="tdShort"><input type="text" name="position" class="txt1"></td>
                </tr>
                <tr class="trMenu">
                    <th class="short">직책 </th>
                    <td class="tdShort"><input type="text" name="lv" class="txt1"></td>
                </tr>
                <tr class="trMenu">
                    <th class="short">이메일 </th>
                    <td class="tdShort"><input type="email" name="email" class="txt1"></td>
                </tr>
                <tr class="trMenu">
                    <th class="short">주소 </th>
                    <td class="tdShort"><input type="text" name="address" class="txt1"></td>
                </tr>
                <tr class="trMenu">
                    <th class="short">팀 선택 </th>
                    <td class="tdShort">
                        <select name="team">
                           <c:forEach items="${teamlist}" var="dto">
                            <option value="${dto.teamseq}">${dto.team}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr class="trMenu">
                    <th class="short">아이디 </th>
                    <td class="tdShort">
                        <input type="text" name="id" class="txt1" id="txtid" onkeydown="inputIdChk()">
                     
                        <input type="button" name="dbCheckId" class="btn btnAdd" value="중복확인" id="id">
                           
                                         
                        
                    </td>
                </tr>
                <tr class="trMenu">
                    <th class="short">비밀번호 </th>
                    <td class="tdShort"><input type="password" placeholder="비밀번호 입력" name="newPw" class="txt1"></td>
                </tr>
                <tr class="trMenu">
                    <th class="short">비밀번호 확인 </th>
                    <td class="tdShort"><input type="password" placeholder="비밀번호 확인" name="newPw2" class="txt1"></td>
                </tr>

            </table>
            
            <div style="text-align: center;">
                <input type="submit" name="btn1" id="btn1" class="btn btnAdd" value="시원신규등록" onclick="location.href='/pms/main.do';">
             </div>
        </form>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

   var manageMenu = document.querySelector('.manage');
   var manageDetailMenu = document.querySelector('.manageDetail');
   
   manageMenu.addEventListener('click', function () {
       manageDetailMenu.style.display = manageDetailMenu.style.display === 'none' ? 'block' : 'none';
   });

   $(document).on('click', '#id', function(){
      
      let id = $('#txtid').val();
      
      $.ajax({
         url: '/pms/employee/checkid.do',
         type: 'POST',
         data:{
            id : id
         },
         dataType: 'json',
         success: (result) => {
               let temp = $('#txtid').parent().html();
               $('#txtid').parent().find('#ok').remove();
            if(result.result == '성공'){
               $('#txtid').parent().append('<div id="ok">사용 가능한 아이디 입니다.</div>');
               $('#txtid').val(id);
            } else{

               $('#txtid').parent().append('<div id="ok">사용중인 아이디 입니다.</div>');
               $('#txtid').val('');
            }
         }
      
      });
   });
    
   function checkUserId() {
      
       var regex = /^[A-Za-z_][A-Za-z0-9_]{3,12}$/;

          if (!regex.test(txtid.value)){
           alert('아이디를 올바르게 입력하세요');
           form.txtid.value = "";
           form.txtid.focus();
           return false;
          }
           
          return ture;
   }
   
   
    document.form1.btn1.onclick = m1;

    function m1(){
        var txtname = document.form1.name;
       /*  var txtid = document.form1.id; */
        var txtpw = document.form1.newPw;
        var txtpwc = document.form1.newPw2;

        //유효성 검사 > 잘못된 값을 찾기 !!

        // 이름
        //- 필수값
        //- 2~5자 이내
        //- 한글만

        if(txtname.value == ''){
            alert('이름을 입력하세요');
            txtname.focus();
            return; //진행 종료
        }

        if(txtname.value.length <2 || txtname.value.length>5){
            alert('이름을 2~5자 이내로 입력하세요');

            //셋중에 초기화 시키는거 골라서 사용하면 됨
            // txtname.focus();
            // txtname.value = '';
            // txtname.select();
            return;
            
           
        }

        for(var i=0; i<txtname.value.length; i++){
            var c = txtname.value.charAt(i);

            if (c < '가' || c > '힣'){
                alert('이름을 한글로 입력하세요')
                txtname.value = '';
                return;
            }
            
        }

     
        //아이디
        //1. 필수값
        //2. 4~12자 이내
        //3. 영어 + 숫자 + _
        //4. 숫자로 시작 불가

        //정규표현식
        //JavaScript > 정규표현식 사용
        
        //두개중 편한거 사용
        // var regex = new RegExp('정규 표현식');
       // var regex = /정규표현식/;

     /*   var regex = /^[A-Za-z_][A-Za-z0-9_]{3,12}$/;

       if (!regex.test(txtid.value)){
        alert('아이디를 올바르게 입력하세요');
        txtid.value = "";
        txtid.focus();
        return;
       }
        */
      
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
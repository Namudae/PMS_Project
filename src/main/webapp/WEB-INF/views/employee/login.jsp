<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>

   html {
      background-color: #27374D;
   }
    body{
        background-color: #27374D;
    }

    #container {
       margin: auto;
       width: 300px;
       background-color: #EEEFF1;
       border-radius: 5px;
       text-align: center;
       padding-top: 20px;
       padding-bottom: 70px;
       padding-left: 100px;
       padding-right: 100px;
       margin-top: 130px;
       padding-right: 100px;
       display: flex;
       flex-direction: column;
        }

        #form1{
            display: flex;
        }

        .login{
            margin-bottom: 10px;
            background-color: #CFD3D7 ;
            height: 40px;
            width:200px;
            border: 1px solid #CFD3D7;
        }

        #btn {
            height: 98px;
            background-color: #526D82;
            color: white;
            width: 300px;
            border: 1px solid #526D82 ;
        }
        #box {
            height: 100px;
            font-size: 0;
            margin-right: 10px;
        }

       .saveid{
        font-size: 16px;
       }

      
</style>
</head>
<body>
     <div><p style="font-size: 40px; font-weight: bold; text-align: center;"><span style="color:#CFD3D7">J</span><span style="color: tomato;">D</span><span style="color:#CFD3D7">S</span><span style="color: cornflowerblue;">C</span> <span style="color:#CFD3D7">Company</span></p></div> 
    <div id="container"> 
        <div id="top" style="margin-top:0;">
            <div id="logintop">
            <h1>
             로그인
             </h1>
            </div>
        <form method="POST" action="login.do" id="form1">
            <div id="box">
                <input type="text" name="id" placeholder="아이디" class="login">
                <input type="password" name="pw" placeholder="비밀번호" class="login">

                <div class="saveid">
                    <label for="chKeepLogin" id="keep">
                        <input type="checkbox" id="chKeepLogin">
                    아이디 저장
                    </label>
                </div>

            </div>
                <input type="submit" id="btn" value="로그인">
            </form>
        </div>
        </div>
    
    
    <script src="js/jquery-3.6.4.js"></script>
    <script>
    
        $('#btn').hover();
        

    </script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/png" sizes="32x32" href="views/7H_The_Town/resource/img/favicon-32x32.png">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/views/7H_The_Town/resource/CSS,JS/fonts/fonts.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/views/7H_The_Town/resource/CSS,JS/materialize/css/materialize.css">
    <script src="<%= request.getContextPath() %>/views/7H_The_Town/resource/CSS,JS/materialize/js/materialize.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/views/7H_The_Town/resource/CSS,JS/header.css">
    <script src="<%= request.getContextPath() %>/views/7H_The_Town/resource/CSS,JS/header.js"></script>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/views/7H_The_Town/resource/CSS,JS/footer.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/views/7H_The_Town/resource/CSS,JS/materialize/css/materializeBtn.css">
    <title>7H THE TOWN | 로그인</title>
    <style>
        .login-box {
            margin: 200px;
            display: flex;
            flex-direction: column;
            width: 500px;
            align-items: center;
            background-color: rgb(255, 255, 255);
        }

        .login-text{
            text-align: center; 
            margin-bottom:20px;
        }
        
        .login-text label {
        	font-size:0.9rem !important;
        }

        #개더타운-login-btn{
            background: rgb(240, 237, 237);
            width: 100%;
            border-radius: 5px;
            border-style: none;
            font-size: 11px;
            font-weight:500;
        }

        #Naver-login-btn{
            background: rgb(32, 202, 105);
            color: rgb(255, 255, 255);
            width: 100%;
            border-radius: 5px;
            border-style: none;
            font-size: 12px;
            font-weight:550;
        }

        #Kakao-login-btn {
            background: rgb(243, 230, 107);
            width: 100%;
            border-radius: 5px;
            border-style: none;
            font-size: 12px;
            font-weight:50;
        }
        

        .login-btns {
            display: flex;
            flex-direction: column;
            align-items: center;
            line-height: 2.6em;
            margin: 60px 50px 15px;
        }
        .login-btns div{
            width: 280px;
            height:50px;
        }

        .login-btns button{
            height: 45px;
            cursor: pointer;
        }

        .login-btns:hover {
            cursor: pointer;
        }

        .etc-btns {
            display: flex;
            flex-direction: column;
            align-items: center;
            font-weight: bold;
            color: rgb(33, 33, 33);
            margin: 30px 0 60px;
        }

        .etc:hover {
        	text-decoration:underline;
            cursor: pointer;
        }
        
    </style>
</head>
<body>

	<%@ include file="/views/common/Header.jsp" %>


    <div class="outer">
        <form action="<%=contextPath %>/login.me" method="POST">
            <div class="login-box  col s12 m2 z-depth-2">
                <img src="<%=contextPath %>/views/7H_The_Town/resource/img/7H_THE_TOWN_LOGO.png" alt="" width="200px" height="200px" style="margin: 50px 0px 0">
                <!-- <img src="/views/7H_The_Town/resource/img/7H_THE_TOWN_LOGO.png" alt="" width="200px" height="200px" style="margin: 50px 0px 20px 0px"> -->
                <div>
                    <div class="login-text">
                        <div class="input-field inline">
                            <input autocomplete="off" name="userId" id="mainAddress" type="text" style="width: 350px;">
                            <label for="mainAddress" style="font-weight: bold;">아이디</label>
                        </div>
                        <div class="input-field inline login">
                            <input autocomplete="off" name="userPwd" id="mainAddress" type="password" style="width: 350px;">
                            <label for="mainAddress" style="font-weight: bold;">비밀번호</label>
                        </div>
                    </div>

                    <div class="login-btns">
                        <div>
                            <button type="submit" id="개더타운-login-btn" class="loginBtn" style="font-size:13px;">7H THE TOWN 계정으로 로그인</button>
                        </div>
                        <div>
                            <button type="button" id="Naver-login-btn" class="loginBtn" style="font-size:13px;" onclick="notYet();">Naver 계정으로 로그인</button>
                        </div>
                        <div>
                            <button type="button" id="Kakao-login-btn" class="loginBtn" style="font-size:13px;" onclick="notYet();">Kakao 계정으로 로그인</button>
                        </div>
                    </div>
                    <div class="etc-btns">
                        <div>
                            <button type="button" class="etc" id="join" onclick="enrollForm();" style="border-style:none; font-size: 12px; background-color:rgb(255, 255, 255);">회원가입 > </button>
                            <button type="button" class="etc" id="idPw-search" style="border-style:none; font-size:12px; background-color:rgb(255, 255, 255); " onclick="notYet();">아이디 / 비밀번호 찾기 ></button>
                        </div>
                    </div>
                </div>
            </div>            
        </form>
    </div>
    
    <%@ include file="/views/7H_The_Town/Footer.jsp" %>


    <script>
        function loginForm_submit(form) {
            if (form.loginId.value.length == 0) {
                alert('로그인 아이디를 입력해주세요.');
                form.loginId.focus();

                return;
            }

            if (form.loginPwd.value.length == 0) {
                alert('비밀번호를 입력해주세요.');
                form.loginPwd.focus();

                return;
            }

            alert(loginId + '님 반갑습니다.');
        }
        
        function enrollForm() {
        	location.href="<%= contextPath %>/enrollForm.me";
        }
        
		function notYet(){
			alert("서비스 준비중입니다.");
		}
    </script>

</body>
</html>
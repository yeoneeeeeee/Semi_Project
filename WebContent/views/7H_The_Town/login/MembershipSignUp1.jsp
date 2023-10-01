<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>7H THE TOWN | 회원가입</title>
<link rel="icon" type="image/png" sizes="32x32" href="views/7H_The_Town/resource/img/favicon-32x32.png">
<link rel="stylesheet" href="../resource/CSS,JS/fonts/fonts.css">
<link rel="stylesheet"
	href="../resource/CSS,JS/materialize/css/materialize.css">
<script src="../resource/CSS,JS/materialize/js/materialize.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<link rel="stylesheet" href="../resource/CSS,JS/header.css">
<script src="../resource/CSS,JS/header.js"></script>
<link rel="stylesheet"
	href="../resource/CSS,JS/materialize/css/materializeBtn.css">
<link rel="stylesheet" href="../resource/CSS,JS/footer.css">
<style>
* {
	/* border: 1px solid red; */
	
}

.join-box {
	margin: 250px;
	width: 500px;
	display: flex;
	flex-direction: column;
	align-items: center;
	background-color: rgb(255, 255, 255);
}

.join-btns {
	font-size: 16px;
}

#개더타운-join-btn {
	margin: 0 10% 3% 6%;
	width: 90%;
	background: rgb(240, 237, 237);
	border-radius: 15px;
	border: 1px solid rgb(230, 230, 230);
	cursor: pointer;
}

#Naver-join-btn {
	margin: 0 10% 3% 6%;
	width: 90%;
	background: rgb(32, 202, 105);
	color: rgb(255, 255, 255);
	border-radius: 15px;
	border: 1px solid rgb(230, 230, 230);
	cursor: pointer;
}

#Kakao-join-btn {
	margin: 0 10% 9% 6%;
	width: 90%;
	background: rgb(243, 230, 107);
	border-radius: 15px;
	border: 1px solid rgb(230, 230, 230);
	cursor: pointer;
}

#join-btns:hover {
	cursor: pointer;
}

#join-text {
	text-align: center;
	margin: 10% 0 10% 0;
	font-size: 11px;
	font-weight: b;
	color: #7f8c8d;
}
</style>
</head>
<body>

	<%@ include file="/views/common/Header.jsp"%>

	<div class="outer">
		<div class="join-box">
			<img src="../resource/img/7H_THE_TOWN_LOGO.png" alt="" width="200px"
				height="200px" style="margin: 50px 0px 20px 0px"> <br />
			<div>
				<div class="join-btns">
					<div>
						<button type="button" id="개더타운-join-btn" style="height: 40px"
							onclick="enrollPage();">일반 회원가입</button>
					</div>
					<div>
						<button type="button" id="Naver-join-btn" style="height: 40px">
							Naver 계정으로 로그인</button>
					</div>
					<div>
						<button type="button" id="Kakao-join-btn" style="height: 40px">
							Kakao 계정으로 로그인</button>
					</div>
				</div>
				<div id="join-text">
					개 더 타운에 가입하면 서비스 약관에 동의하게 됩니다. <br /> 게더타운 개인정보 보호정책을 확인하세요.
				</div>

			</div>
		</div>
	</div>
	<script>
			function enrollPage() {
				location.href="<%= contextPath%>/enrollForm.me"; 
				
			}
	</script>

	<div class="footerArea">
		<ul class="footerUl">
			<li>이용약관</li>
			<li>|</li>
			<li>개인정보처리방침</li>
			<li>|</li>
			<li>법적고지</li>
			<li>|</li>
			<li>사업자정보확인</li>
		</ul>

		<p class="footerP">
			본사 : 서울특별시 강남구 테헤란로14길 6 남도빌딩 3F, 4F, 5F <br> 상호 : 개더타운 대표자 :
			파워레인저 사업자등록번호 123-456-789 <br> 개인정보보호책임자 : 이정택 <br> TEL :
			02)1234 - 5678 | FAX : 02-1111-2222 | 이메일 : ckdwjd2717@naver.com <br>
			대표전화 : 010 - 0000 - 0000
		</p>
	</div>

</body>
</html>

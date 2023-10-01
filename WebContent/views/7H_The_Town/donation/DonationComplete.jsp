<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>7H THE TOWN | 후원 완료</title>
<link rel="icon" type="image/png" sizes="32x32" href="views/7H_The_Town/resource/img/favicon-32x32.png">
<link rel="stylesheet"
	href="views/7H_The_Town/resource/CSS,JS/fonts/fonts.css">
<link rel="stylesheet"
	href="views/7H_The_Town/resource/CSS,JS/materialize/css/materialize.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<link rel="stylesheet"
	href="views/7H_The_Town/resource/CSS,JS/header.css">
<script src="views/7H_The_Town/resource/CSS,JS/header.js"></script>
<link rel="stylesheet"
	href="views/7H_The_Town/resource/CSS,JS/footer.css">
<link rel="stylesheet"
	href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeBtn.css">
<style>
* {
	/* border: 1px solid red; */
	
}

.join-comp-box {
	width: 500px;
	display: flex;
	flex-direction: column;
	align-items: center;
	background-color: rgb(255, 255, 255);
}

#join-comp-text {
	text-align: center;
	margin: 10% 0% 15% 0%;
}

#main-re-btn {
	width: 250px;
	margin-bottom: 20%;
	background-color: rgb(255, 255, 255);
	border-radius: 18px;
	border-color: black;
}

a {
	text-decoration: none;
	color: black;
}

.outer {
	margin: 300px;
}

.outer p {
	font-size: 18px;
	font-weight: bold;
	padding-top: 20px;
}
</style>
</head>
<body>

	<%@ include file="/views/common/Header.jsp"%>

	<div class="outer col s12 m2 z-depth-3">
		<div class="join-comp-box">
			<img src="views/7H_The_Town/resources/image/누끼.png" width="200px"
				alt="">
			<div id="join-comp-text">
				<p>
					결제 완료되었습니다. <br> 후원해주셔서 감사드립니다.
				</p>
			</div>
			<div>
				<img src="views/7H_The_Town/resource/img/7H_THE_TOWN_LOGO.png"
					width="200px" height="200px" alt="">
			</div>
			<div style="padding-bottom: 30px;">
				<button type="submit" id="main-re-btn" style="height: 45px">
					<a href="<%= contextPath%>/main">홈으로</a> </a>
				</button>
			</div>
		</div>
	</div>


	<%@ include file="/views/7H_The_Town/Footer.jsp" %>


</body>
</html>
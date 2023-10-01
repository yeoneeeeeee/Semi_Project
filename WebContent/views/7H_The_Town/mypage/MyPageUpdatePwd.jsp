<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="icon" type="image/png" sizes="32x32"
	href="views/7H_The_Town/resource/img/favicon-32x32.png">
<link rel="stylesheet"
	href="views/7H_The_Town/resource/CSS,JS/mypage/MyPageSecession.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/views/7H_The_Town/resource/CSS,JS/materialize/css/materializeCuteBtn.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/views/7H_The_Town/resource/CSS,JS/materialize/css/materializeCuteText.css">

<script
	src="<%= request.getContextPath() %>/views/7H_The_Town/resource/CSS,JS/materialize/js/materialize.js"></script>

<title>7H THE TOWN | 비밀번호 변경</title>
</head>

<body>

	<%@ include file="/views/common/Header.jsp"%>

	<div class="outer ani-slide">
		<div class="container">
			<div class="sidebar box" id="sidebar">
				<div class="user-name">
					<a href="<%=contextPath%>/main.me" class="user-txt1">안녕하세요</a><br>
                    <a href="<%=contextPath%>/main.me" class="user-txt2" style="color:#553830;"><%=loginUser.getUserName()%> 회원님</a>
				</div>
				<dl class="side-navi">
					<dt>
						<a href="<%=contextPath%>/update.me">개인 정보 수정</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/updatepwd.me">비밀번호 변경</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/posting.me">나의 게시글</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/like.me">찜한 목록</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/adopt.me">배송현황</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/message.me">쪽지함</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/donation.me">후원 내역</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/inquiry.me">문의 내역</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/delete.me">회원탈퇴</a>
					</dt>
				</dl>
			</div>
			<form action="<%= contextPath%>/updatepwd.me" method="post">
				<div class="mypage-content">
					<div class="mypage-title">
						<span>비밀번호 변경</span>
					</div>
					<div class="user-info user-info2 box">
						<div class="info2-wrap">
							<div class="info2-title">변경할 비밀번호를 입력하세요</div>
							<div class="info2-input">
								<div class="input-field inline">
									<input type="password" name="userPwd"
										style="width: 680px; height: 50px; border: 0px; border-bottom: 1px solid gray;" />
									<label>변경할 비밀번호</label>
								</div>
								<div class="input-field inline">
									<input type="password" name="checkPwd"
										style="width: 680px; height: 50px; border: 0px; border-bottom: 1px solid gray;" />
									<label>비밀번호 확인</label>
								</div>
								<div>
									<div class="btn-wrap col s12 m2">
										<button type="submit" class="waves-effect waves-light btn">비밀번호 변경</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
<script>
	//기본 위치(top)값
	var floatPosition = parseInt($("#sidebar").css('top'))
	
	// scroll 인식
	$(window).scroll(function() {
	
		// 현재 스크롤 위치
		var currentTop = $(window).scrollTop();
		var bannerTop = currentTop + floatPosition + "px";
	
		//이동 애니메이션
		$("#sidebar").animate({
			"top" : bannerTop
		}, 30);
	}).scroll();
</script>

</html>
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
	href="views/7H_The_Town/resource/CSS,JS/adminPage/AdminPageInsertPet.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/views/7H_The_Town/resource/CSS,JS/materialize/css/materializeCuteBtn.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/views/7H_The_Town/resource/CSS,JS/materialize/css/materializeCuteText.css">
<script
	src="<%=request.getContextPath()%>/views/7H_The_Town/resource/CSS,JS/materialize/js/materialize.js"></script>

<title>7H THE TOWN | 유기동물 등록</title>
</head>

<body>

	<%@ include file="/views/common/Header.jsp"%>

	<div class="outer ani-slide">
		<div class="container">
			<div class="sidebar box" id="sidebar">
				<div class="user-name">
					<span class="user-txt1">안녕하세요</span><br>
					<a href="<%=contextPath %>/main.ad" class="user-txt2" style="color:#553830;">관리자 님</a>
				</div>
				<dl class="side-navi">
					<dt>
						<a href="<%=contextPath%>/edit.ad">회원 정보 관리</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/posting.ad">게시판 관리</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/pet.ad">유기견 관리</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/deliver.ad">배송 관리</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/donation.ad">후원 관리</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/client.ad">고객 센터 관리</a>
					</dt>
				</dl>
			</div>
			<form action="<%=contextPath%>/insertpet.ad" method="post">
				<div class="mypage-content">
					<div class="mypage-title">
						<span>Pet 등록</span>
					</div>
					<div class="user-info user-info1 box">
						<div class="info1-wrap">
							<div class="info1-txt">
								<div class="info1-txt1">7H THE TOWN Pet 등록하기</div>
								<div class="info1-txt2">
									보금자리를 잃은 아이의 새로운 보호자를 만날 수 있게 <br> 사랑스러운 아이의 정보를 상세하게
									작성해주세요.
								</div>
							</div>
						</div>
					</div>
					<div class="user-info user-info2 box">
						<div class="info2-wrap">
							<div class="info2-title">Pet 정보 입력하기</div>
							<div class="info2-input">
								<div class="input-field inline">
									<input type="text" name="petName" required
										style="width: 680px; height: 50px; border: 0px; border-bottom: 1px solid gray;" />
									<label>* 이름</label>
								</div>
								<div class="input-field inline">
									<input type="text" name="petKind" required
										style="width: 680px; height: 50px; border: 0px; border-bottom: 1px solid gray;" />
									<label>* 종</label>
								</div>
								<div class="input-field inline">
									<input type="text" name="petAge" required
										style="width: 680px; height: 50px; border: 0px; border-bottom: 1px solid gray;" />
									<label>* 나이</label>
								</div>
								<div class="input-field inline">
									<input type="text" name="petGender" required
										style="width: 680px; height: 50px; border: 0px; border-bottom: 1px solid gray;" />
									<label>* 성별</label>
								</div>
								<div class="input-field inline">
									<input type="text" name="petPrice" required
										style="width: 680px; height: 50px; border: 0px; border-bottom: 1px solid gray;" />
									<label>* 분양가</label>
								</div>
								<div class="input-field inline">
									<input class="datepicker" type="text" name="petRescue"
										style="width: 680px; height: 50px; border: 0px; border-bottom: 1px solid gray;" />
									<label>* 구조일(YYYY-MM-DD)</label>
								</div>
								<div>
									<div class="btn-wrap col s12 m2">
										<button type="submit" class="waves-effect waves-light btn">등록하기</button>
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

<Script>
	$.datepicker.setDefaults({
		  dateFormat: 'yy-mm-dd',
		  prevText: '이전 달',
		  nextText: '다음 달',
		  monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		  monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		  dayNames: ['일', '월', '화', '수', '목', '금', '토'],
		  dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
		  dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
		  showMonthAfterYear: true,
		  yearSuffix: '년'
		});
	
		$(function () {
		  $('.datepicker').datepicker();
		});
		
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
</Script>










</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" type="image/png" sizes="32x32" href="views/7H_The_Town/resource/img/favicon-32x32.png">

    <link rel="stylesheet" href="<%= request.getContextPath() %>/views/7H_The_Town/resource/CSS,JS/mypage/MyPageAccount.css">

	<link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materialize.css">
	<link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeCuteBtn.css">
    
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
	<script src="views/7H_The_Town/resource/CSS,JS/materialize/js/materialize.js"></script>
    <script src="views/7H_The_Town/resource/CSS,JS/materialize/js/materializeCuteBtn.js"></script>
    <title>7H THE TOWN | 개인 정보 수정</title>
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
            <form action="<%=contextPath%>/update.me" class="form-wrap" method="post">
                <div class="mypage-content">
                    <div class="mypage-title">
                        <span>개인 정보 수정</span>
                    </div>
                    <div class="user-info user-info1 box">
                        <div class="info1-wrap">
                            <div class="info1-txt">
                                <div class="info1-txt1">
                                    7H THE TOWN 서비스에 표시되는 내 프로필 정보
                                </div>
                                <div class="info1-txt2">
                                    개인 정보 및 이를 관리하기 위한 옵션입니다. 다른 사용자가 나에게 쉽게 연락할
                                    수 있도록 정보 중 일부(예: 연락처 세부정보)를 다른 사용자에게 공개할 수 있습니다.
                                    프로필 정보를 한눈에 확인할 수도 있습니다.
                                </div>
                            </div>
                            <div class="info1-img">
                                <img src="views/7H_The_Town/resource/img/7H_THE_TOWN_LOGO.png" width="150px"
                                    height="150px" />
                            </div>
                        </div>
                    </div>
                    <div class="user-info user-info2 box">
                        <div class="info2-wrap">
                            <div class="info2-title">
                                개인 정보
                            </div>
                            <div class="info2-input">
                                <div class="input-field inline">
                                    <input type="text" name="userName"
                                        style="height: 50px; border: 0px; border-bottom: 1px solid gray;" />
                                    <label>이름</label>
                                    <span class="helper-text"></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class=" user-info user-info3 box">
                        <div class="info3-wrap">
                            <div class="info3-title">
                                연락처 정보
                            </div>
                            <div class="info3-input">
                                <div class="input-field inline">
                                    <input type="text" name="email"
                                        style="height: 50px; border: 0px; border-bottom: 1px solid gray;" />
                                    <label>이메일( ' @ ' 을 포함)</label>
                                    <span class="helper-text"></span>

                                </div>
                                <div class="input-field inline">
                                    <input type="text" name="phone"
                                        style="height: 50px; border: 0px; border-bottom: 1px solid gray;" />
                                    <label>전화번호( ' - ' 제외)</label>
                                    <span class="helper-text"></span>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class=" user-info user-info4 box">
                        <div class="info4-wrap">
                            <div class="info4-title">
                                배송지 정보
                            </div>
                            <div class="info4-input">
	                          	<div class="input-field inline" style="width: 100%; margin: 0;">
									<button type="button" class="waves-effect waves-light btn idCheck"
										onclick="sample6_execDaumPostcode()" style="color: white;">우편번호 찾기</button>
									<div class="input-field inline add" style="width: 100%; margin: 0;">
										<input type="text" id="sample6_postcode" placeholder="">
										<label></label> 
										<span class="helper-text">우편번호</span>
									</div>
									<div class="input-field inline add" style="width: 100%; margin: 0;">
										<input type="text" name="address" id="sample6_address" placeholder="">
										<label></label>
										<span class="helper-text">주소</span>
									</div>
									<div class="input-field inline add" style="width: 100%; margin: 0;">
										<input type="text" name="detailAddress" id="sample6_detailAddress" placeholder=""> 
										<label></label>
										<span class="helper-text">상세주소</span>
									</div>
									<div class="input-field inline add" style="width: 100%; margin: 0;">
										<input type="text" id="sample6_extraAddress" placeholder="">
										<label></label>
										<span class="helper-text">참고항목</span>
									</div>
								</div>
                            </div>
                        </div>
	                    <div class="btn-wrap col s12 m2">
	                        <button type="submit" class="waves-effect waves-light btn" value="">개인 정보 수정</button>
	                    </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <script>
		 // 주소 API
	    function sample6_execDaumPostcode() {
	        new daum.Postcode({
	            oncomplete: function (data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var addr = ''; // 주소 변수
	                var extraAddr = ''; // 참고항목 변수
	
	                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }
	
	                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	                if (data.userSelectedType === 'R') {
	                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                    if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있고, 공동주택일 경우 추가한다.
	                    if (data.buildingName !== '' && data.apartment === 'Y') {
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                    if (extraAddr !== '') {
	                        extraAddr = ' (' + extraAddr + ')';
	                    }
	                    // 조합된 참고항목을 해당 필드에 넣는다.
	                    document.getElementById("sample6_extraAddress").value = extraAddr;
	
	                } else {
	                    document.getElementById("sample6_extraAddress").value = '';
	                }
	
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('sample6_postcode').value = data.zonecode;
	                document.getElementById("sample6_address").value = addr;
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById("sample6_detailAddress").focus();
	            }
	        }).open();
	    }
    </script>

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

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

</html>
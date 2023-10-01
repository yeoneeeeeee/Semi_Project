<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>7H THE TOWN | 반려동물 등록</title>
	<link rel="icon" type="image/png" sizes="32x32" href="views/7H_The_Town/resource/img/favicon-32x32.png">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/fonts/fonts.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materialize.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/header.css">
    <script src="views/7H_The_Town/resource/CSS,JS/header.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/footer.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/board/PostingFAQ.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeBtn.css">

</head>
<body>
    
	<%@ include file="/views/common/Header.jsp" %>
	
	
    <div class="main_posting_wrap">
        <h2 class="posting_title">Pet 추가 등록</h2>
        <form id="petInsertForm" class="PetInsertController-form" name="pet" action="<%=contextPath%>/insert.p" method="post">
            <div class="category_head">
                <div class="category_title"><input type="text" id="petName" name="petName" placeholder="pet 이름" required style="height: 60px;"></div>
            </div>
            <br>
            <div class="category_head">
                <div class="category_title"><input type="text" id="petKind" name="petKind" placeholder="pet 종" required style="height: 60px;"></div>
            </div>
            <br>
            <div class="category_head">
                <div class="category_title"><input type="text" id="petAge" name="petAge" placeholder="pet 나이" required style="height: 60px;"></div>
            </div>
            <br>
            <div class="category_head">
                <div class="category_title"><input type="text" id="petGender" name="petGender" placeholder="pet 성별" required style="height: 60px;"></div>
            </div>
            <br>
            <div class="category_head">
                <div class="category_title"><input type="text" id="petPrice" name="petPrice" placeholder="pet 가격" required style="height: 60px;"></div>
            </div>
            
            <button type="submit" id="petSendBtn" align="center" class="petInsert_sumt" style="margin-top: 30px; width: 100px;height: 35px; border-radius: 15px; background-color: black; color: white; margin-left: 600px; margin-bottom: 50px; cursor:pointer;">등록하기</button>
        </form>

    </div>
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
            본사 : 서울특별시 강남구 테헤란로14길 6 남도빌딩 3F, 4F, 5F
        </p>
        <p class="footerP">
            상호 : 개더타운 대표자 : 파워레인저 사업자등록번호 123-456-789
        </p>
        <p class="footerP">
            개인정보보호책임자 : 이정택
        </p>
        <p class="footerP">
            TEL : 02)1234 - 5678 | FAX : 02-1111-2222 | 이메일 : ckdwjd2717@naver.com
        </p>
        <p class="footerP">
            대표전화 : 010 - 0000 - 0000
        </p>

    </div>

	<script>
		// pet list 추가할 값 입력받기
		$(document).ready(function(){
			$("#petSendBtn").click(function(){
				if($("#petName").val()==''){
	                alert("pet 이름을 입력하세요");
					return;
				}else if($("#petKind").val()==''){
					alert("pet 종을 입력하세요");
					return;
				}else if($("#petAge").val()==''){
					alert("pet 나이를 입력하세요");
					return;
				}else if($("#petGender").val()==''){
					alert("pet 성별을 입력하세요");
					return;
				}else if($("#petPrice").val()==''){
					alert("pet 가격을 입력하세요");
					return;
				}
				
			});
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
		
				
	</script>

</body>

</html>
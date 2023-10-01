<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>7H THE TOWN | 회원가입</title>
<link rel="icon" type="image/png" sizes="32x32" href="views/7H_The_Town/resource/img/favicon-32x32.png">
<script
	src="views/7H_The_Town/resource/CSS,JS/materialize/js/materialize.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<link rel="stylesheet"
	href="views/7H_The_Town/resource/CSS,JS/materialize/css/materialize.css">
<link rel="stylesheet"
	href="views/7H_The_Town/resource/CSS,JS/footer.css">
<link rel="stylesheet"
	href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeCuteBtn.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>


<style>
.outer {
	width: 1300px;
}

.btn { 
	background-color: #999999 !important;
	color : #FFFFFF !important;
	width:150px;
	height:40px;
}

.membership-box {
	margin: 250px;
	width: 600px;
	display: flex;
	flex-direction: column;
	align-items: center;
	background-color: rgb(255, 255, 255);
	border-style: none;
}

.add-form {
	margin: 30px 20px;
	height: 450px;
	display:flex;
}

.add {
	margin-top: 10px !important;
}

.add-form button {
	margin-top:50px;
}

#check-btn, #mem-join-btn {
	display: flex;
	flex-direction: column;
	align-items: center;
	height: 40px;
	width: 230px;
	margin-left: 4%;
	background-color: rgb(255, 255, 255);
	border-style: solid;
	border-radius: 14px;
	border-color: rgb(51, 51, 51);
	font-size: 12px;
}

.mambership-text {
	text-align: center;
	font-size: 11px;
	font-weight: bold;
	color: #7F8C8D;
	margin: 10% 0 10% 0;
}

.idCheck {
	margin-left: 21vw;
}

.notice-box {
	flex-direction: column;
	align-items: center;
	width: 500px;
	background-color: rgb(255, 255, 255);
}

#notice-text1, #notice-text2 {
	padding: 2% 4% 6% 4%;
	margin: 0% 3% 0% 3%;
	color: #5E5E5E;
}

#notice-title1, #notice-title2 {
	margin-left: 6%;
	margin-top: 10%;
	text-align: left;
}

#notice {
	margin: 3% 3%;
}

.notice-btn {
	display: flex;
	justify-content: center;
	margin-bottom: 10%;
}

.notice-btn button {
	width: 150px;
	height: 50px;
}

.termsForm .termsInfo {
	height: 250px;
	font-weight: bold;
	border: 2px solid darkgray;
	background-color: rgb(250, 250, 250);
	white-space: pre-line;
	overflow-y: scroll;
	margin: 40px;
}

.termsCheckBox {
	margin: 40px;
	text-align: right;
}
</style>
</head>
<body>

	<%@ include file="/views/common/Header.jsp"%>

	<form action="<%=contextPath %>/insert.me" method="POST"
		id="enroll-form" onsubmit="return checks();">

		<div class="membership-box  col s12 m2 z-depth-2">
			<img src="views/7H_The_Town/resource/img/7H_THE_TOWN_LOGO.png" alt=""
				width="200px" height="200px">
			<table>
				<tr>
					<div class="input-field inline">
						<input autocomplete="off" type="text" style="width: 550px;"
							name="userId" id="userId"> <label
							style="font-weight: bold;">* 아이디</label> <span class="helper-text"
							style="font-size: 10px; font-weight: bold;">4자 이상 32자 이하
						</span>
						<button class="waves-effect waves-light btn idCheck"
							type="button" onclick="idCheck();" value="">아이디 중복 체크</button>
					</div>
				</tr>
				<tr>
					<div class="input-field inline">
						<input autocomplete="off" type="text" style="width: 550px;"
							name="userName" id="userName"> <label
							style="font-weight: bold;">* 이름</label> <span class="helper-text"
							style="font-size: 10px; font-weight: bold;">이름을 입력해주세요.</span>
					</div>
				</tr>
				<tr>
					<div class="input-field inline">
						<input type="password" style="width: 550px;" name="userPwd"
							id="userPwd"> <label id="userPwd" for="PWD"
							style="font-weight: bold;">* 비밀번호</label> <span class="helper-text"
							style="font-size: 10px; font-weight: bold;">8자이상 32자 이하</span>
					</div>
				</tr>
				<tr>
					<div class="input-field inline">
						<input type="password" style="width: 550px;" name="checkPwd"
							id="checkPwd"> <label for="PWDCHECK"
							style="font-weight: bold;">* 비밀번호 확인</label> <span
							class="helper-text" style="font-size: 10px; font-weight: bold;">비밀번호와
							동일하게 입력해주세요</span>
					</div>
				</tr>
				<tr>
					<div class="input-field inline">
						<input type="text" style="width: 550px;" name="phone" id="phone">
						<label id="checkPhone" for="PHONENUMBER"
							style="font-weight: bold;">* 전화번호</label> <span class="helper-text"
							style="font-size: 10px; font-weight: bold;">'-'제외</span>
					</div>
				</tr>
				<tr>
					<div class="input-field inline">
						<input type="text" style="width: 550px;" name="email" id="email"
							onkeyup="myKey();"> <label for="mainAddress"
							style="font-weight: bold;" id="checkEmail">* 이메일</label> <span
							class="helper-text" style="font-size: 10px; font-weight: bold;">이메일
							형식으로 입력해주세요.</span>
					</div>
				</tr>
			</table>
			<div class="add-form">
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
			<div>
				<input data-bs-toggle="modal" data-bs-target="#exampleModal"
					type="button" value="개 더 타운 가입 약관 동의" id="check-btn"
					style="margin: 10% 0 3% 0; line-height: 32px;">
			</div>
			<div>
				<input type="submit" id="mem-join-btn" value="일반 회원가입"
					style="margin: 5% 0 3% 0; line-height: 32px;" disabled>
			</div>

			<div class="mambership-text">
				개 더 타운에 가입하면 서비스 약관에 동의하게 됩니다.<br> 게더타운 개인정보 보호정책을 확인하세요.
			</div>
		</div>
	</form>

	<script>
		$(function() {
			$("#check-btn").click(function() {
				$("#mem-join-btn").prop("disabled",false);
			});
		});
	
	</script>


	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true"
		style="background: none; box-shadow: 0 0px 0px 0px rgba(0, 0, 0, 0.14), 0 0px 0px 0px rgba(0, 0, 0, 0.12), 0 0px 0px 0px rgba(0, 0, 0, 0.2); width: fit-content; height: fit-content;">
		<div class="modal-dialog modal-xl">
			<div class="modal-content">
				<div class="notice-box col s12 m2 z-depth-3">
					<form class="termsForm ">


						<h4 style="text-align: center; margin-top: 12%;">개 더 타운 가입 약관
							동의</h4>
						<h5 id="notice-title1">약관 동의</h5>

						<div class="termsInfo">
							<p>개인정보보호법에 따라 네이버에 회원가입 신청하시는 분께 수집하는 개인정보의 항목, 개인정보의 수집 및 이용목적, 개인정보의 보유 및 이용기간, 동의 거부권 및 동의 거부 시 불이익에 관한 사항을 안내 드리오니 자세히 읽은 후 동의하여 주시기 바랍니다. 
								
								
								1. 수집하는 개인정보 이용자는 회원가입을 하지 않아도 정보 검색 등 대부분의 개 더 타운 가입 서비스를 회원과 동일하게 이용할 수 있습니다. 이용자가 메일, 캘린더, 카페, 블로그 등과 같이
								개인화 혹은 회원제 서비스를 이용하기 위해 회원가입을 할 경우, 개 더 타운 가입은 서비스 이용을 위해 필요한
								최소한의 개인정보를 수집합니다. 회원가입 시점에 개 더 타운 가입이 이용자로부터 수집하는 개인정보는 아래와
								같습니다. - 회원 가입 시 필수항목으로 아이디, 비밀번호, 이름, 생년월일, 성별, 휴대전화번호를, 선택항목으로
								본인확인 이메일주소를 수집합니다. 실명 인증된 아이디로 가입 시, 암호화된 동일인 식별정보(CI), 중복가입
								확인정보(DI), 내외국인 정보를 함께 수집합니다. 만14세 미만 아동의 경우, 법정대리인 정보(법정대리인의 이름,
								생년월일, 성별, 중복가입확인정보(DI), 휴대전화번호)를 추가로 수집합니다. - 비밀번호 없이 회원 가입 시에는
								필수항목으로 아이디, 이름, 생년월일, 휴대전화번호를, 선택항목으로 비밀번호를 수집합니다. - 단체 회원가입 시
								필수 항목으로 단체아이디, 비밀번호, 단체이름, 이메일주소, 휴대전화번호를, 선택항목으로 단체 대표자명을
								수집합니다. 서비스 이용 과정에서 이용자로부터 수집하는 개인정보는 아래와 같습니다. - 회원정보 또는 개별
								서비스에서 프로필 정보(별명, 프로필 사진)를 설정할 수 있습니다. 회원정보에 별명을 입력하지 않은 경우에는 마스킹
								처리된 아이디가 별명으로 자동 입력됩니다. - 네이버 내의 개별 서비스 이용, 이벤트 응모 및 경품 신청 과정에서
								해당 서비스의 이용자에 한해 추가 개인정보 수집이 발생할 수 있습니다. 추가로 개인정보를 수집할 경우에는 해당
								개인정보 수집 시점에서 이용자에게 ‘수집하는 개인정보 항목, 개인정보의 수집 및 이용목적, 개인정보의 보관기간’에
								대해 안내 드리고 동의를 받습니다. 서비스 이용 과정에서 IP 주소, 쿠키, 서비스 이용 기록, 기기정보,
								위치정보가 생성되어 수집될 수 있습니다. 또한 이미지 및 음성을 이용한 검색 서비스 등에서 이미지나 음성이 수집될
								수 있습니다. 구체적으로 1) 서비스 이용 과정에서 이용자에 관한 정보를 자동화된 방법으로 생성하여 이를
								저장(수집)하거나, 2) 이용자 기기의 고유한 정보를 원래의 값을 확인하지 못 하도록 안전하게 변환하여 수집합니다.
								서비스 이용 과정에서 위치정보가 수집될 수 있으며, 네이버에서 제공하는 위치기반 서비스에 대해서는 '네이버
								위치기반서비스 이용약관'에서 자세하게 규정하고 있습니다. 이와 같이 수집된 정보는 개인정보와의 연계 여부 등에 따라
								개인정보에 해당할 수 있고, 개인정보에 해당하지 않을 수도 있습니다.
								
								
								 2. 수집한 개인정보의 이용 네이버 및 네이버 관련 제반 서비스(모바일 웹/앱 포함)의 회원관리, 서비스 개발・제공 및 향상, 안전한 인터넷 이용환경 구축 등
								아래의 목적으로만 개인정보를 이용합니다. - 회원 가입 의사의 확인, 연령 확인 및 법정대리인 동의 진행, 이용자
								및 법정대리인의 본인 확인, 이용자 식별, 회원탈퇴 의사의 확인 등 회원관리를 위하여 개인정보를 이용합니다. -
								콘텐츠 등 기존 서비스 제공(광고 포함)에 더하여, 인구통계학적 분석, 서비스 방문 및 이용기록의 분석, 개인정보
								및 관심에 기반한 이용자간 관계의 형성, 지인 및 관심사 등에 기반한 맞춤형 서비스 제공 등 신규 서비스 요소의
								발굴 및 기존 서비스 개선 등을 위하여 개인정보를 이용합니다. - 법령 및 네이버 이용약관을 위반하는 회원에 대한
								이용 제한 조치, 부정 이용 행위를 포함하여 서비스의 원활한 운영에 지장을 주는 행위에 대한 방지 및 제재,
								계정도용 및 부정거래 방지, 약관 개정 등의 고지사항 전달, 분쟁조정을 위한 기록 보존, 민원처리 등 이용자 보호
								및 서비스 운영을 위하여 개인정보를 이용합니다. - 유료 서비스 제공에 따르는 본인인증, 구매 및 요금 결제, 상품
								및 서비스의 배송을 위하여 개인정보를 이용합니다. - 이벤트 정보 및 참여기회 제공, 광고성 정보 제공 등 마케팅
								및 프로모션 목적으로 개인정보를 이용합니다. - 서비스 이용기록과 접속 빈도 분석, 서비스 이용에 대한 통계,
								서비스 분석 및 통계에 따른 맞춤 서비스 제공 및 광고 게재 등에 개인정보를 이용합니다. - 보안, 프라이버시,
								안전 측면에서 이용자가 안심하고 이용할 수 있는 서비스 이용환경 구축을 위해 개인정보를 이용합니다. 
								
								
								3. 개인정보의 보관기간 회사는 원칙적으로 이용자의 개인정보를 회원 탈퇴 시 지체없이 파기하고 있습니다. 단, 이용자에게 개인정보
								보관기간에 대해 별도의 동의를 얻은 경우, 또는 법령에서 일정 기간 정보보관 의무를 부과하는 경우에는 해당 기간
								동안 개인정보를 안전하게 보관합니다. 이용자에게 개인정보 보관기간에 대해 회원가입 시 또는 서비스 가입 시 동의를
								얻은 경우는 아래와 같습니다. - 부정 가입 및 이용 방지 부정 이용자의 가입인증 휴대전화번호 또는 DI (만14세
								미만의 경우 법정대리인DI) : 탈퇴일로부터 6개월 보관 탈퇴한 이용자의 휴대전화번호(복호화가 불가능한 일방향
								암호화(해시처리)) : 탈퇴일로부터 6개월 보관 - QR코드 복구 요청 대응 QR코드 등록 정보:삭제
								시점으로부터6개월 보관 - 스마트플레이스 분쟁 조정 및 고객문의 대응 휴대전화번호:등록/수정/삭제 요청 시로부터
								최대1년 - 네이버 플러스 멤버십 서비스 혜택 중복 제공 방지 암호화처리(해시처리)한DI :혜택 제공
								종료일로부터6개월 보관 - 지식iN eXpert 재가입 신청 및 부정 이용 방지 eXpert 서비스 및 eXpert
								센터 가입 등록정보 : 신청일로부터 6개월(등록 거절 시, 거절 의사 표시한 날로부터 30일) 보관 전자상거래
								등에서의 소비자 보호에 관한 법률, 전자문서 및 전자거래 기본법, 통신비밀보호법 등 법령에서 일정기간 정보의 보관을
								규정하는 경우는 아래와 같습니다. 네이버는 이 기간 동안 법령의 규정에 따라 개인정보를 보관하며, 본 정보를 다른
								목적으로는 절대 이용하지 않습니다. - 전자상거래 등에서 소비자 보호에 관한 법률 계약 또는 청약철회 등에 관한
								기록: 5년 보관 대금결제 및 재화 등의 공급에 관한 기록: 5년 보관 소비자의 불만 또는 분쟁처리에 관한 기록:
								3년 보관 - 전자문서 및 전자거래 기본법 공인전자주소를 통한 전자문서 유통에 관한 기록 : 10년 보관 -
								전자서명 인증 업무 인증서와 인증 업무에 관한 기록: 인증서 효력 상실일로부터 10년 보관 - 통신비밀보호법 로그인
								기록: 3개월 참고로 네이버는 ‘개인정보 유효기간제’에 따라 1년간 서비스를 이용하지 않은 회원의 개인정보를 별도로
								분리 보관하여 관리하고 있습니다. 
								
								
								4. 개인정보 수집 및 이용 동의를 거부할 권리 이용자는 개인정보의 수집 및 이용
								동의를 거부할 권리가 있습니다. 회원가입 시 수집하는 최소한의 개인정보, 즉, 필수 항목에 대한 수집 및 이용
								동의를 거부하실 경우, 회원가입이 어려울 수 있습니다.</p>
						</div>
						<div class="termsCheckBox">
							<label> <input type="checkbox" id="notice" required /> <span>약관에
									동의하면 체크해주세요.</span>
							</label>
						</div>

						<h5 id="notice-title2">개인정보 수집 및 이용에 대한 안내</h5>

						<div class="termsInfo">
							<p>개인정보보호법에 따라 네이버에 회원가입 신청하시는 분께 수집하는 개인정보의 항목, 개인정보의 수집 및
								이용목적, 개인정보의 보유 및 이용기간, 동의 거부권 및 동의 거부 시 불이익에 관한 사항을 안내 드리오니 자세히
								읽은 후 동의하여 주시기 바랍니다. 1. 수집하는 개인정보 이용자는 회원가입을 하지 않아도 정보 검색, 뉴스 보기
								등 대부분의 네이버 서비스를 회원과 동일하게 이용할 수 있습니다. 이용자가 메일, 캘린더, 카페, 블로그 등과 같이
								개인화 혹은 회원제 서비스를 이용하기 위해 회원가입을 할 경우, 네이버는 서비스 이용을 위해 필요한 최소한의
								개인정보를 수집합니다. 회원가입 시점에 네이버가 이용자로부터 수집하는 개인정보는 아래와 같습니다. - 회원 가입 시
								필수항목으로 아이디, 비밀번호, 이름, 생년월일, 성별, 휴대전화번호를, 선택항목으로 본인확인 이메일주소를
								수집합니다. 실명 인증된 아이디로 가입 시, 암호화된 동일인 식별정보(CI), 중복가입 확인정보(DI), 내외국인
								정보를 함께 수집합니다. 만14세 미만 아동의 경우, 법정대리인 정보(법정대리인의 이름, 생년월일, 성별,
								중복가입확인정보(DI), 휴대전화번호)를 추가로 수집합니다. - 비밀번호 없이 회원 가입 시에는 필수항목으로
								아이디, 이름, 생년월일, 휴대전화번호를, 선택항목으로 비밀번호를 수집합니다. - 단체 회원가입 시 필수 항목으로
								단체아이디, 비밀번호, 단체이름, 이메일주소, 휴대전화번호를, 선택항목으로 단체 대표자명을 수집합니다. 서비스 이용
								과정에서 이용자로부터 수집하는 개인정보는 아래와 같습니다. - 회원정보 또는 개별 서비스에서 프로필 정보(별명,
								프로필 사진)를 설정할 수 있습니다. 회원정보에 별명을 입력하지 않은 경우에는 마스킹 처리된 아이디가 별명으로 자동
								입력됩니다. - 네이버 내의 개별 서비스 이용, 이벤트 응모 및 경품 신청 과정에서 해당 서비스의 이용자에 한해
								추가 개인정보 수집이 발생할 수 있습니다. 추가로 개인정보를 수집할 경우에는 해당 개인정보 수집 시점에서 이용자에게
								‘수집하는 개인정보 항목, 개인정보의 수집 및 이용목적, 개인정보의 보관기간’에 대해 안내 드리고 동의를 받습니다.



								서비스 이용 과정에서 IP 주소, 쿠키, 서비스 이용 기록, 기기정보, 위치정보가 생성되어 수집될 수 있습니다.
								또한 이미지 및 음성을 이용한 검색 서비스 등에서 이미지나 음성이 수집될 수 있습니다. 구체적으로 1) 서비스 이용
								과정에서 이용자에 관한 정보를 자동화된 방법으로 생성하여 이를 저장(수집)하거나, 2) 이용자 기기의 고유한 정보를
								원래의 값을 확인하지 못 하도록 안전하게 변환하여 수집합니다. 서비스 이용 과정에서 위치정보가 수집될 수 있으며,
								네이버에서 제공하는 위치기반 서비스에 대해서는 '네이버 위치기반서비스 이용약관'에서 자세하게 규정하고 있습니다.
								이와 같이 수집된 정보는 개인정보와의 연계 여부 등에 따라 개인정보에 해당할 수 있고, 개인정보에 해당하지 않을
								수도 있습니다. 2. 수집한 개인정보의 이용 네이버 및 네이버 관련 제반 서비스(모바일 웹/앱 포함)의 회원관리,
								서비스 개발・제공 및 향상, 안전한 인터넷 이용환경 구축 등 아래의 목적으로만 개인정보를 이용합니다. - 회원 가입
								의사의 확인, 연령 확인 및 법정대리인 동의 진행, 이용자 및 법정대리인의 본인 확인, 이용자 식별, 회원탈퇴
								의사의 확인 등 회원관리를 위하여 개인정보를 이용합니다. - 콘텐츠 등 기존 서비스 제공(광고 포함)에 더하여,
								인구통계학적 분석, 서비스 방문 및 이용기록의 분석, 개인정보 및 관심에 기반한 이용자간 관계의 형성, 지인 및
								관심사 등에 기반한 맞춤형 서비스 제공 등 신규 서비스 요소의 발굴 및 기존 서비스 개선 등을 위하여 개인정보를
								이용합니다. - 법령 및 네이버 이용약관을 위반하는 회원에 대한 이용 제한 조치, 부정 이용 행위를 포함하여
								서비스의 원활한 운영에 지장을 주는 행위에 대한 방지 및 제재, 계정도용 및 부정거래 방지, 약관 개정 등의
								고지사항 전달, 분쟁조정을 위한 기록 보존, 민원처리 등 이용자 보호 및 서비스 운영을 위하여 개인정보를
								이용합니다. - 유료 서비스 제공에 따르는 본인인증, 구매 및 요금 결제, 상품 및 서비스의 배송을 위하여
								개인정보를 이용합니다. - 이벤트 정보 및 참여기회 제공, 광고성 정보 제공 등 마케팅 및 프로모션 목적으로
								개인정보를 이용합니다. - 서비스 이용기록과 접속 빈도 분석, 서비스 이용에 대한 통계, 서비스 분석 및 통계에
								따른 맞춤 서비스 제공 및 광고 게재 등에 개인정보를 이용합니다. - 보안, 프라이버시, 안전 측면에서 이용자가
								안심하고 이용할 수 있는 서비스 이용환경 구축을 위해 개인정보를 이용합니다. 3. 개인정보의 보관기간 회사는
								원칙적으로 이용자의 개인정보를 회원 탈퇴 시 지체없이 파기하고 있습니다. 단, 이용자에게 개인정보 보관기간에 대해
								별도의 동의를 얻은 경우, 또는 법령에서 일정 기간 정보보관 의무를 부과하는 경우에는 해당 기간 동안 개인정보를
								안전하게 보관합니다. 이용자에게 개인정보 보관기간에 대해 회원가입 시 또는 서비스 가입 시 동의를 얻은 경우는
								아래와 같습니다. - 부정 가입 및 이용 방지 부정 이용자의 가입인증 휴대전화번호 또는 DI (만14세 미만의 경우
								법정대리인DI) : 탈퇴일로부터 6개월 보관 탈퇴한 이용자의 휴대전화번호(복호화가 불가능한 일방향
								암호화(해시처리)) : 탈퇴일로부터 6개월 보관 - QR코드 복구 요청 대응 QR코드 등록 정보:삭제
								시점으로부터6개월 보관 - 스마트플레이스 분쟁 조정 및 고객문의 대응 휴대전화번호:등록/수정/삭제 요청 시로부터
								최대1년 - 네이버 플러스 멤버십 서비스 혜택 중복 제공 방지 암호화처리(해시처리)한DI :혜택 제공
								종료일로부터6개월 보관 - 지식iN eXpert 재가입 신청 및 부정 이용 방지 eXpert 서비스 및 eXpert
								센터 가입 등록정보 : 신청일로부터 6개월(등록 거절 시, 거절 의사 표시한 날로부터 30일) 보관 전자상거래
								등에서의 소비자 보호에 관한 법률, 전자문서 및 전자거래 기본법, 통신비밀보호법 등 법령에서 일정기간 정보의 보관을
								규정하는 경우는 아래와 같습니다. 네이버는 이 기간 동안 법령의 규정에 따라 개인정보를 보관하며, 본 정보를 다른
								목적으로는 절대 이용하지 않습니다. - 전자상거래 등에서 소비자 보호에 관한 법률 계약 또는 청약철회 등에 관한
								기록: 5년 보관 대금결제 및 재화 등의 공급에 관한 기록: 5년 보관 소비자의 불만 또는 분쟁처리에 관한 기록:
								3년 보관 - 전자문서 및 전자거래 기본법 공인전자주소를 통한 전자문서 유통에 관한 기록 : 10년 보관 -
								전자서명 인증 업무 인증서와 인증 업무에 관한 기록: 인증서 효력 상실일로부터 10년 보관 - 통신비밀보호법 로그인
								기록: 3개월 참고로 네이버는 ‘개인정보 유효기간제’에 따라 1년간 서비스를 이용하지 않은 회원의 개인정보를 별도로
								분리 보관하여 관리하고 있습니다. 4. 개인정보 수집 및 이용 동의를 거부할 권리 이용자는 개인정보의 수집 및 이용
								동의를 거부할 권리가 있습니다. 회원가입 시 수집하는 최소한의 개인정보, 즉, 필수 항목에 대한 수집 및 이용
								동의를 거부하실 경우, 회원가입이 어려울 수 있습니다.</p>
						</div>
						<div class="termsCheckBox">
							<label> <input type="checkbox" id="notice" required /> <span>약관에
									동의하면 체크해주세요.</span>
							</label>
						</div>

						<div class="notice-btn">
							<div>
								<button onclick="checkNotice();" type="button"
									data-bs-dismiss="modal" aria-label="Close"
									style="width: 150px; height: 40px; border-radius: 4px; border-style: none; background-color: rgb(52, 152, 219); font-size: 16px; margin: 20px 10px 20px 0px; color: white;">확인</button>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-header"></div>
			</div>
		</div>
	</div>
















	<%@ include file="/views/common/Footer.jsp"%>

	<script>
		// 아이디 중복체크
		function idCheck() {
			// 아이디를 입력하는 input요소 객체 조회
			const $userId = $("#enroll-form input[name=userId]");
			
			$.ajax({
				url : "<%=contextPath%>/idCheck.me",
				data : {
					checkId : $userId.val()
				},
				success : function(result) {
					if (result == "0") { // 사용불가

						alert("존재하는 아이디입니다.");
						$userId.focus();
					} else { // 사용가능
						if (confirm("사용가능한 아이디입니다. 사용하시겠습니까?")) { // 사용함
							$userId.attr("readonly", true); // 아이디값 확정

						} else { // 사용안함
							$userId.focus();
						}
					}
				}
			});
		}

		// 비밀번호 유효검사
		function checks() {
			var getEmail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
			var getCheck = RegExp(/^[a-zA-Z0-9]{4,32}$/);
			var getPwd = RegExp(/^[a-zA-Z0-9]{8,32}$/);
			var getName = RegExp(/^[가-힣]+$/);
			var getPhone = RegExp(/^[0-9]{10,11}$/);

			//아이디 공백 확인
			if ($("#userId").val() == "") {
				alert("아이디를 입력하세요.");
				$("#userId").focus();
				return false;
			}

			//아이디 유효성검사
			if (!getCheck.test($("#userId").val())) {
				alert("형식에 맞게 입력해주세요");
				$("#userId").val("");
				$("#userId").focus();
				return false;
			}

			//비밀번호 공백 확인
			if ($("#userPwd").val() == "") {
				alert("패스워드를 입력하세요.");
				$("#userPwd").focus();
				return false;
			}

			//비밀번호 유효성검사
			if (!getPwd.test($("#userPwd").val())) {
				alert("형식에 맞게 입력해주세요");
				$("#userPwd").val("");
				$("#userPwd").focus();
				return false;
			}

			//비밀번호 확인란 공백 확인
			if ($("#checkPwd").val() == "") {
				alert("패스워드 확인란을 입력해주세요");
				$("#checkPwd").focus();
				return false;
			}

			//비밀번호 같음 확인
			if ($("#userPwd").val() != $("#checkPwd").val()) {
				alert("비밀번호가 일치하지 않습니다.");
				$("#userPwd").val("");
				$("#checkPwd").val("");
				$("#userPwd").focus();
				return false;
			}

			//이메일 공백 확인
			if ($("#email").val() == "") {
				alert("이메일을 입력해주세요");
				$("#email").focus();
				return false;
			}

			//이메일 유효성 검사
			if (!getEmail.test($("#email").val())) {
				alert("이메일형식에 맞게 입력해주세요")
				$("#email").val("");
				$("#email").focus();
				return false;
			}

			//이름 공백 검사
			if ($("#userName").val() == "") {
				alert("이름을 입력해주세요");
				$("#userName").focus();
				return false;
			}

			//이름 유효성 검사
			if (!getName.test($("#userName").val())) {
				alert("이름형식에 맞게 입력해주세요")
				$("#userName").val("");
				$("#userName").focus();
				return false;
			}
		}
		// 주소 API
		function sample6_execDaumPostcode() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
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
								if (data.bname !== ''
										&& /[동|로|가]$/g.test(data.bname)) {
									extraAddr += data.bname;
								}
								// 건물명이 있고, 공동주택일 경우 추가한다.
								if (data.buildingName !== ''
										&& data.apartment === 'Y') {
									extraAddr += (extraAddr !== '' ? ', '
											+ data.buildingName
											: data.buildingName);
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
							document.getElementById("sample6_detailAddress")
									.focus();
						}
					}).open();
		}
	</script>
</body>

<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</html>
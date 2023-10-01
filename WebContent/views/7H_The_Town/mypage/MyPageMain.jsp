<%@ page import="java.util.ArrayList, com.semi.delivery.model.vo.Delivery" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Board countBoard = (Board) request.getSession().getAttribute("countBoard");
	ArrayList<Delivery> dList = (ArrayList<Delivery>)request.getAttribute("dList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="icon" type="image/png" sizes="32x32"
	href="views/7H_The_Town/resource/img/favicon-32x32.png">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/views/7H_The_Town/resource/CSS,JS/mypage/MyPageMain.css">
<title>7H THE TOWN | 마이 페이지</title>
</head>

<body>

	<%@ include file="/views/common/Header.jsp"%>

	<div class="outer ani-slide">
		<div class="main-container">
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
			<div class="mypage-content">
				<div class="mypage-title">
					<span>투게더 등급</span>
				</div>
				<div class="user-info user-info1 box">
					<div class="grade-info">
						<div class="grade-img">
							<img src="views/7H_The_Town/resource/img/7H_THE_TOWN_LOGO.png">
						</div>
						<div class="grade-txt">
							<div class="txt txt1">
								<span><%=loginUser.getUserName()%>회원님의</span><br> <span>투게더
									등급은 <%=userGrade.getGradeName()%>입니다.
								</span>
							</div>
							<br>
							<div class="txt txt2">
								<span>등급별 혜택 상세보기 ></span>
							</div>
						</div>
					</div>
				</div>
				<div class="user-info user-info2">
					<div class="user-count box">
						<div class="count-wrap">
							<div class="flex-box">
								<div class="img-box">
									<img src="views/7H_The_Town/resource/img/7H_THE_TOWN_LOGO.png"/>
								</div>
								<div class="txt-box">
									<span>누적 후원</span>
									<div>
										<% String donaSum = numberFormat.format(countDona.getSum()); %>
										<span>금액</span> <span><%= donaSum %> 원</span>
									</div>
								</div>
							</div>
							<div class="flex-box top-box">
								<div class="img-box">
									<img src="views/7H_The_Town/resource/img/7H_THE_TOWN_LOGO.png"/>
								</div>
								<div class="txt-box">
									<span>투개더</span>
									<div>
										<span>포인트</span> 
										<span>
											<% String pointSum = numberFormat.format((int)Math.floor(countDona.getSum()*0.001)); %>
											<%= pointSum %> 포인트
										</span>
									</div>
								</div>
							</div>
							<div class="flex-box top-box">
								<div class="img-box">
									<img src="views/7H_The_Town/resource/img/7H_THE_TOWN_LOGO.png"/>
								</div>
								<div class="txt-box">
									<span>내가 작성한</span>
									<div>
										<span>게시글</span> <span><%= countBoard.getCount() %> 개</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="user-deli box">
						<div class="deli-txt">
							<span></span>
							<table class="deli-content highlight">
									<thead>
		                            	<tr>
		                                    <td style="width: 60%;">반려동물 이름</td>
											<td style="width: 40%;">배송현황</td>
		                                </tr>
		                            </thead>
		                            <tbody>
										<% if (dList == null || dList.isEmpty()) { %>
                                	<tr>
										<td colspan="6">조회된 배송내역이 없습니다.</td>
									</tr>
									<% } else { %> 
										<% int i = 0; %>
										<% for (Delivery d : dList) { %>
                                        <tr class="deli-state-txt">
                                            <input type="hidden" value="<%=d.getUserNo() %>">
											<% if(d.getDelStatus().equals("배송준비")) { %>
												<img src="views/7H_The_Town/resource/img/delivery_ready_icon.png" width="160px" height="160px" />
											<% } else if(d.getDelStatus().equals("배송중")) { %>
												<img src="views/7H_The_Town/resource/img/delivery_ing_icon.png" width="160px" height="160px" />
											<% } else if(d.getDelStatus().equals("배송완료")) { %>
												<img src="views/7H_The_Town/resource/delivery_complete_icon.png" width="160px" height="160px" />
											<% } else { %>
												<img src="views/7H_The_Town/resource/img/7H_THE_TOWN_LOGO.png" width="250px" height="250px" />
											<% } %>
											
	                                        <td><%=d.getPetName()%></td>
											<td id="items<%=i%>"><%=d.getDelStatus()%></td>
												
										<% i++; %>
											<% if(i == 1) break; %>
										</tr>
											<% } %>
										<% } %>
									</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="user-info user-info3 box">
					<div class="info3-wrap">
						<div class="user-email">
							<div class="email-txt1">
								<span>회원정보 ></span>
							</div>
							<div class="email-txt2">
								<span>EMAIL_ID | <%= loginUser.getEmail() %></span>
							</div>
						</div>
						<hr>
						<div class="user-address">
							<div class="address-txt1">
								<span>배송지 관리 ></span>
							</div>
							<div class="address-txt2">
								<span>배송지 | <%= loginUser.getAddress() %></span>
							</div>
							
						</div>
					</div>
				</div>
			</div>
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
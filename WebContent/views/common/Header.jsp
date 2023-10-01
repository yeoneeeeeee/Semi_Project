<%@ page import="java.text.NumberFormat"%>
<%@ page import="com.semi.member.model.vo.Member, com.semi.member.model.vo.Grade,
 com.semi.donation.model.vo.Donation, com.semi.board.model.vo.Board, com.semi.common.model.vo.PageInfo "%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	NumberFormat numberFormat = NumberFormat.getInstance();

	Member loginUser = (Member) request.getSession().getAttribute("loginUser");
	
	Grade userGrade = (Grade) request.getSession().getAttribute("userGrade");
	Donation userDona = (Donation) request.getSession().getAttribute("userDona");
	Donation countDona = (Donation) request.getSession().getAttribute("countDona");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="icon" type="image/png" sizes="32x32" href="<%=contextPath %>/views/7H_The_Town/resource/img/favicon-32x32.png">

<link rel="stylesheet" href="<%=contextPath %>/views/7H_The_Town/resource/CSS,JS/fonts/fonts.css">
<link rel="stylesheet" href="<%=contextPath %>/views/7H_The_Town/resource/CSS,JS/materialize/css/materialize.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<link rel="stylesheet" href="<%=contextPath %>/views/7H_The_Town/resource/CSS,JS/header.css">
<script src="<%=contextPath %>/views/7H_The_Town/resource/CSS,JS/header.js"></script>
<link rel="stylesheet" href="<%=contextPath %>/views/7H_The_Town/resource/CSS,JS/footer.css">
<link rel="stylesheet" href="<%=contextPath %>/views/7H_The_Town/resource/CSS,JS/materialize/css/materializeBtn.css">
	
</head>
<body>

	<script>
		const msg = "<%=(String) session.getAttribute("alertMsg")%>";

		if (msg != "null") {
			alert(msg);
		<%session.removeAttribute("alertMsg");%>
		}
	</script>

	<div class="naviBack  col s12 m2 z-depth-2"></div>
	<div class="naviBar">
		<div class="header">
			<a class="notArea" href="<%=contextPath%>/main"
				style="margin-right: 30px;"> <img
				src="<%=contextPath%>/views/7H_The_Town/resource/img/7H_THE_TOWN_LOGO.png"
				alt="" width="100px" height="100px"
				style="margin: 0px 50px 0px 30px;">
			</a>
			<ul class="headerUl">
				<a href="<%=contextPath%>/list.get">Get The Pet</a>
				<li class="headerLi topMargin" style="line-height: 30px;"><a
					href="<%=contextPath%>/list.get">유기견 목록</a></li>
			</ul>
			<ul class="headerUl2">
				<a href="<%=contextPath%>/donation.do">7H더 머니</a>
				<li class="headerLi topMargin"><a href="<%=contextPath%>/donation.do">후원현황</a></li>
				<li class="headerLi"><a href="<%=contextPath%>/donation.po">후원신청</a></li>
			</ul>
			<ul class="headerUl3">
				<a href="<%=contextPath%>/list.lo">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7H시판</a>
				<li class="headerLi topMargin"><a href="<%=contextPath%>/list.lo">공지사항</a></li>
				<li class="headerLi"><a href="<%=contextPath%>/list.bo">자유 게시판</a></li>
				<li class="headerLi"><a href="<%=contextPath%>/list.yo">입양 후기</a></li>
				<li class="headerLi"><a href="<%=contextPath%>/list.no">나눔 게시판</a></li>
			</ul>
			<ul class="headerUl4">
				<a href="<%=contextPath%>/faqPetList.bo">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;고객 센터</a>
				<li class="headerLi topMargin"><a href="<%=contextPath%>/faqPetList.bo">FAQ</a></li>
				<li class="headerLi"><a href="<%=contextPath%>/faqpost.bo">1:1 상담</a></li>
			</ul>

			<%
				if (loginUser == null) {
			%>

			<ul class="notArea" style="margin-left: 150px; margin-top: 42px;">
				<a
					href="<%=contextPath%>/login.me">
					로그인 </a>
			</ul>
			<ul class="notArea" style="margin-left: 30px; margin-top: 42px;">
				<a
					href="<%=contextPath%>/enrollForm.me">
					회원가입 </a>
			</ul>

			<%
				} else {
			%>

			<ul class="notArea" style="margin-left: 130px; margin-top: 35px;">
				<a href="<%=contextPath%>/main.me"> <img
					src="<%=contextPath%>/views/7H_The_Town/resource/img/Profile_Icon.png"
					alt="" width="30px" height="30px">
				</a>
			</ul>
			<ul class="notArea" style="margin-left: 10px; margin-top: 40px;">
				<a href="<%=contextPath%>/main.me"><%=loginUser.getUserName()%>님</a>
			</ul>
			<ul class="menuIcon notArea"
				style="margin-left: 25px; margin-top: 35px; z-index: 10;">
				<img class="menuIcon"
					src="<%=contextPath%>/views/7H_The_Town/resource/img/Menu_Icon.png" alt=""
					width="30px" height="30px">
			</ul>

			<%
				}
			%>

		</div>
	</div>
	<div class="myPage" style="margin-top: 60px; z-index: 1;">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
	<div class="myPage menuIcon col s12 m2 z-depth-2" style="z-index: 10;">
		<%
			if (loginUser != null && !(loginUser.getUserId().equals("admin"))) {
		%>
		<ul class="myPageUl" style="height:380px;">
			<li class="myPageLi"><a href="<%=contextPath%>/main.me">마이페이지</a></li>
			<li class="myPageLi"><a href="<%=contextPath%>/update.me">개인정보수정</a></li>
			<li class="myPageLi"><a href="<%=contextPath%>/updatepwd.me">비밀번호변경</a></li>
			<li class="myPageLi"><a href="<%=contextPath%>/posting.me">나의 게시글</a></li>
			<li class="myPageLi"><a href="<%=contextPath%>/like.me">찜한 목록</a></li>
			<li class="myPageLi"><a href="<%=contextPath%>/adopt.me">배송현황</a></li>
			<li class="myPageLi"><a href="<%=contextPath%>/message.me">쪽지함</a></li>
			<li class="myPageLi"><a href="<%=contextPath%>/donation.me">후원내역</a></li>
			<li class="myPageLi"><a href="<%=contextPath%>/inquiry.me">문의내역</a></li>
			<li class="myPageLi"><a href="<%=contextPath%>/delete.me">회원탈퇴</a></li>
			<li class="myPageLi"><a href="<%=contextPath%>/logout.me">로그아웃</a></li>
		</ul>
		<%
			} else {
		%>
		<ul class="myPageUl">
			<li class="myPageLi"><a href="<%=contextPath%>/main.ad">관리자페이지</a></li>
			<li class="myPageLi"><a href="<%=contextPath%>/edit.ad">회원정보관리</a></li>
			<li class="myPageLi"><a href="<%=contextPath%>/posting.ad">게시판관리</a></li>
			<li class="myPageLi"><a href="<%=contextPath%>/pet.ad">유기견관리</a></li>
			<li class="myPageLi"><a href="<%=contextPath%>/deliver.ad">배송관리</a></li>
			<li class="myPageLi"><a href="<%=contextPath%>/donation.ad">후원관리</a></li>
			<li class="myPageLi"><a href="<%=contextPath%>/client.ad">고객센터관리</a></li>
			<li class="myPageLi"><a href="<%=contextPath%>/logout.me">로그아웃</a></li>
		</ul>
		<%
			}
		%>
	</div>
	
	
	<script>
		<% if (loginUser != null && !(loginUser.getUserId().equals("admin"))) { %>
			$(document).ready(function(){
			    // $(".myPage").hide();
			    $(".menuIcon").hover(function(){
			        $(".myPage").css("height", "380px");
			    }, function(){
			        $(".myPage").css("height", "0px");
			    });
			})
		<% } else { %>
			$(document).ready(function(){
			    // $(".myPage").hide();
			    $(".menuIcon").hover(function(){
			        $(".myPage").css("height", "280px");
			    }, function(){
			        $(".myPage").css("height", "0px");
			    });
			})
		<% } %>
	</script>
	
	
</body>
</html>
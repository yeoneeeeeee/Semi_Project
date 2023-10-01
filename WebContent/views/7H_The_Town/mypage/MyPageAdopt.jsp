<%@ page import="java.util.ArrayList, com.semi.pet.model.vo.Pet, com.semi.delivery.model.vo.Delivery, com.semi.member.model.vo.Member, com.semi.common.model.vo.PageInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Pet> list = (ArrayList<Pet>) request.getAttribute("list");
	ArrayList<Delivery> dList = (ArrayList<Delivery>) request.getAttribute("dList");

	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>7H THE TOWN | 배송현황</title>
    <link rel="icon" type="image/png" sizes="32x32" href="views/7H_The_Town/resource/img/favicon-32x32.png">
    <link rel="stylesheet" href="views/7H_The_Town/resource/fonts/fonts.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/header_My.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeCuteCheckbox.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeCuteBtn.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materialize.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="views/7H_The_Town/resource/materialize/js/materialize.js"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/mypage/MyPageAdopt.css">
    <script src="views/7H_The_Town/resource/CSS,JS/materialize/js/materialize.js"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
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
                <div class="mypage-content">
                    <div class="mypage-title">
                        <span>나의 가족</span>
                    </div>
                    <div class="user-info user-info1 box">
                        <div class="info1-wrap">
                            <div class="info1-img">
                                <img src="views/7H_The_Town/resource/img/UserIcon2.png" width="110px" height="110px" />
                            </div>
                            <div class="info1-txt">
                                <div class="info1-txt1">
                                    <%=loginUser.getUserName() %>님
                                </div>
                                <div class="info1-txt2">
	                                <% if (dList.isEmpty()) { %>
	                                	<tr>
											<td colspan="3">조회된 리스트가 없습니다.</td>
										</tr>
									<% } else { %> 
	                                	<% int i = 0; %>
	                                	<% for (Delivery d : dList) { %>
		                                <% i++; %>
	                                    <% } %>
		                                <span>가족이 될 아이 : <%= i %></span>
	                                <% } %>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="user-info3 box">
                        <div class="info3-wrap">
                            <div class="info3-title">
                                나의 새로운 가족
                            </div>
                            <div class="info3-table">
                                <table>
                                    <thead>
                                        <tr>
                                            <td style="width:50%;">견종</td>
                                            <td style="width:20%;">이름</td>
                                            <td style="width:30%;">배송상태</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<% if (dList.isEmpty()) { %>
                                	<tr>
										<td colspan="6">조회된 리스트가 없습니다.</td>
									</tr>
									<% } else { %> 
								      	<% int i = 0; %>
										<% for (Delivery d : dList) { %>
                                    <tr>
                                        <td><%=d.getPetKind()%></td>
										<td><%=d.getPetName()%></td>
										<td id="items<%=i%>"><%=d.getDelStatus()%></td>
										<% i++; %>
									</tr>
										<% } %>
									<% } %>
                                </table>
                            </div>
                        </div>
                    </div>
	            <div style="display:flex; justify-content:center; margin-top:50px;" >
					<ul class="pagination" style="align-items: center; margin:auto;">
					<% if(currentPage != 1)  {%>
					    <li class="disabled"><a href="<%=contextPath %>/adopt.me?currentPage=<%=currentPage -1 %>"><i class="material-icons">chevron_left</i></a></li>
				    <% } %>
						    
			    	<% for(int p = startPage; p <= endPage; p++) { %>
				    <% if(p != currentPage){ %>
					    <li class="waves-effect"><a href="<%=contextPath%>/adopt.me?currentPage=<%= p %>"><%= p %></a></li>
				    <% } else { %>
				    	<li class="active"><a href="<%=contextPath%>/adopt.me?currentPage=<%= p %>"><%= p %></a></li>
			    	<% } %>
					<% } %>
					<% if(maxPage == 0) maxPage=1; %>
					<% if(currentPage != maxPage) { %>
					    <li class="waves-effect"><a href="<%=contextPath%>/adopt.me?currentPage=<%= currentPage + 1 %>"><i class="material-icons">chevron_right</i></a></li>
					</ul>
					<% } %>
				</div>
            </div>
        </div>
    </div>
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
 

</body>

</html>
<%@ page
	import="com.semi.postAll.model.vo.PostAll, java.util.ArrayList, com.semi.common.model.vo.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ArrayList<PostAll> list = (ArrayList<PostAll>) request.getAttribute("list");
/*  PostAll p = (PostAll)request.getAttribute("p"); */

PageInfo pi = (PageInfo) request.getAttribute("pi");

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

<link rel="icon" type="image/png" sizes="32x32"
	href="views/7H_The_Town/resource/img/favicon-32x32.png">

<link rel="stylesheet" href="views/7H_The_Town/resource/fonts/fonts.css">
<link rel="stylesheet"
	href="views/7H_The_Town/resource/CSS,JS/header_My.css">
<link rel="stylesheet"
	href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeCuteCheckbox.css">
<link rel="stylesheet"
	href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeCuteBtn.css">
<link rel="stylesheet"
	href="views/7H_The_Town/resource/CSS,JS/materialize/css/materialize.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<link rel="stylesheet"
	href="views/7H_The_Town/resource/CSS,JS/adminPage/AdminPageDelivery.css">
<script src="views/7H_The_Town/resource/CSS,JS/header_My.js"></script>
<script
	src="views/7H_The_Town/resource/CSS,JS/materialize/js/materializeCuteBtn.js"></script>
<script
	src="views/7H_The_Town/resource/CSS,JS/materialize/js/materialize.js"></script>
<title>7H THE TOWN | 쪽지함</title>
</head>

<body>

	<%@ include file="/views/common/Header.jsp"%>
	
	<div class="outer">
		<div class="container">
			<div class="sidebar ol s12 m2 z-depth-2">
				<div class="user-name">
					<span class="user-txt1">안녕하세요</span><br> <span
						class="user-txt2">관리자 님</span>
				</div>
				<dl class="side-navi">
					<dt>
						<a href="/7HTheTown/7HTHETOWN_AdminPage_UserEdit.html">회원 정보
							관리</a>
					</dt>
					<dt>
						<a href="/7HTheTown/7HTHETOWN_AdminPage_Posting_Notice.html">게시판
							관리</a>
					</dt>
					<dt>
						<a href="/7HTheTown/7HTHETOWN_AdminPage_PetControll.html">유기견
							관리</a>
					</dt>
					<dt>
						<a href="/7HTheTown/7HTHETOWN_AdminPage_Delivery.html">배송 관리</a>
					</dt>
					<dt>
						<a href="/7HTheTown/7HTHETOWN_AdminPage_Donation.html">후원 관리</a>
					</dt>
					<dt>
						<a href="/7HTheTown/7HTHETOWN_AdminPage_ClientCenter.html">고객
							센터 관리</a>
					</dt>
				</dl>
			</div>
			<div class="adminpage-content">
				<div class="adminpage-title">
					<span>쪽지함</span>
				</div>
				<div class="board-wrap">
					<div class="board-top">
						<div class="board-search ">
							<div class="category"></div>
							<div class="search"></div>
						</div>
					</div>
					<div class="board-list"></div>
				</div>
				<div class="admin-info1 ol s12 m2 z-depth-2">
					<div class="info1-wrap">
						<div class="info1-userinfo">
							<table class="highlight">
								<thead>
									<tr>
										<td style="width: 10%;"><label> <input
												type="checkbox"> <span></span>
										</label></td>
										<td style="width: 28%; text-align: center;">쪽지명</td>
										<td style="width: 28%; text-align: center;">발신자</td>
										<td style="width: 17%; text-align: center;">날짜</td>
									</tr>
								</thead>
								<tbody>

									<%
										if (!(list.isEmpty())) {
									%>
									<%
										for (int i = 0; i < list.size(); i++) {
									%>
									<tr>
										<td><label> <input type="checkbox"> <span></span>
										</label></td>
										<td><%=list.get(i).getPostTitle() %></td>
										<td><%=list.get(i).getCallerNo()%></td>
										<td><%=list.get(i).getCreateDate()%></td>
									</tr>
									<%
										}
									%>
									<%
										}
									%>


								</tbody>





							</table>
								<div align="center" class="petListPageSelect paging-area">
							         <% if(currentPage != 1)  {%>
							            <button onclick="location.href='<%=contextPath %>/Plist.bo?currentPage=<%=currentPage -1 %>'">&lt;</button>
							         <% } %>
							         
							         <% for(int p = startPage; p <= endPage; p++) { %>
							            <% if(p != currentPage){ %>
							               <button onclick="location.href='<%=contextPath%>/Plist.bo?currentPage=<%= p %>'"><%= p %></button>
							            <% } else { %>
							               <button disabled><%= p %></button>         
							            <% } %>
							         <% } %>
							         <% if(currentPage != maxPage) { %>
							            <button onclick="location.href='<%=contextPath%>/Plist.bo?currentPage=<%= currentPage + 1 %>'">&gt;</button>
							         <% } %>
							      </div>
								</div>
							<div class="btn-wrap">
								<input type="hidden" name="petNo" id="result">
								<a id="delCheck1" class="waves-effect waves-light btn" onclick="del();">삭제하기</a>
								<button type="submit" id="delCheck2" class="waves-effect waves-light btn" style="display:none;">삭제하기</button>
								<a href="<%=contextPath%>/postWrite.bo" class="waves-effect waves-light btn" onclick="insert();">쪽지 작성</a>
							</div>
							
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	</div>
	<script>
        $(function(){
        	  $(".list-area>tbody>tr").click(function(){
        	        location.href="<%=contextPath%>/detail.bo?bno="+ $(this).children().eq(0).text();})
		});
        
	</script>
</body>

</html>
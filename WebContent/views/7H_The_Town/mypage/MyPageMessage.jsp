<%@ page
	import="com.semi.postAll.model.vo.PostAll, java.util.ArrayList, com.semi.common.model.vo.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ArrayList<PostAll> list = (ArrayList<PostAll>) request.getAttribute("list");

	PageInfo pi = (PageInfo) request.getAttribute("pi");
%>

<%
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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="views/7H_The_Town/resource/fonts/fonts.css">
<link rel="stylesheet"	href="views/7H_The_Town/resource/CSS,JS/header_My.css">
<link rel="stylesheet"	href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeCuteCheckbox.css">
<link rel="stylesheet"	href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeCuteBtn.css">
<link rel="stylesheet"	href="views/7H_The_Town/resource/CSS,JS/materialize/css/materialize.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<link rel="stylesheet"	href="views/7H_The_Town/resource/CSS,JS/mypage/MyPageMessage.css">
<script src="views/7H_The_Town/resource/CSS,JS/header_My.js"></script>
<script	src="views/7H_The_Town/resource/CSS,JS/materialize/js/materializeCuteBtn.js"></script>
<script	src="views/7H_The_Town/resource/CSS,JS/materialize/js/materialize.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<title>7H THE TOWN | 쪽지함</title>
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
					<span>개인 쪽지함</span>
				</div>
				<div class="user-info1 box">
					<div class="info1-wrap">
						<div class="info1-title">쪽지 리스트</div>

						<form class="admin-info1"
							action="<%=contextPath%>/postingDelete.no" method="post">
							<div class="info1-table">
								<table class="highlight">
									<thead>
										<tr>
											<td style="width: 10%;"><label> <input
													type="checkbox" id="selectAllBtn"> <span></span>
											</label></td>
											<td style="width: 50%;">내게 온 쪽지</td>
											<td style="width: 20%;">보낸 사람</td>
											<td style="width: 20%;">수신날짜</td>
										</tr>
									</thead>

									<%
										if (!(list.isEmpty())) {
									%>
									<%
										for (int i = 0; i < list.size(); i++) {
									%>
									<tbody>
										<tr>
											<td><label> <%-- 
												<input type="hidden"  value="<%=p.getPetNo() %>"> --%> <input
													type="checkbox" name="rowCheck"
													value="<%=list.get(i).getPostNo() %>" class="rowCheck-btn"
													id=checkItem> <span></span>
											</label></td>

											<td><%=list.get(i).getPostTitle() %></td>
											<td><%=list.get(i).getCallerNo()%></td>
											<td><%=list.get(i).getCreateDate()%></td>
										</tr>
									</tbody>
									<%
										}
									%>
									<%
										}
									%>

								</table>

							</div>
							<div class="btn-wrap">
								<input type="hidden" name="petNo" id="result"> <a
									id="delCheck1" class="waves-effect waves-light btn"
									onclick="del();">삭제하기</a>
								<button type="submit" id="delCheck2"
									class="waves-effect waves-light btn" style="display: none;">삭제하기</button>
								<a href="<%=contextPath%>/postWrite.bo"
									class="waves-effect waves-light btn">쪽지작성</a>
							</div>
						</form>
					</div>
				</div>
				<div style="display:flex; justify-content:center; margin-top:50px;" >
					<ul class="pagination" style="align-items: center; margin:auto;">
					<% if(currentPage != 1)  {%>
					    <li class="disabled"><a href="<%=contextPath %>/message.me?currentPage=<%=currentPage -1 %>"><i class="material-icons">chevron_left</i></a></li>
				    <% } %>
				    
			    	<% for(int p = startPage; p <= endPage; p++) { %>
				    <% if(p != currentPage){ %>
					    <li class="waves-effect"><a href="<%=contextPath%>/message.me?currentPage=<%= p %>"><%= p %></a></li>
				    <% } else { %>
				    	<li class="active"><a href="<%=contextPath%>/message.me?currentPage=<%= p %>"><%= p %></a></li>
			    	<% } %>
					<% } %>
					<% if(maxPage == 0) maxPage=1; %>
					<% if(currentPage != maxPage) { %>
					    <li class="waves-effect"><a href="<%=contextPath%>/message.me?currentPage=<%= currentPage + 1 %>"><i class="material-icons">chevron_right</i></a></li>
					</ul>
					<% } %>
				</div>
			</div>
		</div>
		<div class="footer"></div>
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
	
		// delete 버튼 작동
		function del(){

			const query = 'input[class="rowCheck-btn"]:checked';
			const del = document.querySelectorAll(query);
			
			let result = '';

			del.forEach((el)=>{
				result += el.value + ",";
			});
			
			$("#result").val(result);
			
			alert("정말 삭제하시겠습니까? 다시 한번 확인해주세요.");
			
			$("#delCheck2").css("display", "block");
			$("#delCheck1").css("display", "none");
			
		}
	
		// 처크박스 선택 & 전체선택 및 해제 
    	function selectAll(){
	    	const checked = document.getElementById("selectAllBtn").checked;
	    	const rowChecks = document.querySelectorAll('input[type="checkbox"]');
	
	        rowChecks.forEach( function(rowCheck) {
	        	rowCheck.checked = checked;
	        })
		}
	      // 하나라도 체크되지 않으면 전체선택 해제
	      function selectOne(){
	          const all = document.getElementById("selectAllBtn");
	          const one = document.querySelectorAll('input[class="rowCheck-btn"]');
	
	          let isAll = true;
	              
	          for(let i = 0; i < one.length; i++){
	            if(one[i].checked == false){
	                    isAll = false;
	                  break;
	              }
	          }
	
	          if(isAll){
	            all.checked = true;
	          } else{
	          all.checked = false;
	          }
	      }
		
    </script>
    
    
    

</body>

</html>
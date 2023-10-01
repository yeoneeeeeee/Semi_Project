<%@ page import="com.semi.board.model.vo.Board, java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Board> list = (ArrayList<Board>) request.getAttribute("list");
	
	
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	
	String category = (String)request.getAttribute("category");
	String keyword = (String)request.getAttribute("keyword");
	
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
	href="views/7H_The_Town/resource/CSS,JS/adminPage/AdminPagePostingShare.css">
<script src="views/7H_The_Town/resource/CSS,JS/header_My.js"></script>
<script
	src="views/7H_The_Town/resource/CSS,JS/materialize/js/materializeCuteBtn.js"></script>
<script
	src="views/7H_The_Town/resource/CSS,JS/materialize/js/materialize.js"></script>
<title>7H THE TOWN | 게시판관리(나눔)</title>
</head>

<body>

	<%@ include file="/views/common/Header.jsp"%>

	<div class="outer ani-slide">
		<div class="container">
			<div class="sidebar ol s12 m2 z-depth-2" id="sidebar">
				<div class="user-name">
					<span class="user-txt1">안녕하세요</span><br>
					<a href="<%=contextPath %>/main.ad" class="user-txt2" style="color:#553830;">관리자 님</a>
				</div>
				<dl class="side-navi">
					<dt>
						<a href="<%= contextPath %>/edit.ad">회원 정보 관리</a>
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
			<div class="adminpage-content">
				<div class="adminpage-title">
					<span>게시판 관리</span>
				</div>
				<div class="search-tool">
					<form action="searchreport.ad">
						<select style="font-size:12px; color:gray;" name="category">
							<option>최신순</option>
							<option>제목순</option>
							<option>작성자순</option>
						</select>
						<div>
							<i class="material-icons">search</i>
							<input type="text" name="keyword" placeholder="검색할 키워드를 입력하세요."
							style="width:200px; background-color:white; font-size:12px;">
						</div>
					</form>
				</div>
				<div class="board-wrap">
					<div class="board-top">
						<div class="board-category">
							<div class="category-list">
								<li><button class="waves-effect waves-light">
										<a href="<%=contextPath%>/posting.ad">공지사항</a>
									</button></li>
								<li><button class="waves-effect waves-light"
										>
										<a href="<%=contextPath%>/free.ad">일반게시판</a>
									</button></li>
								<li><button class="waves-effect waves-light"
								style="background-color: rgb(255, 216, 144);">
										<a href="<%=contextPath%>/share.ad">나눔 게시판</a>
									</button></li>
								<li><button class="waves-effect waves-light">
										<a href="<%=contextPath%>/review.ad">입양후기 게시판</a>
									</button></li>
							</div>
						</div>
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
							<form action="<%=contextPath %>/mypageDelete.bo" method = "post">
								<table class="highlight">
									<thead>
										<tr>
											<td style="width: 10%;"><label> <input type="checkbox" onclick="selectAll();" id="selectAllBtn"> <span></span>
											</label></td>
											<td style="width: 35%; text-align: center;">제목</td>
											<td style="width: 35%; text-align: center;">작성자</td>
											<td style="width: 20%; text-align: center;">작성일</td>
										</tr>
									</thead>
									<tbody>
										<% if(list.isEmpty()) { %>
											<tr>
												<td colspan="5">조회된 리스트가 없습니다.</td>
											</tr>
											<% } else { %>
											<%for(int i = 0; i < list.size(); i++) { %>
											<tr data-bs-toggle="modal"
												data-bs-target="#exampleModal<%= i %>">
												<td><label> <input type = "checkbox" class="rowCheck-btn" name="bno" value="<%=list.get(i).getBoardNo() %>"> <span></span>
												</label></td>
												<td><%= list.get(i).getBoardTitle() %></td>
												<td><%= list.get(i).getWriter() %></td>
												<td><%= list.get(i).getCreateDate() %></td>
											</tr>
											<% } %>
											<% } %>
									</tbody>
								</table>
								<div class="btn-wrap">
									<input type ="hidden" name="boardNo" id = "result">
                                	<a id="delCheck1" class = "waves-effect waves-light btn" onclick = "del();">삭제하기</a>
                                    <button type = "submit"  id = "delCheck2" class="waves-effect waves-light btn" style="display:none;">삭제하기</button>
									<a href="<%=contextPath %>/Adminpost.bo"
										class="waves-effect waves-light btn">작성하기</a>
								</div>
							</form>
						</div>
						<script>
                                	function del(){
                                		const query = 'input[class="rowCheckbox-btn"]:checked';
                                		const del = document.querySelectorAll(query);
                                		
                                		let result = '';
                                		
                                		del.forEach((el)=>{
                                			result += el.value +",";
                                		});
                                		
                                		$("#result").val(result);
                                		
                                		alert("정말 삭제하시려면 다시 한번 눌러주세요");
                                		
                                		$("#delCheck2").css("display","block");
                                		$("#delCheck1").css("display","none");
                                	}
                                	
                                	function selectAll(){
                                		const checked = document.getElementById("selectAllBtn").checked;
                                		const rowChecks = document.querySelectorAll('input[type="checkbox"]');
                                		
                                		rowChecks.forEach( function(rowCheck){
                                			rowCheck.checked = checked;
                                		})
                                	}
                                	
                                	function selectOne(){
                                		const all = document.getElementById("selectAllBtn");
                                		const one = document.querySelectorAll('input[class="rowCheck-btn"]');
                                		
                                		let isAll = true;
                                		
                                		for(let i = 0; i<one.length; i++){
                                			if(one[i].checked == false){
                                				isAll = false;
                                				break;
                                			}
                                		}
                                		if(isAll){
                                			all.checked = true;
                                		}else{
                                			all.checked = false;
                                		}
                                	}
                                </script>
					</div>
				</div>
				
				<br><br>
				
				<% if(category == null && keyword == null) { %>
				<div style="display:flex; justify-content:center;" >
					<ul class="pagination" style="align-items: center; margin:auto;">
					<% if(currentPage != 1)  {%>
					    <li class="disabled"><a href="<%=contextPath %>/board.ad?currentPage=<%=currentPage -1 %>&category="><i class="material-icons">chevron_left</i></a></li>
				    <% } %>
				    
				    <% for(int p = startPage; p <= endPage; p++) { %>
				    <% if(p != currentPage){ %>
					    <li class="waves-effect"><a href="<%=contextPath%>/board.ad?currentPage=<%= p %>"><%= p %></a></li>
				    <% } else { %>
				    <li class="active"><a href="#!"><%= p %></a></li>
				    <% } %>
					<% } %>
					<% if(maxPage == 0) maxPage = 1; %>
					<% if(currentPage != maxPage) { %>
					    <li class="waves-effect"><a href="<%=contextPath%>/board.ad?currentPage=<%= currentPage + 1 %>"><i class="material-icons">chevron_right</i></a></li>
					</ul>
					<% } %>
				</div>
				<% } else { %>
				<div style="display:flex; justify-content:center;" >
					<ul class="pagination" style="align-items: center; margin:auto;">
					<% if(currentPage != 1)  {%>
					    <li class="disabled"><a href="<%=contextPath %>/searchboard.ad?currentPage=<%=currentPage -1 %>&category=<%= category %>&keyword=<%=keyword%>"><i class="material-icons">chevron_left</i></a></li>
				    <% } %>
				    
				    <% for(int p = startPage; p <= endPage; p++) { %>
				    <% if(p != currentPage){ %>
					    <li class="waves-effect"><a href="<%=contextPath%>/searchboard.ad?currentPage=<%= p %>&category=<%= category %>&keyword=<%=keyword%>"><%= p %></a></li>
				    <% } else { %>
				    <li class="active"><a href="#!"><%= p %></a></li>
				    <% } %>
					<% } %>
					<% if(maxPage == 0) maxPage = 1; %>
					<% if(currentPage != maxPage) { %>
					    <li class="waves-effect"><a href="<%=contextPath%>/searchboard.ad?currentPage=<%= currentPage + 1 %>&category=<%= category %>&keyword=<%=keyword%>"><i class="material-icons">chevron_right</i></a></li>
					</ul>
					<% } %>
				</div>
				
				<% } %>
			
				

			</div>
		</div>
	</div>
	
	
	
	
	 <!-- Modal -->
	<% for(int i = 0; i < list.size(); i++) { %>
	<div class="modal fade" id="exampleModal<%= i %>" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true"
		style="background: none; box-shadow: 0 0px 0px 0px rgba(0, 0, 0, 0.14), 0 0px 0px 0px rgba(0, 0, 0, 0.12), 0 0px 0px 0px rgba(0, 0, 0, 0.2);">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel"><%= list.get(i).getWriter() %>님의 게시글정보</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="<%=contextPath%>/reply.ad" method="post">
						<table class="highlight">
							<thead>
								<tr>
									<th style="width: 35%; text-align: center;">제목</th>
									<th style="width: 35%; text-align: center;">작성자</th>
									<th style="width: 30%; text-align: center;">작성일</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td style="width: 35%; text-align: center;"><%=list.get(i).getBoardTitle()%></td>
									<td style="width: 35%; text-align: center;"><%=list.get(i).getWriter() %></td>
									<td style="width: 30%; text-align: center;"><%=list.get(i).getCreateDate()%></td>
								</tr>
								<tr>
									<td colspan="3"></td>
								</tr>
								<tr>
									<th colspan="3" style="width: 100%;">게시글 내용</th>
								</tr>
								<tr>
									<td colspan="3" >
										<textarea style="resize:none; height:150px;" readonly><%=list.get(i).getBoardContent()%></textarea>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
	<% } %>
    
	
	
	
</body>


<script>

	/* $(function() {
		$(".search-tool input").hover(function(){
			$(".search-tool i").css("border-bottom":"5px solid green");
		},function() {
			$(".search-tool i").css("border-bottom":"rgba(20,20,20,0.5)");
		})
	}) */


	function deleteMember() {
		
		const del = 'input[name="checkBox"]:checked';
		const delMember = document.querySelectorAll(del);
		
		let result = '';
		
		delMember.forEach((el) => {
			result += el.value + ',';
		})
		$("#result").val(result);
		
		$("#delCheck2").css("display", "block");
	    $("#delCheck1").css("display", "none");
	}
	
	
	$(function() {
		$("#checkAll").click(function() {
			var isChecked = $(this).prop("checked");
			$("input[type='checkbox']").prop("checked", isChecked);
		});
	});

</script>

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

<%@ page import="java.util.ArrayList, com.semi.pet.model.vo.Pet, com.semi.common.model.vo.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	
	ArrayList<Pet> list = (ArrayList<Pet>) request.getAttribute("list");
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
	href="views/7H_The_Town/resource/CSS,JS/adminPage/AdminPagePetControll.css">
<script src="views/7H_The_Town/resource/CSS,JS/header_My.js"></script>
<script
	src="views/7H_The_Town/resource/CSS,JS/materialize/js/materializeCuteBtn.js"></script>
<script
	src="views/7H_The_Town/resource/CSS,JS/materialize/js/materialize.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<title>7H THE TOWN | 반려동물 관리</title>
</head>

<body>

	<%@ include file="/views/common/Header.jsp" %>
	
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
					<span>유기 동물 관리</span>
				</div>
				<div class="board-wrap">
					<div class="board-top">
						<div class="board-search">
							<div class="category"></div>
							<div class="search"></div>
						</div>
					</div>
					<div class="board-list"></div>
				</div>
				<form class="admin-info1 ol s12 m2 z-depth-2" action="<%=contextPath%>/delete.p" method="post">
					<div class="info1-wrap">
						<div class="info1-userinfo">
							<table class="highlight">
								<thead>
									<tr>
										<td style="width: 10%;">
											<label class="delArea"> 
												<input type="checkbox" id="selectAllBtn" class="check-btn" onclick="selectAll();"> 
												<span></span>
											</label>
										</td>
										<td style="width: 30%; text-align: center;">이름</td>
										<td style="width: 30%; text-align: center;">종</td>
										<td style="width: 15%; text-align: center;">나이</td>
										<td style="width: 15%; text-align: center;">성별</td>
									</tr>
								</thead>
								<tbody>
									<% if (list.isEmpty()) { %>
									<tr>
										<td colspan="6">조회된 리스트가 없습니다.</td>
									</tr>
									<% } else { %> 
										<% int i = 0; %>
										<% for (Pet p : list) { %>
									<tr>
										<td>
											<label> <%-- 
												<input type="hidden"  value="<%=p.getPetNo() %>"> --%>
												<input type="checkbox" name="rowCheck" value="<%=p.getPetNo() %>" class="rowCheck-btn" id=checkItem>
												<span></span> 
											</label>
										</td>

										<td><%=p.getPetName()%></td>
										<td><%=p.getPetKind()%></td>
										<td><%=p.getPetAge()%></td>
										<td><%=p.getPetGender()%></td>
										<% i++; %>
									</tr>
										<% } %>
									<% } %>
									
								</tbody>
							</table>
							<div class="btn-wrap">
								<input type="hidden" name="petNo" id="result">
								<a id="delCheck1" class="waves-effect waves-light btn" onclick="del();">삭제하기</a>
								<button type="submit" id="delCheck2" class="waves-effect waves-light btn" style="display:none;">삭제하기</button>
								<a href="<%=contextPath%>/insert.p" class="waves-effect waves-light btn" onclick="insert();">작성하기</a>
							</div>
						</div>
						
						
					</div>
				</form>
				
				<div style="display:flex; justify-content:center; margin-top:50px;" >
					<ul class="pagination" style="align-items: center; margin:auto;">
					<% if(currentPage != 1)  {%>
					    <li class="disabled"><a href="<%=contextPath %>/pet.ad?currentPage=<%=currentPage -1 %>"><i class="material-icons">chevron_left</i></a></li>
				    <% } %>
				    
			    	<% for(int p = startPage; p <= endPage; p++) { %>
				    <% if(p != currentPage){ %>
					    <li class="waves-effect"><a href="<%=contextPath%>/pet.ad?currentPage=<%= p %>"><%= p %></a></li>
				    <% } else { %>
				    	<li class="active"><a href="<%=contextPath%>/pet.ad?currentPage=<%= p %>"><%= p %></a></li>
			    	<% } %>
					<% } %>
					<% if(maxPage == 0) maxPage=1; %>
					<% if(currentPage != maxPage) { %>
					    <li class="waves-effect"><a href="<%=contextPath%>/pet.ad?currentPage=<%= currentPage + 1 %>"><i class="material-icons">chevron_right</i></a></li>
					</ul>
					<% } %>
				</div>
			</div>
		</div>
	</div>

	<script>
		
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
		

		function selectOne(){
		    const all = document.getElementById("selectAllBtn");
		    const one = document.querySelectorAll('input[class="checkGetNo"]');

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
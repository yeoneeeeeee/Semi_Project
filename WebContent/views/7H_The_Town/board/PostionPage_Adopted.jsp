<%@ page import="java.util.ArrayList, com.semi.board.model.vo.Board, com.semi.common.model.vo.PageInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>7H THE TOWN | 게시판(입양후기)</title>
	<link rel="icon" type="image/png" sizes="32x32" href="views/7H_The_Town/resource/img/favicon-32x32.png">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/fonts/fonts.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materialize.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/header.css">
    <script src="views/7H_The_Town/resource/CSS,JS/header.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/footer.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/board/Board.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeBtn.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
    <%@ include file= "/views/common/Header.jsp" %>
    <div class="main_title_wrap ani-slide">
        <h2 class="main_tlt_txt">입양 후기 게시판</h2>
    </div>
	<div class="board_wrap ani-slide">
        <div class="board_top_list">
            <li ><a href="list.lo">공지사항 및 이벤트</a></li>
            <li><a href="list.bo">자유게시판</a></li>
            <li><a href="list.yo">나눔 게시판</a></li>
            <li style="background-color: rgb(255, 216, 144);"><a href="list.no">입양후기 게시판</a></li>
        </div>
        <div class="board_title">
            <form id="searchForm" action="<%= contextPath%>/search.bo" method="post">
            <select id="category_select" name="category_select" class="ct_select" style="width:100px;">
                <option value="stitle" required>제목</option>
                <option value="snum">번호</option>
                <option value="swirter">작성자</option>
            </select>
            <input type="text" id="search" name="search" style="width: 200px; height: 30px; border: 1px solid lightgray; background: white; border-radius: 5px;" placeholder="검색하기">
        </form>
        </div>
        <script>
	        $(document).ready(function() {
	            $("#search").keydown(function(key){
	                if (key.keyCode == 13) {
	                	$("#searchForm").submit();
	                	console.log("엔터침");
	    			}
	             })
	           });
        </script>
        <div class="board_list_wrap_body col s12 m2 z-depth-2">
            <div class="board_list_wrap">
                <div class="board_list">
                    <div class="top">
                        <div class="num">번호</div>
                        <div class="title">제목</div>
                        <div class="writer">작성자</div>
                        <div class="date">작성일</div>
                        <div class="count">조회수</div>
                    </div>
                    
                    <%for(Board b : list){ %>
                    <%if(b.getBoardCategory().equals("입양후기")){ %>
	                <div class="board_list_gle">
                        <div class="num" data-bno="<%=b.getBoardNo() %>"><%=b.getRnum() %></div>
                        <div class="title"><%=b.getBoardTitle() %></div>
                        <div class="writer"><%=b.getWriter() %></div>
                        <div class="date"><%=b.getCreateDate() %></div>
                        <div class="count"><%=b.getCount() %></div>
                    </div>
                    <%} %>
                    <%} %>
				</div>
                <div class="bt_wrap">
                    <a href="post.bo">글쓰기</a>
                </div>
            </div>
            </div>
			<div style="display:flex; justify-content:center; margin-top:50px; margin-bottom:200px;" >
				<ul class="pagination" style="align-items: center; margin:auto;">
				<% if(currentPage != 1)  {%>
				    <li class="disabled"><a href="<%=contextPath %>/list.no?currentPage=<%=currentPage -1 %>"><i class="material-icons">chevron_left</i></a></li>
			    <% } %>
			    
			   	<% for(int p = startPage; p <= endPage; p++) { %>
			    <% if(p != currentPage){ %>
				    <li class="waves-effect"><a href="<%=contextPath%>/list.no?currentPage=<%= p %>"><%= p %></a></li>
			    <% } else { %>
			    	<li class="active"><a href="<%=contextPath%>/list.no?currentPage=<%= p %>"><%= p %></a></li>
			   	<% } %>
				<% } %>
				<% if(maxPage == 0) maxPage=1; %>
				<% if(currentPage != maxPage) { %>
				    <li class="waves-effect"><a href="<%=contextPath%>/list.no?currentPage=<%= currentPage + 1 %>"><i class="material-icons">chevron_right</i></a></li>
				</ul>
				<% } %>
			</div>
		<script>
			$(function(){
				$(".board_list_gle").click(function(){
					const bno = $(this).children().eq(0).data("bno");
					location.href="<%= contextPath%>/detail.bo?bno="+bno;
				})
			});
		</script>
	</div>
    <%@ include file ="/views/common/Footer.jsp" %>
</body>










</html>
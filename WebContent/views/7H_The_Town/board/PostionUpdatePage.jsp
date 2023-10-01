<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.semi.board.model.vo.*, java.util.ArrayList" %>
<%	Board b = (Board)request.getAttribute("b"); 
	ArrayList<Attachment> list = (ArrayList<Attachment>)request.getAttribute("list");
	Attachment at = (Attachment)request.getAttribute("at");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>7H THE TOWN | 게시글 수정</title>
	<link rel="icon" type="image/png" sizes="32x32" href="views/7H_The_Town/resource/img/favicon-32x32.png">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/fonts/fonts.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materialize.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/header.css">
    <script src="views/7H_The_Town/resource/CSS,JS/header.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/footer.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/board/PostingPage.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeBtn.css">

</head>
<body>
    
    <%@ include file= "/views/common/Header.jsp" %>
    <div class="main_posting_wrap">
        <h2 class="posting_title">게시글 수정</h2>
        <form action="<%=contextPath %>/postUpdate.bo" method="post" enctype="multipart/form-data">
        	<input type="hidden" name="bno" value="<%= b.getBoardNo() %>">
        	<input type="hidden" name="userNo" value="<%= loginUser.getUserNo() %>">
            <div class="category_head">
                <select name="category" class="category_select">
                    <option value="일반게시판">일반게시판</option>
                    <option value="나눔게시판">나눔게시판</option>
                    <option value="공지사항">공지사항</option>
                    <option value="입양후기">입양후기게시판</option>
                </select>
                <div class="category_title"><input type="text" name="title" id="title" placeholder="수정 전: <%=b.getBoardTitle()%>" required style="height: 58px;"></div>
            </div>
            <div class="category_text">
                <textarea name="text" id="text" style="resize: none;"><%=b.getBoardContent() %></textarea>
            </div>
            <div class="attc">
            	
                <input type="file" id ="file1" name="reUpfile1"  style="width:250px;">
            
				<input type="file" id ="file2" name="reUpfile2"  style="width:250px;">            
            
				<input type="file" id ="file3" name="reUpfile3"  style="width:250px;">
            </div>
            <button align="center" class="category_sumt">수정하기</button>
        </form>
    </div>
    <%@ include file ="/views/common/Footer.jsp" %>
</body>










</html>
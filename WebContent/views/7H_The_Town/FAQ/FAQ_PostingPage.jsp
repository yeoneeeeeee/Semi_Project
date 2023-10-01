<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.semi.board.model.vo.*" %>
<%	FAQ f = (FAQ)request.getAttribute("f"); 
	
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>7H THE TOWN | 문의글 작성</title>
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
        <h2 class="posting_title">문의글 등록</h2>
        <form action="<%=contextPath %>/faqpost.bo" method="post" enctype="multipart/form-data">
        	<input type="hidden" name="userNo" value="<%= loginUser.getUserNo() %>">
            <div class="category_head">
                <select name="category" class="category_select">
                    <option value="입양문의">입양문의</option>
                    <option value="후원문의">후원문의</option>
                    <option value="기타문의">기타문의</option>
                </select>
                <div class="category_title"><input type="text" name="title" id="title" placeholder="제목" required style="height: 60px;"></div>
            </div>
            <div class="category_text">
                <textarea name="text" id="text" style="resize: none;" placeholder="내용 작성"></textarea>
            </div>
           
            <button align="center" class="category_sumt">문의하기</button>
        </form>
    </div>
    <script>
    	
    </script>
    <%@ include file="/views/7H_The_Town/Footer.jsp" %>
</body>










</html>
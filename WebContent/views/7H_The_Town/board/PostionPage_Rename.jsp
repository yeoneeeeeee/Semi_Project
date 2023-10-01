<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <form>
            <div class="category_head">
                <select name="board_category" class="category_select">
                    <option>일반 게시판</option>
                    <option>나눔 게시판</option>
                    <option>공지사항</option>
                    <option>입양후기 게시판</option>
                </select>
                <div class="category_title"><input type="text" name="title" placeholder="제목" required></div>
            </div>
            <div class="category_text">
                <textarea name="text" style="resize: none;" placeholder="내용 작성"></textarea>
            </div>
            <div class="category_text attc">
                <input type="file" name="fileupload">
            </div>
            <button type="submit" align="center" class="category_sumt">수정하기</button>
        </form>

    </div>
    <%@ include file ="/views/common/Footer.jsp" %>
</body>










</html>
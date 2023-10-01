<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.semi.board.model.vo.*" %>
<%	Board b = (Board)request.getAttribute("b"); 
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>7H THE TOWN | 게시글 등록</title>
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
        <h2 class="posting_title">게시글 등록</h2>
        <form action="<%=contextPath %>/post.bo" method="post" enctype="multipart/form-data">
        	<input type="hidden" name="userNo" value="<%= loginUser.getUserNo() %>">
            <div class="category_head">
                <select name="category" class="category_select">
                    <option value="일반게시판">자유게시판</option>
                    <option value="나눔게시판">나눔게시판</option>
                    <option value="입양후기">입양후기게시판</option>
                </select>
                <div class="category_title"><input type="text" name="title" id="title" placeholder="제목" required style="height: 60px;"></div>
            </div>
            <div class="category_text">
                <textarea name="text" id="text" style="resize: none;" placeholder="내용 작성"></textarea>
            </div>
            <div class="attc">
            	<input type="file" id ="file1" name="file1" onchange ="loadImg(this,1)" style="width:250px;">
            
				<input type="file" id ="file2" name="file2" onchange ="loadImg(this,2)" style="width:250px;">            
            
				<input type="file" id ="file3" name="file3" onchange ="loadImg(this,3)" style="width:250px;">
            </div>
            <button align="center" class="category_sumt">등록하기</button>
        </form>
    </div>
    <script>
	    function loadImg(inputFile, num){
			//inputFile : 현재 변화가 생긴 input type="file"요소 객체
			//num : 몇번째 input요소인지 확인 후 해당영역에 미리보기하기 위한 매개변수
			
			/*
				파일 선택시 길이는 1, 파일선택 취소시 길이는 0
				length속성을 활용해서 인풋태그에 파일 존재유무를 확인할 수 있다.
			*/
			if(inputFile.files.length == 1){
				// 파일을 읽어들일 수 있는 자바스크립트 내장객체 FileReader객체 생성
				const reader = new FileReader();
				
				// 파일을 읽어들이는 메소드 => 매개변수로 어느파일을 읽어들일건지 선택해줘야함.
				reader.readAsDataURL(inputFile.files[0]);
				
				reader.onload = function(e){//event의 target.result에 각 파일의 url가 담김
					// 각 영역에 맞춰서 이미지 미리보기
					switch(num){
					case 1: $("#file1").attr("src",e.target.result); break;
					case 2: $("#file2").attr("src",e.target.result); break;
					case 3: $("#file3").attr("src",e.target.result); break;
					}
				}
			}
	    }
    </script>
    <%@ include file ="/views/common/Footer.jsp" %>
</body>










</html>
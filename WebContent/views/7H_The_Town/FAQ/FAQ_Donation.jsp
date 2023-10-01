<%@ page import="java.util.ArrayList, com.semi.board.model.vo.FAQ, com.semi.common.model.vo.PageInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<FAQ> list = (ArrayList<FAQ>)request.getAttribute("list");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>7H THE TOWN | FAQ(후원)</title>
	<link rel="icon" type="image/png" sizes="32x32" href="views/7H_The_Town/resource/img/favicon-32x32.png">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/fonts/fonts.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materialize.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/header.css">
    <script src="views/7H_The_Town/resource/CSS,JS/header.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/footer.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/FAQ/FAQ.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeBtn.css">
</head>
<body>
    <%@ include file= "/views/common/Header.jsp" %>
    <div class="main_title_wrap ani-slide">
        <h2 class="main_tlt_txt">후원 문의</h2>
    </div>
	<div class="board_wrap ani-slide">
        <div class="board_top_list">
            <li ><a href="faqPetList.bo">입양문의</a></li>
            <li style="background-color: rgb(255, 216, 144);"><a href="faqDonaList.bo">후원문의</a></li>
            <li ><a href="faqEtcList.bo">기 타</a></li>
        </div>
        <div class="board_title">
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
        <div class="board_list_wrap_body">
        	<div class="question">Q. 정기후원과 일시후원의 차이는 뭔가요?</div>
		    <p class="answer">A.<br>정기후원은 결제일 기준으로 매달 해당 날짜에 자동결제됩니다.</p>
		
		    <div class="question">Q. 후원을 했는데 포인트가 생겼어요. 포인트는 어디에 쓰는건가요?</div>
		    <p class="answer">A.<br>포인트를 통해 분양시에 자동차감되어 사용되거나,<br>
		    저희 센터에 직접 연락주시면 현금으로 포인트백해드리기도 합니다</p>
		
		    <div class="question">Q. 후원하는데 멤버등급이 있는건 처음보네요. 왜 있나요?</div>
		    <p class="answer">A.<br>후원하시는 분들이 조금이라도 기분좋아지게끔<br>
		    후원등급에 따라 분기별로 소정의 유기견 악세사리를 보내드리고 있습니다.<br>
		    해당 시스템을 도입한 후 후원이 소폭 늘어나는 효과도 있었습니다.</p>
		
		    <div class="question">Q. 후원금은 어디에 쓰이나요?</div>
		    <p class="answer">A.<br>유기견 구조 및 유기견 보호에 쓰이며<br>
		    동시에 길거리 고양이 개체수 조절등의 일에도 쓰이는 등 여러 길거리 동물을 위해 사용됩니다.</p>
		
		    <div class="question">Q. 후원해주세요</div>
		    <p class="answer">A.<br>제발요</p>
        </div>
        
		<script>
			$(function(){
				$(".board_list_gle").click(function(){
					const bno = $(this).children().eq(0).data("bno");
					location.href="<%= contextPath%>/faqDetail.bo?bno="+bno;
				})
			});
			
			$(function(){
	            $(".question").click(function(){
	                const answer = $(this).next(); 
	                if(answer.css("display") == "none"){
	                	answer.slideDown().siblings("p").slideUp();
	                }else{
	                	answer.slideUp(500);
	                }
	            });
	        });
		</script>
	</div>
    <%@ include file="/views/7H_The_Town/Footer.jsp" %>
</body>










</html>
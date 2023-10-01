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
	<title>7H THE TOWN | FAQ(기타)</title>
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
        <h2 class="main_tlt_txt">기타 문의</h2>
    </div>
	<div class="board_wrap ani-slide">
        <div class="board_top_list">
            <li ><a href="faqPetList.bo">입양문의</a></li>
            <li ><a href="faqDonaList.bo">후원문의</a></li>
            <li style="background-color: rgb(255, 216, 144);"><a href="faqEtcList.bo">기 타</a></li>
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
        	<div class="question">Q. 전화 통화 가능한 시간을 알려주세요</div>
		    <p class="answer">A.<br>1대1 상담문의를 주시면 24시간 내에 답변드리겠습니다<br>
		    혹은 하단의 전화번호로 연락주세요. <br>
		    02)1234 - 5678</p>
		
		    <div class="question">Q. 게시판에서 판매행위를 하는 사람이 있습니다</div>
		    <p class="answer">A.<br>게시판 내의 신고하기를 이용하시면 24시간 내에 글삭제 등의 적절한 대처를 해드립니다.</p>
		
		    <div class="question">Q. 나눔게시판에서 나눔하기로 한 사람이 나타나질 않습니다</div>
		    <p class="answer">A.<br>나눔은 개인회원들간의 이루어지는 자율적 행위이기에 <br>
		    저희가 나눔약속을 완전하게 보장해드릴 수는 없습니다.<br>
		    다만, 지속적으로 신고가 누적된 회원은 향후 게시판이용이 제한되기에<br>
		    문제 발생시 지체없이 바로 신고해주시면 감사하겠습니다.</p>
		
		    <div class="question">Q. 누가 이렇게 잘 만들었나요</div>
		    <p class="answer">A.<br>저희가 좀 칩니다</p>
		
		    <div class="question">Q. 세미 프로젝트 드디어 끝났다!!!</div>
		    <p class="answer">A.<br>독터조 너무 잘했다</p>
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
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
	<title>7H THE TOWN | FAQ(입양)</title>
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
        <h2 class="main_tlt_txt">입양 문의</h2>
    </div>
	<div class="board_wrap ani-slide">
        <div class="board_top_list">
            <li style="background:rgb(255, 216, 144);"><a href="faqPetList.bo">입양문의</a></li>
            <li><a href="faqDonaList.bo">후원문의</a></li>
            <li><a href="faqEtcList.bo">기 타</a></li>
        </div>
        <div class="board_title">
        </div>
        
        
        <div class="board_list_wrap_body">
        	<div class="question">Q. 유기견인데 입양비는 왜 받는건가요?</div>
		    <p class="answer">A.<br> 무료 분양시 무분별하게 분양을 받으신 후 <br>
		    책임감없이 기르시다가 다시 버리시는 분들이 간혹 발생하였습니다.<br>
		    또 다시 버림받는 경우 반려동물은 처음보다도 큰 정신적 피해를 입어<br>
		    정상적인 생활이 힘들어지기에 이러한 불상사를 막기위해 소액의 분양금을 받기 시작하였습니다. </p>
		
		    <div class="question">Q. 파양은 가능한가요?</div>
		    <p class="answer">A.<br>또 다시 버림받는 경우 반려동물은 처음보다도 큰 정신적 피해를 입어<br>
		    정상적인 생활이 힘들어지기에 절대 불가능합니다.</p>
		
		    <div class="question">Q. 입양을 하려면 어떻게 해야하나요?</div>
		    <p class="answer">A.<br>Get The Pet 페이지에서 현재 보호소에 있는 반려동물의 <br>
		    목록을 볼 수 있습니다. 해당 페이지에서 원하는 반려동물을 입양신청하신 후<br>
		    결제완료를 하신다면 상담사분께서 연락을 드릴 것입니다.</p>
		
		    <div class="question">Q. 반려동물 입양 시 데려다주시기도 하나요?</div>
		    <p class="answer">A.<br>네, 입양 시 배송을 선택하시면 저희 직원분께서 자가용 차량을 이용하여<br>
		    강아지 전용좌석에 탑승시킨 후 안전하게 데려다드립니다.</p>
		
		    <div class="question">Q. 입양할 반려동물을 직접 눈으로 보고 정하고 싶은데 가능한가요?</div>
		    <p class="answer">A.<br>네, 저희 보호소로 찾아오시면 직접 보실 수 있습니다.<br>
		    원하신다면 서약서 작성 후 바로 데려가실 수도 있습니다.<br>
		    주소 : 서울특별시 강남구 테헤란로14길 6 남도빌딩 3F, 4F, 5F</p>
        </div>
    
	</div>
	
	
    <%@ include file="/views/7H_The_Town/Footer.jsp" %>
    
    <script>
    	
    	$(document).ready(function() {
	        $("#search").keydown(function(key){
	            if (key.keyCode == 13) {
	            	$("#searchForm").submit();
	            	console.log("엔터침");
				}
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
        
		$(function(){
			$(".board_list_gle").click(function(){
				const bno = $(this).children().eq(0).data("bno");
				location.href="<%= contextPath%>/faqDetail.bo?bno="+bno;
			})
		});
	</script>
    
    
</body>
</html>
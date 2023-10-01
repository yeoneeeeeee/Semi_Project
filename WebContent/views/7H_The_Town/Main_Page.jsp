<%@ page import="java.util.ArrayList, com.semi.board.model.vo.GetThePet, com.semi.common.model.vo.PageInfo,
			com.semi.pet.model.vo.Pet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<GetThePet> gList = (ArrayList<GetThePet>)request.getAttribute("gList");
	ArrayList<Pet> pList = (ArrayList<Pet>) request.getAttribute("pList");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	int oneLength = pList.size();
	
	int fakeCount = pi.getListCount()*1592;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>7H THE TOWN</title>
	<link rel="icon" type="image/png" sizes="32x32" href="views/7H_The_Town/resource/img/favicon-32x32.png">
	<link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/fonts/fonts.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materialize.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/header.css">
    <script src="views/7H_The_Town/resource/CSS,JS/header.js"></script>
	<link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/footer.css">
	<link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/petlist.css">
	<link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeBtn.css">
	<link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/main_pg.css">
</head>
<body>
 
 	<%@ include file="/views/common/Header.jsp" %>

    <div class="outer">

        

        <div class="main_pg_wrap section1" style="background-image: url(views/7H_The_Town/resource/img/메인페이지1.jpg);">
            <h4 class=" ani-slide">
                7H THE TOWN
            </h4>
            <p class=" ani-slide">
                후원 ．입양 ．나눔
            </p>
        </div>

        <div class="main_pg_wrap section2" style="
    	background-image: linear-gradient(rgba(255, 255, 255, 0.3),
        rgba(0, 0, 0, 0.5)), url(views/7H_The_Town/resource/img/메인페이지2.jpg);">
        	<div class="slide-effect" style="">
	            <p class="petMent">개더타운에서 구조한 반려동물</p><br>
	            <p class="petCount" id="countTarget">0</p><p class="petMent2">마리</p>
            </div>
        </div>
        
        <div class="main_pg_wrap section4">
            <div class="petListBox">
            	<div class="slide-effect">
            		<h4>개더타운의 주민들</h4>
            	</div>
            	
            	<% if(pList == null || pList.size() == 0) {%>
            	<% }else{ %>
                <% int i = 0; %>
                <div class="petBoxLine slide-effect">
                	<% if(pList.size() > 4){ %>
                		<% for(; i < 4; i++) {%>
                        <div class="petBoxOne">
                            <div class="textAlignCenter petImage">
                            	<% if(gList.get(i).getThumbnail() == null) {%>
                            	<a href="<%=contextPath%>/detail.get?bno=<%=gList.get(i).getGetNo()%>">
    		                    	<img src="views/7H_The_Town/resource/img/7H_THE_TOWN_LOGO.png" alt="" width="300px" height="300px">
    		                    </a>
    		                    <% } else {%>
    		                    <a href="<%=contextPath%>/detail.get?bno=<%=gList.get(i).getGetNo()%>">
    		                    	<img src="<%= gList.get(i).getThumbnail()%>" alt="" width="300px" height="300px">
    		                    </a>
    		                    <% } %>
                            </div>
                            <div class="textAlignCenter petInformation">
                                <p><%=pList.get(i).getPetKind() %></p>
                                <p><%=pList.get(i).getPetName() %></p>
                            </div>
                        </div>
                        <% }
                	} else {
                		
	                	for(; i < pList.size(); i++) {%>
	                    <div class="petBoxOne">
	                        <div class="textAlignCenter petImage">
	                        	<% if(gList.get(i).getThumbnail() == null) {%>
	                        	<a href="<%=contextPath%>/detail.get?bno=<%=gList.get(i).getGetNo()%>">
			                    	<img src="views/7H_The_Town/resource/img/7H_THE_TOWN_LOGO.png" alt="" width="300px" height="300px">
			                    </a>
			                    <% } else {%>
			                    <a href="<%=contextPath%>/detail.get?bno=<%=gList.get(i).getGetNo()%>">
			                    	<img src="<%= gList.get(i).getThumbnail()%>" alt="" width="300px" height="300px">
			                    </a>
			                    <% } %>
	                        </div>
	                        <div class="textAlignCenter petInformation">
	                            <p><%=pList.get(i).getPetKind() %></p>
	                            <p><%=pList.get(i).getPetName() %></p>
	                        </div>
	                    </div>
	                    <% } %>
                	<% } %>
                </div>
                
                <div class="petBoxLine slide-effect">
	                <% if( pList.size() > 4 && pList.size() <8) {%>
		                <% for(; i < pList.size(); i++) {%>
	                    <div class="petBoxOne">
	                        <div class="textAlignCenter petImage">
	                        	<% if(gList.get(i).getThumbnail() == null) {%>
	                        	<a href="<%=contextPath%>/detail.get?bno=<%=gList.get(i).getGetNo()%>">
			                    	<img src="views/7H_The_Town/resource/img/7H_THE_TOWN_LOGO.png" alt="" width="300px" height="300px">
			                    </a>
			                    <% } else {%>
			                    <a href="<%=contextPath%>/detail.get?bno=<%=gList.get(i).getGetNo()%>">
			                    	<img src="<%= gList.get(i).getThumbnail()%>" alt="" width="300px" height="300px">
			                    </a>
			                    <% } %>
	                        </div>
	                        <div class="textAlignCenter petInformation">
	                            <p><%=pList.get(i).getPetKind() %></p>
	                            <p><%=pList.get(i).getPetName() %></p>
	                        </div>
	                    </div>
	                    <% } %>
                    <% } else if(pList.size() >= 8){%>
                    	<% for(; i < 8; i++) {%>
	                    <div class="petBoxOne">
	                        <div class="textAlignCenter petImage">
	                        	<% if(gList.get(i).getThumbnail() == null) {%>
	                        	<a href="<%=contextPath%>/detail.get?bno=<%=gList.get(i).getGetNo()%>">
			                    	<img src="views/7H_The_Town/resource/img/7H_THE_TOWN_LOGO.png" alt="" width="300px" height="300px">
			                    </a>
			                    <% } else {%>
			                    <a href="<%=contextPath%>/detail.get?bno=<%=gList.get(i).getGetNo()%>">
			                    	<img src="<%= gList.get(i).getThumbnail()%>" alt="" width="300px" height="300px">
			                    </a>
			                    <% } %>
	                        </div>
	                        <div class="textAlignCenter petInformation">
	                            <p><%=pList.get(i).getPetKind() %></p>
	                            <p><%=pList.get(i).getPetName() %></p>
	                        </div>
	                    </div>
                    	<% } %>
                    <% } %>
                </div>
                <div class="petBoxLine slide-effect">
	                <% if( pList.size() > 8 && pList.size() <12) {%>
		                <% for(; i < pList.size(); i++) {%>
	                    <div class="petBoxOne">
	                        <div class="textAlignCenter petImage">
	                        	<% if(gList.get(i).getThumbnail() == null) {%>
	                        	<a href="<%=contextPath%>/detail.get?bno=<%=gList.get(i).getGetNo()%>">
			                    	<img src="views/7H_The_Town/resource/img/7H_THE_TOWN_LOGO.png" alt="" width="300px" height="300px">
			                    </a>
			                    <% } else {%>
			                    <a href="<%=contextPath%>/detail.get?bno=<%=gList.get(i).getGetNo()%>">
			                    	<img src="<%= gList.get(i).getThumbnail()%>" alt="" width="300px" height="300px">
			                    </a>
			                    <% } %>
	                        </div>
	                        <div class="textAlignCenter petInformation">
	                            <p><%=pList.get(i).getPetKind() %></p>
	                            <p><%=pList.get(i).getPetName() %></p>
	                        </div>
	                    </div>
	                    <% } %>
                    <% } else if(pList.size() >= 12){%>
                    	<% for(; i < 12; i++) {%>
	                    <div class="petBoxOne">
	                        <div class="textAlignCenter petImage">
	                        	<% if(gList.get(i).getThumbnail() == null) {%>
	                        	<a href="<%=contextPath%>/detail.get?bno=<%=gList.get(i).getGetNo()%>">
			                    	<img src="views/7H_The_Town/resource/img/7H_THE_TOWN_LOGO.png" alt="" width="300px" height="300px">
			                    </a>
			                    <% } else {%>
			                    <a href="<%=contextPath%>/detail.get?bno=<%=gList.get(i).getGetNo()%>">
			                    	<img src="<%= gList.get(i).getThumbnail()%>" alt="" width="300px" height="300px">
			                    </a>
			                    <% } %>
	                        </div>
	                        <div class="textAlignCenter petInformation">
	                            <p><%=pList.get(i).getPetKind() %></p>
	                            <p><%=pList.get(i).getPetName() %></p>
	                        </div>
	                    </div>
                    	<% } %>
                    <% } %>
                    <% } %>
                </div>
            </div>
        </div>
        
        
        <div class="main_pg_wrap section3" style="">
	        <h4 class="slide-effect">이 순간에도 많은 반려동물들이 버림받고 있습니다.</h4>
            <div class="section3_wrap slide-effect">
                <iframe class="col s12 m2 z-depth-5" width="1520" height="855" src="https://www.youtube.com/embed/OqJRH3JfiXs" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
            </div>
            <div class="section3_wrap3 slide-effect">
                <div class="section3_content1">
    				<img class="section3_content1 col s12 m2 z-depth-4" src="views/7H_The_Town/resource/img/유기견기사5.png" width="400" height="600">
    				<h4>최근 5년간 '119,783' 마리의 유기견이 안락사되고 있습니다.<br> 이는 보호소에 오는 반려동물의 20%에 해당합니다.</h4>
    			</div>
                <div class="section3_content2 slide-effect">
    				<h4>게다가 매년 '116,984'<br> 마리의 반려동물이 계속해서 버려지고 있습니다. <br>유기동물 문제를 해결하기 위해서는 여러분들의 손길이 필요합니다.</h4>
    				<img class="section3_content1 col s12 m2 z-depth-4" src="views/7H_The_Town/resource/img/유기견기사2.png" width="400" height="600">
    			</div>
    			
            </div>

        </div>
        
        
    </div>

    <div class="main_pg_wrap section5 " style="
    background-image: linear-gradient(to bottom, rgba(255, 255, 255, 1), 20%,
    rgba(0, 0, 0, 0.7)),  url(views/7H_The_Town/resource/img/메인페이지7.jpg);">
    	<div class="slide-effect">
	    	<h2>상처받는 반려동물이 없는 세상을 위해 도와주세요</h2>
			<h4>한달에 커피 한잔이면 상처받는 아이들을 구할 수 있습니다</h4>
			<a href="<%=contextPath%>/donation.do">후원하기</a>
		</div>
    </div>
    
    <%@ include file="/views/7H_The_Town/Footer.jsp" %>
    
    <script>
    	$(document).on("mouseenter", ".petImage" ,function(){
            $(this).addClass("col s12 m2 z-depth-5");
        }).on("mouseleave", ".petImage", function(){
        	$(this).removeClass("col s12 m2 z-depth-5");
        });
    	
    	function countUp(target, start, end, duration) {
  	      var range = end - start;
  	      var current = start;
  	      var increment = Math.ceil(range / 30); // 100단위로 증가
  	      var stepTime = Math.abs(Math.floor(duration / range));
  	      var interval = 50; // 갱신 간격 (밀리초)
  	      var steps = Math.ceil(range / increment);
  	      var step = 0;
  	      var timer = setInterval(function () {
  	        current += increment;
  	        step++;
  	        $(target).text(current.toLocaleString()); // 숫자에 쉼표(,) 추가
  	        if (step >= steps) {
  	          clearInterval(timer);
  	          $(target).text(end.toLocaleString()); // 정확한 최종 숫자 표시
  	        }
  	      }, interval);
  	    }
  	  
    	
    	$(window).scroll(function () {
    	    
    	    // 예시: 카운트를 시작할 버튼을 클릭했을 때 호출
    	    setTimeout(function () {
    	      var targetElement = $("#countTarget");
    	      var startNumber = parseInt(targetElement.text().replace(/,/g, "")); // 쉼표(,) 제거 후 숫자 추출
    	      var endNumber = <%=fakeCount%>; // 도달할 최종 숫자
    	      var duration = 2000; // 애니메이션의 지속 시간 (밀리초)
    	      countUp(targetElement, startNumber, endNumber, duration);
    	    },1000);

    	});
    </script>
</body>
</html>
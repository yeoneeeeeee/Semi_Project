<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
	import="java.util.ArrayList, com.semi.board.model.vo.GetThePet, com.semi.common.model.vo.PageInfo,
			com.semi.pet.model.vo.Pet"%>
<% 
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<GetThePet> gList = (ArrayList<GetThePet>)request.getAttribute("gList");
	ArrayList<Pet> pList = (ArrayList<Pet>) request.getAttribute("pList");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	int oneLength = pList.size();
%>    

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>7H THE TOWN | GetThePet</title>
    <link rel="icon" type="image/png" sizes="32x32" href="views/7H_The_Town/resource/img/favicon-32x32.png">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/fonts/fonts.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materialize.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/header.css">
    <script src="views/7H_The_Town/resource/CSS,JS/header.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/footer.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/getThePet/PetList.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeCuteBtn.css">
    <script src="views/7H_The_Town/resource/CSS,JS/materialize/js/materializeCuteBtn.js"></script>
    <script src="views/7H_The_Town/resource/CSS,JS/materialize/js/materialize.js"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>

    <%@ include file="/views/common/Header.jsp" %>

    <div class="petListBox col s12 m2 z-depth-3 ani-slide">
        <h2>PET LIST</h2>
        <div class="petListSearch">
            <form action="search.get"> 
	            <button type="button" class="search" onclick="search();" style="border:none;">
	            	<img src="views/7H_The_Town/resource/img/search_Icon.png" alt="" width="20px" height="20px">
	            </button>
                <input type="text" placeholder=" 이름, 견종, 성별" id="keyword" name = "keyword"
                style="background: white; border: 2px solid rgb(190, 190, 190); border-radius: 5px; width: 170px; height: 30px;">
            </form>
        </div>
        
        
        
        
        
        <% if(0 <= oneLength && oneLength <= 4) {%>
        <% int i = 0; %>
        <div class="petBoxLine">
        	<% for(;i < oneLength; i++){ %>
            <div class="petBoxOne col s12 m2 z-depth-2">
                <div class="bottomBorder textAlignCenter">
                	<% if(gList.get(i).getThumbnail() == null) {%>
                    <img src="views/7H_The_Town/resource/img/7H_THE_TOWN_LOGO.png" alt="" width="200px" height="200px">
                    <% } else {%>
                    <img src="<%= gList.get(i).getThumbnail()%>" alt="" width="200px" height="200px">
                    <% } %>
                </div>
                <p class="pathNo" style="display:none;"><%= gList.get(i).getGetNo() %></p>
                <div class="middleBorder textAlignCenter">
                    <p><%=pList.get(i).getPetName() %></p>
                </div>
                <div class="middleBorder textAlignCenter">
                    <p><%=pList.get(i).getPetKind() %></p>
                </div>
                <div class="middleBorder textAlignCenter">
                    <p><%=pList.get(i).getPetAge() %>세</p>
                </div>
                <div class="topBorder textAlignCenter">
                    <p><%=pList.get(i).getPetGender() %></p>
                </div>
            </div>
            <% } %>
        </div>
        <% } %>
        
        
        <% if(5 <= oneLength && oneLength <= 8) {%>
        <% int i = 0; %>
	        <div class="petBoxLine">
	        	<% for(;i < 4; i++){ %>
	            <div class="petBoxOne col s12 m2 z-depth-2">
	                <div class="bottomBorder textAlignCenter">
	                    <% if(gList.get(i).getThumbnail() == null) {%>
	                    <img src="views/7H_The_Town/resource/img/7H_THE_TOWN_LOGO.png" alt="" width="200px" height="200px">
	                    <% } else {%>
	                    <img src="<%= gList.get(i).getThumbnail()%>" alt="" width="200px" height="200px">
	                    <% } %>
	                </div>
	                <p class="pathNo" style="display:none;"><%= gList.get(i).getGetNo() %></p>
	                <div class="middleBorder textAlignCenter">
	                    <p><%=pList.get(i).getPetName() %></p>
	                </div>
	                <div class="middleBorder textAlignCenter">
	                    <p><%=pList.get(i).getPetKind() %></p>
	                </div>
	                <div class="middleBorder textAlignCenter">
	                    <p><%=pList.get(i).getPetAge() %>세</p>
	                </div>
	                <div class="topBorder textAlignCenter">
	                    <p><%=pList.get(i).getPetGender() %></p>
	                </div>
	            </div>
	            <% } %>
	        </div>
	        <div class="petBoxLine">
	        	<% for(;i < oneLength; i++){ %>
	            <div class="petBoxOne col s12 m2 z-depth-2">
	                <div class="bottomBorder textAlignCenter">
	                    <% if(gList.get(i).getThumbnail() == null) {%>
	                    <img src="views/7H_The_Town/resource/img/7H_THE_TOWN_LOGO.png" alt="" width="200px" height="200px">
	                    <% } else {%>
	                    <img src="<%= gList.get(i).getThumbnail()%>" alt="" width="200px" height="200px">
                    <% } %>
	                </div>
	                <p class="pathNo" style="display:none;"><%= gList.get(i).getGetNo() %></p>
	                <div class="middleBorder textAlignCenter">
	                    <p><%=pList.get(i).getPetName() %></p>
	                </div>
	                <div class="middleBorder textAlignCenter">
	                    <p><%=pList.get(i).getPetKind() %></p>
	                </div>
	                <div class="middleBorder textAlignCenter">
	                    <p><%=pList.get(i).getPetAge() %>세</p>
	                </div>
	                <div class="topBorder textAlignCenter">
	                    <p><%=pList.get(i).getPetGender() %></p>
	                </div>
	            </div>
		        <% } %>
	        </div>
        <% } %>
        
        
        <% if(9 <= oneLength && oneLength <= 12) {%>
        <% int i = 0; %>
	        <div class="petBoxLine">
	        	<% for(;i < 4; i++){ %>
	            <div class="petBoxOne col s12 m2 z-depth-2">
	                <div class="bottomBorder textAlignCenter">
	                    <% if(gList.get(i).getThumbnail() == null) {%>
	                    <img src="views/7H_The_Town/resource/img/7H_THE_TOWN_LOGO.png" alt="" width="200px" height="200px">
	                    <% } else {%>
	                    <img src="<%= gList.get(i).getThumbnail()%>" alt="" width="200px" height="200px">
                    <% } %>
	                </div>
	                <p class="pathNo" style="display:none;"><%= gList.get(i).getGetNo() %></p>
	                <div class="middleBorder textAlignCenter">
	                    <p><%=pList.get(i).getPetName() %></p>
	                </div>
	                <div class="middleBorder textAlignCenter">
	                    <p><%=pList.get(i).getPetKind() %></p>
	                </div>
	                <div class="middleBorder textAlignCenter">
	                    <p><%=pList.get(i).getPetAge() %>세</p>
	                </div>
	                <div class="topBorder textAlignCenter">
	                    <p><%=pList.get(i).getPetGender() %></p>
	                </div>
	            </div>
		        <% } %>
	        </div>
	        <div class="petBoxLine">
	        	<% for(;i < 8; i++){ %>
	            <div class="petBoxOne col s12 m2 z-depth-2">
	                <div class="bottomBorder textAlignCenter">
	                    <% if(gList.get(i).getThumbnail() == null) {%>
	                    <img src="views/7H_The_Town/resource/img/7H_THE_TOWN_LOGO.png" alt="" width="200px" height="200px">
		                <% } else {%>
	                    <img src="<%= gList.get(i).getThumbnail()%>" alt="" width="200px" height="200px">
	                    <% } %>
	                </div>
	                <p class="pathNo" style="display:none;"><%= gList.get(i).getGetNo() %></p>
	                <div class="middleBorder textAlignCenter">
	                    <p><%=pList.get(i).getPetName() %></p>
	                </div>
	                <div class="middleBorder textAlignCenter">
	                    <p><%=pList.get(i).getPetKind() %></p>
	                </div>
	                <div class="middleBorder textAlignCenter">
	                    <p><%=pList.get(i).getPetAge() %>세</p>
	                </div>
	                <div class="topBorder textAlignCenter">
	                    <p><%=pList.get(i).getPetGender() %></p>
	                </div>
	            </div>
		        <% } %>
	        </div>
	        <div class="petBoxLine">
	        	<% for(;i < oneLength; i++){ %>
	            <div class="petBoxOne col s12 m2 z-depth-2">
	                <div class="bottomBorder textAlignCenter">
	                    <% if(gList.get(i).getThumbnail() == null) {%>
	                    <img src="views/7H_The_Town/resource/img/7H_THE_TOWN_LOGO.png" alt="" width="200px" height="200px">
	                    <% } else {%>
	                    <img src="<%= gList.get(i).getThumbnail()%>" alt="" width="200px" height="200px">
                    <% } %>
	                </div>
	                <p class="pathNo" style="display:none;"><%= gList.get(i).getGetNo() %></p>
	                <div class="middleBorder textAlignCenter">
	                    <p><%=pList.get(i).getPetName()%></p>
	                </div>
	                <div class="middleBorder textAlignCenter">
	                    <p><%=pList.get(i).getPetKind() %></p>
	                </div>
	                <div class="middleBorder textAlignCenter">
	                    <p><%=pList.get(i).getPetAge() %>세</p>
	                </div>
	                <div class="topBorder textAlignCenter">
	                    <p><%=pList.get(i).getPetGender() %></p>
	                </div>
	            </div>
	        	<% } %>
	        </div>
        <% } %>
        
        
        <div class="listBtn" align="right">
        <% if(loginUser != null && loginUser.getUserId().equals("admin")){ %>
        	<button class="insertGetBtn waves-effect waves-light btn">작성하기</button>
        <% } %>
        </div>
        <div class="listBtn" align="right">
        	<button class="seeAll waves-effect waves-light btn">전체보기</button>
        </div>
        
        
		<div style="display:flex; justify-content:center; margin-top:50px; margin-bottom:200px;" >
			<ul class="pagination" style="align-items: center; margin:auto;">
			<% if(currentPage != 1)  {%>
			    <li class="disabled"><a href="<%=contextPath %>/list.get?currentPage=<%=currentPage -1 %>"><i class="material-icons">chevron_left</i></a></li>
		    <% } %>
		    
		   	<% for(int p = startPage; p <= endPage; p++) { %>
		    <% if(p != currentPage){ %>
			    <li class="waves-effect"><a href="<%=contextPath%>/list.get?currentPage=<%= p %>"><%= p %></a></li>
		    <% } else { %>
		    	<li class="active"><a href="<%=contextPath%>/list.get?currentPage=<%= p %>"><%= p %></a></li>
		   	<% } %>
			<% } %>
			<% if(maxPage == 0) maxPage=1; %>
			<% if(currentPage != maxPage) { %>
			    <li class="waves-effect"><a href="<%=contextPath%>/list.get?currentPage=<%= currentPage + 1 %>"><i class="material-icons">chevron_right</i></a></li>
			</ul>
			<% } %>
		</div>
		
    </div>

    <%@ include file="/views/7H_The_Town/Footer.jsp" %>
    
    <script>
		$(function() {
			$(".petBoxOne").click(function() {
				location.href="<%=contextPath %>/detail.get?bno=" + $(this).children(".pathNo").text();
			})
		});
		
		$(function(){
			$(".insertGetBtn").click(function(){
				location.href="<%=contextPath %>/insert.get";
			})
		})
		
		$(function(){
			$(".seeAll").click(function(){
				location.href="<%=contextPath %>/list.get";
			})
		})
		
	</script>
</body>
</html>
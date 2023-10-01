<%@ page import="java.util.ArrayList, com.semi.board.model.vo.GetThePet, java.text.NumberFormat,
			com.semi.pet.model.vo.Pet, com.semi.board.model.vo.Attachment, com.semi.board.model.vo.Favorite"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	ArrayList<Attachment> aList = (ArrayList<Attachment>)request.getAttribute("aList");
	Pet p = (Pet) request.getAttribute("p");
	GetThePet g = (GetThePet)request.getAttribute("g");
	Favorite red = (Favorite)(request.getAttribute("red"));
%>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>7H THE TOWN | GetThePet 게시글</title>
    <link rel="icon" type="image/png" sizes="32x32" href="views/7H_The_Town/resource/img/favicon-32x32.png">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/fonts/fonts.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materialize.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/header.css">
    <script src="views/7H_The_Town/resource/CSS,JS/header.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/footer.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/getThePet/PetDetail.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeCuteBtn.css">
    <script src="views/7H_The_Town/resource/CSS,JS/materialize/js/materialize.js"></script>
</head>
<body>
    
    <%@ include file="/views/common/Header.jsp" %>
    
    <div class="petDetailOuter">
    
        <div class="petDetailBox">
            <div class="petImage col s12 m2 z-depth-2">
            	<% if(aList.size() != 0){ %>
                <img src="<%=aList.get(0).getFilePath()%><%=aList.get(0).getChangeName() %>" width="370px" height="450px" style="padding: 15px 0px;">
                <% } %>
            </div>

            <div class="petInfo col s12 m2 z-depth-2">
                <h3><%= p.getPetName() %></h3>
                <p>구조일 : <%= p.getPetRescue() %></p>
                <table>
                    <thead>
                        <tr>
                            <th>견 종</th>
                            <th>성 별</th>
                        </tr>
                        <tr>
                            <!-- 견종 -->
                            <td><%=p.getPetKind() %></td>
                            <!-- 성별 -->
                            <td><%=p.getPetGender() %></td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th>나 이</th>
                            <th>분양가</th>
                        </tr>
                        <tr>
                            <!-- 나이 -->
                            <td><%=p.getPetAge() %></td>
                            <!-- 분양가 -->
                            <% String petPrice = numberFormat.format(p.getPetPrice()); %>
                            <td><%= petPrice %></td>
                        </tr>
                    </tbody>
                </table>
                <div class="tripleButton">
                	<% if(red != null){ %>
                    	<img class="favorite" onclick="favorite();" src="views/7H_The_Town/resource/img/red_heart_Icon.png" width="40px" height="40px" alt="" style="margin: 5px 5px 5px 35px;">
                	<% }else{ %>
                    	<img class="favorite" onclick="favorite();" src="views/7H_The_Town/resource/img/heart_Icon.png" width="40px" height="40px" alt="" style="margin: 5px 5px 5px 35px;">
                	<% } %>
                    <img src="views/7H_The_Town/resource/img/share_Icon.png" width="32px" height="32px" alt="" style="margin: 8px 8px 8px 15px;">
                    <button class="adoptBtn" type="button">입양 신청</button>
                    <input type="hidden" name="petNo" value="<%=p.getPetNo()%>">
                </div>
                <div class="priceInfo">
                    <img src="views/7H_The_Town/resource/img/info_Icon.png" width="20px" height="20px" alt="">
                    <p>분양가는 반려동물이 상처받는 것을 방지하기 위해 받는 최소금액입니다.</p>
                </div>
            </div>

        </div>
        
        <div class="petDetails col s12 m2 z-depth-2">
            <% for(Attachment at : aList) {%>
                    	<img src="<%=at.getFilePath()%><%=at.getChangeName() %>" width="500px" height="500px" alt="">
                    <% } %>
            <pre><%=g.getGetContent() %></pre>
        </div>
        <div class="toPetList">
            <a href="<%=contextPath%>/list.get">목록으로</a>
        </div>

		<% if(loginUser != null && loginUser.getUserId().equals("admin")){ %>
        <div align="right">
        	<button class="updateGetBtn waves-effect waves-light btn">수정하기</button>
        	<button class="deleteGetBtn waves-effect waves-light btn">삭제하기</button>
        </div>
		<% } %>
		
    </div>

    <%@ include file="/views/7H_The_Town/Footer.jsp" %>
    
    <script>
	    $(function(){
			$(".deleteGetBtn").click(function(){
				location.href="<%=contextPath %>/delete.get?bno=<%=g.getGetNo() %>";
			})
		})
		
		$(function(){
			$(".updateGetBtn").click(function(){
				location.href="<%=contextPath %>/update.get?bno=<%=g.getGetNo() %>";
			})
		})
		
		$(function(){
			$(".adoptBtn").click(function(){
				location.href="<%=contextPath %>/adoptTerms.get?bno=<%=g.getGetNo() %>";
			})
		})
		
		
		function favorite(){
			$.ajax({
				url : "<%= contextPath%>/favorite.get",
				data : {getNo : "<%=g.getGetNo()%>"},
				success : function(result){
					if(result == 1){
						alert('최애 목록에 추가되었습니다.');
						$(".favorite").attr("src","views/7H_The_Town/resource/img/red_heart_Icon.png");
					}else if(result == 2){
						alert('최애 목록에서 삭제되었습니다.');	
						$(".favorite").attr("src","views/7H_The_Town/resource/img/heart_Icon.png");
					}else if(result == 3){
						alert('잠시 후 다시 시도해주십시오.');
					}else if(result == 4){
						alert('로그인 후 다시 시도해주십시오.');
					}
				}
			});
    	}
	</script>
	
</body>
</html>
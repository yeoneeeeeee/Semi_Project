<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.semi.board.model.vo.FAQ " %>
<%
	FAQ b = (FAQ)request.getAttribute("b");

	

	
%>
<!DOCTYPE html>
<html lang="ko">
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>7H THE TOWN | FAQ</title>
	<link rel="icon" type="image/png" sizes="32x32" href="views/7H_The_Town/resource/img/favicon-32x32.png">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/fonts/fonts.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materialize.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/header.css">
    <script src="views/7H_The_Town/resource/CSS,JS/header.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/footer.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/board/BoardContent.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeBtn.css">

</head>
<body>
	<%@ include file= "/views/common/Header.jsp" %>
    <div class="board_view_wrap">
        <div class="board_view_title">       
            <p class="content_ct_title"><%=b.getFaqTitle() %></p>
            <p class="content_ct_writer"><%=b.getWriter() %></p>
            <p class="content_ct_date"><%=b.getCreateDate() %></p> 
        </div>
        <!-- <div class="board_view_picture">
            <img src="resource/img/7H_THE_TOWN_LOGO.png" width="600" height="600">      
        </div> -->
        <div class="board_view_contents">
            <p class="board_view_contents_p"><%=b.getFaqContent() %></p>
        </div>
	</div>
    <div class="datgle">	
    </div>
    <div class="datgle_input">
        <textarea placeholder="댓글을 입력하세요." style="resize: none;" id="txt_inp"></textarea>
        <button class="datgle_put" onclick="insertReply();">댓글 등록</button>
    </div>
     <script>
	    function insertReply(){
			$.ajax({
				url : "<%= contextPath%>/rinsert.bo",
				data : {
					replyContent : $("#txt_inp").val(),
					bno : "<%= b.getFaqNo() %>"
				},
				type : "post",
				success : function(result){
					if(result >0){ 
						$("#txt_inp").val("");
						selectReply();
					}else{
						
					}
				}
			});
	    }
		function selectReply(){
			$.ajax({
				url : "rlist.bo",
				data : {bno : <%=b.getFaqNo() %>},
				success : function(list){
					let result = "";
					for(let reply of list){
						result += "<div class=" +"'board_list_gle'"+">"
								+ "<div class=" +"'view_gle'"+">"+reply.replyContent +"</div>"
								+ "<div class=" +"'view_name'"+">"+reply.userName +"</div>"
								+ "<div class=" +"'view_date'"+">"+reply.createDate +"</div>"
								+"</div>"
					}
					console.log(list, result)
					$(".datgle").html(result);
				}
			});
		}		
		selectReply();
    </script>
    <div class="bt_wrap">
        <div><a  class = "bt_a" data-category = "<%=b.getCategory() %>" onclick="listgo('<%=b.getCategory() %>');">목록으로</a></div>
        <% if(loginUser.getUserNo().equals(b.getUserNo()) || loginUser.getUserId().equals("admin")){ %>
        <a href="<%=contextPath %>/FaqUpdate.bo?bno=<%= b.getFaqNo() %>">수정하기</a>
        <a href="<%=contextPath %>/deleteFaq.ho?bno=<%= b.getFaqNo() %>">삭제하기</a>
        <%} %>
    </div>
    <script>
	    function listgo(category) {
	        if (category == "입양문의") {
	            location.href= "<%= contextPath%>/faqPetList.bo";
	        } else if(category == "후원문의"){
	        	location.href= "<%= contextPath%>/faqDonaList.bo";
	        } else{
	        	location.href= "<%= contextPath%>/faqEtcList.bo";
	        }
	    }
	</script>
    <%@ include file="/views/7H_The_Town/Footer.jsp" %>
     
</body>










</html>
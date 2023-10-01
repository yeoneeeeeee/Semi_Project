<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.semi.board.model.vo.Board, com.semi.board.model.vo.Attachment" %>
<%
	Board b = (Board)request.getAttribute("b");
	ArrayList<Attachment> list = (ArrayList<Attachment>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>7H THE TOWN | 게시글</title>
	<link rel="icon" type="image/png" sizes="32x32" href="views/7H_The_Town/resource/img/favicon-32x32.png">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/fonts/fonts.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materialize.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/header.css">
    <script src="views/7H_The_Town/resource/CSS,JS/header.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/footer.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/board/BoardContent.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeBtn.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
	<%@ include file= "/views/common/Header.jsp" %>

    <div class="board_view_wrap col s12 m2 z-depth-2">
        <div class="board_view_title">       
            <p class="content_ct_title"><%=b.getBoardTitle() %></p>
            <p class="content_ct_writer"><%=b.getWriter() %></p>
            <p class="content_ct_date"><%=b.getCreateDate() %></p>
            <a href="<%=contextPath %>/report.bo?bno=<%= b.getBoardNo() %>" class="report" style="color:darkred;">
            <i class="material-icons" style="margin-left:20px; width:30px; height:30px;">report_problem</i>
            </a>
        </div>
        <div class="board_view_picture">
			<%for (int i = 0; i <list.size(); i++) {%>
				<img src="<%=contextPath%>/<%=list.get(i).getFilePath()+list.get(i).getChangeName()%>"
					 width="600" height="600">
			<%}%>    
        </div>
        <div class="board_view_contents">
            <pre class="board_view_contents_p" style="font-size:20px; font-weight:300; font-family : 'S-CoreDream-3Light';"><%=b.getBoardContent() %></pre>
        </div>
	</div>
    <div class="datgle col s12 m2 z-depth-2" style="margin-bottom:0px;">	
    	댓글
    </div>
    <div class="datgle_input col s12 m2 z-depth-2"  style="margin-top:0px;">
        <textarea placeholder="댓글을 입력하세요." style="resize: none;" id="txt_inp"></textarea>
        <button class="datgle_put" onclick="insertReply();">댓글 등록</button>
    </div>
    <script>
	    function insertReply(){
			$.ajax({
				url : "<%= contextPath%>/rinsert.bo",
				data : {
					replyContent : $("#txt_inp").val(),
					bno : "<%= b.getBoardNo()%>"
				},
				type : "post",
				success : function(result){
					if(result >0){ 
						$("#txt_inp").val("");
						selectReply();
					}else if(result == "none"){
						alert('내용을 입력해주세요.');						
					}else if(result == "login"){
						alert('로그인 후 다시 시도해주세요.');
					}
				}
			});
			
	    }
		function selectReply(){
			$.ajax({
				url : "rlist.bo",
				data : {bno : "<%=b.getBoardNo()%>"},
				success : function(list){
					let result = "";
					for(let reply of list){
						result += "<div class=" +"'board_list_gle'"+">"
								+ "<div class=" +"'view_gle'"+">"+reply.replyContent +"</div>"
								+ "<div class=" +"'view_name'"+">"+reply.userName +"</div>"
								+ "<div class=" +"'view_date'"+">"+reply.createDate +"</div>"
								+"</div>"
					}
					console.log(list, result);
					$(".datgle").html(result);
				}
			});
		}		
		selectReply();
    </script>
    <div class="bt_wrap">
        <div><a data-category = "<%=b.getBoardCategory() %>" onclick="listgo('<%=b.getBoardCategory()%>');">목록으로</a>
        </div>
        <% if(loginUser != null ){ %>
	        <% if(loginUser.getUserNo().equals(b.getWriteNo()) || loginUser.getUserId().equals("admin")){ %>
		        <a href="<%=contextPath %>/postUpdate.bo?bno=<%= b.getBoardNo() %>">수정하기</a>
		        <a href="<%=contextPath %>/deletePost.ho?bno=<%= b.getBoardNo() %>">삭제하기</a>
	        <%} %>
        <%} %>
    </div>
    <script>
	    function listgo(category) {
	        if (category == "일반게시판") {
	            location.href= "<%= contextPath%>/list.bo";
	        } else if(category == "나눔게시판"){
	        	location.href= "<%= contextPath%>/list.yo";
	        } else if(category == "입양후기"){
	        	location.href= "<%= contextPath%>/list.no";
	        }else{
	        	location.href= "<%= contextPath%>/list.lo";
	        }
	    }
	</script>
</body>
    <%@ include file ="/views/common/Footer.jsp" %>










</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>7H THE TOWN | 쪽지 작성</title>
   	<link rel="icon" type="image/png" sizes="32x32" href="views/7H_The_Town/resource/img/favicon-32x32.png">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/fonts/fonts.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materialize.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/header.css">
    <script src="views/7H_The_Town/resource/CSS,JS/header.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/footer.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/board/PostingFAQ.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeBtn.css">

</head>
<body>
       <%@ include file="/views/common/Header.jsp" %>

   
   
    <div class="main_posting_wrap">
        <h2 class="posting_title">쪽지 등록</h2>
        <form action="<%= contextPath %>/AllPost.do" id="enroll-form" method="post" >
            </div> 
            
            
            <div class="category_head">
                <button type="button" class="waves-effect waves-light btn petNoCheck" onclick="memberNsearch()" style="position:relative; top:12px; left:235px;" >이름으로 검색</button>
                </div>
                
                <!-- <div style="height:58px; width:700px; background-color:white;">     -->
                     <!--  <textarea name="title" style="resize: none;" placeholder="쪽지 제목" style="height:58px; width:700px;" >sdsd</textarea> -->
                  <!-- </div>  -->
                  
                  
                  <div class="category_text" style="position:relative; left:-36px; bottom:10px">
                 <br> <br> <br> 
                   <input type="hidden" id="userNo" name="userNo" value="<%= loginUser.getUserNo() %>">
                <div align="center" style="margin-right:100px; margin-top:-50px;">
                <div style="position:relative; left:35px; bottom:60px">
                <input type="text" id="memberName" name="memberName" placeholder="받는 사람(회원번호) 혹은 이름 입력 후 검색" style="height:40px; width:600px;"  required>
                </div>
                <div style="position:relative; left:35px; bottom:60px">
                <textarea name="title" style="height:50px; width:600px; background-color:white;" placeholder="제목내용"></textarea>
                 </div> 
             <div class="category_text" style="position:relative; left:-4px; bottom:96px">
                <textarea name="content" style="height:250px; width:600px;" placeholder="내용 작성"></textarea>
            </div>
            <div style="position:relative; left:289px; bottom:80px">
            <input type="submit" align="right" class="waves-effect waves-light btn" value="등록하기">
            </div>
            </div> 
            
           
                </div>
                        
        </form>
        
         <script>
    
			
    	
    	function  memberNsearch(){
 			const $memberName = $("#memberName");
 			
 			$.ajax({
 				url : "<%= contextPath%>/AllPost.do",
 				data : {memberName : $memberName.val()},
 				type : "get",
 				success : function(receiverNo){
 					if(receiverNo == ""){
 						alert("존재하지 않는 회원 이름입니다.");		
 						$memberName.focus();
 					} else { // 사용가능
 						alert("회원번호는 " + receiverNo + "입니다. 회원번호를 다시 입력해주세요.");		
 						$memberName.focus();
 					}
 				}
 			});
 		  }
    </script>
    

    </div>
    
   
    <%@ include file="/views/7H_The_Town/Footer.jsp" %>
    
</body>
</html>
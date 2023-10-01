<%@ page import="com.semi.postAll.model.vo.PostAll, java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
      <%
    ArrayList<PostAll> list = (ArrayList<PostAll>)request.getAttribute("list");
    PostAll p = (PostAll)request.getAttribute("p");
    String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>7H THE TOWN | 쪽지</title>
	<link rel="icon" type="image/png" sizes="32x32" href="views/7H_The_Town/resource/img/favicon-32x32.png">
    <link rel="stylesheet" href="resources/fonts/fonts.css">
    <link rel="stylesheet" href="resources/materialize/css/materialize.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link rel="stylesheet" href="resources/css/header.css">
    <script src="resources/js/header.js"></script>
    <link rel="stylesheet" href="resources/css/footer.css">
    <link rel="stylesheet" href="resources/css/board.css">
    <link rel="stylesheet" href="resources/materialize/css/materializeBtn.css">
</head>
<body>
   
         <div class="outer">
         <br>
         <h2 align="center">공지사항 상세보기</h2>
         <br>
         
         <table id="detail-area" align="center" border="1">
            <tr>
               <th width="70">제목</th>
               <!-- <td width="350" colspan="3">공지사항 제목입니다.</td> -->
            </tr>
            <tr>
            <% if(!(list.isEmpty())){ %>
            <% for(int i = 0; i < list.size(); i++) {%>
                 <th width="70"><%= list.get(i).getPostTitle() %></th>
                 <th>작성자</th>
                <!--   <td>admin</td> -->
                <td><%= list.get(i).getReceiverNo() %></td>
                <th>작성일</th>
                   <!--  <td>2023-06-29</td> -->
                   <td><%= list.get(i).getCreateDate() %></td> 
 	           <% } %>
            <% } %>
            </tr>
             <tr>
         </table>
         <br><br>
   
        
</body>










</html>
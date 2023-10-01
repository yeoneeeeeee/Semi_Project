<%@ page import="java.util.ArrayList, com.semi.pet.model.vo.Pet, com.semi.common.model.vo.PageInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Pet> pList = (ArrayList<Pet>)(request.getAttribute("pList"));
	ArrayList<String> gList = (ArrayList<String>)(request.getAttribute("gList"));
	
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="icon" type="image/png" sizes="32x32" href="views/7H_The_Town/resource/img/favicon-32x32.png">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="views/7H_The_Town/resource/fonts/fonts.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/header_My.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeCuteCheckbox.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeCuteBtn.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materialize.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/mypage/MyPageLike.css">
    <script src="views/7H_The_Town/resource/CSS,JS/header_My.js"></script>
    <script src="views/7H_The_Town/resource/CSS,JS/materialize/js/materializeCuteBtn.js"></script>
    <script src="views/7H_The_Town/resource/CSS,JS/materialize/js/materialize.js"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <title>7H THE TOWN | 찜한 목록</title>
</head>

<body>

	<%@ include file="/views/common/Header.jsp"%>

    <div class="outer ani-slide">
        <div class="container">
            <div class="sidebar box" id="sidebar">
                <div class="user-name">
                    <a href="<%=contextPath%>/main.me" class="user-txt1">안녕하세요</a><br>
                    <a href="<%=contextPath%>/main.me" class="user-txt2" style="color:#553830;"><%=loginUser.getUserName()%> 회원님</a>
                </div>
                <dl class="side-navi">
					<dt>
						<a href="<%=contextPath%>/update.me">개인 정보 수정</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/updatepwd.me">비밀번호 변경</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/posting.me">나의 게시글</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/like.me">찜한 목록</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/adopt.me">배송현황</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/message.me">쪽지함</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/donation.me">후원 내역</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/inquiry.me">문의 내역</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/delete.me">회원탈퇴</a>
					</dt>
				</dl>
            </div>
                <div class="mypage-content">
                    <div class="mypage-title">
                        <span>최애의 아이</span>
                    </div>
                    <div class="user-info user-info1 box">
                        <div class="info1-wrap">
                            <div class="info1-img">
                                <img src="views/7H_The_Town/resource/img/UserIcon2.png" width="110px" height="110px" />
                            </div>
                            <div class="info1-txt">
                                <div class="info1-txt1">
                                    <%=loginUser.getUserName() %>님
                                </div>
                                <div class="info1-txt2">
                                    <span>내가 찜한 아이 : <%=listCount %> 마리 </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="user-info2 box">
                        <div class="info2-wrap">
                            <div class="info2-title">
                                내가 찜한 아이
                            </div>
            				<form id="likeForm" method="post">
                            <div class="info2-table">
                                <table class="highlight">
                                    <thead>
                                        <tr>
                                            <td style="width:10%;">
                                                <label>
                                                    <input id="selectAllBtn" type="checkbox" onclick="selectAll();">
                                                    <span></span>
                                                </label>
                                            </td>
                                            <td style="width:40%;">견종</td>
                                            <td style="width:30%;">이름</td>
                                            <td style="width:30%;">성별</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<% if(pList != null) {%>
	                                    	<% for(int i = 0; i < pList.size(); i++) {%>
	                                        <tr class="aBlack">
	                                            <td>
	                                                <label>
	                                                    <input class="checkGetNo" type="checkbox" value="<%=gList.get(i)%>" onclick="selectOne();">
	                                                    <span></span>
	                                                </label>
	                                            </td>
	                                            <td><a href="http://localhost:8081/semi/detail.get?bno=<%=gList.get(i)%>"> <%= pList.get(i).getPetKind() %></a></td>
	                                            <td align="center"><a href="http://localhost:8081/semi/detail.get?bno=<%=gList.get(i)%>"><%= pList.get(i).getPetName() %></a></td>
	                                            <td align="center"><a href="http://localhost:8081/semi/detail.get?bno=<%=gList.get(i)%>"><%= pList.get(i).getPetGender() %></a></td>
	                                        </tr>
                                    		<% } %>
                                    	<% } %>
                                    </tbody>
                                </table>
                                <input name="getNo" id="result" type="hidden">
                                <div class="btn-wrap">
                                    <a id="delCheck2" class="waves-effect waves-light btn" style="display:block;">목록 삭제</a>
                                </div>
                            </div>
            			</form>
					</div>
				</div>
				<div style="display:flex; justify-content:center; margin-top:50px;" >
					<ul class="pagination" style="align-items: center; margin:auto;">
					<% if(currentPage != 1)  {%>
					    <li class="disabled"><a href="<%=contextPath %>/like.me?currentPage=<%=currentPage -1 %>"><i class="material-icons">chevron_left</i></a></li>
				    <% } %>
				    
			    	<% for(int p = startPage; p <= endPage; p++) { %>
				    <% if(p != currentPage){ %>
					    <li class="waves-effect"><a href="<%=contextPath%>/like.me?currentPage=<%= p %>"><%= p %></a></li>
				    <% } else { %>
				    	<li class="active"><a href="<%=contextPath%>/like.me?currentPage=<%= p %>"><%= p %></a></li>
			    	<% } %>
					<% } %>
					<% if(maxPage == 0) maxPage=1; %>
					<% if(currentPage != maxPage) { %>
					    <li class="waves-effect"><a href="<%=contextPath%>/like.me?currentPage=<%= currentPage + 1 %>"><i class="material-icons">chevron_right</i></a></li>
					</ul>
					<% } %>
				</div>
			</div>
        </div>
    </div>

<script>
	/* 전체선택기능 */
	function selectAll(){
	    
	     const all = document.getElementById("selectAllBtn").checked;
	     const one = document.querySelectorAll('input[class="checkGetNo"]');
	
	     one.forEach( function(one) {
	    	 one.checked = all;
	      })
	 }
	function selectOne(){
	    
		const all = document.getElementById("selectAllBtn");
        const one = document.querySelectorAll('input[class="checkGetNo"]');

        let isAll = true;
        
        for(let i = 0; i < one.length; i++){
            if(one[i].checked == false){
                isAll = false;
                break;
            }
        }

        if(isAll){
        	all.checked = true;
        } else{
        	all.checked = false;
        }
	 }
	
	 // delete 체크박스 밸류 저장
	 function del(){
	    
	    const del = document.querySelectorAll('input[class="checkGetNo"]:checked');
	    
	    let result = '';
	
	    del.forEach((el)=>{
	       result += el.value + ",";
	    });
	    
	    $("#result").val(result);	    
	 }
	 
	 function submit(){
 		$("#likeForm").attr("action","<%=contextPath%>/like.me");
	    $("#likeForm").submit();
 	 }
	 
	 // delete 전송
	 $(function(){
	    $("#delCheck2").click(function(){
	    	del();
	    	setTimeout(function(){submit();},500);
	       })
	 });
	 
		
	//기본 위치(top)값
	var floatPosition = parseInt($("#sidebar").css('top'))
	
	// scroll 인식
	$(window).scroll(function() {
	
		// 현재 스크롤 위치
		var currentTop = $(window).scrollTop();
		var bannerTop = currentTop + floatPosition + "px";
	
		//이동 애니메이션
		$("#sidebar").animate({
			"top" : bannerTop
		}, 30);
	}).scroll();
</script>

</body>

</html>
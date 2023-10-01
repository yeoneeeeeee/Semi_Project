<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Board> userBoard = (ArrayList<Board>) request.getAttribute("list");
	
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
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/mypage/MyPagePosting.css">
    <script src="views/7H_The_Town/resource/CSS,JS/header_My.js"></script>
    <script src="views/7H_The_Town/resource/CSS,JS/materialize/js/materializeCuteBtn.js"></script>
    <script src="views/7H_The_Town/resource/CSS,JS/materialize/js/materialize.js"></script>
    <title>7H THE TOWN | 나의 게시글</title>
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
            <form action="<%=contextPath %>/mypageDelete.bo" method = "post">
                <div class="mypage-content">
                    <div class="mypage-title">
                        <span>나의 게시글</span>
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
                                    <span>내가 쓴 게시글 : <%= pi.getListCount() %> &nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp; 멤버십 : <%=userGrade.getGradeName() %></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="user-info2 ol s12 m2 z-depth-2">
                        <div class="info2-wrap">
                            <div class="info2-title">
                                내가 쓴 게시글
                            </div>
                            <div class="info2-table">
                                <table class="highlight">
                                    <thead>
                                        <tr>
                                            <td style="width:10%;">
                                                <label>
                                                    <input type="checkbox" onclick="selectAll();" id="selectAllBtn">
                                                    <span></span>
                                                </label>
                                            </td>
                                            <td style="width:35%;">게시물 제목</td>
                                            <td style="width:25%;">카테고리</td>
                                            <td style="width:20%;">작성일</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% if(userBoard.isEmpty()) { %>
										<tr>
											<td colspan="5">조회된 리스트가 없습니다.</td>
										</tr>
										<% } else { %>
										<%for(int i = 0; i < userBoard.size(); i++) { %>
										<tr data-bs-toggle="modal" data-bs-target="#exampleModal<%= i %>">
											<td>
												<label> 
													<input type = "checkbox" class="rowCheck-btn" name="bno" value="<%=userBoard.get(i).getBoardNo() %>" type="checkbox">
													<span></span>
												</label>
											</td>
											<td><%= userBoard.get(i).getBoardTitle() %></td>
											<td><%= userBoard.get(i).getBoardCategory()%></td>
											<td><%= userBoard.get(i).getCreateDate() %></td>
										</tr>
											<% } %>
										<% } %>
                                    </tbody>
                                </table>
                                <div class="btn-wrap">
                                	<input type ="hidden" name="boardNo" id = "result">
                                	<a id="delCheck1" class = "waves-effect waves-light btn" onclick = "del();">삭제하기</a>
                                    <button type = "submit"  id = "delCheck2" class="waves-effect waves-light btn" style="display:none;">삭제하기</button>
                                </div>
                                <script>
                                	function del(){
                                		const query = 'input[class="rowCheckbox-btn"]:checked';
                                		const del = document.querySelectorAll(query);
                                		
                                		let result = '';
                                		
                                		del.forEach((el)=>{
                                			result += el.value +",";
                                		});
                                		
                                		$("#result").val(result);
                                		alert("정말 삭제하시려면 다시 한번 눌러주세요");
                                		$("#delCheck2").css("display","block");
                                		$("#delCheck1").css("display","none");
                                	}
                                	
                                	function selectAll(){
                                		const checked = document.getElementById("selectAllBtn").checked;
                                		const rowChecks = document.querySelectorAll('input[type="checkbox"]');
                                		
                                		rowChecks.forEach( function(rowCheck){
                                			rowCheck.checked = checked;
                                		})
                                	}
                                	
                                	function selectOne(){
                                		const all = document.getElementById("selectAllBtn");
                                		const one = document.querySelectorAll('input[class="rowCheck-btn"]');
                                		
                                		let isAll = true;
                                		
                                		for(let i = 0; i<one.length; i++){
                                			if(one[i].checked == false){
                                				isAll = false;
                                				break;
                                			}
                                		}
                                		if(isAll){
                                			all.checked = true;
                                		}else{
                                			all.checked = false;
                                		}
                                	}
                                </script>
                            </div>
                        </div>
                    </div>
					<div style="display:flex; justify-content:center;  margin-top:50px;" >
						<ul class="pagination" style="align-items: center; margin:auto;">
						<% if(currentPage != 1)  {%>
						    <li class="disabled"><a href="<%=contextPath %>/posting.me?currentPage=<%=currentPage -1 %>&category="><i class="material-icons">chevron_left</i></a></li>
					    <% } %>
					    
					    <% for(int p = startPage; p <= endPage; p++) { %>
					    <% if(p != currentPage){ %>
						    <li class="waves-effect"><a href="<%=contextPath%>/posting.me?currentPage=<%= p %>"><%= p %></a></li>
					    <% } else { %>
					    <li class="active"><a href="#!"><%= p %></a></li>
					    <% } %>
						<% } %>
						<% if(maxPage == 0) maxPage = 1; %>
						<% if(currentPage != maxPage) { %>
						    <li class="waves-effect"><a href="<%=contextPath%>/posting.me?currentPage=<%= currentPage + 1 %>"><i class="material-icons">chevron_right</i></a></li>
						</ul>
						<% } %>
					</div>
                </div>
            </form>
        </div>
        <div class="footer">
        </div>
    </div>

<script>
		
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
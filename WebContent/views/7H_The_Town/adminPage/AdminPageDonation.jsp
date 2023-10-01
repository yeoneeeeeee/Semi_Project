<%@ page
	import="com.semi.donation.model.vo.Donation, java.util.ArrayList, com.semi.common.model.vo.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ArrayList<Donation> list = (ArrayList<Donation>) request.getAttribute("list");
/*  PostAll p = (PostAll)request.getAttribute("p"); */


PageInfo pi = (PageInfo) request.getAttribute("pi");

%>

<%
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

    <link rel="stylesheet" href="views/7H_The_Town/resource/fonts/fonts.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/header_My.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeCuteCheckbox.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeCuteBtn.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materialize.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/adminPage/AdminPageDonation.css">
    <script src="views/7H_The_Town/resource/CSS,JS/materialize/js/materializeCuteBtn.js"></script>
    <script src="views/7H_The_Town/resource/CSS,JS/materialize/js/materialize.js"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <title>7H THE TOWN | 후원관리</title>
</head>

<body>

	<%@ include file="/views/common/Header.jsp"%>

    <div class="outer ani-slide">
        <div class="container">
            <div class="sidebar ol s12 m2 z-depth-2" id="sidebar">
                <div class="user-name">
                    <span class="user-txt1">안녕하세요</span><br>
                    <a href="<%=contextPath %>/main.ad" class="user-txt2" style="color:#553830;">관리자 님</a>
                </div>
                <dl class="side-navi">
					<dt>
						<a href="<%= contextPath %>/edit.ad">회원 정보 관리</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/posting.ad">게시판 관리</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/pet.ad">유기견 관리</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/deliver.ad">배송 관리</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/donation.ad">후원 관리</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/client.ad">고객 센터 관리</a>
					</dt>
				</dl>
            </div>
            <div class="adminpage-content">
                <div class="adminpage-title">
                    <span>후원 관리</span>
                </div>
                <div class="board-wrap">
                    <div class="board-top">
                        <div class="board-search ">
                            <div class="category">

                            </div>
                            <div class="search">

                            </div>
                        </div>
                    </div>
                    <div class="board-list">

                    </div>
                </div>
                <div class="admin-info1 ol s12 m2 z-depth-2">
                    <div class="info1-wrap">
                        <div class="info1-userinfo">
                           <table class="highlight">
                                <thead>
                                    <tr>
                                        <td style="width: 5%;"></td>
                                        <td style="width: 15%;">회원번호</td>
                                        <td style="width:30%;">후원금액</td>
                                        <td style="width:25%;">후원종류</td>
                                        <td style="width:30%;">후원날짜</td>
                                    </tr>
                                </thead>
                               <%
										if (!(list.isEmpty())) {
									%>
									<%
										for (int i = 0; i < list.size(); i++) {
									%>
									<tbody>
									<tr>
									 
									    <td><%= i + 1   %> </td>
									    <td><%=list.get(i).getUserNo() %> </td>
										<td><%=list.get(i).getDonaPrice() %> 원</td>
										<td><%=list.get(i).getDonaKind() %></td>
										<td><%=list.get(i).getDonaDate() %></td>
									</tr>
								</tbody>
									<%
										}
									%>
									<%
										}
									%>
									</table>
                        </div>
                    </div>
                </div>

            </div>
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
<%@ page
	import="com.semi.donation.model.vo.Donation, com.semi.member.model.vo.Grade, java.util.ArrayList, com.semi.common.model.vo.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
ArrayList<Donation> list = (ArrayList<Donation>) request.getAttribute("list");
ArrayList<Grade> list1 = (ArrayList<Grade>) request.getAttribute("list1");
/*  PostAll p = (PostAll)request.getAttribute("p"); */


PageInfo pi = (PageInfo) request.getAttribute("pi");

System.out.println(list);
System.out.println(list1);
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
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/mypage/MyPageDonation.css">
    <script src="views/7H_The_Town/resource/CSS,JS/header_My.js"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="views/7H_The_Town/resource/CSS,JS/materialize/js/materializeCuteBtn.js"></script>
    <script src="views/7H_The_Town/resource/CSS,JS/materialize/js/materialize.js"></script>
    <title>7H THE TOWN | 고객 센터 관리(문의내용)</title>
</head>

<body>

	<%@ include file="/views/common/Header.jsp"%>

    <div class="outer">
        <div class="container">
            <div class="sidebar box">
                <div class="user-name">
                    <span class="user-txt1">안녕하세요</span><br>
                    <span class="user-txt2"><%=loginUser.getUserName() %> 회원님</span>
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
						<a href="<%=contextPath%>/like.me">최애의 아이</a>
					</dt>
					<dt>
						<a href="<%=contextPath%>/adopt.me">나의 가족</a>
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
                    <span>후원 내역</span>
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
                                <span>후원 횟수 : 
                                 <%     
                                       int sum = 0;
										if (!(list.isEmpty())) {
									%>
											<%=list.size() %>
									<%-- <%
										for (int i = 0; i < list.size(); i++) {
									%>
									    <%  sum += i; %>
									<%
										}
									%> --%>
									<%
										}
									%>
									 <%-- <h7><%= sum +1 %></h7> --%>
                            <input type="hidden" id="userNo" name="userNo" value="<%= loginUser.getUserNo() %>">  
                                 &nbsp;&nbsp; | &nbsp;&nbsp; 멤버쉽 : <%= list1.get(0).getGradeName() %></span>
                            </div>
                        </div>
                        <div class="info1-total">
                            <div class="total-txt">
                                <span>누적금액</span>
                            </div>
                            <div class="total-count">
                            	<%     
										if (!(list.isEmpty())) {
									%>
									<%
										for (int i = 0; i < list.size(); i++) {
									%>
									    <%  sum += list.get(i).getDonaPrice(); %>
									<%
										}
									%>
									<%
										}
									%>
									
                            </div>
									<h7 style="text-align:end;">
									  <%= sum%>원 
									  </h7>
                        </div>
                    </div>
                </div>
                <div class="user-info2 box">
                    <div class="info2-wrap">
                        <div class="info2-title">
                            후원 내역
                        </div>
                        <div class="info2-table">
                            <table class="highlight">
                                <thead>
                                    <tr>
                                        <td style="width: 10%;"></td>
                                        <td style="width:30%;">후원 금액</td>
                                        <td style="width:30%;">후원 종류</td>
                                        <td style="width:25%;">후원 날짜</td>
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

</body>

</html>
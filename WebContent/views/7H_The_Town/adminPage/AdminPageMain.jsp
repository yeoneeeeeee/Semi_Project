<%@ page import="com.semi.client.model.vo.Faq, com.semi.board.model.vo.Report, java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Faq> fList = (ArrayList<Faq>) request.getAttribute("fList");
	ArrayList<Report> rList = (ArrayList<Report>) request.getAttribute("rList");
	
	
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="icon" type="image/png" sizes="32x32"
	href="<%= request.getContextPath() %>/views/7H_The_Town/resource/img/favicon-32x32.png">

<link rel="stylesheet"
	href="<%= request.getContextPath() %>/views/7H_The_Town/resource/CSS,JS/adminPage/AdminPageMain.css">
<title>7H THE TOWN | 관리자 페이지</title>
</head>

<body>

	<%@ include file="/views/common/Header.jsp"%>

	<div class="outer ani-slide">
		<div class="container">
			<div class="sidebar box" id="sidebar">
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
					<span>관리자 페이지</span>
				</div>
				<div class="admin-info1 ol s12 m2 z-depth-2">
					<div class="info1-wrap">
						<div class="info1-img">
							<img
								src="<%= contextPath %>/views/7H_The_Town/resource/img/UserIcon2.png"
								width="100px" height="100px" />
						</div>
						<div class="info1-txt">
							<div class="info1-txt1">관리자님</div>
							<div class="info1-txt2">
								<span>문의함 : <%= fList.size() %> &nbsp;&nbsp; | &nbsp;&nbsp; 신고함 : <%= rList.size() %></span>
							</div>
						</div>
					</div>
				</div>
				<div class="admin-info2 ol s12 m2 z-depth-2">
					<div class="info2-wrap">
						<div class="info2-title">최근 문의 내용</div>
						<div class="info2-inquiry">
							<table class="highlight">
								<thead>
									<tr>
										<td style="width: 10%;"><label> 
										<input type="checkbox" id="checkAllFaq" onclick="selectAllFaq();"> 
										<span></span>
										</label></td>
										<td style="width: 45%; text-align: center;">문의 제목</td>
										<td style="width: 25%;">작성자</td>
										<td style="width: 20%;">작성일자</td>
									</tr>
								</thead>
								<tbody>
									<% if(fList.isEmpty()) { %>
										<tr>
											<td colspan="5">조회된 리스트가 없습니다.</td>
										</tr>
										<% } else { %>
										<%for(int i = 0; i < fList.size(); i++) { %>
										<tr data-bs-toggle="modal"
											data-bs-target="#exampleModal<%= i %>">
											<td><label> <input class="checkboxFaq" onclick="selectOneFaq();"
													name="checkBox" value="<%=fList.get(i).getFaqNo() %>"
													type="checkbox"> <span></span>
											</label></td>
											<td><%= fList.get(i).getFaqTitle() %></td>
											<td><%= fList.get(i).getUserNo() %></td>
											<td><%= fList.get(i).getCreateDate() %></td>
										</tr>
										<% } %>
									<% } %>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="admin-info2 ol s12 m2 z-depth-2">
					<div class="info2-wrap">
						<div class="info2-title">최근 신고 내용</div>
						<div class="info2-inquiry">
							<table class="highlight">
								<thead>
									<tr>
										<td style="width: 10%;"><label> <input
												type="checkbox" id="checkAllReport" onclick="selectAllReport();"> <span></span>
										</label></td>
										<td style="width: 45%; text-align: center;">신고 제목</td>
										<td style="width: 25%;">작성자</td>
										<td style="width: 20%;">작성일자</td>
									</tr>
								</thead>
								<tbody>
									<% if(rList.isEmpty()) { %>
										<tr>
											<td colspan="5">조회된 리스트가 없습니다.</td>
										</tr>
										<% } else { %>
										<%for(int i = 0; i < rList.size(); i++) { %>
										<tr data-bs-toggle="modal"
											data-bs-target="#exampleModal<%= i %>">
											<td><label> <input class="checkboxReport"
													type="checkbox" name="checkBox" onclick="selectOneReport();"
													value="<%=rList.get(i).getReportNo() %>"> <span></span>
											</label></td>
											<td>사용자 신고글</td>
											<td><%= rList.get(i).getBoardNo() %></td>
											<td><%= rList.get(i).getCreateDate() %></td>
										</tr>
										<% } %>
									<% } %>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
	
	function selectAllFaq(){
      	/* 체크박스 선택 & 전체선택 및 해제 */
         
         const checked = document.getElementById("checkAllFaq").checked;
         const rowChecks = document.querySelectorAll('input[class="checkboxFaq"]');
  
         rowChecks.forEach( function(rowCheck) {
            rowCheck.checked = checked;
         })
      }
    
      // 하나라도 체크되지 않으면 전체선택 해제
      function selectOneFaq(){
          const all = document.getElementById("checkAllFaq");
          const one = document.querySelectorAll('input[class="checkboxFaq"]');

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
      
      function selectAllReport(){
        	/* 체크박스 선택 & 전체선택 및 해제 */
           
           const checked = document.getElementById("checkAllReport").checked;
           const rowChecks = document.querySelectorAll('input[class="checkboxReport"]');
    
           rowChecks.forEach( function(rowCheck) {
              rowCheck.checked = checked;
           })
        }
      
        // 하나라도 체크되지 않으면 전체선택 해제
        function selectOneReport(){
            const all = document.getElementById("checkAllReport");
            const one = document.querySelectorAll('input[class="checkboxReport"]');

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
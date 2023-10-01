<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>7H THE TOWN | 회원가입</title>
    <link rel="icon" type="image/png" sizes="32x32" href="views/7H_The_Town/resource/img/favicon-32x32.png">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/fonts/fonts.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materialize.css">
    <script src="views/7H_The_Town/resource/CSS,JS/materialize/js/materialize.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/header.css">
    <script src="views/7H_The_Town/resource/CSS,JS/header.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/footer.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeBtn.css">
    <style>

      .join-comp-box {
        margin: 250px;
        width: 500px;
        display: flex;
        flex-direction: column;
        align-items: center;
        background-color: rgb(255, 255, 255);
      }

      #join-comp-text {
        text-align: center;
        margin: 10% 0% 15% 0%;
      }

      #main-re-btn {
        width: 250px;
        margin-bottom: 20%;
        background-color: rgb(255, 255, 255);
        border-radius: 18px;
        border: 1px solid rgb(100, 100, 100);
      }
    </style>
  </head>
  <body>

	<%@ include file="/views/common/Header.jsp" %>

    <div class="outer">
      <div class="join-comp-box">
        <img src="views/7H_The_Town/resource/img/7H_THE_TOWN_LOGO.png" alt="" width="200px" height="200px" style="margin: 50px 0px 20px 0px">
        <div id="join-comp-text">
          개 더 타운의 회원이 되신걸<br>
          축하드립니다.
        </div>
        <div>
          <button type="submit" id="main-re-btn" style="height: 45px" onclick="location.href='<%=contextPath %>'">
            메인으로 돌아가기
          </button>
        </div>
      </div>
    </div>

    <div class="footerArea">
      <ul class="footerUl">
          <li>이용약관</li>
          <li>|</li>
          <li>개인정보처리방침</li>
          <li>|</li>
          <li>법적고지</li>
          <li>|</li>
          <li>사업자정보확인</li>
      </ul>
      
      <p class="footerP">
          본사 : 서울특별시 강남구 테헤란로14길 6 남도빌딩 3F, 4F, 5F
          <br>
          상호 : 개더타운 대표자 : 파워레인저 사업자등록번호 123-456-789
          <br>
          개인정보보호책임자 : 이정택
          <br>
          TEL : 02)1234 - 5678 | FAX : 02-1111-2222 | 이메일 : ckdwjd2717@naver.com
          <br>
          대표전화 : 010 - 0000 - 0000
      </p>
    </div>




  </body>
</html>

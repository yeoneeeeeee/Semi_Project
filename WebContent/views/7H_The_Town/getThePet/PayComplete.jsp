<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>7H THE TOWN | GetThePet 결제완료</title>
    <link rel="icon" type="image/png" sizes="32x32" href="views/7H_The_Town/resource/img/favicon-32x32.png">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/fonts/fonts.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materialize.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/header.css">
    <script src="views/7H_The_Town/resource/CSS,JS/header.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/footer.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeBtn.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/petlist.css">
    <style>
        .payCompleteBox{
            margin: 250px;
            width: 600px;
            height: 600px;
            background: white;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .payCompleteBox h4{
            margin-top: 90px;
            margin-bottom: 50px;
            font-weight: bold;
        }
        .payCompleteBox img{
            margin: 50px;
        }
        .payCompleteBox>div{
            display: flex;
        }
        .payCompleteBox a{
            color: black;
            font-family: 'S-CoreDream-3Light';
            font-size: 17px;
            text-align: center;
            line-height: 2.5;
            margin: 20px;
            width: 120px;
            height: 45px;
            background: rgb(210, 210, 210);
            border: none;
            border-radius: 5px;
        }
    </style>
</head>
<body>

    <%@ include file="/views/common/Header.jsp" %>

    <div class="payCompleteBox col s12 m2 z-depth-2">
        <h4>결제가 완료되었습니다</h4>
        <img src="views/7H_The_Town/resource/img/check_Icon.png" alt="" width="150px">
        <div>
            <a href="<%=contextPath %>/main">홈으로</a>
        </div>
    </div>

    <%@ include file="/views/7H_The_Town/Footer.jsp" %>

</body>
</html>
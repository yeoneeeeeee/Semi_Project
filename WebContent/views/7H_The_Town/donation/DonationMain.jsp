<%@ page
	import="com.semi.donation.model.vo.Donation, java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Donation> list = (ArrayList<Donation>) request.getAttribute("list");
/*  PostAll p = (PostAll)request.getAttribute("p"); */
/* String contextPath = request.getContextPath(); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>7H THE TOWN | 후원</title>
<link rel="icon" type="image/png" sizes="32x32" href="views/7H_The_Town/resource/img/favicon-32x32.png">
<link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/fonts/fonts.css">
<link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materialize.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/header.css">
<script src="views/7H_The_Town/resource/CSS,JS/header.js"></script>
<link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/footer.css">
<link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeBtn.css">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

<link rel="stylesheet" href="/path/to/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="/path/to/jquery.bxslider.min.js"></script>

  <script>
    $(document).ready(function(){
      $('.slider').bxSlider();
    });
  </script>


<style>
 
 .slidebox {max-width:3000px; max-height: 1000px; margin:0 auto;position:relative; position: absolute; top: 150px; right: 0px; left: 10px;}
    .slidebox .slidelist {position:relative;white-space:nowrap; overflow:hidden;}
    .slidebox .slidelist .slideitem {position:relative;display:inline-block;vertical-align:middle;background-color:#fff; width:100%; transition:all 1s;}
    .slidebox .slidelist .slideitem > a {display:flex;width:auto;position:relative;}
    .slidebox .slidelist .slideitem > a img {max-width:100%;}
    
    .slidebox .slide-control [class*="control"] label {position:absolute; z-index:10; bottom: 12%; transform:translateY(-430%);padding:18px; border-radius:50%;cursor:pointer;}
    .slidebox .slide-control [class*="control"] label.prev {left:-50px; background:#333 url('views/7H_The_Town/resource/img/1button.png') center center / 100% no-repeat;}
    .slidebox .slide-control [class*="control"] label.next {right:-50px; background:#333 url('views/7H_The_Town/resource/img/button.png') center center / 100% no-repeat;}
    
    [name="slide"] {display:non;}

    #slide01:checked ~ .slidelist .slideitem {left:0;}
    #slide02:checked ~ .slidelist .slideitem {left:-100%;}
    #slide03:checked ~ .slidelist .slideitem {left:-200%;}
    #slide04:checked ~ .slidelist .slideitem {left:-300%;}
    #slide05:checked ~ .slidelist .slideitem {left:-400%;}
    #slide06:checked ~ .slidelist .slideitem {left:-500%;}
    #slide07:checked ~ .slidelist .slideitem {left:-600%;}
    #slide08:checked ~ .slidelist .slideitem {left:-700%;}
    #slide09:checked ~ .slidelist .slideitem {left:-800%;}
    #slide10:checked ~ .slidelist .slideitem {left:-900%;}
    #slide11:checked ~ .slidelist .slideitem {left:-1000%;}
    #slide12:checked ~ .slidelist .slideitem {left:-1100%;}
    #slide13:checked ~ .slidelist .slideitem {left:-1200%;}
    #slide14:checked ~ .slidelist .slideitem {left:-1300%;}
    #slide15:checked ~ .slidelist .slideitem {left:-1400%;}
    
    .slide-control [class*="control"] {display:none;}
    
    #slide01:checked ~ .slide-control .control01 {display:block;}
    #slide02:checked ~ .slide-control .control02 {display:block;}
    #slide03:checked ~ .slide-control .control03 {display:block;}
    #slide04:checked ~ .slide-control .control04 {display:block;}
    #slide05:checked ~ .slide-control .control05 {display:block;}
    #slide06:checked ~ .slide-control .control06 {display:block;}
    #slide07:checked ~ .slide-control .control07 {display:block;}
    #slide08:checked ~ .slide-control .control08 {display:block;}
    #slide09:checked ~ .slide-control .control09 {display:block;}
    #slide10:checked ~ .slide-control .control10 {display:block;}
     #slide11:checked ~ .slide-control .control11 {display:block;}
    #slide12:checked ~ .slide-control .control12 {display:block;}
    #slide13:checked ~ .slide-control .control13 {display:block;}
    #slide14:checked ~ .slide-control .control14 {display:block;}
    #slide15:checked ~ .slide-control .control15 {display:block;}
    
    .GOTOOFFERS{
            text-decoration: none;
            color: black;
            
        }
    .box{
        color: white;
        border: 1px solid;
    }
    .top{
        font-size: 0px;
        position: relative; overflow: hidden;
    }

        .screen:hover{
            cursor: pointer;
            filter: brightness(0.5);
        }
        .screen:hover .top{
            font-size: 30px;
            color: white;
            position: absolute; top:120px; left:95px; 
          }
      

.slider div p{width:40em;height:40em;margin:5em 0;}


.padding100 {
	padding: 100px;
}

div {
	box-sizing: border-box;
	/* border: 1px solid  */
}

/* 전체를 감싸는 div wrap */
.wrap {
	background:
	linear-gradient(to bottom, rgba(255, 255, 255, 1), 50%, rgba(245, 245, 245, 0.6));
	width: 1300px;
	height: auto;
	display: flex;
	flex-direction: column;
	align-items: center;
}

/* 크게 3가지 영역에 스타일 부여 */
/* #header, #content, #footer */
#wrap>div {
	/*class 속성이 wrap이면서 자손태그중 div태그에만 스타일 부여하겠다. */
	width: 100%;
}

#content5>div {
	border: 1px solid black;
}

#header, #footer {
	width: 1300px;
	height: 210px;
}

#content1 {
	width: 1100px;
	height: 650px;
}

#content1 h4 {
	margin-left: 100px;
	margin-top: -300px;
}

#content2 {
	width: 900px;
	height: 500px;
}

#content2 img {
	width: 900px;
	height: 500px;
}

#content3 {
	height: 17%;
}

.content3box {
	background: rgb(240, 240, 240);
}

#content4 {
	height: 17%;
}

#content4 button {
	border: 1px solid rgb(210, 210, 210, 1);
	border-radius: 13px;
	background-color: seashell;
}

#content4 button:hover {
	cursor: pointer;
	opacity: 0.5;
}

#content4 button>h4 {
	position: relative;
	top: -5px;
}

#content5 {
	width: 1100px;
	height: 20%;
	background: rgb(240, 240, 240);
}

#h1 {
	text-align: center;
}

a {
	text-decoration: none;
	color: black;
}

/*ddddddd*/
/* 브라우저 마진과 패딩 리셋 */
* {
	margin: 0;
	padding: 0;
}

/* INPUT 가리기 */
.section input[id*="slide"] {
	display: none;
}

/* 슬라이드 영역 - max-width 크기를 조절해주면 됩니다*/
.section .slidewrap {
	max-width: 1200px;
	margin: 0 auto;
	overflow: hidden;
}

.section .slidelist {
	overflow: hidden;
	white-space: nowrap;
	font-size: 0;
}

.section .slidelist>li {
	display: inline-block;
	vertical-align: middle;
	width: 100%;
	transition: all .5s;
}

.section .slidelist>li>a {
	display: block;
	position: relative;
}

.section .slidelist>li>a img {
	width: 1300px;
	height: 600px;
}

/* 좌우로 넘기는 LABEL버튼에 대한 스타일 */
.section .slidelist label {
	position: absolute;
	z-index: 100;
	top: 50%;
	transform: translateY(-50%);
	padding: 50px;
	cursor: pointer;
}

.section .slidelist .left {
	left: 0px;
	width: 10px;
	height: 10px;
	border-radius: px;
}

.slider div p{width:40em;height:40em;margin:5em 0;}

/* .section .slidelist .right {
	right: 0px;
	background: url('views/7H_The_Town/resource/img/찐방향키.png') center center/35%
		no-repeat;
	border-radius: 100px;
}

/* INPUT 체크되면 변화값이 li까지 전달되는 스타일 */
/* .section input[id="slide01"]:checked ~.slidewrap .slidelist>li {
	transform: translateX(0%);
}

.section input[id="slide02"]:checked ~.slidewrap .slidelist>li {
	transform: translateX(-100%);
}

.section input[id="slide03"]:checked ~.slidewrap .slidelist>li {
	transform: translateX(-200%);
} */ */
</style>

</head>

<body>


	<%@ include file="/views/common/Header.jsp"%>



	<div class="wrap  col s12 m2 z-depth-2" style="margin-top:200px;">

		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<div id="content1" class="ani-slide">
			<div>
				<h4
					style="margin-top: -420px; margin-left: 20px; margin-bottom: 200px;">
					&nbsp;&nbsp;<b>개더타운을 움직이는 하나의 힘, 사랑하는 여러분들의 후원 입니다.</b>
				</h4>
			</div>
			<div class="col s12 m2 z-depth-3">
				<img id="사진"
					src="views/7H_The_Town/resource/img/슬픈표정의_강아지사진들13 - 복사본.jpg"
					style="top: 4px; left: 3px;" width="1100px" height="580">
				<p></p>
			</div>
			<h4>
				<b>"후원" 이라는 의미는 <br> 무엇일까요
				</b>
			</h4>
		</div>

		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<div class="slide-effect" id="content2" style="position: relative;">
			<div>
				<h3
					style="margin-left: -50px; margin-top: 50px; margin-bottom: 80px;">
					&nbsp;&nbsp;&nbsp;&nbsp; <b>유기동물을 지켜주세요</b>
				</h3>
			</div>
			<div class="col s12 m2 z-depth-2">
     <div class="slidebox">
        <input type="radio" name="slide" id="slide01" checked="">
        <input type="radio" name="slide" id="slide02">
        <input type="radio" name="slide" id="slide03">
        <input type="radio" name="slide" id="slide04">
        <input type="radio" name="slide" id="slide05">
        <input type="radio" name="slide" id="slide06">
        <input type="radio" name="slide" id="slide07">
        <input type="radio" name="slide" id="slide08">
        <input type="radio" name="slide" id="slide09">
        <input type="radio" name="slide" id="slide10">
        <input type="radio" name="slide" id="slide11">
        <input type="radio" name="slide" id="slide12">
        <input type="radio" name="slide" id="slide13">
        <input type="radio" name="slide" id="slide14">
        <input type="radio" name="slide" id="slide15">
        <ul class="slidelist">
            <li class="slideitem" display="block">
                <a>
                    <div> 
                            <div class="screen">
                                <img src="views/7H_The_Town/resource/img/슬라이드1.jpg" style="width:830px; height: 500px; ">
                        </div>
                    </div>
                    
                </a>
            </li>
            <li class="slideitem" disply="block">
                    <a>
                        <div style="padding-left:0px;">
                            <div class="screen">
                                <img src="views/7H_The_Town/resource/img/슬라이드2.jpg" style="width:830px; height: 500px; ">
                                </div>
                        </div>
                    </a>
                </li>
                <li class="slideitem" disply="block">
                    <a>
                        <div style="padding-left:10px;">
                            <div class="screen">
                                <img src="views/7H_The_Town/resource/img/슬라이드3.jpg"style="width:830px; height: 500px; ">
                                </div>
                        </div>
                    </a>
                </li>
                <li class="slideitem" display="block">
                <a>
                    <div> 
                            <div class="screen">
                                <img src="views/7H_The_Town/resource/img/슬라이드4.jpg" style="width:830px; height: 500px; ">
                        </div>
                    </div>
                    
                </a>
            </li>
            <li class="slideitem" display="block">
                <a>
                    <div> 
                            <div class="screen">
                                <img src="views/7H_The_Town/resource/img/슬라이드5.jpg" style="width:830px; height: 500px; ">
                        </div>
                    </div>
                    
                </a>
            </li>
            <li class="slideitem" display="block">
                <a>
                    <div> 
                            <div class="screen">
                                <img src="views/7H_The_Town/resource/img/슬라이드6.jpg" style="width:830px; height: 500px; ">
                        </div>
                    </div>
                    
                </a>
            </li>
            <li class="slideitem" display="block">
                <a>
                    <div> 
                            <div class="screen">
                                <img src="views/7H_The_Town/resource/img/슬라이드7.jpg" style="width:830px; height: 500px; ">
                        </div>
                    </div>
                    
                </a>
            </li>
            <li class="slideitem" display="block">
                <a>
                    <div> 
                            <div class="screen">
                                <img src="views/7H_The_Town/resource/img/슬라이드8.jpg" style="width:830px; height: 500px; ">
                        </div>
                    </div>
                    
                </a>
            </li>
            <li class="slideitem" display="block">
                <a>
                    <div> 
                            <div class="screen">
                                <img src="views/7H_The_Town/resource/img/슬라이드9.jpg" style="width:830px; height: 500px; ">
                        </div>
                    </div>
                    
                </a>
            </li>
            <li class="slideitem" display="block">
                <a>
                    <div> 
                            <div class="screen">
                                <img src="views/7H_The_Town/resource/img/슬라이드10.jpg" style="width:830px; height: 500px; ">
                        </div>
                    </div>
                    
                </a>
            </li>
            <li class="slideitem" display="block">
                <a>
                    <div> 
                            <div class="screen">
                                <img src="views/7H_The_Town/resource/img/슬라이드11.jpg" style="width:830px; height: 500px; ">
                        </div>
                    </div>
                    
                </a>
            </li>
            <li class="slideitem" display="block">
                <a>
                    <div> 
                            <div class="screen">
                                <img src="views/7H_The_Town/resource/img/슬라이드12.jpg" style="width:830px; height: 500px; ">
                        </div>
                    </div>
                    
                </a>
            </li>
            <li class="slideitem" display="block">
                <a>
                    <div> 
                            <div class="screen">
                                <img src="views/7H_The_Town/resource/img/슬라이드13.jpg" style="width:830px; height: 500px; ">
                        </div>
                    </div>
                    
                </a>
            </li>
            <li class="slideitem" display="block">
                <a>
                    <div> 
                            <div class="screen">
                                <img src="views/7H_The_Town/resource/img/슬라이드14.jpg" style="width:830px; height: 500px; ">
                        </div>
                    </div>
                    
                </a>
            </li>
            <li class="slideitem" display="block">
                <a>
                    <div> 
                            <div class="screen">
                                <img src="views/7H_The_Town/resource/img/슬라이드15.jpg" style="width:830px; height: 500px; ">
                        </div>
                    </div>
                    
                </a>
            </li>
        </ul>

        <div class="slide-control">
            <div class="control01">
                <label for="slide15" class="prev"></label>
                <label for="slide02" class="next"></label>
            </div>
            <div class="control02">
                <label for="slide01" class="prev"></label>
                <label for="slide03" class="next"></label>
            </div>
             <div class="control03">
                <label for="slide02" class="prev"></label>
                <label for="slide04" class="next"></label>
            </div>
            <div class="control04">
                <label for="slide03" class="prev"></label>
                <label for="slide05" class="next"></label>
            </div>
             <div class="control05">
                <label for="slide04" class="prev"></label>
                <label for="slide06" class="next"></label>
            </div>
             <div class="control06">
                <label for="slide05" class="prev"></label>
                <label for="slide07" class="next"></label>
            </div>
             <div class="control07">
                <label for="slide06" class="prev"></label>
                <label for="slide08" class="next"></label>
            </div>
             <div class="control08">
                <label for="slide07" class="prev"></label>
                <label for="slide09" class="next"></label>
            </div>
             <div class="control09">
                <label for="slide08" class="prev"></label>
                <label for="slide10" class="next"></label>
            </div>
             <div class="control10">
                <label for="slide09" class="prev"></label>
                <label for="slide11" class="next"></label>
            </div>
             <div class="control11">
                <label for="slide10" class="prev"></label>
                <label for="slide12" class="next"></label>
            </div>
             <div class="control12">
                <label for="slide11" class="prev"></label>
                <label for="slide13" class="next"></label>
            </div>
             <div class="control13">
                <label for="slide12" class="prev"></label>
                <label for="slide14" class="next"></label>
            </div>
             <div class="control14">
                <label for="slide13" class="prev"></label>
                <label for="slide15" class="next"></label>
            </div>
             <div class="control15">
                <label for="slide14" class="prev"></label>
                <label for="slide01" class="next"></label>
            </div>
        </div>
    </div>
     
         </div>
      </div>


		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<div class="slide-effect" id="content3" style="margin-top: 150px;">
			<div>
				<h3 style="margin-bottom: 50px;">
					&nbsp;&nbsp;<b>후원현황</b>
					</h1>
			</div>
			<div class="content3box col s12 m2 z-depth-2"
				style="box-sizing: border-box; border: 1px solid; width: 1100px; height: 300px;">
				<h1>&nbsp;&nbsp;후원해주신 투개더 후원금 현황</h1>
				<div>
				    <br><br>

						<% int sum = 0; %>
						<% for(int i =1; i <list.size(); i++) {
                    	  sum += list.get(i).getDonaPrice();
                     }
                            %>
						<div>
						
						</div>
						<div style="position:relative; bottom:px;">
						 <div>
						 <h3 style="text-align:end;">
						<b><%= sum %> 원&nbsp;&nbsp;&nbsp;</b>
					    </h3>
					    </div>
					    <div style="position:relative; bottom:110px; left:670px;">
					    <img src="views/7H_The_Town/resource/img/7H_THE_TOWN_LOGO.png" style="width="150px" height="150px"> 
					    </div>
					    </div>
				</div>
			</div>

		</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<div id="content4" class="slide-effect"
			style="position: relative; bottom: 100px; height: 320px; border: 1px solid gray; background-color:white;">
			<div style="text-align: center; position: relative; top: -150px; ">
				<h3>
					<b>저희와 함께 걸어가보아요</b>
				</h3>
			</div>
			<div
				style="box-sizing: border-box; width: 1100px; height: 320px; position: relative; top: -94px; ">
				<div
					style="position: relative; top: px; box-sizing: border-box; width: 1100px; height: 80px; ">

					<h5
						style="text-align: center; position: relative; top: 50px; ">
						<b>아이들이 배고프지않게 도와주세요.</b>
					</h5>
				</div>
				<button type="button"
					style="width: 180px; height: 90px; position: relative; top: 100px; left: 20px;">
					<h4>10,000</h4>
				</button>
				<button type="button"
					style="width: 180px; height: 90px; position: relative; top: 100px; left: 40px;">
					<h4>50,000</h4>
				</button>
				<button type="button"
					style="width: 180px; height: 90px; position: relative; top: 100px; left: 60px;">
					<h4>100,000</h4>
				</button>
				<button type="button"
					style="width: 180px; height: 90px; position: relative; top: 100px; left: 80px;">
					<h4>직접입력</h4>
				</button>
				<button type="button"
					style="width: 200px; height: 100px; position: relative; top: 100px; left: 130px;">
					<h4>
						<a href="<%=contextPath%>/donation.po">후원하기</a>
					</h4>
				</button>
				<div></div>
			</div>
		</div>
		<br>
		<br> <br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>

		<div class="col s12 m2 z-depth-2 slide-effect" id="content5"
			style="position: relative; bottom: 200px; right: 0px;">
			<div>
				<h3 style="text-align: center;">
					<b>후원절차</b>
				</h3>
			</div>
			<div
				style="box-sizing: border-box; border: 1px solid; width: 1100px; height: 359px; background-color:white;">
				<div style="position: relative; top: 35px;">
					<img src="views/7H_The_Town/resource/img/강아지이모티콘.png"
						style="position: relative; top: 10px; left: 80px;" width="100px"
						height="100px"> <img
						src="views/7H_The_Town/resource/img/강아지이모티콘.png"
						style="position: relative; top: 10px; left: 230px;" width="100px"
						height="100px"> <img
						src="views/7H_The_Town/resource/img/강아지이모티콘.png"
						style="position: relative; top: 10px; left: 450px;" width="100px"
						height="100px"> <img
						src="views/7H_The_Town/resource/img/개집.png"
						style="position: relative; top: 10px; left: 630px;" width="100px"
						height="100px">
				</div>
				<div style="position: relative; top: 10px;">
					<div
						style="border: 0px solid black; height: 200px; width: 200px; position: relative; top: 54px; left: 60px;">
						<h5>
							<b>후원금 모음</b>
						</h5>
					</div>
					<div
						style="border: 0px solid black; height: 200px; width: 200px; position: relative; top: -162px; left: 290px;">
						<div>
							<h5>
								<b>후원금 사용계획<br> 유기견 보호&비품 <br> 업체선정
								</b>
							</h5>
						</div>
					</div>
					<div
						style="border: 0px solid black; height: 200px; width: 200px; position: relative; top: -378px; left: 600px;">
						<div>
							<h5>
								<b>유기견 보호 및 분양</b>
							</h5>
						</div>
					</div>

					<div
						style="border: black; height: 200px; width: 200px; position: relative; top: -595px; left: 900px;">
						<div>
							<h5>
								<b>후원금 사용 세부내역 공유</b>
							</h5>
						</div>


						<div style="position: relative; left: 25px;">
							<h5 style="position: relative; top: -50px; left: -700px;">▶</h5>
							<h5 style="position: relative; top:  -90px; left: -400px;">▶</h5>
							<h5 style="position: relative; top: -130px; left: -90px;">▶</h5>
						</div>
					</div>

				</div>
			</div>

		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	</div>



	<%@ include file="/views/7H_The_Town/Footer.jsp" %>



	<script>
        let slides = document.querySelector('.slides');
        let slideImg = document.querySelectorAll('.slides li');
        currentIdx = 0;
        slideCount = slideImg.length;
        prev = document.querySelector('.prev'); //이전 버튼
        next = document.querySelector('.next'); //다음 버튼
        slideWidth = 300; //슬라이드이미지 넓이
        slideMargin = 100; //슬라이드 끼리의 마진값
        makeClone(); // 처음이미지와 마지막 이미지 복사 함수
        initfunction(); //슬라이드 넓이와 위치값 초기화 함수
        function makeClone() {
            let cloneSlide_first = slideImg[0].cloneNode(true);
            let cloneSlide_last = slides.lastElementChild.cloneNode(true);
            slides.append(cloneSlide_first);
            slides.insertBefore(cloneSlide_last, slides.firstElementChild);
        }
        function initfunction() {
            slides.style.width = (slideWidth + slideMargin) * (slideCount + 2) + 'px';
            slides.style.left = -(slideWidth + slideMargin) + 'px';
        }
        next.addEventListener('click', function () {
            //다음 버튼 눌렀을때
            if (currentIdx <= slideCount - 1) {
                //슬라이드이동
                slides.style.left = -(currentIdx + 2) * (slideWidth + slideMargin) + 'px';
                slides.style.transition = `${0.5}s ease-out`; //이동 속도
            }
            if (currentIdx === slideCount - 1) {
                //마지막 슬라이드 일때
                setTimeout(function () {
                    //0.5초동안 복사한 첫번째 이미지에서, 진짜 첫번째 위치로 이동
                    slides.style.left = -(slideWidth + slideMargin) + 'px';
                    slides.style.transition = `${0}s ease-out`;
                }, 500);
                currentIdx = -1;
            }
            currentIdx += 1;
        });
        prev.addEventListener('click', function () {
            //이전 버튼 눌렀을때
            console.log(currentIdx);
            if (currentIdx >= 0) {
                slides.style.left = -currentIdx * (slideWidth + slideMargin) + 'px';
                slides.style.transition = `${0.5}s ease-out`;
            }
            if (currentIdx === 0) {
                setTimeout(function () {
                    slides.style.left = -slideCount * (slideWidth + slideMargin) + 'px';
                    slides.style.transition = `${0}s ease-out`;
                }, 500);
                currentIdx = slideCount;
            }
            currentIdx -= 1;
        });
    </script>


</body>

</html>
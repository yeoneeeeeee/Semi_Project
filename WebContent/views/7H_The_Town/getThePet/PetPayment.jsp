<%@ page import="com.semi.pet.model.vo.Pet, com.semi.board.model.vo.GetThePet, java.text.NumberFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	GetThePet g = (GetThePet)request.getAttribute("g");
	Pet p = (Pet)request.getAttribute("p");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>7H THE TOWN | GetThePet 결제창</title>
    <link rel="icon" type="image/png" sizes="32x32" href="views/7H_The_Town/resource/img/favicon-32x32.png">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/fonts/fonts.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materialize.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/header.css">
    <script src="views/7H_The_Town/resource/CSS,JS/header.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/footer.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/getThePet/PetPayment.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeBtn.css">
    <script src="views/7H_The_Town/resource/CSS,JS/materialize/js/materialize.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>

    <%@ include file="/views/common/Header.jsp" %>


    <div class="paymentBox col s12 m2 z-depth-2">

        <h4>
            배송지 선택/결제
        </h4>
        <div class="paymentForm">
            <form class="col s12" action="insert.d" method="post">
                <div class="deliverySelect">
                    <p>
                        <label>
                            <input class="with-gap" name="addressRadio" type="radio" value="픽업" checked/>
                            <span>픽업</span>
                        </label>
                    </p>
                    <p>
                        <label>
                            <input class="with-gap" name="addressRadio" type="radio" value="배송" />
                            <span>배송</span>
                        </label>
                    </p>
                </div>
			                
                <div class="addressSelect">
                    <div class="col s12">
                        <div class="input-field inline">
                            <input id="sample6_postcode" name="postCode" type="text" style="width: 550px;">
                            <label for="sample6_postcode" style="font-weight: bold;"></label>
                            <span class="helper-text" style="font-size: 10px; font-weight: bold;">우편번호</span>
		                    <input class="searchAddressBtn" type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
                        </div>
                    </div>
                    <div class="col s12">
                        <div class="input-field inline">
                            <input id="sample6_address" name="mainAddress" type="text" style="width: 550px;">
                            <label for="sample6_address" style="font-weight: bold;"></label>
                            <span class="helper-text" style="font-size: 10px; font-weight: bold;">주소</span>
                        </div>
                    </div>
                    <div class="col s12">
                        <div class="input-field inline">
                            <input id="sample6_detailAddress" name="detailAddress" type="text" style="width: 550px;">
                            <label for="sample6_detailAddress" style="font-weight: bold;"></label>
                            <span class="helper-text" style="font-size: 10px; font-weight: bold;">상세 주소</span>
                        </div>
                    </div>
                    <div class="col s12">
                        <div class="input-field inline">
                            <input id="sample6_extraAddress" name="extraAddress" type="text" style="width: 550px;">
                            <label for="sample6_extraAddress" style="font-weight: bold;"></label>
                            <span class="helper-text" style="font-size: 10px; font-weight: bold;">참고사항</span>
                        </div>
                    </div>
                    <div class="col s12">
                        <div class="input-field inline">
                            <input class="datepicker" id="hopeDate" name="hopeDate" type="text" style="width: 550px;">
                            <label for="hopeDate" style="font-weight: bold;"></label>
                            <span class="helper-text" style="font-size: 10px; font-weight: bold;">입양 희망 날짜(YY/MM/DD)</span>
                        </div>
                    </div>
                </div>

                <div class="paymentLine"> </div>

                <div class="petInfoCheck">
                    <img src="views/7H_The_Town/resource/img/7H_THE_TOWN_LOGO.png" width="300px" height="300px" alt="">
                    <div>
                        <p><%=p.getPetName() %></p>
                        <p><%=p.getPetKind() %></p>
                        <p><%=p.getPetGender() %></p>
                        <p><%=p.getPetAge() %> 세</p>
                        <input type="hidden" name="petNo" value="<%=p.getPetNo()%>">
                    </div>
                </div>

                <div class="paymentLine"> </div>

                <div class="paymentAmount">
                    <p>결제 예정 금액</p>
                    <% String petPrice = numberFormat.format(p.getPetPrice()); %>
                    <p><%=petPrice %> 원</p>
                </div>

                <div class="paymentLine"> </div>

                <div class="paymentMethod1">
                    <p>결제 수단 선택</p>
                </div>
                <div class="paymentMethod2">
                    <p>
                        <label>
                            <input class="with-gap" name="paymentRadio" type="radio" checked="checked" />
                            <span>신용 카드</span>
                        </label>
                    </p>
                    <p>
                        <label>
                            <input class="with-gap" name="paymentRadio" type="radio"  />
                            <span>핸드폰 결제</span>
                        </label>
                    </p>
                    <p>
                        <label>
                            <input class="with-gap" name="paymentRadio" type="radio"  />
                            <span>무통장 입금</span>
                        </label>
                    </p>
                    <p>
                        <label>
                            <input class="with-gap" name="paymentRadio" type="radio"  />
                            <span>간편 결제</span>
                        </label>
                    </p>
                </div>
                <div class="paymentSubmit">
                    <input type="submit" value="결제하기">
                </div>
            </form>
            
        </div>
    
    </div>

    <%@ include file="/views/7H_The_Town/Footer.jsp" %>
    
    
    <script>
    
	    $.datepicker.setDefaults({
	    	  dateFormat: 'yy-mm-dd',
	    	  prevText: '이전 달',
	    	  nextText: '다음 달',
	    	  monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	    	  monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	    	  dayNames: ['일', '월', '화', '수', '목', '금', '토'],
	    	  dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
	    	  dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
	    	  showMonthAfterYear: true,
	    	  yearSuffix: '년'
	    });
	
	    $(function () {
	      $('.datepicker').datepicker();
	    });	
    
        function sample6_execDaumPostcode() {
            new daum.Postcode({
                oncomplete: function (data) {
                    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                    // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                    var addr = ''; // 주소 변수
                    var extraAddr = ''; // 참고항목 변수

                    //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                    if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                        addr = data.roadAddress;
                    } else { // 사용자가 지번 주소를 선택했을 경우(J)
                        addr = data.jibunAddress;
                    }

                    // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                    if (data.userSelectedType === 'R') {
                        // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                        // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                        if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                            extraAddr += data.bname;
                        }
                        // 건물명이 있고, 공동주택일 경우 추가한다.
                        if (data.buildingName !== '' && data.apartment === 'Y') {
                            extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                        }
                        // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                        if (extraAddr !== '') {
                            extraAddr = ' (' + extraAddr + ')';
                        }
                        // 조합된 참고항목을 해당 필드에 넣는다.
                        document.getElementById("sample6_extraAddress").value = extraAddr;

                    } else {
                        document.getElementById("sample6_extraAddress").value = '';
                    }

                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById('sample6_postcode').value = data.zonecode;
                    document.getElementById("sample6_address").value = addr;
                    // 커서를 상세주소 필드로 이동한다.
                    document.getElementById("sample6_detailAddress").focus();
                }
            }).open();
        }
    </script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    
</body>
</html>
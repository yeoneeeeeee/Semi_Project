<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>7H THE TOWN | GetThePet 게시글 등록</title>
	<link rel="icon" type="image/png" sizes="32x32" href="views/7H_The_Town/resource/img/favicon-32x32.png">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/fonts/fonts.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materialize.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/header.css">
    <script src="views/7H_The_Town/resource/CSS,JS/header.js"></script>
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/footer.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/board/PostingFAQ.css">
    <link rel="stylesheet" href="views/7H_The_Town/resource/CSS,JS/materialize/css/materializeBtn.css">

</head>
<body>
    <%@ include file="/views/common/Header.jsp" %>
	
	
    <div class="main_posting_wrap">
        <h2 class="posting_title">Get The Pet 등록</h2>
        <form action="<%= contextPath %>/insert.get" id="enroll-form" method="post" enctype="multipart/form-data">
        
            <div class="category_head">
                <div class="category_title">
                	<input type="text" id="petNo" name="petNo" placeholder="펫 넘버" style="height: 58px;" required>
                </div>
                <div align="right" style="margin-right:100px; margin-top:-50px;">
                	<button type="button" class="waves-effect waves-light btn petNoCheck" onclick="petNoSearch();">이름으로 검색</button>
                	<button class="waves-effect waves-light btn petNoCheck" onclick="petNoCheck();">펫 번호확인</button>
                </div>
            </div>
            
            <div class="category_text">
                <textarea name="getContent" style="resize: none;" placeholder="내용 작성"></textarea>
	            <div id="file-area">
					<input type="file" id="file1" name="file1" onchange="loadImg(this, 1)" required>
					<input type="hidden" name="categoryNo1" value="FI1">
				</div>
            </div>
                        
            <input type="submit" align="center" class="category_sumt" value="등록하기">
            
        </form>

    </div>
    
    
    <%@ include file="/views/7H_The_Town/Footer.jsp" %>
    
    
    <script>
    
    	function petNoCheck(){
			const $petNo = $("#petNo");
			
			$.ajax({
				url : "<%= contextPath%>/petNoCheck.get",
				data : {petNo : $petNo.val()},
				success : function(result){
					if(result == "0"){
						alert("없는 펫 번호입니다.");		
						$petNo.focus();
					} else { // 사용가능
						if(confirm("사용 가능한 펫 번호입니다. 사용하시겠습니까?")){
							$petNo.attr("readonly",true); // 아이디값 확정
						} else{ // 사용안함
							$petNo.focus();
						}
					}
				}
			});
    	}
    	
    	function petNoSearch(){
 			const $petNo = $("#petNo");
 			
 			$.ajax({
 				url : "<%= contextPath%>/petNoCheck.get",
 				data : {petNo : $petNo.val()},
 				type : "post",
 				success : function(petNumber){
 					if(petNumber == ""){
 						alert("존재하지 않는 펫 이름입니다.");		
 						$petNo.focus();
 					} else { // 사용가능
 						alert("펫번호는 " + petNumber + "입니다.");		
 						$petNo.focus();
 					}
 				}
 			});
 		}
    	
    	$(function(){
            $("#file1").one("change", function(){
    			if(this.files.length==1){
                    const file = $("<input type='file' id='file2' name='file2' onchange='loadImg(this, 2)'><input type='hidden' name='categoryNo2' value='FI2'>");
                    $("#file-area").append(file);
                    
                    $(function(){
                        $("#file2").one("change", function(){
                			if(this.files.length==1){
                                const file = $("<input type='file' id='file3' name='file3' onchange='loadImg(this, 3)'><input type='hidden' name='categoryNo3' value='FI2'>");
                                $("#file-area").append(file);
                                
                                $(function(){
                                    $("#file3").one("change", function(){
                            			if(this.files.length==1){
                                            const file = $("<input type='file' id='file4' name='file4' onchange='loadImg(this, 4)'><input type='hidden' name='categoryNo4' value='FI2'>");
                                            $("#file-area").append(file);
                                            
                                            $(function(){
                                                $("#file4").one("change", function(){
                                        			if(this.files.length==1){
                                                        const file = $("<input type='file' id='file5' name='file5' onchange='loadImg(this, 5)'><input type='hidden' name='categoryNo5' value='FI2'>");
                                                        $("#file-area").append(file);
                                        			}
                                        		});
                                            });
                            			}
                            		});
                                });
                			}
                		});
                    });
    			}
    		});
        });
    	
    
    	function loadImg(inputFile, num){
			// inputFile : 현재 변화가 생긴 input type="file"요소 객체
			// num : 몇번쨰 input 요소인지 확인 후 해당 영역에 미리보기하기 위한 매개변수
			console.log(inputFile.files);
			/*
				파일 선택시 길이는 1, 파일선택 취소시 길이는 0
				length 속성을 활용해서 인풋태그에 파일 존재유무를 확인할 수 있다.
			*/
			if(inputFile.files.length==1){
				// 파일을 읽어들이는 메소드 => 매개변수로 어느파일을 읽어들일건지 선택해줘야함.
				const reader = new FileReader();
				
				// 파일을 읽어들일 수 있는 자바스크립트 내장객체 FileReader객체 생성
				reader.readAsDataURL(inputFile.files[0]); // 0번 인덱스에 담긴 파일정보 제시
				// 해당 파일을 읽어들이는 순간 그 파일만의 고유한 url이 부여
				// 해당 url을 src속성으로 부여
				
				// 파일 읽기가 완료되었을 경우 실행할 함수를 정의
				reader.onload = function(e){ // event의 target.result에 각 파일의 url이 담김
				}
				
			}
		}
    </script>
    
</body>
</html>
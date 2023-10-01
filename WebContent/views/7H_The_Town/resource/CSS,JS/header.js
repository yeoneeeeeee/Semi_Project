$(document).ready(function(){
    $(".headerLi").css("display","none");
});

$(document).ready(function(){
    $(".header").children().not(".notArea").hover(function(){
        $(".header").css("height", "230px");
        $(".naviBack").css("height", "230px");
        $(".headerLi").css("display","block");
    }, function(){
        $(".header").css("height", "100px");
        $(".naviBack").css("height", "100px");
        $(".headerLi").css("display","none");
    });
})



$(function() {
	$(window).scroll(function() {
    
        $(".slide-effect").each(function() {
        var element = $(this);
    
        // 애니메이션이 이미 실행된 경우, 해당 영역은 건너뜁니다.
            if (element.hasClass('ani-slide')) {
            return true; // continue
            }
    
            // 특정 영역이 스크롤에 보일 때 애니메이션 실행
            if (isElementInView(element)) {
            element.addClass('ani-slide');
            }
        });
    });

    // ===================================================================
    // ===================================================================
    // ===================================================================

    // 특정 요소가 스크롤에 보이는지 확인하는 함수
    function isElementInView(element) {
        var windowHeight = $(window).height();
        var scrollPosition = $(window).scrollTop();
        var elementOffset = element.offset().top;
    
        if (elementOffset < (scrollPosition + windowHeight)) {
            return true;
        }
        return false;
    }
})




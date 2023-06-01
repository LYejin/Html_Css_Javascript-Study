<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	  <title>Studio GHIBLI</title>
	  <link rel="stylesheet" href="css/style.css" />
	  <script>
	  		document.cookie = "buttonListNumber=1";
	  </script>
		<jsp:include page="./head.jsp" />
	  <style>
	    body {
	      background-image: url("images/Py0.gif");
	      background-repeat: no-repeat;
	      background-attachment: fixed;
	      background-position: center;
	      background-size: cover;
	    }
	  </style>
	  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	  <script type="text/javascript">
	    $('html').css({'cursor':'url(/project_4team/images/current-img.png), auto'});
	  </script> -->
	  
</head>
<body>
	<jsp:include page="./header.jsp" />
	<main>
	  <h1>안녕하세요.</h1>
	  <p id="typingText"></p>
	  <script>
	
	    const typingText = document.getElementById("typingText");
	    const messages = [
	      "행복 4조입니다٩(๑❛ᴗ❛๑)۶",
	      "열심히 하겠습니다!( •̀ω•́ )و✧"
	    ];
	    let currentMessageIndex = 0;
	    let currentMessage = "";
	    // 각 글자 입력 딜레이
	    let typingDelay = 200;
	    // 각 글자 삭제 딜레이
	    let erasingDelay = 100;
	    // 다음 메시지 출력 전 딜레이
	    let newMessageDelay = 2000;
	
	    function type() {
	      if (currentMessageIndex < messages.length) {
	        if (currentMessage.length === messages[currentMessageIndex].length) {
	          // 모든 글자를 입력한 경우, 글자가 삭제되도록.
	          typingText.classList.remove("typing");
	          setTimeout(erase, newMessageDelay);
	          return;
	        }
	
	        typingText.textContent = messages[currentMessageIndex].slice(0, currentMessage.length + 1);
	        currentMessage += messages[currentMessageIndex][currentMessage.length];
	
	        setTimeout(type, typingDelay);
	      }
	    }
	
	    function erase() {
	      if (currentMessage.length === 0) {
	        // 모든 글자를 삭제한 경우, 다음 메시지로 넘어갈 수 있게.
	        currentMessageIndex = (currentMessageIndex + 1) % messages.length;
	        setTimeout(type, typingDelay);
	        return;
	      }
	
	      typingText.textContent = messages[currentMessageIndex].slice(0, currentMessage.length - 1);
	      currentMessage = currentMessage.slice(0, -1);
	
	      setTimeout(erase, erasingDelay);
	    }
	
	    type();
	  </script>
	  <div id="main-container">
	    <div id="hero-wrapper">
	      <section id="hero" class="d-flex align-items-center">
	
	        <div class="container position-relative" data-aos="fade-up" data-aos-delay="100">
	
	          <div class="row icon-boxes">
	            <div class="col-md-6 col-lg-3 d-flex justify-content-center align-items-stretch mb-5 mb-lg-0" id="mainicon"
	                 data-aos="zoom-in" data-aos-delay="500"
	                 onclick="location.href='https://castlehyeon.github.io/my-portfolio/';">
	              <div>
	                <div class="icon-box  border rounded-circle">
	                  <img src="https://movie4team.s3.ap-northeast-2.amazonaws.com/KSHimg.jpeg" alt="" width="100">
	                </div>
	
	                <div>
	                  <p class="text-white display-4 font-weight-bold" style="font-size: 40px;">
	                    Seonghyeon</p>
	                  <p class="text-white display-4 font-weight" style="font-size: 17px;">
	                    더존5기 파이팅ೕ(•̀ᴗ•́)!!</p>
	                </div>
	
	              </div>
	            </div>
	
	            <div class="col-md-6 col-lg-3 d-flex justify-content-center align-items-stretch mb-5 mb-lg-0" id="mainicon"
	                 data-aos="zoom-in" data-aos-delay="500"
	                 onclick="location.href='https://crystal9799.github.io/2th_Report/';">
	              <div>
	                <div class="icon-box  border rounded-circle">
	                  <img src="images/LGHimg.JPG" alt="" width="100">
	                </div>
	
	                <div>
	                  <p class="text-white display-4 font-weight-bold" style="font-size: 40px;">
	                    Gunhee</p>
	                  <p class="text-white display-4 font-weight" style="font-size: 17px;">
	                    더존5기 파이팅ೕ(•̀ᴗ•́)!!</p>
	                </div>
	
	              </div>
	            </div>
	            <div class="col-md-6 col-lg-3 d-flex justify-content-center align-items-stretch mb-5 mb-lg-0" id="mainicon"
	                 data-aos="zoom-in" data-aos-delay="500" onclick="location.href='https://seoyeoe.github.io';">
	              <div>
	                <div class="icon-box  border rounded-circle">
	                  <img src="https://movie4team.s3.ap-northeast-2.amazonaws.com/LSYimg.JPG" alt="" width="100">
	                </div>
	
	                <div>
	                  <p class="text-white display-4 font-weight-bold" style="font-size: 40px;">
	                    Seoyeon</p>
	                  <p class="text-white display-4 font-weight" style="font-size: 17px;">
	                    더존5기 파이팅ೕ(•̀ᴗ•́)!!</p>
	                </div>
	
	              </div>
	            </div>
	
	            <div class="col-md-6 col-lg-3 d-flex justify-content-center align-items-stretch mb-5 mb-lg-0" id="mainicon"
	                 data-aos="zoom-in" data-aos-delay="500" onclick="location.href='https://lyejin.github.io/my_portfoilo/';">
	              <div>
	                <div class="icon-box border rounded-circle">
	                  <img src="https://lyejin.github.io/my_portfoilo/image/LYJimg.JPG" alt="" width="100">
	                </div>
	                <div>
	                  <p class="text-white display-4 font-weight-bold" style="font-size: 40px;">
	                    Yejin</p>
	                  <p class="text-white display-4 font-weight" style="font-size: 17px;">
	                    더존5기 파이팅ೕ(•̀ᴗ•́)!!</p>
	                </div>
	              </div>
	            </div>
	
	          </div>
	
	      </section><!-- End Hero -->
	    </div>
	  </div>
	</main>
	<jsp:include page="./footer.jsp" />
	<script src="js/head.js"></script>
	<!--<script src="js/cusor.js"></script>-->
</body>
</html>
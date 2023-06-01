<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
		  <!--css 초기화-->
	  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
	
	  <!-- SWIPER 외부 라이브러리 연결-->
	  <link rel="stylesheet" href="https://unpkg.com/swiper@8/swiper-bundle.min.css" />
	  <script src="https://unpkg.com/swiper@8/swiper-bundle.min.js"></script>
	
	  <!--google material icon 사용
	    class="material-icons"-->
	  <link rel="stylesheet" href="http://fonts.googleapis.com/icon?family=Material+Icons">
	
	  <!-- main.js 연결 -->
	  <script defer src="./main.js"></script>
	  <script defer src="./js/music3.js"></script>

	  <!-- main.css 연결 -->
	  <link rel="stylesheet" href="./css/music3.css">
	  <jsp:include page="./head.jsp" />
	  <script>
	  		document.cookie = "buttonListNumber=5";
	  </script>
	  <style>
      body {
        background-image: url("./images/Py0.gif");
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-position: center;
        background-size: cover;
      }
    </style>
</head>
<body>
	<jsp:include page="./header.jsp" />
	<main class="music_container_wrapper">
    <div class="swiper" id="sid">
      <div class="swiper-wrapper">
        
        <div class="swiper-slide">
          <div class="song1">
            <div class="image1">
              <img src="https://contents.kyobobook.co.kr/sih/fit-in/458x0/pdt/9791133477210.jpg" id="songimg"
                style="width: 250px; height: 250px" />
            </div>

            <div class="name" id="n1">
              <p id="f1">인생의 회전목마</p>
              <p id="f2">히사이시 조</p>
            </div>

            <input type="range" min="0" max="100" value="0" id="slider" onchange="change_duration()" />
            <audio src="" id="audio1"></audio>

            <div class="durations">
              <p id="current_duration1">0:00</p>
              <p id="total_duration1">3:00</p>
            </div>

            <div class="iconc" id="m1">
              <img src="images/prevplay.png" id="previmg" class="pv1" />
              <img src="images/playb.png" id="playimg" class="p1" />
              <img src="images/nextplay.png" id="nextimg" class="pn1" />
            </div>
          </div>
        </div>

        <div class="swiper-slide">
          <div class="song1">
            <div class="image1">
              <img
                src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLJ_gJ8FBBlVg8E8UcHqrEIJ1mQ1uZXEnZeNejwGKA0NKq95YzRrHYJBg3fwzJ-nHFaps&usqp=CAU"
                id="songimg" style="width: 250px; height: 250px" />
            </div>

            <div class="name" id="n1">
              <p id="f1">벼랑 위의 포뇨</p>
              <p id="f2">히사이시 조</p>
            </div>

            <input type="range" min="0" max="100" value="0" id="slider" onchange="change_duration()" />
            <audio src="" id="audio2"></audio>
            <div class="durations">
              <p id="current_duration1">0:00</p>
              <p id="total_duration1">3:00</p>
            </div>

            <div class="iconc" id="m1">
              <img src="images/prevplay.png" id="previmg" class="pv2" />
              <img src="images/playb.png" id="playimg" class="p2" />
              <img src="images/nextplay.png" id="nextimg" class="pn2" />
            </div>
          </div>
        </div>

        <div class="swiper-slide">
          <div class="song1">
            <div class="image1">
              <img
                src="https://mblogthumb-phinf.pstatic.net/MjAxNzA2MDRfMjQy/MDAxNDk2NTY4NjI4MjI5.o6qKy0vaoTOHumrOCijDxf0eYxEL16SPJCeoitOYbeEg.eb4qdhFPuB1LRG-xWciJa4pfNw4Ojb646byFPf1RkRkg.JPEG.daekk1228/%EC%84%BC%EA%B3%BC_%EC%B9%98%ED%9E%88%EB%A1%9C%EC%9D%98_%ED%96%89%EB%B0%A9%EB%B6%88%EB%AA%85.jpg?type=w800"
                id="songimg" style="width: 250px; height: 250px" />
            </div>

            <div class="name" id="n1">
              <p id="f1">센과 치히로의 행방불명</p>
              <p id="f2">키무라 유미</p>
            </div>

            <input type="range" min="0" max="100" value="0" id="slider" onchange="change_duration()" />
            <audio src="" id="audio3"></audio>

            <div class="durations">
              <p id="current_duration1">0:00</p>
              <p id="total_duration1">3:00</p>
            </div>

            <div class="iconc" id="m1">
              <img src="images/prevplay.png" id="previmg" class="pv3" />
              <img src="images/playb.png" id="playimg" class="p3" onclick="change_duration()" />
              <img src="images/nextplay.png" id="nextimg" class="pn3" />
            </div>
          </div>
        </div>

        <div class="swiper-slide">
          <div class="song1">
            <div class="image1">
              <img
                src="https://upload.wikimedia.org/wikipedia/ko/9/9b/%EB%A7%88%EB%85%80%EB%B0%B0%EB%8B%AC%EB%B6%80%ED%82%A4%ED%82%A4_%ED%8F%AC%EC%8A%A4%ED%84%B0.jpg"
                id="songimg" style="width: 250px; height: 250px" />
            </div>

            <div class="name" id="n1">
              <p id="f1">바다가 보이는 마을</p>
              <p id="f2">히사이시 조</p>
            </div>

            <input type="range" min="0" max="100" value="0" id="slider" onchange="change_duration()" />
            <audio src="" id="audio4"></audio>
            <div class="durations">
              <p id="current_duration1">0:00</p>
              <p id="total_duration1">3:00</p>
            </div>

            <div class="iconc" id="m1">
              <img src="images/prevplay.png" id="previmg" class="pv4" />
              <img src="images/playb.png" id="playimg" class="p4" />
              <img src="images/nextplay.png" id="nextimg" class="pn4" />
            </div>
          </div>
        </div>
      </div>
      <div class="swiper-pagination"></div>
      <div class="swiper-button-prev">
        <!--      <div class="material-icons">arrow_back</div>-->
        <img src="images/prevplay.png" class="material-icons" style="width:55px" />
      </div>
      <div class="swiper-button-next">
        <!--      <div class="material-icons">arrow_forward</div>-->
        <img src="images/nextplay.png" class="material-icons" style="width:55px" />
      </div>
    </div>

  </main>
  	<jsp:include page="./footer.jsp" />
</body>
</html>
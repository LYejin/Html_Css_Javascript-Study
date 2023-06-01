<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	  <link rel="stylesheet" href="css/style.css" />
	  <jsp:include page="./head.jsp" />
	  <script>
	  		document.cookie = "buttonListNumber=3";
	  </script>
	    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
</head>
<body>
	<jsp:include page="./header.jsp" />
	<main class="music_container_wrapper">
	    <div class="music_container">
	      <main class="page_one__main">
	        <div class="main__singer_info_container">
	          <div class="singer-photo">
	            <img src="images/logo.png" />
	          </div>
	          <span class="singer-name">지브리</span>
	          <span class="singer-category">애니메이션 ost</span>
	        </div>
	        <div class="main__shuffle_or_heart">
	          <div class="shuffle">Shuffle</div>
	          <div class="heart">
	            <i class="fas fa-heart" id="heartIcon" style="color: rgb(177, 177, 177)"></i>
	            <span class="heartSpan">&nbsp;&nbsp;391,234</span>
	          </div>
	        </div>
	        <div class="main__playList">
	          <div class="playList__song" data-index="0">
	            <div class="song__album">
	              <img src="https://contents.kyobobook.co.kr/sih/fit-in/458x0/pdt/9791133477210.jpg" />
	            </div>
	            <div class="song__album_info">
	              <span class="album_info__singer">히사이시 조</span>
	              <span class="album_info__title">인생의 회전목마</span>
	            </div>
	            <div class="song__ellipsis_container">
	              <i class="fas fa-ellipsis-v"></i>
	            </div>
	          </div>
	          <div class="playList__song" data-index="1">
	            <div class="song__album">
	              <img
	                src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLJ_gJ8FBBlVg8E8UcHqrEIJ1mQ1uZXEnZeNejwGKA0NKq95YzRrHYJBg3fwzJ-nHFaps&usqp=CAU" />
	              <div class="song__play_icon_container">
	                <i class="fas fa-play"></i>
	              </div>
	            </div>
	            <div class="song__album_info">
	              <span class="album_info__singer">히사이시 조</span>
	              <span class="album_info__title">벼랑 위의 포뇨(ost)</span>
	            </div>
	            <div class="song__ellipsis_container">
	              <i class="fas fa-ellipsis-v"></i>
	            </div>
	          </div>
	          <div class="playList__song" data-index="2">
	            <div class="song__album">
	              <img
	                src="https://mblogthumb-phinf.pstatic.net/MjAxNzA2MDRfMjQy/MDAxNDk2NTY4NjI4MjI5.o6qKy0vaoTOHumrOCijDxf0eYxEL16SPJCeoitOYbeEg.eb4qdhFPuB1LRG-xWciJa4pfNw4Ojb646byFPf1RkRkg.JPEG.daekk1228/%EC%84%BC%EA%B3%BC_%EC%B9%98%ED%9E%88%EB%A1%9C%EC%9D%98_%ED%96%89%EB%B0%A9%EB%B6%88%EB%AA%85.jpg?type=w800" />
	            </div>
	            <div class="song__album_info">
	              <span class="album_info__singer">키무라 유미</span>
	              <span class="album_info__title">센과 치히로의 행방불명</span>
	            </div>
	            <div class="song__ellipsis_container">
	              <i class="fas fa-ellipsis-v"></i>
	            </div>
	          </div>
	          <div class="playList__song" data-index="3">
	            <div class="song__album">
	              <img
	                src="https://upload.wikimedia.org/wikipedia/ko/9/9f/%EC%B2%9C%EA%B3%B5%EC%9D%98_%EC%84%B1_%EB%9D%BC%ED%93%A8%ED%83%80_%ED%8F%AC%EC%8A%A4%ED%84%B0.jpg" />
	            </div>
	            <div class="song__album_info">
	              <span class="album_info__singer">히사이시 조</span>
	              <span class="album_info__title">너를 태우고</span>
	            </div>
	            <div class="song__ellipsis_container">
	              <i class="fas fa-ellipsis-v"></i>
	            </div>
	          </div>
	          <div class="playList__song" data-index="4">
	            <div class="song__album">
	              <img
	                src="https://upload.wikimedia.org/wikipedia/ko/9/9b/%EB%A7%88%EB%85%80%EB%B0%B0%EB%8B%AC%EB%B6%80%ED%82%A4%ED%82%A4_%ED%8F%AC%EC%8A%A4%ED%84%B0.jpg" />
	            </div>
	            <div class="song__album_info">
	              <span class="album_info__singer">히사이시 조</span>
	              <span class="album_info__title">바다가 보이는 마을</span>
	            </div>
	            <div class="song__ellipsis_container">
	              <i class="fas fa-ellipsis-v"></i>
	            </div>
	          </div>
	        </div>
	        <div class="main__controller">
	          <div class="main__controller_wrapper">
	            <div class="controller__playing">
	              <span class="playing__singer"></span>
	              <span class="playing__title"></span>
	            </div>
	            <div class="controller__btn">
	              <i class="fas fa-step-backward" id="prev-bottom-btn" style="cursor: pointer"></i>
	              <i class="fa-solid fa-play" id="play-bottom-btn" style="cursor: pointer"></i>
	              <i class="fas fa-step-forward" id="next-bottom-btn" style="cursor: pointer"></i>
	            </div>
	          </div>
	        </div>
	      </main>
	
	      <!-- 뮤직플레이어 -->
	      <div class="page_two">
	        <header class="page_two__header">
	          <i class="fas fa-arrow-left" style="cursor: pointer; color: black"></i>
	          <i class="fas fa-ellipsis-v" style="cursor: pointer; color: black"></i>
	        </header>
	        <main class="page_two__main">
	          <div class="page_two__main__current_music_photo">
	            <img src="" width="170" height="250" />
	          </div>
	          <div class="page_two__main__current_music_info">
	            <span class="currrent_music_info__title"></span>
	            <span class="currrent_music_info__singer"></span>
	          </div>
	          <div class="m-progress">
	            <div class="page_two__main__time_bar">
	              <span class="pin"></span>
	              <audio src="" id="main-audio"></audio>
	            </div>
	            <div class="page_two__main__play_time">
	              <span class="current">0:00</span>
	              <span class="duration">0:00</span>
	            </div>
	          </div>
	          <div class="page_two__main__controller">
	            <i class="material-icons" id="repeat-btn" style="cursor: pointer; font-size: 23px">repeat</i>
	            <i class="fas fa-fast-backward" id="prev-btn" style="cursor: pointer"></i>
	            <i class="fas fa-play-circle" id="play-btn" style="cursor: pointer"></i>
	            <i class="fas fa-fast-forward" id="next-btn" style="cursor: pointer"></i>
	            <i class="fas fa-random" id="shuffle-btn" style="cursor: pointer; color: gray"></i>
	          </div>
	        </main>
	      </div>
	      <script src="https://kit.fontawesome.com/b6bfd9ecde.js" crossorigin="anonymous"></script>
	    </div>
	  </main>
	  	<jsp:include page="./footer.jsp" />
<script src="js/music_list.js"></script>
  <script src="js/script.js"></script>
</body>
</html>
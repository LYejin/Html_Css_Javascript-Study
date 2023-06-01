<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link
      rel="icon"
      href="https://douzone-bucket.s3.amazonaws.com/favicon.ico"
    />
    <script
      src="https://kit.fontawesome.com/412379eca8.js"
      crossorigin="anonymous"
    ></script>
    <link rel="stylesheet" href="css/music2.css" />
   	<jsp:include page="./head.jsp" />
	  <script>
	  		document.cookie = "buttonListNumber=4";
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
	<main>
      <div class="container">
        <h1>음악 플레이어</h1>
        <div class="music-container" id="musicContainer">
          <div class="music-info">
            <h4 id="title">노래 제목</h4>
            <div class="progress-container" id="progress-container">
              <div class="progress" id="progress"></div>
            </div>
          </div>
          <audio
            id="audio"
            src="./music/hey.mp3"
            onloadstart="this.volume=50"
          ></audio>
          <div class="img-container">
            <img src="./images/Player.gif" alt="cover" id="cover" />
          </div>
          <div class="navigation">
            <button id="prev" class="action-btn">
              <i class="fa-sharp fa-solid fa-backward"></i>
            </button>
            <button id="play" class="actiong-btn big">
              <i class="fa-solid fa-play"></i>
            </button>
            <button id="next" class="actiong-btn">
              <i class="fa-sharp fa-solid fa-forward"></i>
            </button>
          </div>
        </div>
        <div class="playlist-container">
          <h2 class="list" id="list">재생 목록</h2>
          <ul class="playlist" id="playlist">
            <li class="song" data-index="0">
              <span class="song-title">하울</span>
            </li>
            <li class="song" data-index="1">
              <span class="song-title">포뇨</span>
            <li class="song" data-index="2">
              <span class="song-title">치히로</span>
            </li>
            <li class="song" data-index="3">
              <span class="song-title">라퓨타</span>
            </li>
            <li class="song" data-index="4">
              <span class="song-title">마녀배달부</span>
            </li>
            </li>
          </ul>
        </div>
      </div>
      
      <script src="js/music2.js"></script>

    </main>
    	<jsp:include page="./footer.jsp" />
</body>
</html>
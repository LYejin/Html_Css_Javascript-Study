<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	  <jsp:include page="./head.jsp" />
	  <script>
	  		document.cookie = "buttonListNumber=2";
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
  <div id="playlist">
    <div id="playlist-container">
      <h2>플레이리스트</h2>
      <ul>
        <li
                draggable="true"
                data-src="https://movie4team.s3.ap-northeast-2.amazonaws.com/%EB%85%B9%ED%99%94_2023_05_22_15_12_29_301.mp4"
        >
          시연영상
        </li>
        <li
                draggable="true"
                data-src="https://movie4team.s3.ap-northeast-2.amazonaws.com/Howl's+Moving+Castle+-+Official+Trailer.mp4"
        >
          Howl's Moving Castle
        </li>
        <li
                draggable="true"
                data-src="https://movie4team.s3.ap-northeast-2.amazonaws.com/Ponyo+-+Official+Trailer.mp4"
        >
          Ponyo
        </li>
        <li
                draggable="true"
                data-src="https://movie4team.s3.ap-northeast-2.amazonaws.com/Kiki's+Delivery+Service+-+Official+Trailer.mp4"
        >
          Kiki's Delivery Service
        </li>
        <li
                draggable="true"
                data-src="https://movie4team.s3.ap-northeast-2.amazonaws.com/Laputa_+Castle+in+the+Sky+-+Official+Trailer.mp4"
        >
          Laputa_ Castle in the Sky
        </li>
        <li
                draggable="true"
                data-src="https://movie4team.s3.ap-northeast-2.amazonaws.com/Spirited+Away+-+Official+Trailer.mp4"
        >
          Spirited Away
        </li>
      </ul>
    </div>
  </div>
  <div id="player">
    <video id="myVideo" width="950" height="534" controls></video>
  </div>
</main>
	<jsp:include page="./footer.jsp" />
<script>
  const videoList = document.querySelector("#playlist ul");
  const videoPlayer = document.querySelector("#player");
  const myVideo = document.querySelector("#myVideo");
  const playlistContainer = document.querySelector("#playlist-container");

  videoList.addEventListener("dragstart", function (event) {
    event.dataTransfer.setData("text/plain", event.target.dataset.src);
    const clickedListItem = event.target;
    const existingImage =
            playlistContainer.querySelector(".playlist-image");

    if (existingImage) {
      existingImage.remove();
    }

    const image = document.createElement("img");
    image.src = "/project_4team/images/current-img.png";
    image.classList.add("playlist-image");

    clickedListItem.insertAdjacentElement("afterend", image);
    // 애니메이션 show 클래스 추가
    setTimeout(function () {
      image.classList.add("show");
    }, 0);
  });

  videoPlayer.addEventListener("dragover", function (event) {
    event.preventDefault();
  });

  videoPlayer.addEventListener("drop", function (event) {
    event.preventDefault();
    const videoSrc = event.dataTransfer.getData("text/plain");
    myVideo.src = videoSrc;
    myVideo.play();
  });
</script>
</body>
</html>
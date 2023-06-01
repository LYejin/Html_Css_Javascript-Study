<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	  <jsp:include page="./head.jsp" />
</head>
<body>
		<main>
    <div id="maplist">
      <h2>Map</h2>
      <div id="map" style="width:400px;height:400px;"></div>
      <script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f79fe1576145e1a90b29ddbf8cb06568"></script>
    </div>
    <div>
      <h2>Geolocation Map</h2>
      <div id="map2" style="width:400px;height:400px;"></div>
      <script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f79fe1576145e1a90b29ddbf8cb06568"></script>
    </div>

    <div id="localstorage">
      <h2 class="re">Local Storage</h2>
      <!--  웹 스토리지는 string만 지원,  key와 value로 저장-->

      <form class="js-form">
        <input type="text" placeholder=" Input Name" />
      </form>
      <!-- 이름 입력 -->
      <h2 class="js-greeting"></h2>
      <button id="addbutton" onclick="onAddClick()">submit</button>
      <button id="removbutton" onclick="onClick()">Remove</button>
    </div>

    <div id="bottom-margin"></div>

    <div id="bottom-margin"></div>
  </main>
  	<jsp:include page="./footer.jsp" />
  <script>
    var container = document.getElementById('map');
    var options = {
      center: new kakao.maps.LatLng(33.450701, 126.570667),
      level: 3
    };
    var map = new kakao.maps.Map(container, options);



    /*geolocation 으로 현재 위치 지도 띄우기*/
    var latitude = 0;
    var longitude = 0;

    $(document).ready(function () {
      if ("geolocation" in navigator) {	/* geolocation 사용 가능 */
        navigator.geolocation.getCurrentPosition(function (data) {
          var latitude = data.coords.latitude;
          var longitude = data.coords.longitude;
        }, function (error) {
          alert(error);
        }, {
          enableHighAccuracy: true,
          timeout: Infinity,
          maximumAge: 0
        });
      } else {	/* geolocation 사용 불가능 */
        alert('geolocation 사용 불가능');
      }
    });

    var container = document.getElementById('map2');
    var options = {
      center: new kakao.maps.LatLng(latitude, longitude),
      level: 3
    };
    var map = new kakao.maps.Map(container, options);

  </script>
</body>
</html>
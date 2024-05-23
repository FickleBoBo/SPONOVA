<template>
  <div>
    <div id="map"></div>
    <!-- <button @click="initMap">내위치</button>
    <button @click="displayMarker(myMarkerPosition)">즐겨찾기 마커 표시</button>
    <button @click="displayMarker([])">즐겨찾기 마커 해제</button> -->
  </div>
</template>

<script setup>
import { defineProps, onMounted, ref, toRaw } from 'vue';

const props = defineProps({
  selectedGameMap: String
});

let map = null;
const initMap = function () {

  const choicedLocation = props.selectedGameMap
  // console.log(choicedLocation)
  // console.log(typeof choicedLocation)

  let choicedLocationLat = 0;
  let choicedLocationLon = 0;
  if(choicedLocation == "서울 강동구"){
    choicedLocationLat = 37.5301933196157;
    choicedLocationLon = 127.123792501252;
  }
  if(choicedLocation == "서울 강서구"){
    choicedLocationLat = 37.5509646154244;
    choicedLocationLon = 126.849533759514;
  }
  if(choicedLocation == "서울 강남구"){
    choicedLocationLat = 37.5173319258532;
    choicedLocationLon = 127.047377408384;
  }
  if(choicedLocation == "서울 강북구"){
    choicedLocationLat = 37.6397513275882;
    choicedLocationLon = 127.025538071854;
  }
  if(choicedLocation == "서울 관악구"){
    choicedLocationLat = 37.4783683761333;
    choicedLocationLon = 126.951561853868;
  }
  if(choicedLocation == "서울 광진구"){
    choicedLocationLat = 37.5385583136667;
    choicedLocationLon = 127.082385189457;
  }
  if(choicedLocation == "서울 노원구"){
    choicedLocationLat = 37.6543617567057;
    choicedLocationLon = 127.056430475216;
  }
  if(choicedLocation == "서울 동대문구"){
    choicedLocationLat = 37.5745229817122;
    choicedLocationLon = 127.039657001091;
  }
  if(choicedLocation == "서울 동작구"){
    choicedLocationLat = 37.5124820423519;
    choicedLocationLon = 126.93931505634;
  }
  if(choicedLocation == "서울 성동구"){
    choicedLocationLat = 37.563427205337;
    choicedLocationLon = 127.036930141185;
  }
  if(choicedLocation == "서울 성북구"){
    choicedLocationLat = 37.5893588153919;
    choicedLocationLon = 127.016702905651;
  }
  if(choicedLocation == "서울 은평구"){
    choicedLocationLat = 37.6028174370823;
    choicedLocationLon = 126.928940981464;
  }
  if(choicedLocation == "서울 구로구"){
    choicedLocationLat = 37.4954330863648;
    choicedLocationLon = 126.88750531451;
  }
  if(choicedLocation == "서울 도봉구"){
    choicedLocationLat = 37.6686914100284;
    choicedLocationLon = 127.04721049936;
  }
  if(choicedLocation == "서울 종로구"){
    choicedLocationLat = 37.5735042429813;
    choicedLocationLon = 126.978989954189;
  }
  if(choicedLocation == "서울 마포구"){
    choicedLocationLat = 37.5662141900954;
    choicedLocationLon = 126.901955141101;
  }
  if(choicedLocation == "서울 서초구"){
    choicedLocationLat = 37.483588810333;
    choicedLocationLon = 127.032734543897;
  }
  if(choicedLocation == "서울 용산구"){
    choicedLocationLat = 37.5324274347658;
    choicedLocationLon = 126.990577820242;
  }
  if(choicedLocation == "서울 중구"){
    choicedLocationLat = 37.5638077703601;
    choicedLocationLon = 126.997555182293;
  }
  if(choicedLocation == "역삼 멀티캠퍼스"){
    choicedLocationLat = 37.5012863640697;
    choicedLocationLon = 127.039602741448;
  }
  if(choicedLocation == "역삼 멀티캠퍼스 303호"){
    choicedLocationLat = 37.5012863640697;
    choicedLocationLon = 127.039602741448;
  }
  if(choicedLocation == "서울 송파구"){
    choicedLocationLat = 37.51458371944;
    choicedLocationLon = 127.10591770866;
  }
  if(choicedLocation == "서울 월드컵경기장"){
    choicedLocationLat = 37.568245519837035;
    choicedLocationLon = 126.89722951425345;
  }
  if(choicedLocation == "서울 싸피체육관"){
    choicedLocationLat = 37.5012863640697;
    choicedLocationLon = 127.039602741448;
  }
  if(choicedLocation == "서울 장충체육관"){
    choicedLocationLat = 37.55819889551266;
    choicedLocationLon = 127.0067878217806;
  }
  if(choicedLocation == "고척돔"){
    choicedLocationLat = 37.498315769023364;
    choicedLocationLon = 126.86704072238187;
  }
  if(choicedLocation == "잠실 주경기장"){
    choicedLocationLat = 37.51584767667229;
    choicedLocationLon = 127.07276310176724;
  }

  myMarkerPosition.value = [[choicedLocationLat, choicedLocationLon]]

  // let myCenter = new kakao.maps.LatLng(33.450701, 126.570667); //카카오본사
  let myCenter = new kakao.maps.LatLng(choicedLocationLat, choicedLocationLon); //카카오본사
  // if (navigator.geolocation) {
  //   navigator.geolocation.getCurrentPosition((position) => {
  //     const lat = position.coords.latitude;
  //     const lon = position.coords.longitude;
  //     myCenter = new kakao.maps.LatLng(lat, lon);
  //     new kakao.maps.Marker({
  //       map,
  //       position: myCenter,
  //     });
  //     map.setCenter(myCenter);
  //   });
  // }
  const container = document.getElementById('map');
  const options = {
    center: myCenter,
    level: 5,
  }; // 지도 객체를 등록합니다.
  map = new kakao.maps.Map(container, options);
  // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
  const mapTypeControl = new kakao.maps.MapTypeControl();

  // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
  map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

  // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
  const zoomControl = new kakao.maps.ZoomControl();
  map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

  displayMarker(myMarkerPosition.value)
};

onMounted(() => {
  if (window.kakao && window.kakao.maps) {
    initMap();
  } else {
    const script = document.createElement('script'); // autoload=false 스크립트를 동적으로 로드하기 위해서 사용
    script.src = `//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${
      import.meta.env.VITE_KAKAO_API_KEY
    }`;
    script.addEventListener('load', () => {
      kakao.maps.load(initMap);
    }); //헤드태그에 추가
    document.head.appendChild(script);
  }
});

const myMarkerPosition = ref([
  [33.450701, 126.570667], 
])

const markers = ref([]);

const displayMarker = function (markerPositions) {
  //마커지우기
  if (markers.value.length > 0) {
    markers.value.forEach((marker) => marker.setMap(null));
  }

  const positions = markerPositions.map(
    (position) => new kakao.maps.LatLng(...position)
  );
  if (positions.length > 0) {
    markers.value = positions.map(
      (position) =>
        new kakao.maps.Marker({
          map: toRaw(map),
          position,
        })
    );

    // const bounds = positions.reduce(
    //   (bounds, latlng) => bounds.extend(latlng),
    //   new kakao.maps.LatLngBounds()
    // );

    // toRaw(map).setBounds(bounds);
  }
};





</script>

<style scoped>
#map {
  width: 600px;
  height: 600px;
}
</style>

// URL 쿼리스트링에서 선택된 좌석 정보를 가져오기
const urlParams = new URLSearchParams(window.location.search);
const selectedSeat = urlParams.get("selectedSeat");

// 좌석 정보를 화면에 표시
const seatInfoElement = document.getElementById("seat-info");
seatInfoElement.textContent = selectedSeat
    ? `선택된 좌석: ${selectedSeat}`
    : "선택된 좌석이 없습니다.";
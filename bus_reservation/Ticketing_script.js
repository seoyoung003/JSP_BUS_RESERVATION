// 좌석과 버튼 요소 가져오기
const seats = document.querySelectorAll(".seat");
const selectedSeatList = document.getElementById("selected-seats-list");
const nextButton = document.getElementById("next-button");

let selectedSeat = null; // 선택된 좌석

// 좌석 클릭 이벤트
seats.forEach((seat) => {
    seat.addEventListener("click", () => {
        // 기존 선택된 좌석 초기화
        if (selectedSeat) {
            selectedSeat.classList.remove("selected");
        }

        // 선택한 좌석 활성화
        seat.classList.add("selected");
        selectedSeat = seat;

        // 선택된 좌석 정보 업데이트
        selectedSeatList.textContent = `좌석 ${seat.dataset.seatId}`;

        // 버튼 활성화
        nextButton.disabled = false;
    });
});

// 다음 버튼 클릭 이벤트
nextButton.addEventListener("click", () => {
    if (!selectedSeat) {
        alert("좌석을 선택하세요.");
        return;
    }

    // 선택된 좌석 ID를 사용하여 처리 가능
    console.log(`선택된 좌석 ID: ${selectedSeat.dataset.seatId}`);

    // 페이지 이동
    window.location.href = "next_page.html";
});

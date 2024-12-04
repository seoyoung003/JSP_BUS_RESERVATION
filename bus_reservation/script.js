document.addEventListener("DOMContentLoaded", () => {
    const seats = document.querySelectorAll(".seat");
    const selectedSeatsList = document.getElementById("selected-seats-list");
    const nextButton = document.getElementById("next-button");
    let selectedSeat = null; // 선택된 좌석을 저장

    const updateNextButtonState = () => {
        nextButton.disabled = !selectedSeat;
    };

    seats.forEach((seat) => {
        // 좌석 클릭 이벤트
        seat.addEventListener("click", () => {
            const seatId = seat.dataset.seatId;

            // 기존에 선택된 좌석 해제
            if (selectedSeat) {
                const previouslySelectedSeat = document.querySelector(
                    `.seat[data-seat-id="${selectedSeat}"]`
                );
                if (previouslySelectedSeat) {
                    previouslySelectedSeat.classList.remove("selected");
                }
            }

            // 선택 상태 업데이트
            if (selectedSeat === seatId) {
                // 같은 좌석을 다시 누르면 선택 해제
                selectedSeat = null;
            } else {
                selectedSeat = seatId;
                seat.classList.add("selected");
            }

            // 선택된 좌석 업데이트
            selectedSeatsList.textContent = selectedSeat || "없음";

            // "다음" 버튼 활성화 상태 업데이트
            updateNextButtonState();
        });
    });

    // 다음 버튼 클릭 이벤트
    nextButton.addEventListener("click", () => {
        if (selectedSeat) {
            const nextPageUrl = `next_page.html?selectedSeat=${encodeURIComponent(selectedSeat)}`;
            window.location.href = nextPageUrl;
        }
    });

    // 초기 상태 설정
    updateNextButtonState();
});


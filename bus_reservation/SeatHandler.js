export function sendSeatData(seatId) {
    return fetch("http://localhost:3000/reserve", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({ seatId }),
    })
        .then((response) => {
            if (!response.ok) {
                throw new Error("서버 요청 실패");
            }
            return response.json();
        })
        .then((data) => {
            console.log("서버 응답:", data);
            return data; // 성공적으로 처리된 데이터 반환
        })
        .catch((error) => {
            console.error("서버 전송 오류:", error);
            throw error;
        });
}

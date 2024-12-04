const translations = {
    "ko": {
        "header-title": "Icon 통학버스 예매시스템",
        "nav-booking": "통학버스 예매",
        "nav-query": "조회/변경/취소",
        "nav-timetable": "운행정보",
        "nav-mypage": "마이페이지",
        "welcome-message": "통학버스 예매시스템 홈페이지 방문을 환영합니다."
    },
    "en": {
        "header-title": "Icon Shuttle Bus Reservation System",
        "nav-booking": "Shuttle Bus Booking",
        "nav-query": "Query/Change/Cancel",
        "nav-timetable": "Timetable",
        "nav-mypage": "My Page",
        "welcome-message": "Welcome to the Shuttle Bus Reservation System"
    },
    "zh": {
        "header-title": "Icon 校车预订系统",
        "nav-booking": "校车预订",
        "nav-query": "查询/更改/取消",
        "nav-timetable": "运行信息",
        "nav-mypage": "个人主页",
        "welcome-message": "欢迎访问校车预订系统网站"
    },
    "ja": {
        "header-title": "Icon 通学バス予約システム",
        "nav-booking": "通学バス予約",
        "nav-query": "照会/変更/キャンセル",
        "nav-timetable": "運行情報",
        "nav-mypage": "マイページ",
        "welcome-message": "通学バス予約システムのウェブサイトへようこそ"
    }
};
function changeLanguage() {
    const language = document.getElementById('language-selector').value;
    const translation = translations[language];

        for (const id in translation) {
        const element = document.getElementById(id);
        if (element) {
            element.innerText = translation[id];
        }
    }
}

window.onload = () => {
    document.getElementById('language-selector').value = "ko";
    changeLanguage();
};
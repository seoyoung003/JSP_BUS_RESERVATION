<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import="java.sql.*" %>
<% request.setCharacterEncoding("EUC-KR"); %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>백석대학교 통학버스 예매시스템</title>
    <link rel="stylesheet" href="main.css" />
</head>
<body>
    <header>
        <div>
            <h1><a href="Main.html">Icon 통학버스 예매시스템</a></h1>
        </div>
        <nav>	
            <ul>
            <li><a href="departure.html">통학버스 예매</a></li>
            <li><a href="QueryCancel.html">조회/변경/취소</a></li>
            <li><a href="Timetable.html">운행정보</a></li>
            <li><a href="Mypage.html">마이페이지</a></li>
            </ul>
        </nav>
    </header>
    <h3>통학버스 예매시스템 홈페이지 방문을 환영합니다.</h3>
</body>
</html>

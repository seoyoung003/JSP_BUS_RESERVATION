<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ page import="java.sql.*, javax.sql.*, javax.naming.*" %>
<%
    // DB 연결 설정
    Context ctx = new InitialContext();
    DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/YourDataSource");
    Connection conn = ds.getConnection();

    // HTML 폼에서 전달된 값 받기
    String departure = request.getParameter("departure");
    String price = request.getParameter("price");
    String option = request.getParameter("option");
    String seat = request.getParameter("seat");

    // 예약 정보 저장
    String query = "INSERT INTO reservations (departure, price, option, seat) VALUES (?, ?, ?, ?)";
    PreparedStatement ps = conn.prepareStatement(query);
    ps.setString(1, departure);
    ps.setString(2, price);
    ps.setString(3, option);
    ps.setInt(4, Integer.parseInt(seat));

    int result = ps.executeUpdate();
    if (result > 0) {
        out.println("예약이 완료되었습니다.");
    } else {
        out.println("예약 저장에 실패했습니다.");
    }

    // 자원 해제
    ps.close();
    conn.close();
%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ page import="java.sql.*, javax.sql.*, javax.naming.*" %>
<%
    // DB 연결 설정
    Context ctx = new InitialContext();
    DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/YourDataSource");
    Connection conn = ds.getConnection();

    // 로그인된 사용자 ID 가져오기 (예: session에서)
    int userId = (Integer) session.getAttribute("userId");

    // 예약 정보 조회
    String query = "SELECT * FROM reservations WHERE user_id = ?";
    PreparedStatement ps = conn.prepareStatement(query);
    ps.setInt(1, userId);
    ResultSet rs = ps.executeQuery();

    // 예약 정보 출력
    if (rs.next()) {
        out.println("<p>출발지: " + rs.getString("departure") + "</p>");
        out.println("<p>노선: " + rs.getString("option") + "</p>");
        out.println("<p>좌석 번호: " + rs.getInt("seat") + "</p>");
        out.println("<p>금액: " + rs.getString("price") + "</p>");
    } else {
        out.println("조회된 예매 정보가 없습니다.");
    }

    // 자원 해제
    rs.close();
    ps.close();
    conn.close();
%>
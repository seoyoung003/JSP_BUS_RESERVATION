<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ page import="java.sql.*, javax.sql.*, javax.naming.*" %>
<%
    // DB 연결 설정
    Context ctx = new InitialContext();
    DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/YourDataSource");
    Connection conn = ds.getConnection();

    // 예약 취소 처리
    int reservationId = Integer.parseInt(request.getParameter("reservationId"));

    String query = "DELETE FROM reservations WHERE id = ?";
    PreparedStatement ps = conn.prepareStatement(query);
    ps.setInt(1, reservationId);

    int result = ps.executeUpdate();
    if (result > 0) {
        out.println("예매가 취소되었습니다.");
    } else {
        out.println("예매 취소에 실패했습니다.");
    }

    // 자원 해제
    ps.close();
    conn.close();
%>

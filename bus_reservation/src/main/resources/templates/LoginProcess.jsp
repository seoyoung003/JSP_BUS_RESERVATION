<%@ page import="java.sql.*, javax.servlet.http.*, javax.servlet.*" %>
<%
    // 요청 파라미터로부터 사용자 입력 받기
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // 데이터베이스 연결 정보
    String dbURL = "jdbc:mysql://localhost:3306/bus_reservation";
    String dbUser = "root";
    String dbPassword = "kim123456";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        // 데이터베이스 연결
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);

        // 사용자 인증 쿼리 실행
        String sql = "SELECT user_id FROM users WHERE username = ? AND password = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            // 로그인 성공 시 세션에 사용자 정보 저장
            HttpSession session = request.getSession();
            session.setAttribute("user_id", rs.getInt("user_id"));
            session.setAttribute("username", username);
            response.sendRedirect("welcome.jsp"); // 로그인 성공 페이지로 리다이렉트
        } else {
            // 로그인 실패 시 로그인 페이지로 리다이렉트
            response.sendRedirect("login.jsp?error=1");
        }
    } catch (Exception e) {
        e.printStackTrace();
        response.sendRedirect("login.jsp?error=1");
    } finally {
        // 리소스 정리
        if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
        if (pstmt != null) try { pstmt.close(); } catch (SQLException ignore) {}
        if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
    }
%>

package com.example.bus_reservation.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            // 데이터베이스 연결 및 인증 처리
            String dbURL = "jdbc:mysql://localhost:3306/your_database";
            String dbUser = "your_username";
            String dbPassword = "your_password";
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);

            // 사용자 확인 쿼리
            String sql = "SELECT user_id FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // 로그인 성공 시 세션에 사용자 정보 저장
                HttpSession session = request.getSession();
                session.setAttribute("user_id", rs.getInt("user_id"));
                session.setAttribute("username", username);
                response.sendRedirect("welcome.jsp");
            } else {
                // 로그인 실패 시 로그인 페이지로 리다이렉트
                response.sendRedirect("login.jsp?error=1");
            }

            // 리소스 정리
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=1");
        }
    }
}


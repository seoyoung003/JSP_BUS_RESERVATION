package com.example.bus_reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.sql.*;

@Controller
public class MyController {

    // 로그인 페이지 반환
    @GetMapping("/login")
    public String login() {
        return "login"; // "login.jsp"를 반환
    }

    @PostMapping("/login")
    public String loginProcess(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        String dbURL = "jdbc:mysql://localhost:3306/bus_reservation";
        String dbUser = "root";
        String dbPassword = "kim123456";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 입력된 username과 password를 로그로 확인
            System.out.println("입력된 username: " + username);
            System.out.println("입력된 password: " + password);

            // 데이터베이스 연결
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);

            // 사용자 인증 쿼리 실행
            String sql = "SELECT user_id, password FROM users WHERE username = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // DB에서 비밀번호 가져오기
                String storedPassword = rs.getString("password");

                // DB에서 비밀번호를 가져오지 못했을 때
                if (storedPassword == null) {
                    System.out.println("DB에서 비밀번호를 가져오지 못했습니다.");
                } else {
                    System.out.println("DB에서 가져온 비밀번호: " + storedPassword);
                }

                // DB에서 가져온 비밀번호와 입력된 비밀번호 비교
                if (password.equals(storedPassword)) {
                    // 로그인 성공
                    session.setAttribute("user_id", rs.getInt("user_id"));
                    session.setAttribute("username", username);
                    return "redirect:/welcome"; // 로그인 성공 페이지로 리다이렉트
                } else {
                    model.addAttribute("error", "비밀번호가 틀렸습니다.");
                    return "login"; // 비밀번호 불일치
                }
            } else {
                model.addAttribute("error", "아이디가 존재하지 않습니다.");
                return "login"; // 아이디가 존재하지 않음
            }
        } catch (SQLException e) {
            // SQL 예외 처리
            e.printStackTrace();
            model.addAttribute("error", "데이터베이스 오류가 발생했습니다. 관리자에게 문의하세요.");
            return "login"; // 오류 발생 시 로그인 페이지로 돌아감
        } catch (ClassNotFoundException e) {
            // MySQL 드라이버 클래스 로드 실패 처리
            e.printStackTrace();
            model.addAttribute("error", "JDBC 드라이버를 로드할 수 없습니다. 관리자에게 문의하세요.");
            return "login"; // 오류 발생 시 로그인 페이지로 돌아감
        } catch (Exception e) {
            // 기타 예외 처리
            e.printStackTrace();
            model.addAttribute("error", "로그인 중 오류가 발생했습니다.");
            return "login"; // 기타 오류 발생 시 로그인 페이지로 돌아감
        } finally {
            // 리소스 정리
            try {
                if (rs != null) rs.close();
            } catch (SQLException ignore) {}
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException ignore) {}
            try {
                if (conn != null) conn.close();
            } catch (SQLException ignore) {}
        }
    }
}

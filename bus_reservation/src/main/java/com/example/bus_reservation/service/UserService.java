package com.example.bus_reservation.service;

import com.example.bus_reservation.entity.User;
import com.example.bus_reservation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User register(User user) {
        // 비밀번호 인코딩 제거
        user.setRole("USER");
        return userRepository.save(user); // 사용자 저장
    }

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username); // Read
        // 로그인 검증 로직 (단순 문자열 비교)
        if (user != null && user.getPassword().equals(password)) {
            return user; // 로그인 성공
        }
        return null; // 로그인 실패
    }
}

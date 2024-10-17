package com.example.bus_reservation.controller;

import com.example.bus_reservation.DTO.LoginForm;
import com.example.bus_reservation.DTO.RegisterForm;
import com.example.bus_reservation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 로그인 페이지 렌더링
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login_registration"; // HTML 파일명
    }

    // 로그인 처리
    @PostMapping("/login")
    public String processLogin(LoginForm loginForm, Model model) {
        boolean success = userService.login(loginForm.getUsername(), loginForm.getPassword());
        if (!success) {
            model.addAttribute("loginError", "Invalid username or password");
            return "login_registration";
        }
        return "redirect:/welcome"; // 로그인 성공 후 이동할 페이지
    }

    // 회원가입 페이지 렌더링
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "login_registration"; // HTML 파일명
    }

    // 회원가입 처리
    @PostMapping("/register")
    public String processRegister(RegisterForm registerForm, Model model) {
        if (!registerForm.getPassword().equals(registerForm.getConfirmPassword())) {
            model.addAttribute("registerError", "Passwords do not match");
            return "login_registration";
        }

        boolean success = userService.register(registerForm);
        if (!success) {
            model.addAttribute("registerError", "Registration failed. Try again.");
            return "login_registration";
        }
        return "redirect:/welcome"; // 회원가입 성공 후 이동할 페이지
    }
}


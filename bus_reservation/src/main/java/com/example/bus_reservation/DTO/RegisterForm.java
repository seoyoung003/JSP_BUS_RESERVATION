package com.example.bus_reservation.DTO;

import lombok.Data;

@Data
public class RegisterForm {
    private String name;
    private String phone;
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
}

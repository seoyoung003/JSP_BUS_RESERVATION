package com.example.bus_reservation.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data // Lombok: 자동으로 Getter, Setter, toString, equals, hashCode 등을 생성
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드를 받는 생성자
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    @Column // 사용자 이름 필드 추가
    private String name; // 사용자 이름 추가

    @Column // 회원가입할 때만 입력받기 때문에 nullable 설정을 하지 않음
    private String phone;

    @Column // 회원가입할 때만 입력받기 때문에 nullable 설정을 하지 않음
    private String email;
}
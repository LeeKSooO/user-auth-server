package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController // 이 클래스가 REST API를 처리하는 컨트롤러임을 명시
@RequestMapping("/api") // 공통 URL Prefix 설정
@RequiredArgsConstructor // final field 자동 주입

public class UserController {
    private final UserService userService;

    // 회원가입
    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return userService.signup(user);
    }

    // 로그인
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }

    // 내 정보 조회
    @GetMapping("/me")
    public User getMyInfo(@RequestParam Long userId) {
        return userService.getMyInfo(userId);
    }
}
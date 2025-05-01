package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.UserInfoResponseDto;
import com.example.demo.dto.SignupRequestDto;
import com.example.demo.dto.UpdateUserInfoDto;
import com.example.demo.dto.ChangePasswordRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;


@RestController // 이 클래스가 REST API를 처리하는 컨트롤러임을 명시
@RequestMapping("/api/user") // 공통 URL Prefix 설정
@RequiredArgsConstructor // final field 자동 주입

public class UserController {
    private final UserService userService;

    // 회원가입
    @PostMapping("/signup")
    public User signup(@RequestBody SignupRequestDto signupRequest) {
        System.out.println("signup controller debugging");
        return userService.signup(signupRequest);
    }

    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequestDto) {
        return userService.login(loginRequestDto.getUsername(), loginRequestDto.getPassword());
    }

    // 내 정보 조회
    @GetMapping("/me")
    public UserInfoResponseDto getMyInfo() {
        //SecurityContext에 저장된 username 꺼내기

        System.out.println("getMyInfo controller debugging");

        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.getMyInfoByUsername(username);
    }

    // 내 정보 수정
    @PutMapping("/me")
    public UserInfoResponseDto updateMyInfo(@RequestBody UpdateUserInfoDto updateUserInfoDto) {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.updateUserInfo(username, updateUserInfoDto);
    }

    // 비밀번호 변경
    @PutMapping("/password")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequestDto changePasswordRequestDto) {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userService.changePassword(username, changePasswordRequestDto);
        return ResponseEntity.ok("Password changed successfully");
    }



    // 내 정보 조회2
    /* 
    @GetMapping("/me")
    public User getMyInfo(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        System.out.pringln("내 정보 요청 디버깅 " + userDetails.getUsername());
        return userService.getMyinfoByUsername(userDetails.getUsername());
    }
    */


    // 내 정보 수정(jwt token)

    // 비밀번호 수정(jwt token)

    // 로그아웃

    // 회원탈퇴
}
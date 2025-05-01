package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
//import lombok.Data;

@Getter
@Builder
@AllArgsConstructor
public class UserInfoResponseDto {
    private String username;
    private String name;
    private String phone;
    private String email;
}
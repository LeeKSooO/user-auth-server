package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *  회원 정보 수정 요청용 DTO
 *  - 수정 가능한 필드만 선언할 것
 */

 @Getter
 @Setter
 @NoArgsConstructor
 @AllArgsConstructor
 @Builder
 public class UpdateUserInfoDto {
    private String name;
    private String phone;
    private String email;
 }
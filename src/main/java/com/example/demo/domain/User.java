package com.example.demo.domain;

// JPA 관련 어노테이션 import
import jakarta.persistence.*;
// lombok(코드 자동생성) 관련 어노테이션
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity // 이 클래스가 JPA 엔티티(=DB 테이블과 매핑되는 클래스)임을 나타냄. 
        // 즉 이 클래스가 DB테이블로 만들어질 것임을 나타낸다.
@Table(name = "users")
@Getter // 모든 필드에 대해 Getter 메서드를 자동으로 생성
@NoArgsConstructor // 파라미터가 없는 기본 생성자 자동 생성
@AllArgsConstructor // 모든 필드를 받는 생성자 자동 생성
@Builder // 객체를 편하게 생성할 수 있는 빌더 패던 지원
public class User {

    @Id  // 이 필드가 테이블의 PK(Primary Key)임을 나타냄

    // PK를 어떻게 생성할 것인가에 대한 전략
    // PK 값을 DB가 자동으로 생성(보통 AUTO_INCREMENT처럼)하도록 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id; // 회원 고유 식별 번호 (자동 증가)

    // DB Column설정 : null 허용 안하고(unique), 값이 중복되면 안 됨
    @Column(nullable = false, unique = true)
    private String username; // 사용자 ID (중복 불가)

    // DB Column Config : Not Null
    @Column(nullable = false)
    private String password; // 비밀번호
    
    @Column(nullable = false)
    private String name; // 사용자 이름

    @Column(nullable = false)
    private String phone; // 핸드폰 번호

    // DB Column Config : Not Null
    @Column(nullable = false, unique = true)
    private String email; // 이메일

    @Column(nullable = false)
    private String role; // 사용자 권한 (ex: ROLE_USER, ROLE_ADMIN)
}

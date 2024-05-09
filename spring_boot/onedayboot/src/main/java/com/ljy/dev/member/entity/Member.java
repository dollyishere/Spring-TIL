package com.ljy.dev.member.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

// import 구문 버전 차이로 교재와는 차이가 있음!
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder // java 빌더 패턴을 형성하는 녀석
public class Member {
	@Id
	// primary key처럼 만들 수 있음
	// GenerationType.IDENTITY는 시퀀스와 동일함
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 유일 상수 사용
	private Integer userId;
	// 200길이까지만 받도록 제약
	@Column(length = 200)
	private String nickname;
	private String password;
	private String gender;
	private String job;
	private String email;
	private LocalDate birthday;
	// 오라클에서 sysdate, mysql에서는 now()
	@CreationTimestamp
	private LocalDateTime insertDateTime;
	@UpdateTimestamp
	private LocalDateTime updateDateTime;
}
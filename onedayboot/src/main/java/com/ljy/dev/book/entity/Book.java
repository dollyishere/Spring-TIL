package com.ljy.dev.book.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

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
public class Book {
	@Id
	// primary key처럼 만들 수 있음
	// GenerationType.IDENTITY는 시퀀스와 동일함
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 유일 상수 사용
	private Integer bookId;
	// 200길이까지만 받도록 제약
	@Column(length = 200)
	private String title;
	private Integer price;
	// 오라클에서 sysdate, mysql에서는 now()
	@CreationTimestamp
	private LocalDateTime insertDateTime;
}
package com.ljy.dev.book.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity // 엔티티
@Data // toString 만들어주는 아이, 생성자는 못만듬
@Builder // 객체 생성 담당
@NoArgsConstructor // 매개 변수 없는 기본 생성자 만드는 아이
@AllArgsConstructor // 클래스의 모든 필드를 매개변수로 받는 생성자
public class BookLog {
	@Id // pk 지정
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 식별자 값 생성(자동증가)
	// null값 받기 위해 Integer 사용(int는 null값 못 받음!)
	private Integer bookLogId;
	@ManyToOne(fetch = FetchType.LAZY) // 다대일 관계 생성하고, 지연 로딩
	// 상수로 저장되어 있으니 가져다 쓰면 됨
	@JoinColumn(name="book_id") // 외래키 매핑
	private Book book;
	@Column(columnDefinition = "TEXT") // 데이터 타입 TEXT 지정
	// 굳이 범위 지정 안해주고 싶으면 TEXT로 가는 게 BEST
	// 데이터를 사용할 때 JPA가 쿼리를 실행하는 방식
	private String comment;
	private Integer page;
	@CreationTimestamp // 자동으로 현재 일시 기록
	private LocalDateTime insertDateTime;
}

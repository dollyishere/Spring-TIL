package com.springboot.jpa.data.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// 1씩 증가하는 건 기본적으로 Long 타입
	private Long number;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Integer price;
	
	@Column(nullable = false)
	private Integer stock;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updateAt;
	
}

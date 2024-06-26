package com.springboot.rest_api.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest_api.dto.MemberDTO;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
	
	// http://localhost:9090/api/v1/put-api/member
	@PutMapping(value="/member")
	public String postMember(@RequestBody Map<String, Object> putData) {
		StringBuilder sb = new StringBuilder();
		
		putData.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	// http://localhost:9090/api/v1/put-api/member1
	@PutMapping(value = "/member1")
	public String postMemberDTO1(@RequestBody MemberDTO memberDTO) {
		return memberDTO.toString();
	}
	
	// http://localhost:9090/api/v1/put-api/member2
	@PutMapping(value = "/member2")
	public MemberDTO postMemberDTO2(@RequestBody MemberDTO memberDTO) {
		return memberDTO;
	}
	
	// http://localhost:9090/api/v1/put-api/member3
	@PutMapping(value= "/member3")
	public ResponseEntity<MemberDTO> postMemberDTO3(@RequestBody MemberDTO memberDTO) {
		return ResponseEntity
				// 응답할 코드
				.status(HttpStatus.ACCEPTED)
				// 응답할 데이터
				.body(memberDTO);
	}
}

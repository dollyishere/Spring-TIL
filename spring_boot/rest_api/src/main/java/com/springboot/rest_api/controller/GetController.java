package com.springboot.rest_api.controller;

import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest_api.dto.MemberDTO;

import ch.qos.logback.classic.Logger;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
	
	private final Logger LOGGER = (Logger) LoggerFactory.getLogger(GetController.class);
	
	// http://localhost:9090/api/v1/get-api/hello
	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public String getHello() {
		return "Hello World";
	}
	
	// http://localhost:9090/api/v1/get-api/name
	@GetMapping(value="/name")
	public String getName() {
		return "Flature";
	}
	
	// http://localhost:9090/api/v1/get-api/variable1/{String 값}
	// 매개변수와 블록 내부의 이름은 동일해야 함
	@GetMapping(value="/variable1/{variable}")
	public String getVariable1(@PathVariable String variable) {
		LOGGER.info("@PathVariable를 통해 들어온 값 : {}", variable);
		return variable;
	}
	
	// http://localhost:9090/api/v1/get-api/request1?name=value1&email=value2&organization=value3
	// 보내주는 파라미터 명과 파라미터 개수를 내가 알고 있을 경우 사용
	@ApiOperation(value = "GET 메서드 예제", notes = "@RequestParam을 활용한 GET Method")
	@GetMapping(value = "/request1")
	public String getRequestParam1(
				@ApiParam(value="이름", required=true) @RequestParam String name,
				@ApiParam(value="이메일", required=true) @RequestParam String email,
				@ApiParam(value="회사", required=true) @RequestParam String organization
			) {
		LOGGER.info("getRequestParam1 메서드가 호출되었습니다.");
		return name + " " + email + " " + organization;
	}
	
	// http://localhost:9090/api/v1/get-api/request2?key1=value1&key2=value2
	// 파라미터 몇 개 들어올지 정확히 모를 때
	// 선택값도 있을 때
	@GetMapping(value="/request2")
	public String getRequestParam2(@RequestParam Map<String, String> param) {
		StringBuilder sb = new StringBuilder();
		param.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue() + "\n");
		});
		LOGGER.info("getRequestParam2 메서드가 호출되었습니다.");
		return sb.toString();
	}
	
	// http://localhost:9090/api/v1/get-api/request3?name=value1&email=value2&organization=value3
	@GetMapping(value="/request3")
	public String getRequestParam3(MemberDTO memberDTO) {
		return memberDTO.toString();
	}
}

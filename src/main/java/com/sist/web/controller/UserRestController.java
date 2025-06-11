package com.sist.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dto.UserDTO;
import com.sist.web.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserRestController {
	
	private final UserService uService;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody UserDTO dto) {
		uService.register(dto);
		return ResponseEntity.ok("회원가입 성공");
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserDTO> login(@RequestBody UserDTO dto) {
		UserDTO res = uService.login(dto.getUsername(), dto.getPassword());
		return ResponseEntity.ok(res);
	}
}

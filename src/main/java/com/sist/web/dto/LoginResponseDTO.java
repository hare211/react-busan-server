package com.sist.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class LoginResponseDTO {
	private String token;
	private String username;
	private String nickname;
}

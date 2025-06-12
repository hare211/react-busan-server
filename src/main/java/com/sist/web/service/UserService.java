package com.sist.web.service;

import com.sist.web.dto.LoginRequestDTO;
import com.sist.web.dto.LoginResponseDTO;
import com.sist.web.dto.UserDTO;

public interface UserService {
	void register(UserDTO dto);
	LoginResponseDTO login(LoginRequestDTO requestDTO);
}

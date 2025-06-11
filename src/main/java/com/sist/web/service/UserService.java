package com.sist.web.service;

import com.sist.web.dto.UserDTO;

public interface UserService {
	void register(UserDTO dto);
	UserDTO login(String username, String password);
}

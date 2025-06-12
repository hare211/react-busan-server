package com.sist.web.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.sist.web.dao.UserRepository;
import com.sist.web.dto.LoginRequestDTO;
import com.sist.web.dto.LoginResponseDTO;
import com.sist.web.dto.UserDTO;
import com.sist.web.entity.UserEntity;
import com.sist.web.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	private final UserRepository uDao;
	private final BCryptPasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;
	
	@Override
	public LoginResponseDTO login(LoginRequestDTO requestDTO) {
		UserEntity user = uDao.findByUsername(requestDTO.getUsername())
				.orElseThrow(() -> new RuntimeException("사용자가 존재하지 않습니다."));
		
		if (!passwordEncoder.matches(requestDTO.getPassword(), user.getPassword())) {
			throw new RuntimeException("비밀번호가 일치하지 않습니다.");
		}
		String token = jwtUtil.generateToken(user.getUsername());
		return new LoginResponseDTO(token, user.getUsername(), user.getNickname());
	}
	
	@Override
	public void register(UserDTO dto) {
		if (uDao.findByUsername(dto.getUsername()).isPresent()) {
			throw new RuntimeException("이미 존재하는 사용자입니다.");
		}
		
		UserEntity user = UserEntity.builder()
				.username(dto.getUsername())
				.password(passwordEncoder.encode(dto.getPassword()))
				.nickname(dto.getNickname())
				.email(dto.getEmail())
				.build();
		uDao.save(user);
		
	}
}

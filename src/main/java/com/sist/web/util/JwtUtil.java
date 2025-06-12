package com.sist.web.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	private static final String SECRET_KEY = "my-very-very-secret-jwt-signing-key-123456";
	private final long EXPIRATION_TIME = 1000 * 60 * 60 * 24;
	
	public String generateToken(String username) {
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), SignatureAlgorithm.HS256)
				.compact();
	}
	
	public String getUsernameFromToken(String token) {
		return getClaims(token).getSubject();
	}
	
	public boolean validateToken(String token) {
		try {
			getClaims(token);
			return true;
		} catch (ExpiredJwtException e) {
			System.out.println("토큰 만료: " + e.getMessage());
		} catch (UnsupportedJwtException e) {
			System.out.println("지원되지 않는 토큰: " + e.getMessage());
		} catch (MalformedJwtException e) {
			System.out.println("잘못된 형식의 토큰: " + e.getMessage());
		} catch (SignatureException e) {
			System.out.println("서명 검증 실패: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println("잘못된 인자: " + e.getMessage());
		}
		return false;
	}
	
	private Claims getClaims(String token) {
		return Jwts.parser()
				.setSigningKey(SECRET_KEY.getBytes())
				.parseClaimsJws(token)
				.getBody();
	}
}

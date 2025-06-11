package com.sist.web.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true, length = 50)
	private String username;
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(length = 50)
	private String nickname;
	
	@Column(length = 100)
	private String email;
	
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = LocalDateTime.now();
	}
}
/*
 * 
 create table users(
	id bigint auto_increment primary key,
    username varchar(50) not null unique,
    password varchar(100) not null,
    nickname varchar(50),
    email varchar(100),
    create_at datetime default current_timestamp
);
 
 */

package com.sysface.black.dto;

import com.sysface.black.entitys.Rol;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AuthRequest {

	private String email;
	private String password;
	private Rol role;
	
}
package com.sysface.black.dto;

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
public class AuthRequestRegister {

	private String username;
	private String password;
	private String email;
	private String nombre;
	private String paterno;
	private String materno;
	private Long phone;
	private String role;
	
	
}
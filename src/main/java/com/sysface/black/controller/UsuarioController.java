package com.sysface.black.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sysface.black.dto.AuthRequest;
import com.sysface.black.dto.AuthResponse;
import com.sysface.black.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/usuario")
@RequiredArgsConstructor
public class UsuarioController {

	private final AuthenticationService authenticationService;
	
	@PostMapping("/register")
	ResponseEntity<AuthResponse> register(@RequestBody AuthRequest request){
		return ResponseEntity.ok(authenticationService.register(request));
	}
	
	@PostMapping("/authenticte")
	ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request){
		return ResponseEntity.ok(authenticationService.authenticate(request));
	}
	
}

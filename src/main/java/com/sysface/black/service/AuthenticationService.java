package com.sysface.black.service;

import java.net.Authenticator.RequestorType;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sysface.black.dto.AuthRequest;
import com.sysface.black.dto.AuthResponse;
import com.sysface.black.entitys.Rol;
import com.sysface.black.entitys.Usuarios;
import com.sysface.black.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	
	public AuthResponse register(AuthRequest request) {
		System.out.println(request.getRole());
		var user = Usuarios.builder().
				email(request.getEmail()).
				PASSWORD(passwordEncoder.encode(request.getPassword())).
				role(request.getRole()).build();
		usuarioRepository.save(user);
		var jwtToken = jwtService.generateToken(user);
		return AuthResponse.builder().token(jwtToken).build();
		
	}

	public AuthResponse authenticate(AuthRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
				);
		var user = usuarioRepository.findByEmail(request.getEmail()).
				orElseThrow();
		var jwtToken = jwtService.generateToken(user);
		return AuthResponse.builder().token(jwtToken).build();
		
	}
	
}

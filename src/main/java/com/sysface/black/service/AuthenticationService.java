package com.sysface.black.service;

import java.time.LocalDate;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sysface.black.dto.AuthRequest;
import com.sysface.black.dto.AuthRequestRegister;
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
	
	
	public AuthResponse register(AuthRequestRegister request) {
	
		LocalDate won = LocalDate.now();
		var user = Usuarios.builder().
				username(request.getUsername()).
				PASSWORD(passwordEncoder.encode(request.getPassword())).
				email(request.getEmail()).
				NOMBRE(request.getNombre()).
				PATERNO(request.getPaterno()).
				MATERNO(request.getMaterno()).
				PHONE(request.getPhone()).
				role(Rol.valueOf("ROLE_" + request.getRole())).
				FECHA_ALTA(won) .build();
		usuarioRepository.save(user);
		var jwtToken = jwtService.generateToken(user);
		return AuthResponse.builder().token(jwtToken).build();
		
	}

	public AuthResponse authenticate(AuthRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getLoginIdentifier(), request.getPassword())
				);
		var user = usuarioRepository.findByUsernameOrEmail(request.getLoginIdentifier(),request.getLoginIdentifier()).
				orElseThrow();
		var jwtToken = jwtService.generateToken(user);
		return AuthResponse.builder().token(jwtToken).build();
		
	}
	
}

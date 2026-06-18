package com.sysface.black.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sysface.black.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

	private final UsuarioRepository usuarioRepository;
	
	@Bean 
	UserDetailsService userDetailsService() {
		return loginIdentifier  -> usuarioRepository.findByUsernameOrEmail(loginIdentifier,loginIdentifier).
				orElseThrow(()->new UsernameNotFoundException("Usuario no encontrdo"));
	}
	
		
	@Bean
	 PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	 AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		
		return config.getAuthenticationManager();
		
	}
	
}

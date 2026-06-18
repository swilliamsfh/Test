package com.sysface.black.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
	
	private final JwtAuthenticationFilter jwtAuthenticationFilter ;
			
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		 http.headers(headers->headers.frameOptions(frame->frame.disable()));

		 http.cors(cors->cors.disable());
		
		 http.csrf(AbstractHttpConfigurer::disable)
		 
         .authorizeHttpRequests(request -> request.requestMatchers("/api/v1/resource/**").permitAll()
        		 .requestMatchers("/api/v1/**")
                 .permitAll().anyRequest().authenticated())
         .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
         .addFilterBefore(
                 jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
         ;
		
    return http.build();		
	}
	
	
	
	
	
}

package com.sysface.black.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/management")
public class ManagementController {

    
    @GetMapping("/dashboard")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN','ROLE_MODERATOR')")
    public ResponseEntity<String> userDashboard() {
        return ResponseEntity.ok("Acceso permitido: Panel General.");
    }

    
    @GetMapping("/admin-settings")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> adminSettings() {
        return ResponseEntity.ok("Acceso permitido: Ajustes de Administrador.");
    }
	
}

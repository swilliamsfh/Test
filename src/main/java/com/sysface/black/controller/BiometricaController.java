package com.sysface.black.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sysface.black.entitys.Biometrica_Facial;
import com.sysface.black.service.CrudService;

@RestController
@RequestMapping("/api/v1/biometrica")
public class BiometricaController {

	 private final CrudService<Biometrica_Facial, Long> biometricaService;

	    public BiometricaController(CrudService<Biometrica_Facial, Long> biometricaService) {
	        this.biometricaService = biometricaService;
	    }

	    @PostMapping
	    public ResponseEntity<Biometrica_Facial> crear(@RequestBody Biometrica_Facial acceso) {
	        return ResponseEntity.ok(biometricaService.save(acceso));
	    }

	    @GetMapping
	    public ResponseEntity<List<Biometrica_Facial>> listarTodos() {
	        return ResponseEntity.ok(biometricaService.findAll());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Biometrica_Facial> buscarPorId(@PathVariable Long id) {
	        // Usamos un IF corto (Ternario) para retornar 200 OK o 404 Not Found
	        return biometricaService.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }
	
	    @PutMapping("/{id}")
	    public ResponseEntity<Biometrica_Facial> actualizar(@PathVariable Long id, @RequestBody Biometrica_Facial usuarioDatosNuevos) {
	        try {
	            
	        	Biometrica_Facial accesoActualizado = biometricaService.update(id, usuarioDatosNuevos);
	            return ResponseEntity.ok(accesoActualizado);
	        } catch (RuntimeException e) {
	            
	            return ResponseEntity.notFound().build();
	        }
}
	
}

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

import com.sysface.black.entitys.Acceso;
import com.sysface.black.service.CrudService;

@RestController
@RequestMapping("/api/v1/acceso")
public class AccesoController {

	 private final CrudService<Acceso, Long> accesoService;

	 
	 
	    public AccesoController(CrudService<Acceso, Long> accesoService) {
		super();
		this.accesoService = accesoService;
	}

		

	    @PostMapping
	    public ResponseEntity<Acceso> crear(@RequestBody Acceso acceso) {
	        return ResponseEntity.ok(accesoService.save(acceso));
	    }

	    @GetMapping
	    public ResponseEntity<List<Acceso>> listarTodos() {
	        return ResponseEntity.ok(accesoService.findAll());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Acceso> buscarPorId(@PathVariable Long id) {
	        // Usamos un IF corto (Ternario) para retornar 200 OK o 404 Not Found
	        return accesoService.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }
	
	    @PutMapping("/{id}")
	    public ResponseEntity<Acceso> actualizar(@PathVariable Long id, @RequestBody Acceso usuarioDatosNuevos) {
	        try {
	            
	        	Acceso accesoActualizado = accesoService.update(id, usuarioDatosNuevos);
	            return ResponseEntity.ok(accesoActualizado);
	        } catch (RuntimeException e) {
	            
	            return ResponseEntity.notFound().build();
	        }
}
}

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

import com.sysface.black.entitys.Visitantes;
import com.sysface.black.service.CrudService;

@RestController
@RequestMapping("/api/v1/visitantes")
public class VisitantesController {

	 private final CrudService<Visitantes, Long> visitantesService;

	    public VisitantesController(CrudService<Visitantes, Long> visitantesService) {
	        this.visitantesService = visitantesService;
	    }

	    @PostMapping
	    public ResponseEntity<Visitantes> crear(@RequestBody Visitantes acceso) {
	        return ResponseEntity.ok(visitantesService.save(acceso));
	    }

	    @GetMapping
	    public ResponseEntity<List<Visitantes>> listarTodos() {
	        return ResponseEntity.ok(visitantesService.findAll());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Visitantes> buscarPorId(@PathVariable Long id) {
	        // Usamos un IF corto (Ternario) para retornar 200 OK o 404 Not Found
	        return visitantesService.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }
	
	    @PutMapping("/{id}")
	    public ResponseEntity<Visitantes> actualizar(@PathVariable Long id, @RequestBody Visitantes usuarioDatosNuevos) {
	        try {
	            
	        	Visitantes accesoActualizado = visitantesService.update(id, usuarioDatosNuevos);
	            return ResponseEntity.ok(accesoActualizado);
	        } catch (RuntimeException e) {
	            
	            return ResponseEntity.notFound().build();
	        }
}
	
}

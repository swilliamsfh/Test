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

import com.sysface.black.entitys.Residentes;
import com.sysface.black.service.CrudService;

@RestController
@RequestMapping("/api/v1/residentes")
public class ResidentesController {

	 private final CrudService<Residentes, Long> residentesService;

	    public ResidentesController(CrudService<Residentes, Long> residentesService) {
	        this.residentesService = residentesService;
	    }

	    @PostMapping
	    public ResponseEntity<Residentes> crear(@RequestBody Residentes acceso) {
	        return ResponseEntity.ok(residentesService.save(acceso));
	    }

	    @GetMapping
	    public ResponseEntity<List<Residentes>> listarTodos() {
	        return ResponseEntity.ok(residentesService.findAll());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Residentes> buscarPorId(@PathVariable Long id) {
	        // Usamos un IF corto (Ternario) para retornar 200 OK o 404 Not Found
	        return residentesService.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }
	
	    @PutMapping("/{id}")
	    public ResponseEntity<Residentes> actualizar(@PathVariable Long id, @RequestBody Residentes usuarioDatosNuevos) {
	        try {
	            
	        	Residentes accesoActualizado = residentesService.update(id, usuarioDatosNuevos);
	            return ResponseEntity.ok(accesoActualizado);
	        } catch (RuntimeException e) {
	            
	            return ResponseEntity.notFound().build();
	        }
}
	
	
}

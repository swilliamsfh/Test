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

import com.sysface.black.entitys.Vivienda;
import com.sysface.black.service.CrudService;

@RestController
@RequestMapping("/api/v1/vivienda")
public class ViviendaController {
	
	 private final CrudService<Vivienda, Long> viviendaService;

	    public ViviendaController(CrudService<Vivienda, Long> viviendaService) {
	        this.viviendaService = viviendaService;
	    }

	    @PostMapping
	    public ResponseEntity<Vivienda> crear(@RequestBody Vivienda acceso) {
	        return ResponseEntity.ok(viviendaService.save(acceso));
	    }

	    @GetMapping
	    public ResponseEntity<List<Vivienda>> listarTodos() {
	        return ResponseEntity.ok(viviendaService.findAll());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Vivienda> buscarPorId(@PathVariable Long id) {
	       
	        return viviendaService.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }
	
	    @PutMapping("/{id}")
	    public ResponseEntity<Vivienda> actualizar(@PathVariable Long id, @RequestBody Vivienda usuarioDatosNuevos) {
	        try {
	            
	        	Vivienda accesoActualizado = viviendaService.update(id, usuarioDatosNuevos);
	            return ResponseEntity.ok(accesoActualizado);
	        } catch (RuntimeException e) {
	            
	            return ResponseEntity.notFound().build();
	        }
}
	

}

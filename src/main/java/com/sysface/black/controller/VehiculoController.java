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

import com.sysface.black.entitys.Vehiculo;
import com.sysface.black.service.CrudService;

@RestController
@RequestMapping("/api/v1/vehiculo")
public class VehiculoController {

	 private final CrudService<Vehiculo, Long> vehiculoService;

	    public VehiculoController(CrudService<Vehiculo, Long> vehiculoService) {
	        this.vehiculoService = vehiculoService;
	    }

	    @PostMapping
	    public ResponseEntity<Vehiculo> crear(@RequestBody Vehiculo acceso) {
	        return ResponseEntity.ok(vehiculoService.save(acceso));
	    }

	    @GetMapping
	    public ResponseEntity<List<Vehiculo>> listarTodos() {
	        return ResponseEntity.ok(vehiculoService.findAll());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Vehiculo> buscarPorId(@PathVariable Long id) {
	        // Usamos un IF corto (Ternario) para retornar 200 OK o 404 Not Found
	        return vehiculoService.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }
	
	    @PutMapping("/{id}")
	    public ResponseEntity<Vehiculo> actualizar(@PathVariable Long id, @RequestBody Vehiculo usuarioDatosNuevos) {
	        try {
	            
	        	Vehiculo accesoActualizado = vehiculoService.update(id, usuarioDatosNuevos);
	            return ResponseEntity.ok(accesoActualizado);
	        } catch (RuntimeException e) {
	            
	            return ResponseEntity.notFound().build();
	        }
}
	
	
}

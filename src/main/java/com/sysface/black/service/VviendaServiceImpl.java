package com.sysface.black.service;

import java.util.List;
import java.util.Optional;

import com.sysface.black.entitys.Vivienda;
import com.sysface.black.repository.ViviendaRepository;

public class VviendaServiceImpl implements CrudService<Vivienda, Long>{

private final ViviendaRepository viviendaRepository;
	
	public VviendaServiceImpl(ViviendaRepository viviendaRepository) {
		super();
		this.viviendaRepository = viviendaRepository;
	}

	@Override
	public Vivienda save(Vivienda entity) {
		return viviendaRepository.save(entity);
	}

	@Override
	public Vivienda update(Long id, Vivienda entity) {
		return viviendaRepository.findById(id)
	            .map(usuarioExistente -> {
	                
	            	usuarioExistente.setID_RESIDENTE(entity.getID_RESIDENTE());
	            	usuarioExistente.setNUM_CASA(entity.getNUM_CASA());
	            	usuarioExistente.setFECHA_ALTA(entity.getFECHA_ALTA());
	            	usuarioExistente.setFECHA_BAJA(entity.getFECHA_BAJA());
	            	  
	                return viviendaRepository.save(usuarioExistente);
	            })
	            .orElseThrow(() -> new RuntimeException("Residente no encontrado con el id: " + id));
	}

	@Override
	public List<Vivienda> findAll() {
		return viviendaRepository.findAll();
	}

	@Override
	public Optional<Vivienda> findById(Long id) {
		return viviendaRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		 if (!viviendaRepository.existsById(id)) {
			throw new RuntimeException("Usuario no encontrado");
		 }
		 viviendaRepository.deleteById(id);
		
	}

	
}

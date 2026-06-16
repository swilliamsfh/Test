package com.sysface.black.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sysface.black.entitys.Vehiculo;
import com.sysface.black.repository.VehiculoRepository;
@Service
public class VehiculoServiceImpl implements CrudService<Vehiculo, Long>{

private final VehiculoRepository vehiculoRepository;
	
	public VehiculoServiceImpl(VehiculoRepository vehiculoRepository) {
		super();
		this.vehiculoRepository = vehiculoRepository;
	}

	@Override
	public Vehiculo save(Vehiculo entity) {
		return vehiculoRepository.save(entity);
	}

	@Override
	public Vehiculo update(Long id, Vehiculo entity) {
		return vehiculoRepository.findById(id)
	            .map(usuarioExistente -> {
	                
	            	usuarioExistente.setID_RESIDENTE(entity.getID_RESIDENTE());
	            	usuarioExistente.setPLACA(entity.getPLACA());
	            	usuarioExistente.setMARCA(entity.getMARCA());
	            	usuarioExistente.setMODELO(entity.getMODELO());
	            	usuarioExistente.setANIO(entity.getANIO());
	                usuarioExistente.setCOLOR(entity.getCOLOR());
	                usuarioExistente.setACTIVO(entity.isACTIVO());
	                
	                return vehiculoRepository.save(usuarioExistente);
	            })
	            .orElseThrow(() -> new RuntimeException("Residente no encontrado con el id: " + id));
	}

	@Override
	public List<Vehiculo> findAll() {
		return vehiculoRepository.findAll();
	}

	@Override
	public Optional<Vehiculo> findById(Long id) {
		return vehiculoRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		 if (!vehiculoRepository.existsById(id)) {
			throw new RuntimeException("Usuario no encontrado");
		 }
		 vehiculoRepository.deleteById(id);
		
	}

	
}

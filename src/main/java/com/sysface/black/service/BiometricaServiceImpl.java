package com.sysface.black.service;

import java.util.List;
import java.util.Optional;

import com.sysface.black.entitys.Biometrica_Facial;
import com.sysface.black.repository.BiometricaRepository;

public class BiometricaServiceImpl implements CrudService<Biometrica_Facial, Long>{

private final BiometricaRepository biometricaRepository;
	
	public BiometricaServiceImpl(BiometricaRepository biometricaRepository) {
	super();
	this.biometricaRepository = biometricaRepository;
	}

	@Override
	public Biometrica_Facial save(Biometrica_Facial entity) {
		return biometricaRepository.save(entity);
	}

	@Override
	public Biometrica_Facial update(Long id, Biometrica_Facial entity) {
		return biometricaRepository.findById(id)
	            .map(usuarioExistente -> {
	                
	            	usuarioExistente.setIDBIOMETRICO(entity.getIDBIOMETRICO());
	            	usuarioExistente.setFOTO_ORIGINAL(entity.getFOTO_ORIGINAL());
	            	usuarioExistente.setEMBEDDING_FACIAL(entity.getEMBEDDING_FACIAL());
	            	usuarioExistente.setFECHA_REGISTRO(entity.getFECHA_REGISTRO());
	            	usuarioExistente.setACTIVO(entity.isACTIVO());
	                return biometricaRepository.save(usuarioExistente);
	            })
	            .orElseThrow(() -> new RuntimeException("Acceso no encontrado con el id: " + id));
	}

	@Override
	public List<Biometrica_Facial> findAll() {
		return biometricaRepository.findAll();
	}

	@Override
	public Optional<Biometrica_Facial> findById(Long id) {
		return biometricaRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		 if (!biometricaRepository.existsById(id)) {
			throw new RuntimeException("Usuario no encontrado");
		 }
		 biometricaRepository.deleteById(id);
		
	}
	
}

package com.sysface.black.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sysface.black.entitys.Acceso;
import com.sysface.black.repository.AccesoRepository;

@Service
public class AccesoServiceImpl implements CrudService<Acceso, Long>{

private final AccesoRepository accesoRepository;
	
	public AccesoServiceImpl(AccesoRepository accesoRepository) {
	super();
	this.accesoRepository = accesoRepository;
	}

	@Override
	public Acceso save(Acceso entity) {
		return accesoRepository.save(entity);
	}

	@Override
	public Acceso update(Long id, Acceso entity) {
		return accesoRepository.findById(id)
	            .map(usuarioExistente -> {
	                
	            	usuarioExistente.setID_RESIDENTE(entity.getID_RESIDENTE());
	            	usuarioExistente.setFECHA_HORA(entity.getFECHA_HORA());
	            	usuarioExistente.setPUNTO_ACCESO(entity.getPUNTO_ACCESO());
	            	usuarioExistente.setMETODO(entity.getMETODO());
	            	usuarioExistente.setRESULTADO(entity.getRESULTADO());
	                usuarioExistente.setCONFIANZA(entity.getCONFIANZA());
	                
	                return accesoRepository.save(usuarioExistente);
	            })
	            .orElseThrow(() -> new RuntimeException("Acceso no encontrado con el id: " + id));
	}

	@Override
	public List<Acceso> findAll() {
		return accesoRepository.findAll();
	}

	@Override
	public Optional<Acceso> findById(Long id) {
		return accesoRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		 if (!accesoRepository.existsById(id)) {
			throw new RuntimeException("Usuario no encontrado");
		 }
		 accesoRepository.deleteById(id);
		
	}
	
}

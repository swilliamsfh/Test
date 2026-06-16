package com.sysface.black.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sysface.black.entitys.Visitantes;
import com.sysface.black.repository.VisitanteRepository;
@Service
public class VisitanteServiceImpl implements CrudService<Visitantes, Long>{
	
private final VisitanteRepository visitantesRepository;
	
	public VisitanteServiceImpl(VisitanteRepository visitantesRepository) {
		super();
		this.visitantesRepository = visitantesRepository;
	}

	@Override
	public Visitantes save(Visitantes entity) {
		return visitantesRepository.save(entity);
	}

	@Override
	public Visitantes update(Long id, Visitantes entity) {
		return visitantesRepository.findById(id)
	            .map(usuarioExistente -> {
	                
	            	usuarioExistente.setID_RESIDENTE(entity.getID_RESIDENTE());
	            	usuarioExistente.setNOMBRE(entity.getNOMBRE());
	            	usuarioExistente.setPATERNO(entity.getPATERNO());
	            	usuarioExistente.setMATERNO(entity.getMATERNO());
	                usuarioExistente.setPHONEP(entity.getPHONEP());
	                usuarioExistente.setPHONEA(entity.getPHONEA());
	                usuarioExistente.setEMAIL(entity.getEMAIL());
	                usuarioExistente.setACTIVO(entity.isACTIVO());

	                
	                return visitantesRepository.save(usuarioExistente);
	            })
	            .orElseThrow(() -> new RuntimeException("Residente no encontrado con el id: " + id));
	}

	@Override
	public List<Visitantes> findAll() {
		return visitantesRepository.findAll();
	}

	@Override
	public Optional<Visitantes> findById(Long id) {
		return visitantesRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		 if (!visitantesRepository.existsById(id)) {
			throw new RuntimeException("Usuario no encontrado");
		 }
		 visitantesRepository.deleteById(id);
		
	}


}

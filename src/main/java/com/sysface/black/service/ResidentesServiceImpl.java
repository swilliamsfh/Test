package com.sysface.black.service;

import java.util.List;
import java.util.Optional;

import com.sysface.black.entitys.Residentes;
import com.sysface.black.repository.ResidenteRepository;

public class ResidentesServiceImpl implements CrudService<Residentes, Long>{

	private final ResidenteRepository residenteRepository;
	
	public ResidentesServiceImpl(ResidenteRepository residenteRepository) {
		super();
		this.residenteRepository = residenteRepository;
	}

	@Override
	public Residentes save(Residentes entity) {
		return residenteRepository.save(entity);
	}

	@Override
	public Residentes update(Long id, Residentes entity) {
		return residenteRepository.findById(id)
	            .map(usuarioExistente -> {
	                
	            	usuarioExistente.setNOMBRE(entity.getNOMBRE());
	            	usuarioExistente.setPATERNO(entity.getPATERNO());
	            	usuarioExistente.setMATERNO(entity.getMATERNO());
	            	usuarioExistente.setFECNAC(entity.getFECNAC());
	            	usuarioExistente.setCURP(entity.getCURP());
	                usuarioExistente.setPHONEP(entity.getPHONEP());
	                usuarioExistente.setPHONEA(entity.getPHONEA());
	                usuarioExistente.setEMAIL(entity.getEMAIL());
	                usuarioExistente.setEMAIL(entity.getEMAIL());
	                usuarioExistente.setTYPERESIDENTE(entity.getTYPERESIDENTE());
	                usuarioExistente.setTYPESTATUS(entity.getTYPESTATUS());
	                usuarioExistente.setFECCREACION(entity.getFECCREACION());
	                
	                return residenteRepository.save(usuarioExistente);
	            })
	            .orElseThrow(() -> new RuntimeException("Residente no encontrado con el id: " + id));
	}

	@Override
	public List<Residentes> findAll() {
		return residenteRepository.findAll();
	}

	@Override
	public Optional<Residentes> findById(Long id) {
		return residenteRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		 if (!residenteRepository.existsById(id)) {
			throw new RuntimeException("Usuario no encontrado");
		 }
		 residenteRepository.deleteById(id);
		
	}

}

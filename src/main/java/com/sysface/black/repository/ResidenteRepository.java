package com.sysface.black.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sysface.black.entitys.Residentes;
@Repository
public interface ResidenteRepository extends JpaRepository<Residentes, Long>{

}

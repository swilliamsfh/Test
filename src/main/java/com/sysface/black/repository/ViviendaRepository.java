package com.sysface.black.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sysface.black.entitys.Vivienda;
@Repository
public interface ViviendaRepository extends JpaRepository<Vivienda, Long> {

}

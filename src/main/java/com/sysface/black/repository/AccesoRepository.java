package com.sysface.black.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sysface.black.entitys.Acceso;
@Repository
public interface AccesoRepository extends JpaRepository<Acceso, Long> {

}

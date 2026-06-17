package com.sysface.black.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sysface.black.entitys.Vehiculo;
@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long>{

}

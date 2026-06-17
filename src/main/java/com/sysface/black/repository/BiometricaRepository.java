package com.sysface.black.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sysface.black.entitys.Biometrica_Facial;
@Repository
public interface BiometricaRepository extends JpaRepository<Biometrica_Facial, Long>{

}

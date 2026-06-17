package com.sysface.black.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="vehiculo")
public class Vehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_VEHICULO;
	private Long ID_RESIDENTE;
	private String PLACA;
	private String MARCA;
	private String MODELO;
    private int ANIO;
    private String COLOR;
    private boolean ACTIVO;
}

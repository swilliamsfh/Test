package com.sysface.black.entitys;

import java.util.Date;

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
@Table(name="vivienda")
public class Vivienda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_VIVIENDA;
	private Long ID_RESIDENTE;
	private int NUM_CASA;
	private Date FECHA_ALTA;
	private Date FECHA_BAJA;
	
}

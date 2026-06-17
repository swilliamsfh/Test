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
@Table(name="acceso")
public class Acceso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_ACCESO;
	private Long ID_RESIDENTE;
	private Date FECHA_HORA;
	private String PUNTO_ACCESO;
	private String METODO;
	private String RESULTADO;
	private Float CONFIANZA;
}

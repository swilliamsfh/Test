package com.sysface.black.entitys;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name="residentes")
public class Residentes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDRESIDENTE;
	private String NOMBRE;
	private String PATERNO;
	private String MATERNO;
	private Date FECNAC;
	private String CURP;
	private int PHONEP;
	private int PHONEA;
	private String EMAIL;
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_RESIDENTE", nullable = false)
	private TypeResidente TYPERESIDENTE;
	@Enumerated(EnumType.STRING)
	@Column(name="TIPO_STATUS", nullable = false)
	private TypeStatus TYPESTATUS;
	private Date FECCREACION;
}



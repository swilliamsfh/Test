package com.sysface.black.entitys;

import java.util.Date;

import jakarta.persistence.Entity;
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
@Table(name="usuarios")
public class Usuarios {

	@Id
	private Long ID_USER;
	private String USUARIO;
	private String PASSWORD;
	private String NOMBRE;
	private String PATERNO;
	private String MATERNO;
	private int PHONE;
	private String EMIAL;
	private Date FECHA_ALTA;
}

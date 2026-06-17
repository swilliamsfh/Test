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
@Table(name="visitantes")
public class Visitantes {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_VISITANTE;
	private Long ID_RESIDENTE;
	private String NOMBRE;
	private String PATERNO;
	private String MATERNO;
	private int PHONEP;
	private int PHONEA;
	private String EMAIL;
	private boolean ACTIVO;
}

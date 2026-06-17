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
@Table(name="biometria")
public class Biometrica_Facial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDBIOMETRICO;
	private Long IDRESIDENTE;
	private String FOTO_ORIGINAL;
	private byte EMBEDDING_FACIAL;
	private Date FECHA_REGISTRO;
	private boolean ACTIVO;
	
}

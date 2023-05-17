package com.example.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResultadoCanceladoWs implements Serializable {

	private static final long serialVersionUID = -8724700144097813752L;
	private String codigo;
	private String errmsg;
	private String fechaCancelacion;
	private String estatusUUID;
	private String UUID;	
	private String noidentificacion;
	private BigDecimal idRfactura;
	private String idRtipocom;

}

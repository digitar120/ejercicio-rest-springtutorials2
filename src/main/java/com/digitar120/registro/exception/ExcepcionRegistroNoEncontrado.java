package com.digitar120.registro.exception;

public class ExcepcionRegistroNoEncontrado extends RuntimeException {
	
	public ExcepcionRegistroNoEncontrado(Integer id) {
		super("No se encontró el registro N°" + id);
	}

}

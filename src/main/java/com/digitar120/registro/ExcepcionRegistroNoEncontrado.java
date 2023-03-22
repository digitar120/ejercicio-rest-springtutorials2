package com.digitar120.registro;

public class ExcepcionRegistroNoEncontrado extends RuntimeException {
	
	ExcepcionRegistroNoEncontrado(Integer id) {
		super("No se encontró el registro N°" + id);
	}

}

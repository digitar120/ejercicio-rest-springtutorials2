package com.digitar120.registro.exception;

public class RegisterNotFoundException extends RuntimeException {
	
	public RegisterNotFoundException(Integer id) {
		super("No se encontró el registro N°" + id);
	}

}

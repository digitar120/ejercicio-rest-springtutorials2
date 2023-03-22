package com.digitar120.registro;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ConsejoRegistroNoEncontrado {
	
	@ResponseBody
	@ExceptionHandler(ExcepcionRegistroNoEncontrado.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String handlerRegistroNoEncontrado(ExcepcionRegistroNoEncontrado ex) {
		return ex.getMessage();
	}
}

package com.sistema.biblioteca.ControllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sistema.biblioteca.exception.UsuarioNotFoundExecption;

@ControllerAdvice
public class UsuarioNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(UsuarioNotFoundExecption.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String usuarioNotFoundHandler(UsuarioNotFoundExecption execption) {
		return execption.getMessage();
	}
	
}

package com.sistema.biblioteca.ControllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sistema.biblioteca.exception.ReservaNotFoundExecption;

@ControllerAdvice
public class ReservaNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(ReservaNotFoundExecption.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String reservaNotFoundHandler(ReservaNotFoundExecption execption) {
		return execption.getMessage();
	}
	
}

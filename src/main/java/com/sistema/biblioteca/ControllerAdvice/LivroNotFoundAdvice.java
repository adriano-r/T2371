package com.sistema.biblioteca.ControllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sistema.biblioteca.exception.LivroNotFoundExecption;

@ControllerAdvice
public class LivroNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(LivroNotFoundExecption.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String livroNotFoundHandler(LivroNotFoundExecption execption) {
		return execption.getMessage();
	}
	
}

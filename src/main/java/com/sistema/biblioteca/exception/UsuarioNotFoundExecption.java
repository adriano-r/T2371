package com.sistema.biblioteca.exception;

public class UsuarioNotFoundExecption extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsuarioNotFoundExecption(Long id) {
	    super("Não foi encontrado o usuario " + id);
	}

}

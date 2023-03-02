package com.sistema.biblioteca.exception;

public class ReservaNotFoundExecption extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ReservaNotFoundExecption(Long id) {
	    super("Não foi encontrado a reserva" + id);
	}
	
}

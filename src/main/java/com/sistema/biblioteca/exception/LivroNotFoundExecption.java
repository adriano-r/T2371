package com.sistema.biblioteca.exception;

public class LivroNotFoundExecption extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LivroNotFoundExecption(Long id) {
	    super("Não foi encontrado o livro " + id);
	}

}

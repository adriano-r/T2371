package com.sistema.biblioteca.exception;

public class LivroNotFoundExecption extends RuntimeException {

	public LivroNotFoundExecption(Long id) {
	    super("Não foi encontrado o livro " + id);
	}

}

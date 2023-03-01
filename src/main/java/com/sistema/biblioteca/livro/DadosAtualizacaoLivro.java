package com.sistema.biblioteca.livro;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoLivro(
		@NotNull
		Long id,
		String titulo,
		String autor, 
		String serie, 
		String editora,
		String ano, 
		String topico, 
		String edicao,
		int paginas
		) {

}

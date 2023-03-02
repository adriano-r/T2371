package com.sistema.biblioteca.livro;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroLivro(
		@NotBlank
		String titulo,
		@NotBlank
		String autor, 
		String urlImagem, 
		String editora,
		String ano, 
		String topico, 
		String edicao,
		int paginas
		) {

}

package com.sistema.biblioteca.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(
		@NotBlank
		String nome,
		@NotBlank
		String email,
		@NotBlank
		String senha
		) {

}

package com.sistema.biblioteca.usuario;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public record DadosCadastroUsuario(
		@NotBlank
		String nome,
		@NotBlank
		String email,
		@NotBlank
		String senha
		) {


}

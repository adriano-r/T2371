package com.sistema.biblioteca.reserva;

import java.time.LocalDateTime;

import com.sistema.biblioteca.livro.DadosCadastroLivro;
import com.sistema.biblioteca.usuario.DadosCadastroUsuario;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroReserva(
		@NotNull
		LocalDateTime dataReserva,
		@NotNull
		LocalDateTime dataDevolucao,
		
		@NotNull
		Status status,
		
		@NotNull @Valid
		DadosCadastroLivro livro,
		
		@NotNull @Valid
		DadosCadastroUsuario usuario
		) {
}

package com.sistema.biblioteca.reserva;

import java.time.LocalDateTime;

import com.sistema.biblioteca.livro.DadosAtualizacaoLivro;
import com.sistema.biblioteca.usuario.DadosAtualizacaoUsuario;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoReserva(
		@NotNull
		Long id,
		LocalDateTime dataReserva,
		LocalDateTime dataDevolucao,
		Status status,
		DadosAtualizacaoLivro livro,
		DadosAtualizacaoUsuario usuario

		) {
}

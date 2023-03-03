package com.sistema.biblioteca.reserva;

import java.time.LocalDate;

import com.sistema.biblioteca.livro.DadosAtualizacaoLivro;
import com.sistema.biblioteca.usuario.DadosAtualizacaoUsuario;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoReserva(
		@NotNull
		Long id,
		LocalDate dataReserva,
		LocalDate dataDevolucao,
		Status status
//		DadosAtualizacaoLivro livro,
//		DadosAtualizacaoUsuario usuario

		) {
}

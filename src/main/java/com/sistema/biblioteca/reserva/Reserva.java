package com.sistema.biblioteca.reserva;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "reservas")
@Entity(name = "Reserva")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate dataReserva;
	private LocalDate dataDevolucao;

	@Enumerated(EnumType.STRING)
	private Status status;

//	@Embedded
//	private Livro livro;

//	@Embedded
//	private Usuario usuario;

//	private Acao acao;

	public Reserva(DadosCadastroReserva dados) {
		this.dataReserva = dados.dataReserva();
		this.dataDevolucao = dados.dataDevolucao();
		this.status = dados.status();
//		this.livro = new Livro(dados.livro());
//		this.usuario = new Usuario(dados.usuario());
	}

	public void atualizarInformacoes(DadosAtualizacaoReserva dados) {
		if (dados.dataReserva() != null) {
			this.dataReserva = LocalDate.now();
		}
		if (dados.dataDevolucao() != null) {
			this.dataDevolucao = dados.dataDevolucao();
		}
		if (dados.status() != null) {
			this.status = dados.status();
		}
//		if (dados.livro() != null) {
//			this.livro.atualizarInformacoes(dados.livro());
//		}
//		if (dados.usuario() != null) {
//			this.usuario.atualizarInformacoes(dados.usuario());
//		}

	}
	
	public void excluir() {
//		acao.finalizar();
	}

}

package com.sistema.biblioteca.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
//@Embeddable
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private Boolean isAdmin;

	public Usuario(DadosCadastroUsuario dados) {
		this.isAdmin = false;
		this.nome = dados.nome();
		this.email = dados.email();
		this.senha = dados.senha();
	}

	public void atualizarInformacoes(@Valid DadosAtualizacaoUsuario dados) {
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
		if (dados.email() != null) {
			this.email = dados.email();
		}
		if (dados.senha() != null) {
			this.senha = dados.senha();
		}
		if (dados.isAdmin() != null) {
			this.isAdmin = dados.isAdmin();
		}
	}

	public void excluir() {
		this.isAdmin = false;
	}

}

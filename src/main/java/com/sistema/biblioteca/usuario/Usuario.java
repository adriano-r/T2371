package com.sistema.biblioteca.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Data
//@Getter
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(of = "id")
//@Embeddable
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome é obrigatório!")
	@Size(min = 3, message = "O nome deve ter no minimo 3 caracteres!")
	private String nome;
	
	@Email(message = "Insira um email válido!")
	@NotBlank(message = "O email é obrigatório!")
	private String email;
	
	@NotBlank(message = "A senha é obrigatória!")
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

	public void setSenha(String encoder) {
		this.senha = encoder;
		
	}

}

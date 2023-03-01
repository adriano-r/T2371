package com.sistema.biblioteca.livro;

import com.sistema.biblioteca.livro.DadosCadastroLivro;

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
import lombok.Setter;

@Table(name = "livros")
@Entity(name = "Livro")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String autor;
	private String serie;
	private String editora;
	private String ano;
	private String topico;
	private String edicao;
	private Integer paginas;
//	private Long isbn;

	public Livro(DadosCadastroLivro dados) {
		this.titulo = dados.titulo();
		this.autor = dados.autor();
		this.serie = dados.serie();
		this.editora = dados.editora();
		this.ano = dados.ano();
		this.topico = dados.topico();
		this.edicao = dados.edicao();
		this.paginas = dados.paginas();

	}

	public void atualizarInformacoes(@Valid DadosAtualizacaoLivro dados) {
		if ((dados.titulo() != null) && (dados.autor() != null)) {
			this.titulo = dados.titulo();
			this.autor = dados.autor();
			this.serie = dados.serie();
			this.editora = dados.editora();
			this.ano = dados.ano();
			this.topico = dados.topico();
			this.edicao = dados.edicao();
			this.paginas = dados.paginas();
		}

	}

	public void excluir() {
		System.out.println("Validações para excluir livro: Disponivel");
		
	}

}

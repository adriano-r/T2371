package com.sistema.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Livro {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	private String titulo;
	private String autor; 
	private String serie;
	private String editora;
	private String ano;
	private String topico;
	private String edicao;
	private Integer paginas;
//	private Long isbn;
	
	
	public Livro(String titulo, String autor, String serie, String editora, String ano, String topico,
			String edicao, int paginas) {
		this.titulo = titulo;
		this.autor = autor;
		this.serie = serie;
		this.editora = editora;
		this.ano = ano;
		this.topico = topico;
		this.edicao = edicao;
		this.paginas = paginas;
		
	}
	
}

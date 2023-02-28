package com.sistema.biblioteca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.biblioteca.exception.LivroNotFoundExecption;
import com.sistema.biblioteca.model.Livro;
import com.sistema.biblioteca.repository.LivroRepository;

@RestController
public class LivroController {

	@Autowired
	private LivroRepository repository;
	
	@GetMapping("/livros")
	List<Livro> todos() {
		return repository.findAll();
	}
	
	@PostMapping("/livros")
	Livro novoLivro(@RequestBody Livro novoLivro) {
		return repository.save(novoLivro);
	}
	
	@GetMapping("/livros/{id}")
	Livro unico(@PathVariable Long id) {
		return repository.findById(id)
			.orElseThrow(() -> new LivroNotFoundExecption(id));
	}
	
	@PutMapping("/livros/{id}")
	Livro alterar(@RequestBody Livro novoLivro, @PathVariable Long id) {
		return repository.findById(id)
				.map(livro -> {
					livro.setTitulo(novoLivro.getTitulo());
					livro.setAno(novoLivro.getAno());
					livro.setAutor(novoLivro.getAutor());
					return repository.save(livro);
				})
				.orElseGet(() -> {
					novoLivro.setId(id);
					return repository.save(novoLivro);
				});
	}
	
	@DeleteMapping("/livros/{id}")
	void deletar(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
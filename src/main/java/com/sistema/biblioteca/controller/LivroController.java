package com.sistema.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.biblioteca.exception.LivroNotFoundExecption;
import com.sistema.biblioteca.livro.DadosAtualizacaoLivro;
import com.sistema.biblioteca.livro.DadosCadastroLivro;
import com.sistema.biblioteca.livro.Livro;
import com.sistema.biblioteca.repository.LivroRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.var;

@RestController
@CrossOrigin("*")
@RequestMapping("livros")
public class LivroController {

	@Autowired
	private LivroRepository repository;
	
	@GetMapping
	public List<Livro> listar() {
		return repository.findAll();
	}
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroLivro dados) {
		repository.save(new Livro(dados));
	}
	
	@GetMapping("/{id}")
	public Livro selecionar(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new LivroNotFoundExecption(id));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoLivro dados) {
		var livro = repository.getReferenceById(dados.id());
		livro.atualizarInformacoes(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
//		var livro = repository.getReferenceById(id);
//		livro.excluir();
	}
	
}

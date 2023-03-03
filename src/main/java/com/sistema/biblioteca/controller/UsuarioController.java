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

import com.sistema.biblioteca.exception.UsuarioNotFoundExecption;
import com.sistema.biblioteca.repository.UsuarioRepository;
import com.sistema.biblioteca.usuario.DadosAtualizacaoUsuario;
import com.sistema.biblioteca.usuario.DadosCadastroUsuario;
import com.sistema.biblioteca.usuario.Usuario;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.var;

@RestController
@CrossOrigin("*")
@RequestMapping("usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	@GetMapping
	public List<Usuario> listar() {
		return repository.findAll();
	}

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroUsuario dados) {
		repository.save(new Usuario(dados));
	}

	@GetMapping("/{id}")
	public Usuario selecionar(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new UsuarioNotFoundExecption(id));
	}

	@PutMapping("{id}")
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoUsuario dados) {
		var usuario = repository.getReferenceById(dados.id());
		usuario.atualizarInformacoes(dados);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
//		var usuario = repository.getReferenceById(id);
//		usuario.excluir();
	}

}

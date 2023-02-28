package com.sistema.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.biblioteca.exception.UsuarioNotFoundExecption;
import com.sistema.biblioteca.model.Usuario;
import com.sistema.biblioteca.repository.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping("/usuarios")
	List<Usuario> todosUsuarios() {
		return repository.findAll();
	}
	
	@PostMapping("/usuarios")
	Usuario novoUsuario(@RequestBody Usuario novo) {
		return repository.save(novo);
	}
	
	@GetMapping("/usuarios/{id}")
	Usuario unicoUsuario(@PathVariable Long id) {
		return repository.findById(id)
			.orElseThrow(() -> new UsuarioNotFoundExecption(id));
	}
	
	@PutMapping("/usuarios/{id}")
	Usuario alterar(@RequestBody Usuario novoUsuario, @PathVariable Long id) {
		return repository.findById(id)
				.map(usuario -> {
					usuario.setEmail(novoUsuario.getEmail());
					usuario.setNome(novoUsuario.getNome());
					usuario.setIsAdmin(novoUsuario.getIsAdmin());
					usuario.setSenha(novoUsuario.getSenha());
					return repository.save(usuario);
				})
				.orElseGet(() -> {
					novoUsuario.setId(id);
					return repository.save(novoUsuario(novoUsuario));
				});
	}
	
	@DeleteMapping("/usuarios/{id}")
	void deletar(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}

package com.sistema.biblioteca.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.biblioteca.dto.UsuarioDto;
import com.sistema.biblioteca.exception.UsuarioNotFoundExecption;
import com.sistema.biblioteca.repository.UsuarioRepository;
import com.sistema.biblioteca.security.Token;
import com.sistema.biblioteca.service.UsuarioService;
import com.sistema.biblioteca.usuario.Usuario;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	

	@GetMapping
	public ResponseEntity<List<Usuario>> listar() {
//		List<Usuario> lista = repository.findAll();
		return ResponseEntity.status(200).body(usuarioService.listarUsuario());
	}

	@PostMapping
	@Transactional
//	public ResponseEntity<Usuario> cadastrar(@RequestBody @Valid DadosCadastroUsuario dados) {
	public ResponseEntity<Usuario> cadastrar(@RequestBody @Valid Usuario usuario) {
		return ResponseEntity.status(201).body(usuarioService.cadastrarUsuario(usuario));
//		return ResponseEntity.status(201).body(repository.save(new Usuario(dados)));
	}

	@GetMapping("/{id}")
	public Usuario selecionar(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new UsuarioNotFoundExecption(id));
	}

	@PutMapping("{id}")
	@Transactional
	public ResponseEntity<Usuario> atualizar(@RequestBody @Valid Usuario usuario) {
//		var usuario = repository.getReferenceById(dados.id());
//		usuario.atualizarInformacoes(dados);
		return ResponseEntity.status(201).body(usuarioService.atualizarUsuario(usuario));
	}
//	public ResponseEntity<?> atualizar(@RequestBody @Valid DadosAtualizacaoUsuario dados) {
////		var usuario = repository.getReferenceById(dados.id());
////		usuario.atualizarInformacoes(dados);
//		usuarioService.atualizarUsuario(dados);
//		return ResponseEntity.status(201).build();
//	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> excluir(@PathVariable Long id) {
//		repository.deleteById(id);
		usuarioService.excluirUsuario(id);
		return ResponseEntity.status(204).build();

//		var usuario = repository.getReferenceById(id);
//		usuario.excluir();
	}

	@PostMapping("/login")
	public ResponseEntity<Token> logar(@RequestBody @Valid UsuarioDto usuario) {
		Token token = usuarioService.gerarToken(usuario);
		if (token != null) {
			return ResponseEntity.ok(token);
		}
		return ResponseEntity.status(403).build();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		return errors;
	}

}

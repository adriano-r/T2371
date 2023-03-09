package com.sistema.biblioteca.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sistema.biblioteca.repository.UsuarioRepository;
import com.sistema.biblioteca.usuario.DadosAtualizacaoUsuario;
import com.sistema.biblioteca.usuario.DadosCadastroUsuario;
import com.sistema.biblioteca.usuario.Usuario;

import lombok.var;

@Service
public class UsuarioService {

	private UsuarioRepository repository;
	private PasswordEncoder passwordEncoder;

	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	public List<Usuario> listarUsuario() {
		List<Usuario> lista = repository.findAll();
		return lista;
	}

	public Usuario cadastrarUsuario(Usuario usuario) {
		String encoder = this.passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(encoder);
		return repository.save(usuario);
//		return repository.save(new Usuario(dados));
	}

	public Usuario atualizarUsuario(Usuario usuario) {
		String encoder = this.passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(encoder);
		return repository.save(usuario);
//		var usuario = repository.getReferenceById(dados.id());
//		usuario.atualizarInformacoes(dados);
//		return true;
	}

	public Boolean excluirUsuario(Long id) {
		repository.deleteById(id);
		return true;
	}

	public Boolean validarSenha(Usuario usuario) {
		@SuppressWarnings("deprecation")
		String senha = repository.getById(usuario.getId()).getSenha();
		Boolean valid = passwordEncoder.matches(usuario.getSenha().toString(), senha);
		return valid;
	}

}

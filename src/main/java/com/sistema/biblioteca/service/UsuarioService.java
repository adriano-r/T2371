package com.sistema.biblioteca.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sistema.biblioteca.dto.UsuarioDto;
import com.sistema.biblioteca.repository.UsuarioRepository;
import com.sistema.biblioteca.security.Token;
import com.sistema.biblioteca.security.TokenUtil;
import com.sistema.biblioteca.usuario.Usuario;

import jakarta.validation.Valid;

@Service
public class UsuarioService {

	private UsuarioRepository repository;
	private PasswordEncoder passwordEncoder;
	private final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	public List<Usuario> listarUsuario() {
		logger.info("Usuario: " + getLogado() + " Listando Usuarios") ;
		return repository.findAll();
	}

	public Usuario cadastrarUsuario(Usuario usuario) {
		String encoder = this.passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(encoder);
		logger.info("Usuario: " + getLogado() + " Criando Usuario: " + usuario.getNome());
		return repository.save(usuario);
//		return repository.save(new Usuario(dados));
	}

	public Usuario atualizarUsuario(Usuario usuario) {
		String encoder = this.passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(encoder);
		logger.info("Usuario: " + getLogado() + " Editando Usuario: " + usuario.getNome());
		return repository.save(usuario);
//		var usuario = repository.getReferenceById(dados.id());
//		usuario.atualizarInformacoes(dados);
//		return true;
	}

	public Boolean excluirUsuario(Long id) {
		repository.deleteById(id);
		logger.info("Usuario: " + getLogado() + " Excluindo Usuario id: " + id );
		return true;
	}

	public Boolean validarSenha(Usuario usuario) {
		@SuppressWarnings("deprecation")
		String senha = repository.getById(usuario.getId()).getSenha();
		Boolean valid = passwordEncoder.matches(usuario.getSenha().toString(), senha);
		return valid;
	}

	public Token gerarToken(@Valid UsuarioDto usuario) {
		Usuario user = repository.findByNomeOrEmail(usuario.getNome(), usuario.getEmail());
		if (user != null) {
			Boolean valid = passwordEncoder.matches(usuario.getSenha(), user.getSenha());
			if(valid) {
				return new Token( TokenUtil.createToken(user));
			}
		}
		return null;
	}
	
	private String getLogado() {
		Authentication userLogado = SecurityContextHolder.getContext().getAuthentication();
		if(!(userLogado instanceof AnonymousAuthenticationToken)) {
			return userLogado.getName();
		}
		return "Null";
	}

}

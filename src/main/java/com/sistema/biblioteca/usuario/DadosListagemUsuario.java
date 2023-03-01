package com.sistema.biblioteca.usuario;

public record DadosListagemUsuario(Long id, String nome, String email, String senha, boolean isAdmin) {

	public DadosListagemUsuario(Usuario usuario) {
		this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getIsAdmin());
	}

}

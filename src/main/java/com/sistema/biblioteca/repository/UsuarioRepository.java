package com.sistema.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.biblioteca.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}

package com.sistema.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.biblioteca.livro.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}

package com.sistema.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.biblioteca.reserva.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}

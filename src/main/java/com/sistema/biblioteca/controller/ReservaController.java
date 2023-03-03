package com.sistema.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.biblioteca.exception.ReservaNotFoundExecption;
import com.sistema.biblioteca.repository.ReservaRepository;
import com.sistema.biblioteca.reserva.DadosAtualizacaoReserva;
import com.sistema.biblioteca.reserva.DadosCadastroReserva;
import com.sistema.biblioteca.reserva.Reserva;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.var;

@RestController
@RequestMapping("reservas")
public class ReservaController {

	@Autowired
	private ReservaRepository repository;

	@GetMapping
	public List<Reserva> listar() {
		return repository.findAll();
	}

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroReserva dados) {
		repository.save(new Reserva(dados));
	}

	@GetMapping("/{id}")
	public Reserva selecionar(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new ReservaNotFoundExecption(id));
	}

	@PutMapping("/{id}")
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoReserva dados) {
		var reserva = repository.getReferenceById(dados.id());
		reserva.atualizarInformacoes(dados);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
//		var reserva = repository.getReferenceById(id);
//		reserva.excluir();
	}

}

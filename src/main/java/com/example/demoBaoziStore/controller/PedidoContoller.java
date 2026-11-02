package com.example.demoBaoziStore.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoBaoziStore.model.Pedido;
import com.example.demoBaoziStore.repository.PedidoRepository;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoContoller {
	private final PedidoRepository repository;

	public PedidoContoller(PedidoRepository pedidoRepository) {
		this.repository = pedidoRepository;
	}

	@GetMapping
	public ResponseEntity<List<Pedido>> findAll() {
		List<Pedido> list = repository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Pedido create(@RequestBody Pedido pedido) {
		return repository.save(pedido);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		if(!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}

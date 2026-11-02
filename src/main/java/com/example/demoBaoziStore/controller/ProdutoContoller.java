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

import com.example.demoBaoziStore.model.Produto;
import com.example.demoBaoziStore.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoContoller {
	private final ProdutoRepository repository;

	public ProdutoContoller(ProdutoRepository produtoRepository) {
		this.repository = produtoRepository;
	}

	@GetMapping
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> list = repository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Produto create(@RequestBody Produto produto) {
		return repository.save(produto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}

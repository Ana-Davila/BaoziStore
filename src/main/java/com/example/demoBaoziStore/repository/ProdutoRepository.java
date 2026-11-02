package com.example.demoBaoziStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoBaoziStore.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}

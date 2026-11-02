package com.example.demoBaoziStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoBaoziStore.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}

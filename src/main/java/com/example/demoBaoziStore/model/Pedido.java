package com.example.demoBaoziStore.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_pedido")
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long clienteId;
	private Long produtoId;
	private Integer quantidade;
	
	public Pedido() {
		super();
	}

	public Pedido(Long id, Long clienteId, Long produtoId, Integer quantidade) {
		super();
		this.id = id;
		this.clienteId = clienteId;
		this.produtoId = produtoId;
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", clienteId=" + clienteId + ", produtoId=" + produtoId + ", quantidade="
				+ quantidade + ", getId()=" + getId() + ", getClienteId()=" + getClienteId() + ", getProdutoId()="
				+ getProdutoId() + ", getQuantidade()=" + getQuantidade() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(clienteId, id, produtoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(clienteId, other.clienteId) && Objects.equals(id, other.id)
				&& Objects.equals(produtoId, other.produtoId);
	}
}

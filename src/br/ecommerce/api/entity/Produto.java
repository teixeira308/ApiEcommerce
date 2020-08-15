package br.ecommerce.api.entity; 


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
 
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produto_id")
	private int produto_id;
	@Column(name = "nome", length = 45)
	private String nome;
	@Column(name = "quantidade")
	private int quantidade;
	@Column(name = "valor")
	private double valor;	
	
 

	public int getId() {
		return produto_id;
	}

	public void setId(int id) {
		this.produto_id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Produto() {

	}

	public Produto(String nome, int quantidade, double valor) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
	}

}
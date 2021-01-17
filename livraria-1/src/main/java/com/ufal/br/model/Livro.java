package com.ufal.br.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long livro_id;
	private String nome;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Autor autor;
	private double preco;
	
	public Livro() {}

	public Livro(String nome, Autor autor, double preco) {
		super();
		this.nome = nome;
		this.autor = autor;
		this.preco = preco;
	}

	public long getLivroId() {
		return livro_id;
	}

	public void setLivroId(long livro_id) {
		this.livro_id = livro_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}

package com.ufal.br.model;

public class Livro {
	
	private long id;
	private String nome;
	private double preco;
	private String autor;
	
	public Livro(long id, String nome, double preco, String autor) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.autor = autor;
	}

	public long getId() {
		return id;
	}
	

	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	public String getAutor() {
		return autor;
	}
	
	
}

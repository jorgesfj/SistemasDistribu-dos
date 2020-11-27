package com.ufal.br.model;

public class Consulta {
	
	private int id;
	private String nomePaciente;
	private int dia;
	private int hora;
	private int minuto;
	private String descricao;
	public Consulta (int id, String nomePaciente, int dia, int hora, int minuto, String descricao) {
		this.id = id;
		this.nomePaciente = nomePaciente;
		this.dia = dia;
		this.hora = hora;
		this.minuto = minuto;
		this.descricao = descricao;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomePaciente() {
		return nomePaciente;
	}
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}

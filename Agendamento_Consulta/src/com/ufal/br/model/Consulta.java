package com.ufal.br.model;

import java.io.Serializable;

public class Consulta implements Serializable{
	
	private String nomePaciente;
	private String descricao;
	
	
	public Consulta (String nomePaciente, String descricao) {
		this.nomePaciente = nomePaciente;
		this.descricao = descricao;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}

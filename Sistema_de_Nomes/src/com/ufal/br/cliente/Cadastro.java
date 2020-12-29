package com.ufal.br.cliente;

import java.io.Serializable;

public class Cadastro implements Serializable{
	
	private String operacao;
	private String endereco;
	private String servico;
	
	public Cadastro (String operacao) {
		this.setOperacao(operacao);
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}
	
	
}

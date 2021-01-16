package com.ufal.br.exception;

public class LivroNaoEncontradaException extends Exception {
	
	public LivroNaoEncontradaException(long id) {
		super("Não foi possível encontrar o livro com o id: " + id);
			}

}

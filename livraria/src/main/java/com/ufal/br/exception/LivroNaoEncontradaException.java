package com.ufal.br.exception;

public class LivroNaoEncontradaException extends Exception {
	
	public LivroNaoEncontradaException(long id) {
		super("N�o foi poss�vel encontrar o livro com o id: " + id);
			}

}

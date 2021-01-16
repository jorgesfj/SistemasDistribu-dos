package com.ufal.br.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ufal.br.exception.LivroNaoEncontradaException;
import com.ufal.br.model.Livro;

@RestController
public class LivroController {
	private final List<Livro> livros = new ArrayList<>();
	private final AtomicLong contador = new AtomicLong();
	
	@GetMapping("/{id}")
	public Livro obterPessoa(@PathVariable long id) throws LivroNaoEncontradaException{
		for (Livro p: this.livros){
		if (p.getId() == id){
			return p;
			}
		}
		throw new LivroNaoEncontradaException(id);
		}
	
	
	@PostMapping
	public Livro adicionarLivro(@RequestBody Livro l){
		Livro n = new Livro(contador.incrementAndGet(), l.getNome(), l.getPreco(), l.getAutor());
		this.livros.add(n);
		return n;
	}
	
	
	@PutMapping("/{id}")
		public Livro atualizarLivro(@RequestBody Livro livro, @PathVariable long id) throws LivroNaoEncontradaException{
		for (Livro l: this.livros){
			if (l.getId() == id){
				l.setNome(livro.getNome());
				l.setPreco(livro.getPreco());
				l.setAutor(livro.getAutor());
		return l;
			}
		}
		throw new LivroNaoEncontradaException(id);
		}
	
	@DeleteMapping("/{id}")
		public void excluirLivro(@PathVariable long id) throws LivroNaoEncontradaException{
			if (!this.livros.removeIf(p-> p.getId()==id)){
				throw new LivroNaoEncontradaException(id);
			}
		}
}

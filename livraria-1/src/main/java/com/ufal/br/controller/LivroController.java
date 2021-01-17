package com.ufal.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufal.br.model.Livro;
import com.ufal.br.repository.LivroRepository;

@RestController
@RequestMapping("/livraria")
public class LivroController {
	
	@Autowired
	private LivroRepository repository;
	
	@GetMapping("/livros")
	public List findAll() {
		return repository.findAll();
	}
	
	
	@PostMapping
	public Livro create(@RequestBody Livro livro){
	   return repository.save(livro);
	}
	
}
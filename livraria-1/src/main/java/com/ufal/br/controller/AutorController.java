package com.ufal.br.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufal.br.model.Autor;
import com.ufal.br.model.Livro;
import com.ufal.br.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController {
	
	@Autowired
	private AutorRepository repository;
	
	@GetMapping
	public List findAll() {
		return repository.findAll();
	}
	
	
	@PostMapping
	public Autor create(@RequestBody Autor autor){
	   return repository.save(autor);
	}
	
	@PostMapping("/addautores")
	public List<Autor> createAutores(@RequestBody List<Autor> autores){
		return repository.saveAll(autores);
	}
	
	@GetMapping("/{nome}")
	public Autor findAutorByNome(@PathVariable String nome) {
		return repository.findByNome(nome);
	}
	
	@DeleteMapping("/delete")
	public String deleteAutor(@RequestBody Autor autor) {
		repository.delete(autor);
		return "Produto deletado" + autor.getId();
	}
	
}